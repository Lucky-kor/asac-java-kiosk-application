package v7.entity;

public class RamenMenu extends Menu {
    private String spiceLevel;

    public RamenMenu(String name, int price, String spiceLevel) {
        super(name, price);
        this.spiceLevel = spiceLevel;
    }

    @Override
    public void dislpayDetails() {

    }
}
