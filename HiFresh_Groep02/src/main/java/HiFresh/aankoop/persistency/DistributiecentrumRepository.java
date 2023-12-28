package HiFresh.aankoop.persistency;

import HiFresh.aankoop.domain.DistributieCentrum;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Sami Filjak
 * 27/12/2023
 */
public class DistributiecentrumRepository{
    private DistributieCentrum distributieCentrum;

    public void add(DistributieCentrum distributieCentrum) {
        this.distributieCentrum = distributieCentrum;
    }

    public Optional<DistributieCentrum> getDistributieCentrum() {
        return Optional.ofNullable(distributieCentrum);
    }
}
