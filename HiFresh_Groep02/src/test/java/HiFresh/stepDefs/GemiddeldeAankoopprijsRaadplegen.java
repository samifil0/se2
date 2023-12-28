package HiFresh.stepDefs;

import HiFresh.aankoop.domain.Clausule;
import HiFresh.aankoop.domain.Contract;
import HiFresh.aankoop.domain.DistributieCentrum;
import HiFresh.aankoop.domain.Product;
import HiFresh.aankoop.persistency.DistributiecentrumRepository;
import HiFresh.aankoop.persistency.ProductRepository;
import HiFresh.gebruiker.domain.Leverancier;
import HiFresh.gebruiker.persistency.LeverancierRepository;
import HiFresh.recepten.domain.Ingredient;
import HiFresh.recepten.domain.Recept.BereidingsStap;
import HiFresh.recepten.domain.Recept.Recept;
import HiFresh.recepten.persistency.BereidingsStapRepository;
import HiFresh.recepten.persistency.IngredientRepository;
import HiFresh.recepten.persistency.ReceptRepository;
import HiFresh.stepDefs.BereidingsstapToevoegen;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import HiFresh.recepten.business.ReceptService;
import HiFresh.uitl.Munt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class GemiddeldeAankoopprijsRaadplegen {
    private ReceptService receptService;
    private ReceptRepository receptRepository;
    private Recept currentRecept;
    private ProductRepository productRepository;
    private DistributieCentrum distributieCentrum;
    private DistributiecentrumRepository distributiecentrumRepository;
    private LeverancierRepository leverancierRepository;
    private IngredientRepository ingredientRepository;
    private BereidingsStap bereidingsStap;
    private BereidingsStapRepository bereidingsStapRepository;
    private Contract contract;
    private Clausule clausule;
    private LocalDate vandaag;



    private static final Logger LOGGER = Logger.getLogger(BereidingsstapToevoegen.class.getName());

    @Given("producten")
    public void producten(DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            Product product = new Product(map.get("product_naam"));
            productRepository.add(product);
        }
    }

    @Given("distributiecentra")
    public void distributiecentra(DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            DistributieCentrum distributiecentrum = new DistributieCentrum(map.get("distributiecentrum_naam"), map.get("distributiecentrum_adres"));
            distributiecentrumRepository.add(distributiecentrum);
        }
    }

    @Given("leveranciers")
    public void leveranciers(DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            Leverancier leverancier = new Leverancier(map.get("leverancier_naam"), map.get("leverancier_adres"));
            leverancierRepository.add(leverancier);
        }
    }

    @Given("recepten")
    public void recepten(DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            Recept recept = new Recept(map.get("recept_naam"), map.get("recept_beschrijving"));
            receptRepository.add(recept);
        }
    }

    @Given("ingredienten")
    public void ingredienten(DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            Ingredient ingredient = new Ingredient(Double.parseDouble(map.get("ingredient_hoeveelheid")), map.get("ingredient_eenheid"), productRepository.get(Long.parseLong(map.get("ingredient_product_id"))), receptRepository.get(Long.parseLong(map.get("ingredient_recept_id"))));
            ingredientRepository.add(ingredient);
        }
    }

    @Given("bereidingsstappen")
    public void bereidingsstappen(DataTable dataTable) {
        for (Map<String, String> map : dataTable.asMaps()) {
            BereidingsStap bereidingsStap = new BereidingsStap(map.get("bereidingsstap_instructie"), ingredientRepository.get(Long.parseLong(map.get("bereidingsstap_ingredient_id"))));
            bereidingsStapRepository.add(bereidingsStap);
        }
    }

    public GemiddeldeAankoopprijsRaadplegen(ReceptService receptService) {
        this.receptService = receptService;
    }

    @Given("het is vandaag {string}")
    public void hetIsVandaag(String datum) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.vandaag = LocalDate.parse(datum, formatter);
    }

    @When("ik de gemiddelde aankoopprijs van het recept {int} raadpleeg")
    public void ikDeGemiddeldeAankoopprijsVanHetReceptRaadpleeg(int receptId) {
        Optional<Munt> muntOptional = Optional.ofNullable(receptService.getGemiddeldeAankoopprijs((long) receptId, java.sql.Date.valueOf(vandaag)));
        if (muntOptional.isPresent()) {
            LOGGER.info("Gemiddelde aankoopprijs voor recept " + receptId + " is: " + muntOptional.get().getBedrag());
        } else {
            LOGGER.warning("Gemiddelde aankoopprijs voor recept " + receptId + " is niet gevonden");
        }
    }

    @Then("krijg ik dat de gemiddelde aankoopprijs van het recept {int} gelijk is aan {double}")
    public void krijgIkDatDeGemiddeldeAankoopprijsVanHetReceptGelijkIsAan(int receptId, double expectedPrice) {
        Optional<Munt> muntOptional = Optional.ofNullable(receptService.getGemiddeldeAankoopprijs((long) receptId, java.sql.Date.valueOf(vandaag)));
        if (muntOptional.isPresent()) {
            assertEquals(expectedPrice, muntOptional.get().getBedrag(), 0.01);
            LOGGER.info("Verwachte and actuele gemiddelde aankoopprijs match voor recept " + receptId);
        } else {
            LOGGER.warning("Gemiddelde aankoopprijs voor recept " + receptId + " niet gevonden");
        }
    }
}