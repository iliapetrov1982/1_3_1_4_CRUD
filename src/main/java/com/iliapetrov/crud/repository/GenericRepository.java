package main.java.com.iliapetrov.crud.repository;

import java.util.List;

public interface GenericRepository<T,ID> {
    T getById(ID id);
    List<T> getAll();
    void save(T object);
    void update (T object);
    void deleteById(ID id);
    void writeToFile(List<T> objects);
}
