package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {

    private List<Ingredient> ingredienten = new ArrayList<>();

    public void add(Ingredient ingredient) {
        ingredienten.add(ingredient);
    }


    public List<Ingredient> get(long bereidingsstapIngredientId) {
        return ingredienten;
    }
}
