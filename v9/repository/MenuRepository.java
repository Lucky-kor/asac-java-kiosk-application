package v9.repository;

import v9.entity.Menu;

public interface MenuRepository {
    Menu[] findAll();
    Menu findById(int id);
    void save(Menu menu);
    void delete(int id);
}
