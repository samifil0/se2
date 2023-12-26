package HiFresh.aankoop.domain;

import HiFresh.uitl.Eenheid;
import HiFresh.uitl.Periode;
import HiFresh.uitl.PrijsAfspraak;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Clausule {
    private Periode periode;

    private Eenheid eenheid;

    private PrijsAfspraak prijsAfspraak;

    private Contract contract;

    private List<Levering> leveringen;

    private List<InKoopOrder> inKoopOrders;


    public boolean isClausuleActief(Date date) {
        return periode.isIn(date);
    }
}
