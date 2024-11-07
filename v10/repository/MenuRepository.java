package v10.repository;

import v10.entity.Menu;

import java.util.List;

public interface MenuRepository<T> {
    T findAll();
    Menu findById(int id);
    void save(Menu menu);
    void delete(int id);
}
