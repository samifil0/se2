package HiFresh.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IngredientToevoegen {
    @When("ik product met id {int} toevoeg aan recept met id {int} met een hoeveelheid van {int}")
    public void ikProductMetIdToevoegAanReceptMetIdMetEenHoeveelheidVan(int arg0, int arg1, int arg2) {
    }

    @Then("heeft het recept {int} ingrediënten")
    public void heeftHetReceptIngrediënten(int arg0) {
    }

    @And("één van de ingrediënten is product {int} met hoeveelheid {int}")
    public void éénVanDeIngrediëntenIsProductMetHoeveelheid(int arg0, int arg1) {
    }
}
