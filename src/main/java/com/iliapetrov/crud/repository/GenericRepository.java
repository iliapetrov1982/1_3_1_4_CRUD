package main.java.com.iliapetrov.crud.repository;

import java.util.List;

public interface GenericRepository<T,ID> {
    T getById(ID id);
    List<T> getAll();
    T save(T object);
    T update (T object);
    void deleteById(ID id);
    void writeToFile(List<T> objects);
}
