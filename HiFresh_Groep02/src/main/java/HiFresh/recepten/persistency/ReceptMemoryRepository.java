package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Recept.Recept;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
@ConditionalOnProperty(name = "repository.type", havingValue = "memory", matchIfMissing = true)
public class ReceptMemoryRepository implements ReceptRepository {

    private static AtomicLong nextId = new AtomicLong(1);
    protected Map<Long, Recept> recepten = new HashMap<>();

    @Override
    public Iterable<Recept> findAll() {
        return new ArrayList<>(recepten.values());
    }

    @Override
    public Iterable<Recept> findAllById(Iterable<Long> ids) {
        return ((Collection<Long>)ids).stream()
                .map(recepten::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return recepten.size();
    }

    @Override
    public void deleteById(Long id) {
        recepten.remove(id);
    }

    @Override
    public void delete(Recept entity) {
        recepten.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(recepten::remove);
    }

    @Override
    public void deleteAll(Iterable<? extends Recept> entities) {
        entities.forEach(entity -> recepten.remove(entity.getId()));
    }

    @Override
    public void deleteAll() {
        recepten.clear();
    }

    @Override
    public <S extends Recept> S save(S entity) {
        if (entity.getId() == 0){
            entity.setId(nextId.getAndIncrement());
        }
        recepten.put(entity.getId(), entity);
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
        return Optional.ofNullable(recepten.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return recepten.containsKey(id);
    }

}
