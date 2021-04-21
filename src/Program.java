import DataSaving.*;
import ScanningAndPrinting.*;

import java.io.File;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        Budget budget = new Budget();
        File file = new File(WorkWithFiles.getFileName());
        ArrayList<Record> recordsFromFile = budget.getData(file);
        for (Record record : recordsFromFile) {
            budget.addRecord(record);
        }

        Printing sp = new Printing();
        boolean runProgram = true;

        while (runProgram) {

            int input = MenuPrinting.menuPrint();


            switch (input) {
                case 1:
                    boolean add = true;

                    while (add) {
                        int addRecord = sp.selectionAddRecord();

                        if (addRecord == 1) {
                            Record pajamuIrasas = MenuPrinting.inputAddIncomeRecord();
                            budget.addRecord(pajamuIrasas);
                            System.out.println();
                            add = false;
                        } else if (addRecord == 2) {
                            Record islaiduIrasas = MenuPrinting.inputAddExpenseRecord();
                            budget.addRecord(islaiduIrasas);
                            System.out.println();
                            add = false;
                        } else {
                            System.out.println("Wrong choice!\n");
                        }
                    }
                    break;
                case 2:
                    boolean get = true;

                    while (get) {
                        int receivedRecord = sp.selectionGetRecords();

                        switch (receivedRecord) {
                            case 1:
                                Record oldRecord = budget.getRecord(sp.getRecord());
                                if (oldRecord != null) {
                                    sp.tableForRecords();
                                    System.out.println(oldRecord);
                                    System.out.println();
                                } else {
                                    System.out.println("Record with this ID does not exist!\n");
                                }
                                get = false;
                                break;
                            case 2:
                                ArrayList<IncomeRecord> incomeRecords = budget.getIncomeRecords();
                                double incomeSum = 0;
                                sp.tableForRecords();
                                for (IncomeRecord record : incomeRecords) {
                                    incomeSum += record.getSum();
                                    System.out.println(record);
                                }
                                System.out.println(String.format("|%-21s|   %.2f Eur", "     TOTAL SUM:", incomeSum));
                                System.out.println();
                                get = false;
                                break;
                            case 3:
                                ArrayList<ExpenseRecord> expenseRecords = budget.getExpenseRecords();
                                double expenseSum = 0;
                                sp.tableForRecords();
                                for (ExpenseRecord record : expenseRecords) {
                                    expenseSum += record.getSum();
                                    System.out.println(record);
                                }
                                System.out.println(String.format("|%-21s|   %.2f Eur", "     TOTAL:", expenseSum));
                                System.out.println();
                                get = false;
                                break;
                            default:
                                System.out.println("Wrong choice!\n");
                        }
                    }
                    break;
                case 3:
                    boolean dateBool = true;

                    while (dateBool) {
                        int byDate = sp.selectionByDate();

                        switch (byDate) {
                            case 1:
                                ArrayList<Record> recordsByDate = budget.getRecordsByDate(sp.getRecordsByDate());
                                if (!recordsByDate.isEmpty()) {
                                    sp.tableForRecords();
                                    for (Record record : recordsByDate) {
                                        System.out.println(record);
                                    }
                                    System.out.println();
                                } else {
                                    System.out.println("There are now records on this date!\n");
                                    System.out.println();
                                }
                                dateBool = false;
                                break;
                            case 2:
                                String dates = sp.getRecordsInDateInterval();
                                String[] datesArray = dates.split(",");
                                ArrayList<Record> recordsInInterval = budget.getRecordsInDateInterval(datesArray[0], datesArray[1]);
                                if (!recordsInInterval.isEmpty()) {
                                    sp.tableForRecords();
                                    for (Record record : recordsInInterval) {
                                        System.out.println(record);
                                    }
                                    System.out.println();
                                } else {
                                    System.out.println("No records in this interval!\n");
                                }
                                dateBool = false;
                                break;
                            case 3:
                                ArrayList<Record> recordsFromThisMonth = budget.getRecordsFromCurrentMonth();
                                if (!recordsFromThisMonth.isEmpty()) {
                                    sp.tableForRecords();
                                    for (Record record : recordsFromThisMonth) {
                                        System.out.println(record);
                                    }
                                    System.out.println();
                                } else {
                                    System.out.println("There are now records from this month!\n");
                                }
                                dateBool = false;
                                break;
                            default:
                                System.out.println("Wrong choice!\n");
                        }
                    }
                    break;
                case 4:
                    double balance = budget.balance();
                    System.out.println(String.format("| BALANCE: |  %.2f Eur  |\n", balance));
                    break;
                case 5:
                    budget.deleteRecord(sp.deleteRecord());
                    System.out.println("Record deleted!\n");
                    break;
                case 6:
                    int id = sp.updateRecord();
                    Record oldRecotd = budget.getRecord(id);
                    Record updatedRecord = MenuPrinting.inputUpdate(oldRecotd);
                    budget.deleteRecord(oldRecotd);
                    budget.addRecord(updatedRecord);
                    System.out.println("\nUpdated record: ");
                    sp.tableForRecords();
                    System.out.println(updatedRecord);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("BUDGET PREDICTION (from income and expense of last 3 months): ");
                    System.out.println(String.format("| %-15s |  %.2f Eur  |", "  INCOME:", budget.budgetIncomePrediction()));
                    System.out.println(String.format("| %-15s |  %.2f Eur  |", "  EXPENSE:", budget.budgetExpensePrediction()));
                    System.out.println(String.format("| %-15s |  %.2f Eur  |\n", "  BALANCE:", budget.budgetPredictionBalance()));
                    break;
                case 8:
                    budget.saveData(budget.getRecords());
                    runProgram = false;
                    break;
                default:
                    System.out.println("Wrong choice!\n");
            }
        }

    }
}
