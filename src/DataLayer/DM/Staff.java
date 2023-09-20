package DataLayer.DM;

public class Staff {
    private int StaffID;
    private String StaffName;
    private String StaffPhone;
    private String StaffRole;

    public Staff () {

    }
    public Staff(int StaffID, String StaffName, String StaffPhone, String StaffRole) {
        this.StaffID = StaffID;
        this.StaffName = StaffName;
        this.StaffPhone = StaffPhone;
        this.StaffRole = StaffRole;
    }
    public Staff(String StaffName, String StaffPhone, String StaffRole) {
        this.StaffName = StaffName;
        this.StaffPhone = StaffPhone;
        this.StaffRole = StaffRole;
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
