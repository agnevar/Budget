package Categories;

public enum CategoriesIncome {

    SALARY("Salary"),
    DEBT("Debt"),
    OTHER("Other");

    private String text;

    CategoriesIncome(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public CategoriesIncome value(String tekstas) {

        switch (tekstas) {
            case "Salary":
                return SALARY;
            case "Debt":
                return DEBT;
            default:
                return OTHER;
        }
    }

    @Override
    public String toString() {
        return text;
    }



}
