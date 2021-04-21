package ScanningAndPrinting;

import Categories.*;
import DataSaving.*;

public class MenuPrinting {

    public static int menuPrint() {
        ScannerCatchingErrors sc = new ScannerCatchingErrors();
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("|%-25s|%-25s|%-35s|%-25s|", "   [1] add record", "   [2] get record", "   [3] get record by date", "   [4] get balance"));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("|%-25s|%-25s|%-35s|%-25s|", "   [5] delete record","   [6] update record", "   [7] budget prediction", "   [8] exit program"));
        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        int input = sc.inputNumber();
        return input;
    }

    public static Record inputAddIncomeRecord() {
        Printing pr = new Printing();

        double sum = pr.addSum();
        CategoriesIncome category = pr.addIncomeCategory();
        String date = pr.addDate();
        boolean isToBank = pr.isToBank();
        String comment = pr.addComment();

        IncomeRecord incomeRecord = new IncomeRecord(sum, category, date, isToBank, comment);

        return incomeRecord;
    }

    public static Record inputAddExpenseRecord() {
        Printing pr = new Printing();

        double sumExpense = pr.addSum();
        CategoriesExpenses categoryExpense = pr.addExpenseCategory();
        String dateExpense = pr.addDate();
        PaymentMethods paymentMethod = pr.addPaymentMethod();
        String commentExpense = pr.addComment();

        ExpenseRecord expenseRecord = new ExpenseRecord(sumExpense, categoryExpense,
                dateExpense, paymentMethod, commentExpense);

        return expenseRecord;
    }

    public static Record inputUpdate(Record selectedRecord) {

        Printing pr = new Printing();

        if (selectedRecord instanceof IncomeRecord) {
            IncomeRecord oldRecordIncome = (IncomeRecord) selectedRecord;
            IncomeRecord updatedRecordIncome = oldRecordIncome.clone();

            System.out.println("Sum: " + selectedRecord.getSum());
            int inputSum = pr.updateNext();
            if (inputSum == 1) {
                double newSum = pr.addSum();
                updatedRecordIncome.setSum(newSum);
            }
            System.out.println("Date: " + selectedRecord.getDate());
            int inputDate = pr.updateNext();
            if (inputDate == 1) {
                String newDate = pr.addDate();
                updatedRecordIncome.setDate(ExceptionCatching.dateException(newDate));
            }
            System.out.println("Comment: " + selectedRecord.getComment());
            int inputComment = pr.updateNext();
            if (inputComment == 1) {
                String newComment = pr.addComment();
                updatedRecordIncome.setComment(newComment);
            }

            System.out.println("Category: " + oldRecordIncome.getCategory());
            int inputCategory = pr.updateNext();
            if (inputCategory == 1) {
                CategoriesIncome newCategory = pr.addIncomeCategory();
                updatedRecordIncome.setCategory(newCategory);
            }

            System.out.println("Received to bank: " + oldRecordIncome.getToBank());
            int inputIsToBank = pr.updateNext();
            if (inputIsToBank == 1) {
                boolean newIsToBank = pr.isToBank();
                updatedRecordIncome.setToBank(newIsToBank);
            }
            return updatedRecordIncome;

        } else {
            ExpenseRecord oldExpenseRecord = (ExpenseRecord) selectedRecord;
            ExpenseRecord updatedExpenseRecord = oldExpenseRecord.clone();


            System.out.println("Sum: " + selectedRecord.getSum());
            int inputSum = pr.updateNext();
            if (inputSum == 1) {
                double newSum = pr.addSum();
                updatedExpenseRecord.setSum(newSum);
            }
            System.out.println("Date: " + selectedRecord.getDate());
            int inputDate = pr.updateNext();
            if (inputDate == 1) {
                String newDate = pr.addDate();
                updatedExpenseRecord.setDate(ExceptionCatching.dateException(newDate));
            }
            System.out.println("Comment: " + selectedRecord.getComment());
            int inputComment = pr.updateNext();
            if (inputComment == 1) {
                String newComment = pr.addComment();
                updatedExpenseRecord.setComment(newComment);
            }

            System.out.println("Category: " + oldExpenseRecord.getCategory());
            int inputCategory = pr.updateNext();
            if (inputCategory == 1) {
                CategoriesExpenses newCategory = pr.addExpenseCategory();
                updatedExpenseRecord.setCategory(newCategory);
            }

            System.out.println("Payment method: " + oldExpenseRecord.getPaymentMenthod());
            int inputPaymentMethod = pr.updateNext();
            if (inputPaymentMethod == 1) {
                PaymentMethods newPaymentMethod = pr.addPaymentMethod();
                updatedExpenseRecord.setPaymentMenthod(newPaymentMethod);
            }
            return updatedExpenseRecord;
        }

    }

}
