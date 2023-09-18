package DataLayer.DAO.DM;

public class TableOfRestaurant {
    private int TableID;
    private int Capacity;
    private String TableType;
    private String TableStatus;
    private Admin admin;

    public TableOfRestaurant () {

    }
    public TableOfRestaurant (int TableID, int Capacity, String TableType, String TableStatus, Admin admin) {
        this.TableID = TableID;
        this.Capacity = Capacity;
        this.TableType = TableType;
        this.TableStatus = TableStatus;
        this.admin = admin;
    }

    public int getTableID() {
        return TableID;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getTableType() {
        return TableType;
    }

    public String getTableStatus() {
        return TableStatus;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setTableID(int TableID) {
        this.TableID = TableID;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public void setTableType(String TableType) {
        this.TableType = TableType;
    }

    public void setTableStatus(String TableStatus) {
        this.TableStatus = TableStatus;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "TableOfRestaurant{" +
                "TableID=" + TableID +
                ", Capacity=" + Capacity +
                ", TableType='" + TableType + '\'' +
                ", TableStatus='" + TableStatus + '\'' +
                '}';
    }
}
