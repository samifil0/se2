package HiFresh.aankoop.application;

import HiFresh.aankoop.business.ContractService;
import HiFresh.aankoop.domain.Product;
import HiFresh.recepten.business.ReceptService;

import java.time.LocalDate;
import java.util.Date;

public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService){

        this.contractService = contractService;
    }

    public Product [] geefTopNProductSuggesties(Date datum, int n){
        return contractService.geefTopNProductSuggesties(datum, n);
    }

}
