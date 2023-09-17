package DM;

import java.time.LocalDateTime;

public class Reservation {
    private int ReservationID;
    private String FullName;
    private String Email;
    private String Phone;
    private LocalDateTime BookingDateTime;
    private int NumberOfPeople;
    private String Requirement;

    private Customer customer;

    public Reservation () {

    }
    public Reservation(int ReservationID, String FullName, String Email, String Phone, LocalDateTime BookingDateTime, int NumberOfPeople, String Requirement, Customer customer) {
        this.ReservationID = ReservationID;
        this.FullName = FullName;
        this.Email = Email;
        this.Phone = Phone;
        this.BookingDateTime = BookingDateTime;
        this.NumberOfPeople = NumberOfPeople;
        this.Requirement = Requirement;
        this.customer = customer;
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

    public LocalDateTime getBookingDateTime() {
        return BookingDateTime;
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

    public void setBookingDateTime(LocalDateTime BookingDateTime) {
        this.BookingDateTime = BookingDateTime;
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
                ", BookingDateTime=" + BookingDateTime +
                ", NumberOfPeople=" + NumberOfPeople +
                ", Requirement='" + Requirement + '\'' +
                '}';
    }
}
