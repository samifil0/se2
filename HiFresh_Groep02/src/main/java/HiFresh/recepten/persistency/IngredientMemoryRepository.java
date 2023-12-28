package HiFresh.recepten.persistency;

import HiFresh.recepten.domain.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class IngredientMemoryRepository extends IngredientRepository {

    private final Map<Long, Ingredient> ingredients = new HashMap<>();
    private static final AtomicLong nextId = new AtomicLong(1);

    public <S extends Ingredient> S save(S entity) {
        if (entity.getId() == 0) {
            entity.setId(nextId.getAndIncrement());
        }
        ingredients.put(entity.getId(), entity);
        return entity;
    }

    public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        for (S entity : entities) {
            savedEntities.add(save(entity));
        }
        return savedEntities;
    }

    public Optional<Ingredient> findById(Long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    public boolean existsById(Long id) {
        return ingredients.containsKey(id);
    }

    public Iterable<Ingredient> findAll() {
        return new ArrayList<>(ingredients.values());
    }

    public Iterable<Ingredient> findAllById(Iterable<Long> ids) {
        return ((Collection<Long>) ids).stream()
                .map(ingredients::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public long count() {
        return ingredients.size();
    }

    public void deleteById(Long id) {
        ingredients.remove(id);
    }

    public void delete(Ingredient entity) {
        ingredients.remove(entity.getId());
    }

    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(ingredients::remove);
    }

    public void deleteAll(Iterable<? extends Ingredient> entities) {
        entities.forEach(entity -> ingredients.remove(entity.getId()));
    }

    public void deleteAll() {
        ingredients.clear();
    }
}
