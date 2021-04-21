package DataSaving;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Record {

    private double sum;
    private String comment;
    private static int counter = 0;
    private final int id;
    private LocalDate date;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");

    public Record(int id) {
        this.id = id;
    }

    public Record() {
        this.id = counter++;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Record.counter = counter;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Record) {
            Record record = (Record) o;
            if (id == record.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Record clone() {
        Record naujasIrasas = new Record();
        naujasIrasas.setSum(this.sum);
        naujasIrasas.setDate(this.date);
        naujasIrasas.setComment(this.comment);
        return naujasIrasas;
    }
}
