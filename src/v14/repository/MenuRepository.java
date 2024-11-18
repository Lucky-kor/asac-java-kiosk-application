package v14.repository;

import v14.entity.Menu;

import java.util.Optional;

public interface MenuRepository<T> {
    T findAll();
    Optional<Menu> findById(int id);
    void save(Menu menu);
    void delete(int id);
}
