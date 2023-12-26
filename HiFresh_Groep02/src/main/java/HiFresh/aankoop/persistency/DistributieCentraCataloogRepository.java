package HiFresh.aankoop.persistency;

import HiFresh.aankoop.domain.Clausule;
import infra.Repository;
import org.springframework.data.repository.CrudRepository;

public interface DistributieCentraCataloogRepository extends CrudRepository<Long, Clausule> {
}
