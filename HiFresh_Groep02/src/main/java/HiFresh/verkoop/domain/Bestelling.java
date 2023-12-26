package HiFresh.verkoop.domain;

import HiFresh.gebruiker.domain.Klant;
import HiFresh.uitl.Adres;
import HiFresh.verzending.domain.InpakOpdracht;

import java.util.List;

public class Bestelling {
    private List<Maaltijd> maaltijden;
    private Klant klant;
    private Adres adres;
    private Double korting;

    private InpakOpdracht inpakOpdracht;
}
