package HiFresh.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BereidingsstapToevoegen {



    @When("ik een bereidingsstap {string} toevoeg aan recept met id {int}")
    public void ikEenBereidingsstapToevoegAanReceptMetId(String arg0, int arg1) {
    }

    @Then("heeft het recept {int} bereidingsstappen")
    public void heeftHetReceptBereidingsstappen(int arg0) {
    }

    @And("de laatste bereidingstap voor recept {int} heeft beschrijving {string}")
    public void deLaatsteBereidingstapVoorReceptHeeftBeschrijving(int arg0, String arg1) {
    }

    @When("ik een bereidingsstap {string} toevoeg aan recept met id {int} na stap {int}")
    public void ikEenBereidingsstapToevoegAanReceptMetIdNaStap(String arg0, int arg1, int arg2) {
    }

    @And("de bereidingsstap {int} voor recept {int} heeft beschrijving {string}")
    public void deBereidingsstapVoorReceptHeeftBeschrijving(int arg0, int arg1, String arg2) {
    }
}
