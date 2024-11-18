package v11.entity;

public class KimbapMenu extends Menu {
    private String ingredients;

    public KimbapMenu(String name, int price, String ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    @Override
    public void dislpayDetails() {

    }
}
