package v7.entity;

public abstract class Menu {
    private String name;
    private int price;
    private SaleStatus saleStatus = SaleStatus.AVAILABLE;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract void dislpayDetails();
}