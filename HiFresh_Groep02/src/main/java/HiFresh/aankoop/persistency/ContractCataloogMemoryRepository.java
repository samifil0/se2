package HiFresh.aankoop.persistency;

import HiFresh.aankoop.domain.Clausule;
import HiFresh.aankoop.domain.Contract;
import HiFresh.aankoop.domain.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ContractCataloogMemoryRepository implements ContractCataloogRepository {

    private final Map<Long, Contract> contractenCataloog = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public <S extends Contract> S save(S entity) {
        if (entity.getId() == 0) {
            entity.setId(nextId++);
        }
        contractenCataloog.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends Contract> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        for (S entity : entities) {
            savedEntities.add(save(entity));
        }
        return savedEntities;
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return Optional.ofNullable(contractenCataloog.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return contractenCataloog.containsKey(id);
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractenCataloog.values();
    }

    @Override
    public Iterable<Contract> findAllById(Iterable<Long> ids) {
        List<Contract> result = new ArrayList<>();
        for (Long id : ids) {
            findById(id).ifPresent(result::add);
        }
        return result;
    }

    @Override
    public long count() {
        return contractenCataloog.size();
    }

    @Override
    public void deleteById(Long id) {
        contractenCataloog.remove(id);
    }

    @Override
    public void delete(Contract entity) {
        deleteById(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Contract> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        contractenCataloog.clear();
    }

    @Override
    public List<Contract> getContractenVanEenProduct(Product product) {
        return contractenCataloog.values().stream()
                .filter(contract -> contract.getProduct().equals(product))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contract> getContracten() {
        return new ArrayList<>(contractenCataloog.values());
    }

    @Override
    public Product ReadProductFromContract(Contract contract) {
        return contract.getProduct();
    }

    @Override
    public void addClausuleToContract(Contract contract, Clausule clausule) {
        contract.addClausule(clausule);
        contractenCataloog.put(contract.getId(), contract);
    }
}
