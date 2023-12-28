package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Ingredient;
import HiFresh.recepten.domain.Recept.Recept;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class ReceptRepository {
    private List<Recept> recepten = new ArrayList<>();

    public void add(Recept recept) {
        recepten.add(recept);
    }

    public List<Recept> getRecepten() {
        return recepten;
    }

    public Recept get(long ingredientReceptId) {
        return recepten.stream().filter(recept -> recept.getId() == ingredientReceptId).findFirst().orElse(null);
    }
}
