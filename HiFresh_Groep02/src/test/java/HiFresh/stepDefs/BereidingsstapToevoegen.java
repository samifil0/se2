package HiFresh.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BereidingsstapToevoegen {
    private ReceptService receptService;
    private ReceptRepository receptRepository;

public BereidingsstapToevoegen() {
        receptRepository = new ReceptRepository();
        receptService = new ReceptService(receptRepository);
    }

    @When("ik een bereidingsstap {string} toevoeg aan recept met id {int}")
    public void ikEenBereidingsstapToevoegAanReceptMetId(String arg0, int arg1) {
        Bereidingsstap bereidingsstap = new Bereidingsstap(arg0);
        receptService.addBereidingsstap(bereidingsstap, arg1);
    }

    @Then("heeft het recept {int} bereidingsstappen")
    public void heeftHetReceptBereidingsstappen(int arg0) {
        Recept recept = receptService.getReceptById(arg0);
        assertEquals(recept.getBereidingsstappen().size(), 1);
    }

    @And("de laatste bereidingstap voor recept {int} heeft beschrijving {string}")
    public void deLaatsteBereidingstapVoorReceptHeeftBeschrijving(int arg0, String arg1) {
        Recept recept = receptService.getReceptById(arg0);
        Bereidingsstap bereidingsstap = recept.getBereidingsstappen().get(0);
        assertEquals(bereidingsstap.getBeschrijving(), arg1);
    }

    @When("ik een bereidingsstap {string} toevoeg aan recept met id {int} na stap {int}")
    public void ikEenBereidingsstapToevoegAanReceptMetIdNaStap(String arg0, int arg1, int arg2) {
        Bereidingsstap bereidingsstap = new Bereidingsstap(arg0);
        receptService.addBereidingsstap(bereidingsstap, arg1, arg2);
    }

    @And("de bereidingsstap {int} voor recept {int} heeft beschrijving {string}")
    public void deBereidingsstapVoorReceptHeeftBeschrijving(int arg0, int arg1, String arg2) {
        Recept recept = receptService.getReceptById(arg1);
        Bereidingsstap bereidingsstap = recept.getBereidingsstappen().get(arg0);
        assertEquals(bereidingsstap.getBeschrijving(), arg2);
    }
}
