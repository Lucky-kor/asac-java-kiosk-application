package v9;

import v9.entity.Menu;
import v9.helper.KioskConsoleIOHandler;

// 키오스크 프로그램의 실행을 관장하는 클래스
public class KioskApplication {
    public static void main(String[] args) {
        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(new KioskConsoleIOHandler());

        // 웰컴 메시지 출력
        kiosk.printWelcomeMessage();

        // 주문할 메뉴를 선택합니다.
        Menu menu = kiosk.selectMenu();

        // 주문할 메뉴의 수량을 입력 받습니다.
        int count = kiosk.selectMenuCount();

        // 총 주문 금액을 계산한 이후 출력하고 종료합니다.
        kiosk.printOrderPriceMessage(menu, count);
    }
}
