package HiFresh.aankoop.business;

import HiFresh.aankoop.domain.Clausule;
import HiFresh.aankoop.domain.Contract;
import HiFresh.aankoop.domain.Product;
import HiFresh.aankoop.persistency.ContractCataloogRepository;
import HiFresh.uitl.Munt;
import HiFresh.uitl.PrijsAfspraak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ContractService {

    private final ContractCataloogRepository contractCataloogRepository;
    private final MailService mailService;

    @Autowired
    public ContractService(ContractCataloogRepository contractCataloogRepository, MailService mailService) {
        this.contractCataloogRepository = contractCataloogRepository;
        this.mailService = mailService;
    }


    public Munt getGemiddeldeAankoopprijs(Product product, Date datum) {
        List<Contract> contracten = contractCataloogRepository.getContractenVanEenProduct(product);
        List<PrijsAfspraak> geldendePrijsAfspraken = new ArrayList<>();

        for (Contract contract : contracten) {
            List<Clausule> clausules = contract.getClausules();
            for (Clausule clausule : clausules) {
                if (clausule.isClausuleActief(datum)) {
                    PrijsAfspraak prijsAfspraak = clausule.getPrijsAfspraak();
                    if (prijsAfspraak != null) {
                        geldendePrijsAfspraken.add(prijsAfspraak);
                    }
                }
            }
        }

        return berekenGemiddeldePrijs(geldendePrijsAfspraken);
    }

    private Munt berekenGemiddeldePrijs(List<PrijsAfspraak> geldendePrijsAfspraken) {
        if (geldendePrijsAfspraken.isEmpty()) {
            return new Munt(0,"EUR");
        }

        double totaal = 0;
        for (PrijsAfspraak afspraak : geldendePrijsAfspraken) {
            totaal += afspraak.getPrijs().getBedrag();
        }

        double gemiddelde = totaal / geldendePrijsAfspraken.size();
        return new Munt(gemiddelde,"EUR");
    }



    public Product[] geefTopNProductSuggesties(Date datum, int n) {
        Map<Product, Double> contractPrijsMap = new HashMap<>();
        List<Product> producten = new ArrayList<>();
        List<Contract> contracten = contractCataloogRepository.getContracten();
        for (Contract contract : contracten) {
            List<Clausule> clausules = contract.getClausules();
            for (Clausule clausule : clausules) {
                if (clausule.isClausuleActief(datum)) {
                    return getLowestPrijsAfspraakForContract(clausule, contractPrijsMap,n);
                }
            }
        }

        return null;
    }

    public Product[] getLowestPrijsAfspraakForContract(Clausule clausule, Map<Product, Double> contractPrijsMap, int n) {
        Product product = GetProductFromContract(clausule.getContract());
        double Prijs = GetPrijsAfspraakFromClausule(clausule);

        if (contractPrijsMap.containsKey(product)) {
            double existingPrijs = contractPrijsMap.get(product);
            if (Prijs < existingPrijs) {
                contractPrijsMap.put(product, Prijs);
            }
        } else {
            contractPrijsMap.put(product, Prijs);
        }

        ArrayList<Product> producten = new ArrayList<>(contractPrijsMap.keySet());

        if (producten.size() > n) {
            producten = new ArrayList<>(producten.subList(0, n));
        }

        return producten.toArray(new Product[0]);
    }

    public Product GetProductFromContract(Contract contract){
        return contractCataloogRepository.ReadProductFromContract(contract);
    }

    public double GetPrijsAfspraakFromClausule(Clausule clausule){
        return clausule.getPrijsAfspraak().getPrijs().getBedrag();
    }

    public void voegNieuweClausuleToe(Contract contract, Clausule clausule){
        contractCataloogRepository.save(contract);
        mailService.sendEmailNotification(contract,clausule);
    }


}
