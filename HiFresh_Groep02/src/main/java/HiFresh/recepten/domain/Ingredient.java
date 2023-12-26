package HiFresh.recepten.domain;

import HiFresh.aankoop.domain.Product;
import HiFresh.recepten.domain.Recept.Recept;
import HiFresh.uitl.Eenheid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ingredient {
    private double hoeveelheid;
    private Eenheid eenheid;

    private Product product;

    private Recept recept;

    private long id;


}
