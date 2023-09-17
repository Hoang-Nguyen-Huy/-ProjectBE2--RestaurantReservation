package DM;

import java.time.LocalDateTime;

public class Payment {
    private int PaymentID;
    private String Method;
    private double Amount;
    private LocalDateTime DateTimePay;

    private Bill bill;

    public Payment() {

    }
    public Payment(int PaymentID, String Method, double Amount, LocalDateTime DateTimePay, Bill bill) {
        this.PaymentID = PaymentID;
        this.Method = Method;
        this.Amount = Amount;
        this.DateTimePay = DateTimePay;
        this.bill = bill;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public String getMethod() {
        return Method;
    }

    public double getAmount() {
        return Amount;
    }

    public LocalDateTime getDateTimePay() {
        return DateTimePay;
    }

    public Bill getBill() {
        return bill;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public void setMethod(String Method) {
        this.Method = Method;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public void setDateTimePay(LocalDateTime DateTimePay) {
        this.DateTimePay = DateTimePay;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PaymentID=" + PaymentID +
                ", Method='" + Method + '\'' +
                ", Amount=" + Amount +
                ", DateTimePay=" + DateTimePay +
                ", bill=" + bill +
                '}';
    }
}
