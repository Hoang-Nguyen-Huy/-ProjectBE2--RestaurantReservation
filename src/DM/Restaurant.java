package DM;

import java.time.LocalTime;

public class Restaurant {
    private int RestaurantID;
    private String RestaurantName;
    private String Address;
    private String RestaurantPhone;
    private String RestaurantDescription;
    private LocalTime OpenTime;
    private LocalTime CloseTime;
    private Admin admin;

    public Restaurant () {

    }
    public Restaurant(int RestaurantID, String RestaurantName, String Address, String RestaurantPhone, String RestaurantDescription, LocalTime OpenTime, LocalTime CloseTime, Admin admin) {
        this.RestaurantID = RestaurantID;
        this.RestaurantName = RestaurantName;
        this.Address = Address;
        this.RestaurantPhone = RestaurantPhone;
        this.RestaurantDescription = RestaurantDescription;
        this.OpenTime = OpenTime;
        this.CloseTime = CloseTime;
        this.admin = admin;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public String getAddress() {
        return Address;
    }

    public String getRestaurantPhone() {
        return RestaurantPhone;
    }

    public String getRestaurantDescription() {
        return RestaurantDescription;
    }

    public LocalTime getOpenTime() {
        return OpenTime;
    }

    public LocalTime getCloseTime() {
        return CloseTime;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setRestaurantID(int RestaurantID) {
        this.RestaurantID = RestaurantID;
    }

    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public void setRestaurantPhone(String RestaurantPhone) {
        this.RestaurantPhone = RestaurantPhone;
    }

    public void setRestaurantDescription(String RestaurantDescription) {
        this.RestaurantDescription = RestaurantDescription;
    }

    public void setOpenTime(LocalTime OpenTime) {
        this.OpenTime = OpenTime;
    }

    public void setCloseTime(LocalTime CloseTime) {
        this.CloseTime = CloseTime;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "RestaurantID=" + RestaurantID +
                ", RestaurantName='" + RestaurantName + '\'' +
                ", Address='" + Address + '\'' +
                ", RestaurantPhone='" + RestaurantPhone + '\'' +
                ", RestaurantDescription='" + RestaurantDescription + '\'' +
                ", OpenTime=" + OpenTime +
                ", CloseTime=" + CloseTime +
                '}';
    }
}
