package v9.repository;

import v9.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MenuRepository {
    Menu[] findAll();
    Menu findById(int id);
    void save(Menu menu);
    void delete(int id);
}
