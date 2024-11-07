package v10.repository;

import v10.entity.*;
import java.util.*;

public class InMemoryListMenuRepository implements MenuRepository<List<Menu>> {
    private List<Menu> menus;

    public InMemoryListMenuRepository() {
        menus = new ArrayList<>();

        menus.add(new KimbapMenu("김밥", 2500, "당근, 오이, 단무지"));
        menus.add(new KoreaMenu("비빔밥", 5000, 700));
        menus.add(new DumplingMenu("고기 만두", 4000, "고기"));
        menus.add(new RamenMenu("열라면", 3500, "매우 매움"));
        menus.add(new KimbapMenu("참치 김밥", 4000, "당근, 오이, 단무지, 계란, 참치, 마요네즈"));
        menus.get(1).setSaleStatus(SaleStatus.UNAVAILABLE);
    }

    @Override
    public List<Menu> findAll() {
        // 전체 메뉴를 배열에 담아서 반환 해야 합니다.
        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
        List<Menu> availableMenus = new ArrayList<>();

        for(int i = 0; i < menus.size(); i++) {
            if(menus.get(i).getSaleStatus() == SaleStatus.AVAILABLE) {
                availableMenus.add(menus.get(i));
            }
        }

        return availableMenus;
    }

    @Override
    public Menu findById(int id) {
        // 특정 메뉴를 한개만 인덱스를 통해 찾아서 반환해야 합니다.
        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
        if(id >= 1 && id <= menus.size()) {
            Menu currentSelectedMenu = menus.get(id - 1);
            if(currentSelectedMenu.getSaleStatus() == SaleStatus.AVAILABLE) return currentSelectedMenu;
        }
        return null;
    }

    @Override
    public void save(Menu menu) {
        menus.add(menu);
    }

    @Override
    public void delete(int id) {
        // id에 맞는 메뉴를 삭제합니다.
        if(id >= 1 && id <= menus.size()) {
            menus.remove(id - 1);
        }

        // 혹은 해당 삭제하려는 메뉴의 상태를 "판매 종료"로 바꾸셔도 됩니다.

//        if(id >= 1 && id <= menus.size()) {
//            menus.get(id - 1).setSaleStatus(SaleStatus.DISCONTINUED);
//        }

    }
}
