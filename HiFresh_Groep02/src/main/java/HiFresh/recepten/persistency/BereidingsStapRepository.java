package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Recept.BereidingsStap;

import java.util.ArrayList;
import java.util.List;

/**
 * Sami Filjak
 * 27/12/2023
 */
public class BereidingsStapRepository {
    private List<BereidingsStap> bereidingsStappen = new ArrayList<>();

    public void add(BereidingsStap bereidingsStap) {
        bereidingsStappen.add(bereidingsStap);
    }
}
