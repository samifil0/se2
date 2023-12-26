package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Recept.Recept;
import org.springframework.data.repository.CrudRepository;

public interface ReceptCataloogRepository extends CrudRepository<Recept, Long> {

}


