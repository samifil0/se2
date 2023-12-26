package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
