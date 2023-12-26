package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Ingredient;
import infra.Repository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientCataloogRepository extends CrudRepository<Ingredient, Long> {


}
