package DataLayer.DM;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class Reservation {
    private int ReservationID;
    private String FullName;
    private String Email;
    private String Phone;
    private Date BookingDate;
    private Time BookingTime;
    private int NumberOfPeople;
    private String Requirement;

    private int CustomerID;

    private int TableID;

    public Reservation () {

    }
    public Reservation(int ReservationID, String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, String Requirement, int CustomerID, int TaleID) {
        this.ReservationID = ReservationID;
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
        this.CustomerID = CustomerID;
        this.TableID = TaleID;
    }
    public Reservation(String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, String Requirement, int CustomerID, int TaleID) {
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
        this.CustomerID = CustomerID;
        this.TableID = TaleID;
    }

    public Reservation(int ReservationID, String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, String Requirement, int CustomerID) {
        this.ReservationID = ReservationID;
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
        this.CustomerID = CustomerID;
    }

    public Reservation(String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, String Requirement, int CustomerID) {
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
        this.CustomerID = CustomerID;
    }


    public Reservation(String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, String Requirement) {
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
    }

    public Reservation(String Phone) {
        this.Phone = Phone;
    }
    public int getReservationID() {
        return ReservationID;
    }

    public String getFullName() {
        return FullName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public Time getBookingTime() {
        return BookingTime;
    }

    public int getNumberOfPeople() {
        return NumberOfPeople;
    }

    public String getRequirement() {
        return Requirement;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public int getTableID() {
        return TableID;
    }

    public void setReservationID(int ReservationID) {
        this.ReservationID = ReservationID;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setBookingDate(Date BookingDate) {
        this.BookingDate = BookingDate;
    }

    public void setBookingTime(Time BookingTime) {
        this.BookingTime = BookingTime;
    }

    public void setNumberOfPeople(int NumberOfPeople) {
        this.NumberOfPeople = NumberOfPeople;
    }

    public void setRequirement(String Requirement) {
        this.Requirement = Requirement;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setTableID(int TableID) {
        this.TableID = TableID;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "ReservationID=" + ReservationID +
                ", FullName='" + FullName + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", BookingDate=" + BookingDate +
                ", BookingTime=" + BookingTime +
                ", NumberOfPeople=" + NumberOfPeople +
                ", Requirement='" + Requirement + '\'' +
                ", CustomerID=" + CustomerID +
                ", TableID=" + TableID +
                '}';
    }
}
