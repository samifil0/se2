package HiFresh.recepten.domain.Recept;

import HiFresh.recepten.domain.Ingredient;

import java.util.List;

public interface Bereiding {
    List<Ingredient> getIngredienten();
    List<Bereiding> getVolgendeStappen();
}
