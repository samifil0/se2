package HiFresh.recepten.domain;

import HiFresh.recepten.domain.Recept.Bereiding;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BereidingsStap implements Bereiding {
    private String instructie;
    private List<Ingredient> ingredienten;


    @Override
    public List<Bereiding> getVolgendeStappen() {
        return Collections.emptyList();
    }
}
