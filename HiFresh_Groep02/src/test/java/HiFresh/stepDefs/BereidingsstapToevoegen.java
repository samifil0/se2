package HiFresh.stepDefs;

import HiFresh.aankoop.domain.Clausule;
import HiFresh.aankoop.domain.Contract;
import HiFresh.aankoop.domain.Product;
import HiFresh.aankoop.persistency.DistributiecentrumRepository;
import HiFresh.aankoop.persistency.ProductRepository;
import HiFresh.gebruiker.domain.Leverancier;
import HiFresh.gebruiker.persistency.LeverancierRepository;
import HiFresh.recepten.domain.Ingredient;
import HiFresh.recepten.domain.Recept.BereidingsStap;
import HiFresh.recepten.persistency.BereidingsStapRepository;
import HiFresh.recepten.persistency.IngredientRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import HiFresh.recepten.business.ReceptService;
import HiFresh.recepten.domain.Recept.Recept;
import HiFresh.recepten.persistency.ReceptRepository;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import HiFresh.aankoop.domain.DistributieCentrum;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
public class BereidingsstapToevoegen {
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



    private static final Logger LOGGER = Logger.getLogger(BereidingsstapToevoegen.class.getName());

    public BereidingsstapToevoegen(ReceptRepository receptRepository, IngredientRepository ingredientRepository) {
        this.receptService = new ReceptService(receptRepository, ingredientRepository);
    }

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

//    @Given("subrecepten")
//    public void subrecepten(DataTable dataTable) {
//
//    }
//
//    @Given("contract")
//    public void contract(DataTable dataTable) {
//
//    }
//
//    @Given("clausules")
//    public void clausules(DataTable dataTable) {
//
//    }


    @When("ik een bereidingsstap {string} toevoeg aan recept met id {int}")
    public void ikEenBereidingsstapToevoegAanReceptMetId(String bereidingsstap, int receptId) {
        Optional<Recept> receptOptional = receptService.getRecept((long) receptId);
        if (receptOptional.isPresent()) {
            currentRecept = receptOptional.get();
            currentRecept.addBereidingsstap(bereidingsstap);
            receptService.addRecept(currentRecept);
            LOGGER.info("bereidingsstap: " + bereidingsstap + " toevoegd bij recept met id " + receptId);
        } else {
            LOGGER.warning("Recept met id: " + receptId + " niet gevonden");
        }
    }

    @Then("heeft het recept {int} bereidingsstappen")
    public void heeftHetReceptBereidingsstappen(int expectedSteps) {
        if (currentRecept != null) {
            int actualSteps = currentRecept.getBereidingsstappen().size();
            Assert.assertEquals(expectedSteps, actualSteps);
            LOGGER.info("Recept heeft " + actualSteps + " bereidingsstappen");
        } else {
            LOGGER.warning("Huidige recept is null");
        }
    }

    @And("de laatste bereidingstap voor recept {int} heeft beschrijving {string}")
    public void deLaatsteBereidingstapVoorReceptHeeftBeschrijving(int receptId, String expectedDescription) {
        if (currentRecept != null) {
            String beschrijving = currentRecept.getLastBereidingsstap().getDescription();
            Assert.assertEquals(expectedDescription, beschrijving);
            LOGGER.info("Laatste bereidingsstap voor " + receptId + " heeft beschrijving: " + beschrijving);
        } else {
            LOGGER.warning("Huidige recept is null");
        }
    }
}