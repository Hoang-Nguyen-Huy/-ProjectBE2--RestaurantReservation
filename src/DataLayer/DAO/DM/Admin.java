package DataLayer.DAO.DM;

public class Admin {
    private int AdminID;
    private String AdminName;
    private String AdminEmail;
    private String AdminPassword;

    public Admin () {

    }
    public Admin (int AdminID, String AdminName, String AdminEmail, String AdminPassword) {
        this.AdminID = AdminID;
        this.AdminName = AdminName;
        this.AdminEmail = AdminEmail;
        this.AdminPassword = AdminPassword;
    }

    public int getAdminID() {
        return AdminID;
    }

    public String getAdminName() {
        return AdminName;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }
    public void setAdminName(String AdminName) {
        this.AdminName = AdminName;
    }
    public void setAdminEmail(String AdminEmail) {
        this.AdminEmail = AdminEmail;
    }
    public void setAdminPassword(String AdminPassword) {
        this.AdminPassword = AdminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminID=" + AdminID +
                ", AdminName='" + AdminName + '\'' +
                ", AdminEmail='" + AdminEmail + '\'' +
                ", AdminPassword='" + AdminPassword + '\'' +
                '}';
    }
}
