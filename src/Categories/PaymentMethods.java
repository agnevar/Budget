package Categories;

public enum PaymentMethods {

    CARD("Card"),
    CASH("Cash"),
    TRANSFER("Bank transfer"),
    OTHER("Other");

    private String text;

    PaymentMethods(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public PaymentMethods value(String tekstas) {

        switch (tekstas) {
            case "Card":
                return CARD;
            case "Cash":
                return CASH;
            case "Bank transfer":
                return TRANSFER;
            default:
                return OTHER;
        }
    }

    @Override
    public String toString() {
        return text;
    }

}
