package v9;

import v9.entity.*;
import v9.helper.KioskIOHandler;
import v9.utils.KioskUtils;

public class Kiosk {
    private final KioskIOHandler ioHandler;

    public Kiosk(KioskIOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

//    private final Menu menuItem1 = new KimbapMenu("김밥", 2500, "당근, 오이, 단무지");
//    private final Menu menuItem2 = new KoreaMenu("비빔밥", 5000, 700);
//    private final Menu menuItem3 = new DumplingMenu("고기 만두", 4000, "고기");
//    private final Menu menuItem4 = new RamenMenu("열라면", 3500, "매우 매움");

    private final Menu[] menus = new Menu[]{
            new KimbapMenu("김밥", 2500, "당근, 오이, 단무지"),
            new KoreaMenu("비빔밥", 5000, 700),
            new DumplingMenu("고기 만두", 4000, "고기"),
            new RamenMenu("열라면", 3500, "매우 매움"),
            new KimbapMenu("참치 김밥", 4000, "당근, 오이, 단무지, 계란, 참치, 마요네즈")
    };

    // 1. 웰컴 메시지 출력
    public void printWelcomeMessage() {
        ioHandler.writeOutput("[안내] 안녕하세요. 분식점에 오신것을 환영합니다.");
        ioHandler.writeOutput("-------------------------------------");
    }

    // 2. 주문 안내 메시지 출력
    private void printMenuSelectMessage() {
        ioHandler.writeOutput("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
//        ioHandler.writeOutput("1) 김밥(2500원) 2) 비빔밥(5000원) 3) 고기 만두(4000원) 4) 열라면(3500원)");
        for(int i = 0; i < menus.length; i++) {
            ioHandler.writeOutput((i + 1) + ") "+ menus[i].getName() + "(" + menus[i].getPrice()+"원)");
        }
    }

    // 3. 주문할 음식을 선택(사용자 입력)
    public Menu selectMenu() {
        printMenuSelectMessage();
        // 입력 받는 기능을 호출
        int menuNumber = inputMenuNumber();

//        return switch (menuNumber) {
//            case 1 -> menuItem1;
//            case 2 -> menuItem2;
//            case 3 -> menuItem3;
//            case 4 -> menuItem4;
//            default -> null;
//        };
//        if(1부터 menus.length까지만 선택 가능)
        if(menuNumber >= 1 && menuNumber <= menus.length) return menus[menuNumber - 1];
        return null;
    }

    // 사용자의 입력에 따라 선택한 번호를 반환하는 메서드
    private int inputMenuNumber() {
        int menuNumber = 0;
        do {
            String input = ioHandler.readInput();
            menuNumber = KioskUtils.stringToInt(input);
            if(!KioskUtils.isValidMenuOption(menuNumber, menus.length)) {
                printMenuSelectExceptionMessage();
            }
        } while(!KioskUtils.isValidMenuOption(menuNumber, menus.length));
        return menuNumber;
    }
    // 잘못된 번호 입력시 오류 메시지를 콘솔에 출력하는 메서드
    private void printMenuSelectExceptionMessage() {
        ioHandler.writeOutput("[안내] 메뉴에 포함된 번호를 입력해 주세요.");
    }


    // 5. 상품 갯수 선택(사용자 입력)
    public int selectMenuCount() {
        printMenuCountMessage();
        return inputMenuCountNumber();
    }

    private void printMenuCountMessage() {
        ioHandler.writeOutput("-------------------------------------");
        ioHandler.writeOutput("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
        ioHandler.writeOutput("* 최대 주문 가능 수량 : 99");
    }

    private int inputMenuCountNumber() {
        int count;
        do {
            String input = ioHandler.readInput();
            count = KioskUtils.stringToInt(input);
            if(!KioskUtils.isValidQuantity(count, 99)) {
                printMenuCountExceptionMessage(count);
            }
        } while(!KioskUtils.isValidQuantity(count, 99));
        return count;
    }

    private void printMenuCountExceptionMessage(int count) {
        ioHandler.writeOutput("[경고] " + count + "개는 입력할 수 없습니다.");
        ioHandler.writeOutput("[안내] 수량 선택 화면으로 돌아갑니다.");
    }

    // 수량과 현재 선택한 메뉴의 가격을 계산하는 메서드
    private int calculateOrderPrice(Menu menu, int count) {
        return count * menu.getPrice();
    }
    // 6. 총 주문 금액 출력과 동시에 종료
    public void printOrderPriceMessage(Menu menu, int count) {
        ioHandler.writeOutput("[안내] 주문하신 상품은 : " + menu.getName() + "의 총 주문 갯수는 : " + count + "개 입니다.");
        ioHandler.writeOutput("[안내] 주문하신 메뉴의 총 금액은 " + calculateOrderPrice(menu, count) + "원 입니다.");
        ioHandler.writeOutput("이용해 주셔서 감사합니다.");
    }
}
