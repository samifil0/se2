package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Ingredient;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class IngredientCataloogMemoryRepository implements IngredientCataloogRepository {

    private final Map<Long, Ingredient> ingredientenCataloog = new HashMap<>();
    private static final AtomicLong nextId = new AtomicLong(1);

    @Override
    public <S extends Ingredient> S save(S entity) {
        if (entity.getId() == 0) {
            entity.setId(nextId.getAndIncrement());
        }
        ingredientenCataloog.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        for (S entity : entities) {
            savedEntities.add(save(entity));
        }
        return savedEntities;
    }

    @Override
    public Optional<Ingredient> findById(Long id) {
        return Optional.ofNullable(ingredientenCataloog.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return ingredientenCataloog.containsKey(id);
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return new ArrayList<>(ingredientenCataloog.values());
    }

    @Override
    public Iterable<Ingredient> findAllById(Iterable<Long> ids) {
        return ((Collection<Long>) ids).stream()
                .map(ingredientenCataloog::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return ingredientenCataloog.size();
    }

    @Override
    public void deleteById(Long id) {
        ingredientenCataloog.remove(id);
    }

    @Override
    public void delete(Ingredient entity) {
        ingredientenCataloog.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(ingredientenCataloog::remove);
    }

    @Override
    public void deleteAll(Iterable<? extends Ingredient> entities) {
        entities.forEach(entity -> ingredientenCataloog.remove(entity.getId()));
    }

    @Override
    public void deleteAll() {
        ingredientenCataloog.clear();
    }
}
