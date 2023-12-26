package HiFresh.aankoop.domain;

import HiFresh.gebruiker.domain.Leverancier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@AllArgsConstructor
@Setter
public class Contract {
    private long id;
    private Leverancier leverancier;
    private List<Clausule> clausules;
    private Product product;

    public void addClausule(Clausule clausule) {
        clausules.add(clausule);
    }
}
