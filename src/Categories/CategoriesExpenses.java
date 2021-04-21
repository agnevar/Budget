package Categories;

public enum CategoriesExpenses {

    FOOD_PRODUCTS("Food products"),
    BILL_PAYMENTS("Bill payments"),
    LEISURE("Leisure"),
    CLOTHES("Clothes"),
    RENT("Rent payment"),
    UTILITIES("Utilities"),
    OTHER("Other");

    private String text;

    CategoriesExpenses(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public CategoriesExpenses value(String tekstas) {

        switch (tekstas) {
            case "Food products":
                return FOOD_PRODUCTS;
            case "Bill payments":
                return BILL_PAYMENTS;
            case "Leisure":
                return LEISURE;
            case "Clothes":
                return CLOTHES;
            case "Rent payment":
                return RENT;
            case "Utilities":
                return UTILITIES;
            default:
                return OTHER;
        }
    }

    @Override
    public String toString() {
        return text;
    }
}
