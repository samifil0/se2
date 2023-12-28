package HiFresh;
import HiFresh.aankoop.domain.Clausule;
import HiFresh.aankoop.domain.Contract;
import HiFresh.aankoop.domain.DistributieCentrum;
import HiFresh.aankoop.persistency.DistributiecentrumRepository;
import HiFresh.aankoop.persistency.ProductRepository;
import HiFresh.gebruiker.persistency.LeverancierRepository;
import HiFresh.recepten.business.ReceptService;
import HiFresh.recepten.domain.Recept.BereidingsStap;
import HiFresh.recepten.domain.Recept.Recept;
import HiFresh.recepten.persistency.BereidingsStapRepository;
import HiFresh.recepten.persistency.IngredientRepository;
import HiFresh.recepten.persistency.ReceptRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sami Filjak
 * 27/12/2023
 */
@SpringBootApplication
class SpringDemoApplication {
    private ReceptService receptService;
private ReceptRepository receptRepository;
    private IngredientRepository ingredientRepository;
    private Recept currentRecept;
    private ProductRepository productRepository;
    private DistributieCentrum distributieCentrum;
    private DistributiecentrumRepository distributiecentrumRepository;
    private LeverancierRepository leverancierRepository;
    private BereidingsStap bereidingsStap;
    private BereidingsStapRepository bereidingsStapRepository;
    private Contract contract;
    private Clausule clausule;

    public SpringDemoApplication(ReceptService receptService, ReceptRepository receptRepository, IngredientRepository ingredientRepository) {
        this.receptService = receptService;
        this.receptRepository = receptRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
