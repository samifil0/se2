package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Recept.Recept;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ReceptCataloogMemoryRepository implements ReceptCataloogRepository {

    protected Map<Long, Recept> receptenCataloog = new HashMap<>();
    private static AtomicLong nextId = new AtomicLong(1);

    @Override
    public <S extends Recept> S save(S entity) {
        if (entity.getId() == 0) {
            entity.setId(nextId.getAndIncrement());
        }
        receptenCataloog.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends Recept> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        for (S entity : entities) {
            savedEntities.add(save(entity));
        }
        return savedEntities;
    }

    @Override
    public Optional<Recept> findById(Long id) {
        return Optional.ofNullable(receptenCataloog.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return receptenCataloog.containsKey(id);
    }

    @Override
    public Iterable<Recept> findAll() {
        return new ArrayList<>(receptenCataloog.values());
    }

    @Override
    public Iterable<Recept> findAllById(Iterable<Long> ids) {
        return ((Collection<Long>)ids).stream()
                .map(receptenCataloog::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return receptenCataloog.size();
    }

    @Override
    public void deleteById(Long id) {
        receptenCataloog.remove(id);
    }

    @Override
    public void delete(Recept entity) {
        receptenCataloog.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(receptenCataloog::remove);
    }

    @Override
    public void deleteAll(Iterable<? extends Recept> entities) {
        entities.forEach(entity -> receptenCataloog.remove(entity.getId()));
    }

    @Override
    public void deleteAll() {
        receptenCataloog.clear();
    }
}
