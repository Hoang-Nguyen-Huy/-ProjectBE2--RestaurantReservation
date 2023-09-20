package DataLayer.DM;

public class Customer {
    protected int CustomerID;
    private String CustomerName;
    private String CustomerEmail;
    private String CustomerPhone;

    public Customer () {

    }
    public Customer (int CustomerID, String CustomerName, String CustomerEmail, String CustomerPhone) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.CustomerEmail = CustomerEmail;
        this.CustomerPhone = CustomerPhone;
    }

    public Customer(String CustomerName, String CustomerEmail, String CustomerPhone) {
        this.CustomerName = CustomerName;
        this.CustomerEmail = CustomerEmail;
        this.CustomerPhone = CustomerPhone;
    }

    public Customer(int CustomerID) {
        this.CustomerID = CustomerID;
    }
    public int getCustomerID() {
        return CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setCustomerEmail(String CustomerEmail) {
        this.CustomerEmail = CustomerEmail;
    }

    public void setCustomerPhone(String CustomerPhone) {
        this.CustomerPhone = CustomerPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID=" + CustomerID +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", CustomerPhone='" + CustomerPhone + '\'' +
                '}';
    }
}
