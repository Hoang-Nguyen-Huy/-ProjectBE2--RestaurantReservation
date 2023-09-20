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

    private Customer customer;

    public Reservation () {

    }
    public Reservation(int ReservationID, String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, String Requirement, Customer customer) {
        this.ReservationID = ReservationID;
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
        this.customer = customer;
    }

    public Reservation(int ReservationID, String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, String Requirement) {
        this.ReservationID = ReservationID;
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
    }
    public Reservation( String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople, Customer customer) {
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
        this.customer = customer;
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

    public Reservation(String FullName, String Email, String Phone, Date BookingDate, Time BookingTime, int NumberOfPeople) {
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDate = BookingDate;
        this.BookingTime = BookingTime;
        this.NumberOfPeople = NumberOfPeople;
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

    public Customer getCustomer() {
        return customer;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
                ", customer=" + customer +
                '}';
    }
}
