package HiFresh.stepDefs;

import HiFresh.aankoop.domain.Product;
import HiFresh.recepten.appplication.ReceptController;
import HiFresh.recepten.domain.Recept.Recept;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import HiFresh.recepten.business.ReceptService;

import java.util.List;
import java.util.Map;


public class BackgroundSteps {

    private final ReceptService receptService;

    private final ReceptController receptController;


    public BackgroundSteps(ReceptService receptService, ReceptController receptController) {
        this.receptService = receptService;
        this.receptController = receptController;
    }

    @Given("recepten")
    public void recepten(DataTable data) {
        List<Map<String ,String>> recepten = data.asMaps(String.class, String.class);
        for (Map<String, String> columns : recepten){
            Recept recept = new Recept(columns.get("recept_naam"), columns.get("recept_beschrijving"));
            recept.setId(Integer.parseInt(columns.get("recept_id")));
            receptService.addRecept(recept);
        }

    }


    @Given("producten")
    public void producten(DataTable data) {
        List<Map<String, String>> producten = data.asMaps(String.class, String.class);
        for (Map<String, String> columns : producten){
            Product product = new Product(columns.get("product_naam"));
            product.setId(Integer.parseInt(columns.get("product_id")));
        }
    }
}
