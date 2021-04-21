package DataSaving;

import Categories.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Budget {

    private ArrayList<Record> records = new ArrayList();

    public void addRecord(Record record) {
        records.add(record);
    }

    public void addRecord(double sum, CategoriesIncome category,
                          String date, boolean isToBank, String comment) {
        records.add(new IncomeRecord(sum, category, date, isToBank, comment));
    }

    public void addRecord(double sum, CategoriesExpenses category, String date,
                          PaymentMethods paymentMethod, String comment) {
        records.add(new ExpenseRecord(sum, category, date, paymentMethod, comment));
    }

    public Record getRecord(int id) {

        Record newRecord = new Record(id);

        if (records.contains(newRecord)) {

            for (Record record : records) {
                if (record.equals(newRecord)) {
                    return record;
                }
            }
        }
        return null;
    }


    public ArrayList<Record> getRecordsByDate(String date) {

        ArrayList<Record> recordsByDate = new ArrayList<>();
        LocalDate localDate = ExceptionCatching.dateException(date);

        for (Record record : records) {

            LocalDate receivedDate = record.getDate();

            if (localDate.equals(receivedDate)) {
                recordsByDate.add(record);
            }
        }
        return recordsByDate;
    }

    public ArrayList<Record> getRecordsInDateInterval(String startDate, String endDate) {
        ArrayList<Record> recordsInInterval = new ArrayList<>();

        for (Record record : records) {
            LocalDate startDate1 = ExceptionCatching.dateException(startDate);
            LocalDate endDate1 = ExceptionCatching.dateException(endDate);

            if (record.getDate().isAfter(startDate1) && record.getDate().isBefore(endDate1)) {
                recordsInInterval.add(record);
            }
        }
        return recordsInInterval;
    }

    public ArrayList<Record> getRecordsFromCurrentMonth() {
        ArrayList<Record> currentMonthRecords = new ArrayList<>();
        LocalDate presentDate = LocalDate.now();
        int year = presentDate.getYear();
        int month = presentDate.getMonthValue();

        for (Record record : records) {
            int recordYear = record.getDate().getYear();
            int recordMonth = record.getDate().getMonthValue();

            if (recordYear == year && recordMonth == month) {
                currentMonthRecords.add(record);
            }
        }

        return currentMonthRecords;
    }


    public ArrayList<IncomeRecord> getIncomeRecords() {

        ArrayList<IncomeRecord> incomeRecords = new ArrayList<>();

        for (Record record : records) {
            if (record instanceof IncomeRecord) {
                incomeRecords.add((IncomeRecord) record);
            }
        }
        return incomeRecords;
    }

    public ArrayList<ExpenseRecord> getExpenseRecords() {

        ArrayList<ExpenseRecord> expenseRecords = new ArrayList<>();

        for (Record record : records) {
            if (record instanceof ExpenseRecord) {
                expenseRecords.add((ExpenseRecord) record);
            }
        }
        return expenseRecords;
    }

    public double balance() {

        double incomeSum = 0;
        double expenseSum = 0;

        for (Record record : records) {
            if (record instanceof IncomeRecord) {
                incomeSum += record.getSum();
            } else {
                expenseSum += record.getSum();
            }
        }

        double balance = incomeSum - expenseSum;

        return balance;
    }


    public void deleteRecord(int id) {

        Record newRecord = new Record(id);
        records.remove(newRecord);

    }

    public void deleteRecord(Record record) {
        records.remove(record);
    }

    public Record updateRecord(int id) {
        Record oldRecord = getRecord(id);
        Record updatedRecord = oldRecord;
        if (oldRecord instanceof IncomeRecord) {
            addRecord(updatedRecord);
            IncomeRecord updatedIncomeRecord = (IncomeRecord) updatedRecord;
            deleteRecord(id);
            return updatedIncomeRecord;
        } else if (oldRecord instanceof ExpenseRecord) {
            addRecord(updatedRecord);
            ExpenseRecord updatedExpenseRecord = (ExpenseRecord) updatedRecord;
            deleteRecord(id);
            return updatedExpenseRecord;
        } else {
            return null;
        }
    }

    public void saveData(ArrayList<Record> records) {
        WorkWithFiles.writeToFile(records);
    }

    public double budgetIncomePrediction() {
        double incomeSum;
        int incomeQuantity;

        int thisMonth = LocalDate.now().getMonthValue();
        int lastMonth = LocalDate.now().minusMonths(1).getMonthValue();
        int lastLastMonth = LocalDate.now().minusMonths(2).getMonthValue();

        double thisMonthSum = 0;
        int thisMonthQuantity = 0;
        double lastMonthSum = 0;
        int lastMonthQuantity = 0;
        double lastLastMonthSum = 0;
        int lastLastMonthQuantity = 0;

        for (Record record : records) {
            if (record instanceof IncomeRecord) {

                if (record.getDate().getMonthValue() == thisMonth) {
                    thisMonthSum += record.getSum();
                    thisMonthQuantity ++;
                } else if (record.getDate().getMonthValue() == lastMonth) {
                    lastMonthSum += record.getSum();
                    lastMonthQuantity ++;
                } else if (record.getDate().getMonthValue() == lastLastMonth) {
                    lastLastMonthSum += record.getSum();
                    lastLastMonthQuantity++;
                }
            }
        }
        incomeSum = thisMonthSum + lastMonthSum + lastLastMonthSum;
        incomeQuantity = thisMonthQuantity + lastMonthQuantity + lastLastMonthQuantity;
        double incomePrediction = incomeSum / incomeQuantity;
        return incomePrediction;
    }

    public double budgetExpensePrediction() {
                double expenseSum;
                int expenseQuantity;

                int thisMonth = LocalDate.now().getMonthValue();
                int lastMonth = LocalDate.now().minusMonths(1).getMonthValue();
                int lastLastMonth = LocalDate.now().minusMonths(2).getMonthValue();

                double thisMonthSum = 0;
                int thisMonthQuantity = 0;
                double lastMonthSum = 0;
                int lastMonthQuantity = 0;
                double lastLastMonthSum = 0;
                int lastLastMonthQuantity = 0;

        for (Record record : records) {
            if (record instanceof ExpenseRecord) {

                if (record.getDate().getMonthValue() == thisMonth) {
                    thisMonthSum += record.getSum();
                    thisMonthQuantity ++;
                } else if (record.getDate().getMonthValue() == lastMonth) {
                    lastMonthSum += record.getSum();
                    lastMonthQuantity ++;
                } else if (record.getDate().getMonthValue() == lastLastMonth) {
                    lastLastMonthSum += record.getSum();
                    lastLastMonthQuantity++;
                }
            }
        }
        expenseSum = thisMonthSum + lastMonthSum + lastLastMonthSum;
        expenseQuantity = thisMonthQuantity + lastMonthQuantity + lastLastMonthQuantity;

        double expensePrediction = expenseSum / expenseQuantity;
        return expensePrediction;
    }

    public double budgetPredictionBalance() {
        double balancePrediction = budgetIncomePrediction() - budgetExpensePrediction();
        return balancePrediction;
    }

    public ArrayList<Record> getData(File file)  {
        ArrayList<Record> recordsFromFile = new ArrayList<>();
        try {
            recordsFromFile = WorkWithFiles.skaitytiIsFailo(file);
        } catch (IOException e) {
            System.out.println("Error receiving data from file!");
        }
        return recordsFromFile;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }
}



