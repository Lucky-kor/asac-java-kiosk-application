package v13.entity;

public class DumplingMenu extends Menu {
    private String fillingType;

    public DumplingMenu(String name, int price, String fillingType) {
        super(name, price);
        this.fillingType = fillingType;
    }

    @Override
    public void dislpayDetails() {

    }
}
