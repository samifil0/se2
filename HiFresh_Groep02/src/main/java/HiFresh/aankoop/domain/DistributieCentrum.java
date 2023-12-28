package HiFresh.aankoop.domain;

import HiFresh.verzending.domain.MaaltijdBox;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class DistributieCentrum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naam;
    private String locatie;

    @OneToMany(mappedBy = "distributieCentrum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MaaltijdBox> maaltijdBoxen = new HashSet<>();

    public DistributieCentrum() {
    }

    public DistributieCentrum(String naam, String locatie) {
        this.naam = naam;
        this.locatie = locatie;
    }

    // Getters en setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Set<MaaltijdBox> getMaaltijdBoxen() {
        return maaltijdBoxen;
    }

    public void setMaaltijdBoxen(Set<MaaltijdBox> maaltijdBoxen) {
        this.maaltijdBoxen = maaltijdBoxen;
    }

    public void addMaaltijdBox(MaaltijdBox maaltijdBox) {
        maaltijdBoxen.add(maaltijdBox);
        maaltijdBox.setDistributieCentrum(this);
    }
}
