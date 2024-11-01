package v2;

import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);


    // 1. 웰컴 메시지 출력
    public void printWelcomeMessage() {
        System.out.println("[안내] 안녕하세요. 분식점에 오신것을 환영합니다.");
        System.out.println("-------------------------------------");
    }

    // 2. 주문 안내 메시지 출력
    public void printMenuSelectMessage() {
        System.out.println("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
        System.out.println("1) 김밥(1000원) 2) 계란 김밥(1500원) 3) 충무 김밥(1000원) 4) 떡볶이(2000원)");
    }

    // 3. 주문할 음식을 선택(사용자 입력)
    public int selectMenu() {
        int menuNumber = 0;

        do {
            menuNumber = sc.nextInt();
            if(menuNumber < 1 || menuNumber > 4) {
                System.out.println("[안내] 메뉴에 포함된 번호를 입력해 주세요.");
            }
        } while(menuNumber < 1 || menuNumber > 4);

        return menuNumber;
    }


    // 5. 상품 갯수 선택(사용자 입력)
    public int selectMenuCount() {
        int count;

        do {
            System.out.println("-------------------------------------");
            System.out.println("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
            System.out.println("* 최대 주문 가능 수량 : 99");
            count = sc.nextInt();
            if(count <= 0 || count >= 100) {
                System.out.println("[경고] " + count + "개는 입력할 수 없습니다.");
                System.out.println("[안내] 수량 선택 화면으로 돌아갑니다.");
            }
        } while(count <= 0 || count >= 100);

        return count;
    }


    // menuNumber에 따른 현재 선택한 상품의 금액 반환하는 메서드
    private int getCurrentMenuPrice(int menuNumber) {
        int price = 0;

        // 선택한 숫자에 따라 현재 상품의 금액을 price에 할당
        switch (menuNumber) {
            case 1 :
                price = 1000;
                break;
            case 2:
                price = 1500;
                break;
            case 3:
                price = 1000;
                break;
            case 4:
                price = 2000;
                break;
            default:
        }

        return price;
    }

    // 수량과 현재 선택한 메뉴의 가격을 계산하는 메서드
    public int calculateOrderPrice(int menuNumber, int count) {
        int currentMenuPrice = getCurrentMenuPrice(menuNumber);
        return count * currentMenuPrice;
    }
    // 6. 총 주문 금액 출력과 동시에 종료
    public void printOrderPriceMessage(int currentOrderPrice) {
        System.out.println("[안내] 주문하신 메뉴의 총 금액은 " + currentOrderPrice + "원 입니다.");
        System.out.println("이용해 주셔서 감사합니다.");
    }
}
