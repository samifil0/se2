package HiFresh.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubreceptToevoegen {
    @When("ik het recept {int} toevoeg aan recept met id {int} na stap {int}")
    public void ikHetReceptToevoegAanReceptMetIdNaStap(int arg0, int arg1, int arg2) {
    }

    @Then("heeft recept {int} een subrecept met id {int}")
    public void heeftReceptEenSubreceptMetId(int arg0, int arg1) {
    }

    @And("de bereidingstap {int} voor recept {int} heeft beschrijving {string}")
    public void deBereidingstapVoorReceptHeeftBeschrijving(int arg0, int arg1, String arg2) {
    }

    @And("recept {int} is een subrecept van recept {int}")
    public void receptIsEenSubreceptVanRecept(int arg0, int arg1) {
    }
}
