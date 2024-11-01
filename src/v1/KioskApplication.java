package v1;

import java.util.Scanner;

public class KioskApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 웰컴 메시지 출력
        System.out.println("[안내] 안녕하세요. 분식점에 오신것을 환영합니다.");
        System.out.println("-------------------------------------");
        // 2. 주문 안내 메시지 출력
        System.out.println("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
        System.out.println("1) 김밥(1000원) 2) 계란 김밥(1500원) 3) 충무 김밥(1000원) 4) 떡볶이(2000원)");
        // 3. 주문할 음식을 선택(사용자 입력)

        int menuNumber = 0;

        do {
            menuNumber = sc.nextInt();
            if(menuNumber < 1 || menuNumber > 4) {
                System.out.println("[안내] 메뉴에 포함된 번호를 입력해 주세요.");
            }
        } while(menuNumber < 1 || menuNumber > 4);

        // 5. 상품 갯수 선택(사용자 입력)
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

        // price는 현재 선택한 상품의 가격
        int price = 0;
        // currentOrderedPrice는 총 금액
        int currentOrderedPrice = 0;
        String ex1 = "1";

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

        currentOrderedPrice = count * price;
        // 6. 총 주문 금액 출력과 동시에 종료
        System.out.println("[안내] 주문하신 메뉴의 총 금액은 " + currentOrderedPrice + "원 입니다.");
        System.out.println("이용해 주셔서 감사합니다.");
    }
}
