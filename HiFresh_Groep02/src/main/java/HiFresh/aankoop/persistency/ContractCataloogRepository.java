package HiFresh.aankoop.persistency;

import HiFresh.aankoop.domain.Clausule;
import HiFresh.aankoop.domain.Contract;
import HiFresh.aankoop.domain.Product;
import infra.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractCataloogRepository extends CrudRepository<Contract, Long> {
    List<Contract> getContractenVanEenProduct(Product product);

    List<Contract> getContracten();

    Product ReadProductFromContract(Contract contract);

    void addClausuleToContract(Contract contract, Clausule clausule);


}
