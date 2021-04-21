package ScanningAndPrinting;

import Categories.*;

public class Printing {

    private ScannerCatchingErrors sc = new ScannerCatchingErrors();


    public int selectionAddRecord() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("|%-37s|%-37s|%-37s|", "   Select:", "   [1] add income record", "   [2] add expense record"));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        int input = sc.inputNumber();
        return input;
    }

    public int selectionGetRecords() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("|%-37s|%-37s|%-37s|", "  [1] get record by ID", "   [2] get all income records", "   [3] get all expense records"));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        int input = sc.inputNumber();
        return input;
    }

    public int selectionByDate() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("|%-37s|%-37s|%-37s|", "[1] get records of specific date", "  [2] get records in date interval", "  [3] get this month's records"));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        int input = sc.inputNumber();
        return input;
    }

    public double addSum() {
        System.out.print(String.format("|%-25s|", "  ENTER SUM:"));
        double SUM = sc.inputSum();
        return SUM;
    }

    public CategoriesIncome addIncomeCategory() {
        System.out.print(String.format("|%-25s|", "  ENTER CATEGORY:"));
        System.out.print(String.format("%-20s|%-10s|%-10s|", "  Salary", "   Debt", "   Other"));
        String category = sc.inputText();
        CategoriesIncome categoryEnum = CategoriesIncome.OTHER.value(category);
        return categoryEnum;
    }

    public CategoriesExpenses addExpenseCategory() {
        System.out.println(String.format("|%-25s|%-20s|%-25s|%-13s|", "  ENTER CATEGORY: ", "    Food produce", "   Bill payments", "   Leisure"));
        System.out.println(String.format("|%-25s|%-20s|%-25s|%-13s|", "         Clothes", "   Rent payments", "  Utilities", "    Other"));
        String category = sc.inputText();
        CategoriesExpenses categoryEnum = CategoriesExpenses.OTHER.value(category);
        return categoryEnum;
    }

    public PaymentMethods addPaymentMethod() {
        System.out.print(String.format("|%-25s|", "  PAYMENT METHOD:"));
        System.out.println(String.format("%-11s|%-15s|%-19s|%-8s|", "  Card", "  Cash", "  Bank transfer", "  Other"));
        String paymentMethod = sc.inputText();
        PaymentMethods paymentMethodEnum = PaymentMethods.OTHER.value(paymentMethod);
        return paymentMethodEnum;
    }

    public String addDate() {
        System.out.print(String.format("|%-25s|", "  ENTER DATE:"));
        String date = sc.inputText();
        return date;
    }

    public boolean isToBank() {
        System.out.print(String.format("|%-25s|%-15s|", "  RECEIVED TO BANK?", "  [true/false]"));
        boolean isToBank = sc.ivestasBoolean();
        return isToBank;
    }

    public String addComment() {
        System.out.print(String.format("|%-25s|", "  ADD COMMENT"));
        String comment = sc.inputText();
        return comment;
    }

    public int getRecord() {
        System.out.print("Enter record ID: ");
        int input = sc.inputNumber();
        return input;

    }

    public String getRecordsByDate() {
        System.out.print("Enter date: ");
        String date = sc.inputText();
        return date;

    }

    public String getRecordsInDateInterval() {
        System.out.print("Enter starting date: ");
        String startDate = sc.inputText();
        System.out.print("Enter end date: ");
        String endDate = sc.inputText();
        String dateSum = startDate + "," + endDate;
        return dateSum;
    }

    public int deleteRecord() {
        System.out.print("Enter record you want to remove ID: ");
        int input = sc.inputNumber();
        return input;
    }

    public int updateRecord() {
        System.out.print("Enter record you want to update ID: ");
        int input = sc.inputNumber();
        return input;
    }

    public void tableForRecords() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%4s %4s %12s %14s %25s %25s %25s", "I/E", "ID", "DATE", "SUM", "CATEGORY", "RECEIVED TO BANK", "COMMENT"));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public int updateNext() {
        System.out.print(String.format("|%-25s|%-25s|", "     [1] UPDATE", "      [2] NEXT"));
        int input = sc.inputNumber();
        return input;
    }


    public void saveData() {
        System.out.print("Data is being saved!");
    }

    public String getRecords() {
        System.out.print("Enter file name: ");
        String fileName = sc.inputText();
        return fileName;
    }
}
