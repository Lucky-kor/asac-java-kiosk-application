package v12;

import v12.entity.Menu;
import v12.helper.KioskIOHandler;
import v12.repository.MenuRepository;
import v12.utils.KioskUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Kiosk {
    private final KioskIOHandler ioHandler;
    private final MenuRepository<List<Menu>> menuRepository;

    public Kiosk(KioskIOHandler ioHandler, MenuRepository menuRepository) {
        this.ioHandler = ioHandler;
        this.menuRepository = menuRepository;
    }

    // 1. 웰컴 메시지 출력
    public void printWelcomeMessage() {
        ioHandler.writeOutput("[안내] 안녕하세요. 분식점에 오신것을 환영합니다.");
        ioHandler.writeOutput("-------------------------------------");
    }

    // 2. 주문 안내 메시지 출력
    private void printMenuSelectMessage() {
        ioHandler.writeOutput("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");

        List<Menu> menus = menuRepository.findAll();

        if(menus.size() == 0) ioHandler.writeOutput("판매 가능한 상품이 없습니다.");
        else {
            for(int i = 0; i < menus.size(); i++) {
                ioHandler.writeOutput((i + 1) + ") "+ menus.get(i).getName() + "(" + menus.get(i).getPrice()+"원)");
            }
        }
    }

    // 3. 주문할 음식을 선택(사용자 입력)
    public Menu selectMenu() {
        printMenuSelectMessage();
        // 입력 받는 기능을 호출
        int menuNumber = inputMenuNumber();

//        return menuRepository.findById(menuNumber);
        Optional<Menu> selectedMenu = menuRepository.findById(menuNumber);

        if(selectedMenu.isPresent()) {
            // selectedMenu는 무조건 null이 아님을 보장
            return selectedMenu.get();
        }

        printMenuSelectExceptionMessage();
        return null;
    }

    // 사용자의 입력에 따라 선택한 번호를 반환하는 메서드
    private int inputMenuNumber() {
        List<Menu> menus = menuRepository.findAll();

        int menuNumber = 0;
        do {
            String input = ioHandler.readInput();
            menuNumber = v10.utils.KioskUtils.stringToInt(input);
            if(!KioskUtils.isValidMenuOption(menuNumber, menus.size())) {
                printMenuSelectExceptionMessage();
            }
        } while(!KioskUtils.isValidMenuOption(menuNumber, menus.size()));
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
            count = v10.utils.KioskUtils.stringToInt(input);
            if(!v10.utils.KioskUtils.isValidQuantity(count, 99)) {
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