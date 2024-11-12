//package v12.repository;
//
//import v12.entity.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class InMemoryMapMenuRepository implements MenuRepository<Map<Integer, Menu>> {
//    private Map<Integer, Menu> menus;
//
//    public InMemoryMapMenuRepository() {
//        menus = new HashMap<>();
//
//        menus.put(1, new KimbapMenu("김밥", 2500, "당근, 오이, 단무지"));
//        menus.put(2, new KoreaMenu("비빔밥", 5000, 700));
//        menus.put(3, new DumplingMenu("고기 만두", 4000, "고기"));
//        menus.put(4, new RamenMenu("열라면", 3500, "매우 매움"));
//        menus.put(5, new KimbapMenu("참치 김밥", 4000, "당근, 오이, 단무지, 계란, 참치, 마요네즈"));
//
////        menus.get(1).setSaleStatus(SaleStatus.UNAVAILABLE);
//    }
//
//    @Override
//    public Map<Integer, Menu> findAll() {
//        // 전체 메뉴를 배열에 담아서 반환 해야 합니다.
//        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
//        Map<Integer, Menu> availableMenus = new HashMap<>();
//
//        Integer currentKey = 1;
//        for(Map.Entry<Integer, Menu> entry : menus.entrySet()) {
//            Menu menu = entry.getValue();
//            if(menu.getSaleStatus() == SaleStatus.AVAILABLE) {
//                availableMenus.put(currentKey++, menu);
//            }
//        }
//
//        return availableMenus;
//    }
//
//    @Override
//    public Menu findById(int id) {
//        // 특정 메뉴를 한개만 인덱스를 통해 찾아서 반환해야 합니다.
//        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
//        if(id >= 1 && id <= menus.size()) {
//            Menu currentSelectedMenu = menus.get(id);
//            if(currentSelectedMenu.getSaleStatus() == SaleStatus.AVAILABLE) return currentSelectedMenu;
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Menu menu) {
//        menus.put(menus.size() + 1, menu);
//    }
//
//    @Override
//    public void delete(int id) {
//        // id에 맞는 메뉴를 삭제합니다.
//        if(id >= 1 && id <= menus.size()) {
//            menus.remove(id);
//        }
//
//        // 혹은 해당 삭제하려는 메뉴의 상태를 "판매 종료"로 바꾸셔도 됩니다.
//
////        if(id >= 1 && id <= menus.size()) {
////            menus.get(id).setSaleStatus(SaleStatus.DISCONTINUED);
////        }
//
//    }
//}
