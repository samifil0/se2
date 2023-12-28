package HiFresh.verzending.domain;

import HiFresh.aankoop.domain.DistributieCentrum;
import HiFresh.uitl.Adres;
import HiFresh.uitl.BarCode;
import HiFresh.verkoop.domain.Bestelling;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class MaaltijdBox {

    // Getters en setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String inhoud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributiecentrum_id", nullable = false)
    private DistributieCentrum distributieCentrum;

    public MaaltijdBox() {
    }

    public MaaltijdBox(String inhoud) {
        this.inhoud = inhoud;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public void setDistributieCentrum(DistributieCentrum distributieCentrum) {
        this.distributieCentrum = distributieCentrum;
    }
}
