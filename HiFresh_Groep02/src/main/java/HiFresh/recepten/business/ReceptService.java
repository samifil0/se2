package HiFresh.recepten.business;

import HiFresh.aankoop.business.ContractService;
import HiFresh.aankoop.domain.Product;
import HiFresh.recepten.domain.Ingredient;
import HiFresh.recepten.domain.Recept.Recept;
import HiFresh.recepten.persistency.IngredientCataloogRepository;
import HiFresh.recepten.persistency.IngredientRepository;
import HiFresh.recepten.persistency.ReceptCataloogRepository;
import HiFresh.recepten.persistency.ReceptRepository;
import HiFresh.uitl.Munt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptService {

    private final ReceptRepository receptRepository;
    private final IngredientRepository ingredientRepository;

    private final ReceptCataloogRepository receptCataloogRepository;

    private final IngredientCataloogRepository ingredientCataloogRepository;

    private final ContractService contractService;

    @Autowired
    public ReceptService(ReceptRepository receptRepository, IngredientRepository ingredientRepository, ReceptCataloogRepository receptCataloogRepository, IngredientCataloogRepository ingredientCataloogRepository, ContractService contractService) {
        this.receptRepository = receptRepository;
        this.ingredientRepository = ingredientRepository;
        this.receptCataloogRepository = receptCataloogRepository;
        this.ingredientCataloogRepository = ingredientCataloogRepository;
        this.contractService = contractService;
    }

    public ReceptService(ReceptRepository receptRepository, IngredientRepository ingredientRepository) {
        this.receptRepository = receptRepository;
        this.ingredientRepository = ingredientRepository;
        this.receptCataloogRepository = null;
        this.ingredientCataloogRepository = null;
        this.contractService = null;

    }

    public void addRecept(Recept recept) {
        receptCataloogRepository.save(recept);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientCataloogRepository.save(ingredient);
    }

    public Optional<Recept> getRecept(long id) {
        return receptCataloogRepository.findById(id);
    }

    public Optional<Ingredient> getIngredient(long id) {
        return ingredientCataloogRepository.findById(id);
    }

    public Iterable<Recept> getRecepten() {
        return receptCataloogRepository.findAll();
    }

    public Iterable<Ingredient> getIngredienten() {
        return ingredientCataloogRepository.findAll();
    }

    public Munt getGemiddeldeAankoopprijs(Long receptId, Date datum) {
        Optional<Recept> receptOpt = receptCataloogRepository.findById(receptId);
        if (receptOpt.isPresent()) {
            Recept recept = receptOpt.get();
            List<Ingredient> ingredienten = recept.getIngredienten();

            double totaalPrijs = 0;
            int aantalProducten = 0;

            for (Ingredient ingredient : ingredienten) {
                Product product = ingredient.getProduct();
                assert contractService != null;
                Munt productPrijs = contractService.getGemiddeldeAankoopprijs(product, datum);
                totaalPrijs += productPrijs.getBedrag();
                aantalProducten++;
            }

            return new Munt(totaalPrijs / (aantalProducten == 0 ? 1 : aantalProducten), "EUR");
        }
        return new Munt(0, "EUR");
    }
}

