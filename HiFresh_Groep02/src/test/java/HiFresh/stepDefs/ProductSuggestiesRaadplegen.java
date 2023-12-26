package HiFresh.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSuggestiesRaadplegen {
    @Given("het systeem bevat productgegevens met verschillende aankoopprijzen voor bloem, kaas en melk")
    public void hetSysteemBevatProductgegevensMetVerschillendeAankoopprijzenVoorBloemKaasEnMelk() {
    }

    @When("het menuteamlid ingredientsuggesties opvraagt")
    public void hetMenuteamlidIngredientsuggestiesOpvraagt() {
    }

    @Then("zou het systeem een lijst met ingredientsuggesties moeten tonen, gesorteerd op prijsverschillen de lijst moet ten minste {int} ingredienten bevatten")
    public void zouHetSysteemEenLijstMetIngredientsuggestiesMoetenTonenGesorteerdOpPrijsverschillenDeLijstMoetTenMinsteIngredientenBevatten(int arg0) {
    }

    @Given("het jaar is afgelopen")
    public void hetJaarIsAfgelopen() {
    }

    @When("ik de jaarlijkse gemiddelde aankoopprijs van kaas bereken")
    public void ikDeJaarlijkseGemiddeldeAankoopprijsVanKaasBereken() {
    }

    @Then("verkrijg ik het gemiddelde van alle wekelijkse gemiddelde aankoopprijzen van kaas gedurende het jaar")
    public void verkrijgIkHetGemiddeldeVanAlleWekelijkseGemiddeldeAankoopprijzenVanKaasGedurendeHetJaar() {
    }

    @And("ik ontvang product_id {int} in de lijst met het jaarlijkse gemiddelde aankoopprijs van EUR{double}")
    public void ikOntvangProduct_idInDeLijstMetHetJaarlijkseGemiddeldeAankoopprijsVanEUR(int arg0, int arg1, int arg2) {
    }
}
