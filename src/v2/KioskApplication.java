package v2;

// 키오스크 프로그램의 실행을 관장하는 클래스
public class KioskApplication {
    public static void main(String[] args) {
        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();

        // 웰컴 메시지 출력
        kiosk.printWelcomeMessage();
        // 주문 안내 메시지 출력
        kiosk.printMenuSelectMessage();
        // 주문할 메뉴를 선택합니다.
        int menuNumber = kiosk.selectMenu();

        // 주문할 메뉴의 수량을 입력 받습니다.
        int count = kiosk.selectMenuCount();

        // 전체 금액을 계산합니다.
        int currentOrderPrice = kiosk.calculateOrderPrice(menuNumber, count);

        // 총 주문 금액을 출력하고 종료합니다.
        kiosk.printOrderPriceMessage(currentOrderPrice);
    }
}
