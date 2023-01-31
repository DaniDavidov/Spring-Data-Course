package E05billsPaymentSystem.entities;

public enum CardType {
    DEBIT("DEBIT"),
    CREDIT("CREDIT");

    private final String value;

    CardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
