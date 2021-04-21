package DataSaving;

import Categories.*;

public class ExpenseRecord extends Record {

    private CategoriesExpenses category;
    private PaymentMethods paymentMenthod;

    public ExpenseRecord() {
    }

    public ExpenseRecord(double sum, CategoriesExpenses category, String date, PaymentMethods paymentMenthod, String comment) {
        super.setSum(sum);
        super.setComment(comment);
        this.category = category;
        super.setDate(ExceptionCatching.dateException(date));
        this.paymentMenthod = paymentMenthod;
    }

    public CategoriesExpenses getCategory() {
        return category;
    }

    public void setCategory(CategoriesExpenses category) {
        this.category = category;
    }

    public PaymentMethods getPaymentMenthod() {
        return paymentMenthod;
    }

    public void setPaymentMenthod(PaymentMethods paymentMenthod) {
        this.paymentMenthod = paymentMenthod;
    }

    @Override
    public String toString() {
        return String.format("%4s %4d %12s %10.2f %s %25s %25s %25s", "I",super.getId(), super.getDate().format(getDtf()),
                super.getSum(), "Eur", getCategory(), getPaymentMenthod(), super.getComment());
    }


    @Override
    public ExpenseRecord clone() {
        Record newRecord = super.clone();
        ExpenseRecord newExpenseRecord = new ExpenseRecord();
        newExpenseRecord.setSum(newRecord.getSum());
        newExpenseRecord.setDate(newRecord.getDate());
        newExpenseRecord.setComment(newRecord.getComment());
        newExpenseRecord.setPaymentMenthod(this.paymentMenthod);
        newExpenseRecord.setCategory(this.category);
        return newExpenseRecord;
    }

}
