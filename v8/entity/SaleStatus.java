package v8.entity;

public enum SaleStatus {
    AVAILABLE("판매 중", 1),
    UNAVAILABLE("판매 중지", 2),
    COMING_SOON("판매 예정", 3),
    DISCONTINUED("판매 종료", 4);

    private String status;
    private int code;

    SaleStatus(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return this.status;
    }
}
