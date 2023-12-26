package HiFresh.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GemiddeldeAankoopprijsRaadplegen {
    private ReceptService receptService;
    private LocalDate vandaag;

    public GemiddeldeAankoopprijsRaadplegen(ReceptService receptService) {
        this.receptService = receptService;
    }

    @Given("het is vandaag {string}")
    public void hetIsVandaag(String datum) {
        this.vandaag = LocalDate.parse(datum);
    }

    @When("ik de gemiddelde aankoopprijs van het recept {int} raadpleeg")
    public void ikDeGemiddeldeAankoopprijsVanHetReceptRaadpleeg(int arg0) {
        receptService.getGemiddeldeAankoopprijs(arg0, vandaag);
    }

    @Then("krijg ik dat de gemiddelde aankoopprijs van het recept {int} gelijk is aan {double}")
    public void krijgIkDatDeGemiddeldeAankoopprijsVanHetReceptGelijkIsAan(int arg0, int arg1, int arg2) {
        double berekendePrijs = receptService.getGemiddeldeAankoopprijs(arg0, vandaag);
        assertEquals(berekendePrijs, arg2);
    }


}
