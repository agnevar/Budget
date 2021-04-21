package DataSaving;

import Categories.*;

public class IncomeRecord extends Record {

    private CategoriesIncome category;
    private boolean isToBank;
    private String messageIsToBank;

    public IncomeRecord() {
    }

    public IncomeRecord(double sum, CategoriesIncome category, String date, boolean isToBank, String comment) {
        super.setSum(sum);
        super.setComment(comment);
        this.category = category;
        super.setDate(ExceptionCatching.dateException(date));
        this.isToBank = isToBank;
        this.messageIsToBank = isToBank ? "Yes" : "No";
    }


    public CategoriesIncome getCategory() {
        return category;
    }

    public void setCategory(CategoriesIncome category) {
        this.category = category;
    }

    public boolean getToBank() {
        return isToBank;
    }

    public void setToBank(boolean toBank) {
        this.isToBank = toBank;
        this.messageIsToBank = toBank ? "Yes" : "No";
    }


    @Override
    public String toString() {
        return String.format("%4s %4d %12s %10.2f %s %25s %25s %25s", "P", super.getId(), super.getDate().format(getDtf()),
                super.getSum(), "Eur", getCategory(), messageIsToBank, super.getComment());
    }

    @Override
    public IncomeRecord clone() {
        Record newRecord = super.clone();
        IncomeRecord newIncomeRecord = new IncomeRecord();
        newIncomeRecord.setSum(newRecord.getSum());
        newIncomeRecord.setDate(newRecord.getDate());
        newIncomeRecord.setComment(newRecord.getComment());
        newIncomeRecord.setCategory(this.category);
        newIncomeRecord.setToBank(this.isToBank);
        return newIncomeRecord;
    }

}
