package DM;

import java.time.LocalDateTime;

public class Bill {
    private int BillID;
    private LocalDateTime DateTimeOut;
    private double TotalPrice;
    private Dish dish;
    private Reservation reservation;

    public Bill () {

    }
    public Bill(int BillID, LocalDateTime DateTimeOut, double TotalPrice, Dish dish, Reservation reservation) {
        this.BillID = BillID;
        this.DateTimeOut = DateTimeOut;
        this.TotalPrice = TotalPrice;
        this.dish = dish;
        this.reservation = reservation;
    }

    public int getBillID() {
        return BillID;
    }

    public LocalDateTime getDateTimeOut () {
        return DateTimeOut;
    }
    public double getTotalPrice () {
        return TotalPrice;
    }
    public Dish getDish () {
        return dish;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setBillID(int BillID) {
        this.BillID = BillID;
    }

    public void setDateTimeOut(LocalDateTime DateTimeOut) {
        this.DateTimeOut = DateTimeOut;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "BillID=" + BillID +
                ", DateTimeOut=" + DateTimeOut +
                ", TotalPrice=" + TotalPrice +
                ", dish=" + dish +
                ", reservation=" + reservation +
                '}';
    }
}
