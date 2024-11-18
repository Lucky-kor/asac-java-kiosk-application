package v14.repository;

import v14.entity.*;
import v14.utils.FunctionalExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    // 필터링 예시 코드, 사용하진 않습니다.
    public List<Menu> findMenusByCondition(Predicate<Menu> condition) {
        return menus.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    @Override
    public List<Menu> findAll() {
        // 전체 메뉴를 배열에 담아서 반환 해야 합니다.
        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
        return FunctionalExample.filterMenus(menus,
                menu -> menu.getSaleStatus() == SaleStatus.AVAILABLE);
    }

    @Override
    public Optional<Menu> findById(int id) {
        return FunctionalExample.findByCondition(menus,
                menu -> menus.indexOf(menu) == id - 1 && menu.getSaleStatus() == SaleStatus.AVAILABLE);
    }

    @Override
    public void save(Menu menu) {
        // 가능성은 있음...!
        // List or DB에서 menu.getName()으로 같은 이름의 메뉴가 있는지 확인
        // -> Optional(menu) or Optional(null)
//        menus.add(menu);

        // Optional 객체로 기존의 menus에 우리가 추가할 menu와 같은 이름이 있는지를 확인해서 반환
        // Optional 객체의 안에 menu가 존재한다면 -> 아무것도 하지 않습니다 (추가 안할거니깐요!)
        // Oprional 객체의 안에 null이라면 -> 없는 상품이름이므로 등록 가능 -> menus.add로 상품 추가
        Optional<Menu> findMenu = FunctionalExample.findByCondition(menus,
                el -> el.getName().equals(menu.getName()));

        if(!findMenu.isPresent()) {
            menus.add(menu);
        }
    }

    @Override
    public void delete(int id) {
        // id에 맞는 메뉴를 삭제합니다.
        menus.get(id - 1);
        if(id >= 1 && id <= menus.size()) {
            menus.remove(id - 1);
        }
    }
}
