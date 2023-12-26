package HiFresh.aankoop.persistency;

import HiFresh.aankoop.domain.Clausule;

import java.util.Optional;

public class DistributieCentraCataloogMemoryRepository implements DistributieCentraCataloogRepository{

    @Override
    public <S extends Long> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Long> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Long> findById(Clausule clausule) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Clausule clausule) {
        return false;
    }

    @Override
    public Iterable<Long> findAll() {
        return null;
    }

    @Override
    public Iterable<Long> findAllById(Iterable<Clausule> clausules) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Clausule clausule) {

    }

    @Override
    public void delete(Long entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Clausule> clausules) {

    }

    @Override
    public void deleteAll(Iterable<? extends Long> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
