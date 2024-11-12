package v12.entity;

public class KoreaMenu extends Menu {
    private int kcal;

    public KoreaMenu(String name, int price) {
        super(name, price);
    }

    public KoreaMenu(String name, int price, int kcal) {
        this(name, price);
        this.kcal = kcal;
    }

    @Override
    public void dislpayDetails() {
        System.out.println("메뉴: " + this.getName() + " , 가격: " + this.getPrice() + "원");
    }
}
