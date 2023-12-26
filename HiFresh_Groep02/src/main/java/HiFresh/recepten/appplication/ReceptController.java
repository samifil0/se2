package HiFresh.recepten.appplication;

import HiFresh.recepten.business.ReceptService;
import HiFresh.recepten.domain.Ingredient;
import HiFresh.recepten.domain.Recept.Recept;
import HiFresh.uitl.Munt;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Optional;

@Controller
public class ReceptController {

    private final ReceptService receptService;

    public ReceptController(ReceptService receptService) {
        this.receptService = receptService;
    }



    public Munt getGemiddeldAankoopPrijs(long receptId, Date datum){
        return receptService.getGemiddeldeAankoopprijs(receptId, datum);
    }

    public void addIngredient(Ingredient ingredient){
        receptService.addIngredient(ingredient);
    }

    public void addRecept(Recept recept){
        receptService.addRecept(recept);
    }

    public Optional<Recept> getRecept(long id){
       return receptService.getRecept(id);
    }

    public Optional<Ingredient> getIngredient(long id){
        return receptService.getIngredient(id);
    }


}
