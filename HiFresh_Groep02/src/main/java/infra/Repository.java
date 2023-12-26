package infra;

public interface Repository<K, V>{

    V Save(V entity);

    void Insert(V entity);

    Iterable<V> findAll();

    boolean update(V entity);

    V findById(K id);

    void delete(K id);
}
