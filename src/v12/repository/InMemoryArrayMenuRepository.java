//package v12.repository;
//
//import v12.entity.*;
//
//public class InMemoryArrayMenuRepository implements MenuRepository<Menu[]> {
//    private Menu[] menus;
//    private int menuCount;
//    private static final int INCREMENT_COUNT = 10;
//
//    public InMemoryArrayMenuRepository() {
//        menus = new Menu[5];
//        menuCount = 5;
//
//        menus[0] = new KimbapMenu("김밥", 2500, "당근, 오이, 단무지");
//        menus[1] = new KoreaMenu("비빔밥", 5000, 700);
//        menus[2] = new DumplingMenu("고기 만두", 4000, "고기");
//        menus[3] = new RamenMenu("열라면", 3500, "매우 매움");
//        menus[4] = new KimbapMenu("참치 김밥", 4000, "당근, 오이, 단무지, 계란, 참치, 마요네즈");
////        menus[3].setSaleStatus(SaleStatus.UNAVAILABLE);
//    }
//
//    @Override
//    public Menu[] findAll() {
//        // 전체 메뉴를 배열에 담아서 반환 해야 합니다.
//        // But! AVAILABLE 상태인 메뉴만 담아야 합니다.
//        int availableMenuCount = 0;
//        // menus를 순회하면서 판매 가능한 상품의 갯수를 availableMenuCount에 할당합니다.
//        for(int i = 0; i < menus.length; i++) {
//            if(menus[i].getSaleStatus() == SaleStatus.AVAILABLE) availableMenuCount++;
//        }
//
//        // 판매할 수 있는 상품의 크기만큼의 새로운 배열을 생성합니다.
//        Menu[] availableMenus = new Menu[availableMenuCount];
//
//        // 새로운 상품을 담을 배열의 위치를 판단할 수 있는 카운터 변수를 생성합니다. 초기값은 0입니다.
//        int currentIdx = 0;
//        // menus를 순회하며 menus[i] 상품을 availableMenus[currentIdx]에 할당합니다.(복사합니다).
//        for(int i = 0; i < menus.length; i++) {
//            if(menus[i].getSaleStatus() == SaleStatus.AVAILABLE) {
//                availableMenus[currentIdx++] = menus[i];
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
//        if(id >= 1 && id <= menuCount) {
//            Menu currentSelectedMenu = menus[id - 1];
//            if(currentSelectedMenu.getSaleStatus() == SaleStatus.AVAILABLE) return currentSelectedMenu;
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Menu menu) {
//        // 배열의 크기가 가득 찼다면, 배열을 확장하고 데이터를 추가해야 합니다.
//        // TODO:
//
//        // 만약 현재 메뉴를 관리하는 배열이 가득 찼다면-> 조건문 안의 실행문들 실행
//        if(menuCount == menus.length) {
//            // 현재 menus 배열은 더 이상 메뉴 추가가 어려우므로, menus.length + INCREMENT_COUNT만큼 크기를 가진 새로운 배열을 선언
//            Menu[] currentMenuArray = new Menu[menuCount + INCREMENT_COUNT];
//            // 새로 만든 배열에 기존의 menus 안에 담겨있는 상품들을 복사
//            for(int i = 0; i < menus.length; i++) {
//                currentMenuArray[i] = menus[i];
//            }
//            // 새로 만든 배열을 menus에 할당
//            menus = currentMenuArray;
//
//            // 위 코드는 아래 한 줄로 요약할 수 있습니다.
//            // menus = Arrays.copyOf(menus, menus.length + INCREMENT_COUNT);
//        }
//        // 메뉴 배열에 새로운 상품 추가
//        menus[++menuCount] = menu;
//        // 메뉴의 숫자를 관리하는(배열의 인덱싱 관리를 위한 카운터 변수의 역할도 하고 있습니다) menuCount를 1 증가
//    }
//
//    @Override
//    public void delete(int id) {
//        // id에 맞는 메뉴를 삭제합니다.
//        if(id >= 1 && id <= menuCount) {
//            //1. 새로운 배열을 생성
//            //   menuCount - 1 크기의 배열로
//            Menu[] currentMenuArray = new Menu[--menuCount];
//            //2. 새로운 배열의 카운터 변수 선언
//            int currentIdx = 0;
//            //3. 기존 menus 배열을 순회하며 id - 1이 아닌 요소만 추가
//            for(int i = 0; i < menus.length; i++) {
//                if(i != (id - 1)) {
//                    currentMenuArray[currentIdx++] = menus[i];
//                }
//            }
//            menus = currentMenuArray;
//        }
//
//        // 혹은 해당 삭제하려는 메뉴의 상태를 "판매 종료"로 바꾸셔도 됩니다.
//        /**
//            if(id >= 1 && id <= menuCount) {
//                menus[id - 1].setSaleStatus(SaleStatus.DISCONTINUED);
//            }
//         **/
//    }
//}
