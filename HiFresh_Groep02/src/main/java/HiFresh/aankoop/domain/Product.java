package HiFresh.aankoop.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String naam;
    private long id;

    public Product(String naam) {
        this.naam = naam;
    }


}
