package HiFresh.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GemiddeldeAankoopprijsRaadplegen {
    @Given("het is vandaag {int}{int}{int}")
    public void hetIsVandaag(int arg0, int arg1, int arg2) {
    }

    @When("ik de gemiddelde aankoopprijs van het recept {int} raadpleeg")
    public void ikDeGemiddeldeAankoopprijsVanHetReceptRaadpleeg(int arg0) {
    }

    @Then("krijg ik dat de gemiddelde aankoopprijs van het recept {int} gelijk is aan {double}")
    public void krijgIkDatDeGemiddeldeAankoopprijsVanHetReceptGelijkIsAan(int arg0, int arg1, int arg2) {
    }

    @Then("krijg ik dat de gemiddelde aankoopprijs van recept {int} gelijk is aan {double}")
    public void krijgIkDatDeGemiddeldeAankoopprijsVanReceptGelijkIsAan(int arg0, int arg1, int arg2) {
    }
}
