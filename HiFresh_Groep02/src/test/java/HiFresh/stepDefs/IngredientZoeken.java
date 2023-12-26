package HiFresh.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IngredientZoeken {
    @When("ik zoek op het woord {string}")
    public void ikZoekOpHetWoord(String arg0) {
    }

    @Then("krijg ik een lijst terug met {int} producten")
    public void krijgIkEenLijstTerugMetProducten(int arg0) {
    }

    @And("product_id van item {int} uit de lijst is {int}")
    public void product_idVanItemUitDeLijstIs(int arg0, int arg1) {
    }

    @When("ik zoek naar producten die beschikbaar zijn")
    public void ikZoekNaarProductenDieBeschikbaarZijn() {
    }

    @Then("krijg ik een lijst terug met {int} product")
    public void krijgIkEenLijstTerugMetProduct(int arg0) {
    }

    @And("product_id van het product is {int}")
    public void product_idVanHetProductIs(int arg0) {
    }

    @When("ik zoek naar product die beschikbaar zijn, stijgend gesorteerd op gemiddelde aankoopprijs")
    public void ikZoekNaarProductDieBeschikbaarZijnStijgendGesorteerdOpGemiddeldeAankoopprijs() {
    }

    @And("product_id van item {int} in de lijst is {int}")
    public void product_idVanItemInDeLijstIs(int arg0, int arg1) {
    }
}
