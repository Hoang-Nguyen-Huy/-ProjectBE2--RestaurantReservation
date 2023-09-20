package DataLayer.DM;

public class TableOfRestaurant {
    private int TableID;
    private int Capacity;
    private String TableType;
    private String TableStatus;

    public TableOfRestaurant () {

    }
    public TableOfRestaurant (int TableID, int Capacity, String TableType, String TableStatus) {
        this.TableID = TableID;
        this.Capacity = Capacity;
        this.TableType = TableType;
        this.TableStatus = TableStatus;
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
