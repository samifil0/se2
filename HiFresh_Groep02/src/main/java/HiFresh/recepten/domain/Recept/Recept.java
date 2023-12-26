package HiFresh.recepten.domain.Recept;

import HiFresh.recepten.domain.Ingredient;
import HiFresh.recepten.domain.Label;
import HiFresh.recepten.domain.bereidingsTijd;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor


public class Recept implements Bereiding{
    private String naam;

    private String beschrijving;

    private bereidingsTijd duration;

    private String foto;

    private List<Label> labels;

    private List<Bereiding> bereidingen;

    private long id;

    public Recept (String naam, String beschrijving){
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.bereidingen = new ArrayList<>();
    }

    @Override
    public List<Ingredient> getIngredienten() {
        return bereidingen.stream()
                .flatMap(bereiding -> bereiding.getIngredienten().stream())
                .collect(Collectors.toList());
    }


    @Override
    public List<Bereiding> getVolgendeStappen() {
        return new ArrayList<>(bereidingen);
    }
}
