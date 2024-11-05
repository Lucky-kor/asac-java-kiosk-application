package v5.utils;

import v5.Menu;

public class KioskUtils {
    public static int calculateTotalPrice(Menu menu, int count) {
        return menu.getPrice() * count;
    }

    // 메뉴 선택 유효성 검사 기능
    public static boolean isValidMenuOption(int option, int maxOption) {
        return option >= 1 && option <= maxOption;
    }
    // 수량 선택 유효성 검사 기능
    public static boolean isValidQuantity(int quantity, int maxQuantity) {
        return quantity >= 1 && quantity <= maxQuantity;
    }

    // 숫자 선택 유효성 검증
//    public static boolean isNumeric(String input) {
//        return input.matches("[0-9]+");
//    }

    private static boolean isNumeric(String input) {
        String number = "0123456789";
        for(int i = 0; i < input.length(); i++) {
            if(number.indexOf(input.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
    // String to int
    public static int stringToInt(String input) {
        if(isNumeric(input)) {
            return Integer.parseInt(input);
        } else {
            return -1;
        }
    }
}
