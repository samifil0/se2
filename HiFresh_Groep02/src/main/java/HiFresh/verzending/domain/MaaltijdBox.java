package HiFresh.verzending.domain;

import HiFresh.uitl.Adres;
import HiFresh.uitl.BarCode;
import HiFresh.verkoop.domain.Bestelling;

import java.util.List;

public class MaaltijdBox {
    private List<InpakOpdracht> inpakOpdracht;
    private Bestelling bestelling;
    private Adres adres;
    private BarCode trackEnTraceCode;
}
