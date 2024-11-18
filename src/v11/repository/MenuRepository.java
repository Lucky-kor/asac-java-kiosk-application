package v11.repository;

import v11.entity.Menu;

public interface MenuRepository<T> {
    T findAll();
    Menu findById(int id);
    void save(Menu menu);
    void delete(int id);
}
