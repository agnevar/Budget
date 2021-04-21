package DataSaving;

import Categories.PaymentMethods;
import Categories.CategoriesExpenses;
import Categories.CategoriesIncome;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class WorkWithFiles {

    private static final char SEPARATOR = ',';
    private static final String NEW_LINE = "\n";
    private static final String FILE_NAME = "D:\\Agnes\\java\\Biudzetas1\\src\\BudgetFiles\\recordedBudget.csv";


    public static void writeToFile(ArrayList<Record> records) {

        try {
            File recordedBudget = new File(FILE_NAME);
            if (!recordedBudget.exists()) {
                recordedBudget.createNewFile();
            }

            FileWriter fw = new FileWriter(recordedBudget, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (Record elementas : records) {
                if (elementas instanceof IncomeRecord) {
                    pw.print("I");
                    pw.print(SEPARATOR);
                    pw.print(elementas.getId());
                    pw.print(SEPARATOR);
                    pw.print(elementas.getDate());
                    pw.print(SEPARATOR);
                    pw.print(elementas.getSum());
                    pw.print(SEPARATOR);
                    pw.print(((IncomeRecord) elementas).getCategory());
                    pw.print(SEPARATOR);
                    pw.print(((IncomeRecord) elementas).getToBank());
                    pw.print(SEPARATOR);
                    pw.print(elementas.getComment());
                    pw.print(NEW_LINE);
                } else if (elementas instanceof ExpenseRecord){
                    pw.print("E");
                    pw.print(SEPARATOR);
                    pw.print(elementas.getId());
                    pw.print(SEPARATOR);
                    pw.print(elementas.getDate());
                    pw.print(SEPARATOR);
                    pw.print(elementas.getSum());
                    pw.print(SEPARATOR);
                    pw.print(((ExpenseRecord) elementas).getCategory());
                    pw.print(SEPARATOR);
                    pw.print(((ExpenseRecord) elementas).getPaymentMenthod());
                    pw.print(SEPARATOR);
                    pw.print(elementas.getComment());
                    pw.print(NEW_LINE);
                }
            }
            pw.close();

        } catch (IOException e) {
            System.out.println("Error writing data to file! Please try again");
        }

    }

    public static ArrayList<Record> skaitytiIsFailo(File file) throws IOException {

        ArrayList<Record> irasai = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;

        while ((line = br.readLine()) != null) {

            String[] array = line.split(",");
            Record record;
            if (array[0].equalsIgnoreCase("I")) {
                record = new IncomeRecord();
                record.setDate(LocalDate.parse(array[2]));
                record.setSum(Double.parseDouble(array[3]));
                ((IncomeRecord) record).setCategory(CategoriesIncome.OTHER.value(array[4]));
                ((IncomeRecord) record).setToBank(Boolean.valueOf(array[5]));
                record.setComment(array[6]);
                irasai.add(record);
            } else if (array[0].equalsIgnoreCase("E")) {
                record = new ExpenseRecord();
                record.setDate(LocalDate.parse(array[2]));
                record.setSum(Double.parseDouble(array[3]));
                ((ExpenseRecord) record).setCategory(CategoriesExpenses.OTHER.value(array[4]));
                ((ExpenseRecord) record).setPaymentMenthod(PaymentMethods.OTHER.value(array[5]));
                record.setComment(array[6]);
                irasai.add(record);
            }

        }
        br.close();
        return irasai;
    }

    public static char getSEPARATOR() {
        return SEPARATOR;
    }

    public static String getNewLine() {
        return NEW_LINE;
    }

    public static String getFileName() {
        return FILE_NAME;
    }
}
