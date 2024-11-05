package v9.repository;

import v9.entity.*;

public class InMemoryArrayMenuRepository implements MenuRepository{
    private Menu[] menus;
    private int menuCount;

    public InMemoryArrayMenuRepository() {
        menus = new Menu[10];
        menuCount = 5;

        menus[0] = new KimbapMenu("김밥", 2500, "당근, 오이, 단무지"),
        menus[1] = new KoreaMenu("비빔밥", 5000, 700),
        menus[2] = new DumplingMenu("고기 만두", 4000, "고기"),
        menus[3] = new RamenMenu("열라면", 3500, "매우 매움"),
        menus[4] = new KimbapMenu("참치 김밥", 4000, "당근, 오이, 단무지, 계란, 참치, 마요네즈")
    }

    @Override
    public Menu[] findAll() {
        // 전체 메뉴를 배열에 담아서 반환 해야 합니다.
        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
        return new Menu[0];
    }

    @Override
    public Menu findById(int id) {
        // 특정 메뉴를 한개만 인덱스를 통해 찾아서 반환해야 합니다.
        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
        return null;
    }

    @Override
    public void save(Menu menu) {
        // 배열의 크기가 가득 찼다면, 배열을 확장하고 데이터를 추가해야 합니다.
    }

    @Override
    public void delete(int id) {
        // id에 맞는 메뉴를 삭제합니다.
        // 직접 메뉴를 배열에서 지우셔도 됩니다.
        // 혹은 해당 삭제하려는 메뉴의 상태를 "판매 종료"로 바꾸셔도 됩니다.
    }
}
