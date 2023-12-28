package HiFresh.gebruiker.persistency;

import HiFresh.gebruiker.domain.Leverancier;
import java.util.ArrayList;
import java.util.List;

public class LeverancierRepository {
    private List<Leverancier> leveranciers = new ArrayList<>();

    public void add(Leverancier leverancier) {
        leveranciers.add(leverancier);
    }
}