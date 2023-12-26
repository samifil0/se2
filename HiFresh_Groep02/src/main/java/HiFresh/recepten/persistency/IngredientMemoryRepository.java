package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class IngredientMemoryRepository implements IngredientRepository {

    private final Map<Long, Ingredient> ingredients = new HashMap<>();
    private static final AtomicLong nextId = new AtomicLong(1);

    @Override
    public <S extends Ingredient> S save(S entity) {
        if (entity.getId() == 0) {
            entity.setId(nextId.getAndIncrement());
        }
        ingredients.put(entity.getId(), entity);
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
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return ingredients.containsKey(id);
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return new ArrayList<>(ingredients.values());
    }

    @Override
    public Iterable<Ingredient> findAllById(Iterable<Long> ids) {
        return ((Collection<Long>) ids).stream()
                .map(ingredients::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return ingredients.size();
    }

    @Override
    public void deleteById(Long id) {
        ingredients.remove(id);
    }

    @Override
    public void delete(Ingredient entity) {
        ingredients.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(ingredients::remove);
    }

    @Override
    public void deleteAll(Iterable<? extends Ingredient> entities) {
        entities.forEach(entity -> ingredients.remove(entity.getId()));
    }

    @Override
    public void deleteAll() {
        ingredients.clear();
    }
}
