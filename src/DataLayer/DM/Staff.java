package DataLayer.DM;

public class Staff {
    private int StaffID;
    private String StaffName;
    private String StaffPhone;
    private String StaffRole;
    private Admin admin;

    public Staff () {

    }
    public Staff(int StaffID, String StaffName, String StaffPhone, String StaffRole, Admin admin) {
        this.StaffID = StaffID;
        this.StaffName = StaffName;
        this.StaffPhone = StaffPhone;
        this.StaffRole = StaffRole;
        this.admin = admin;
    }

    public int getStaffID() {
        return StaffID;
    }
    public String getStaffName () {
        return StaffName;
    }

    public String getStaffPhone() {
        return StaffPhone;
    }

    public String getStaffRole() {
        return StaffRole;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public void setStaffPhone(String StaffPhone) {
        this.StaffPhone = StaffPhone;
    }

    public void setStaffRole (String StaffRole) {
        this.StaffRole = StaffRole;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "StaffID=" + StaffID +
                ", StaffName='" + StaffName + '\'' +
                ", StaffPhone='" + StaffPhone + '\'' +
                ", StaffRole='" + StaffRole + '\'' +
                '}';
    }
}
