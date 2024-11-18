package v14.utils;

import v14.entity.Menu;
import v14.entity.SaleStatus;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalExample {
    public static List<Menu> filterMenus(List<Menu> menus, Predicate<Menu> condition) {
        return menus.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public static Optional<Menu> findByCondition(List<Menu> menus, Predicate<Menu> condition) {
        return menus.stream()
                .filter(condition)
                .findFirst();
    }
}
