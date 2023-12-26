package HiFresh.gebruiker.domain;

import HiFresh.aankoop.domain.Contract;
import lombok.Getter;

import java.util.List;

@Getter
public class Leverancier extends Rol {
    private List<Contract> contracten;
    private int reputatie;

    private String naam;
}
