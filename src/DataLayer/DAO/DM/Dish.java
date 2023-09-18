package DataLayer.DAO.DM;

public class Dish {
    private int DishID;
    private String DishName;
    private double price;
    private String description;
    private int DishRate;
    private MenuItem menuItem;
    public Dish () {

    }
    public Dish(int DishID, String DishName, double price, String description, int DishRate, MenuItem menuItem) {
        this.DishID = DishID;
        this.DishName = DishName;
        this.price = price;
        this.description = description;
        this.DishRate = DishRate;
        this.menuItem = menuItem;
    }

    public int getDishID() {
        return DishID;
    }

    public String getDishName() {
        return DishName;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getDishRate() {
        return DishRate;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setDishID(int DishID) {
        this.DishID = DishID;
    }

    public void setDishName(String DishName) {
        this.DishName = DishName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDishRate(int DishRate) {
        this.DishRate = DishRate;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "DishID=" + DishID +
                ", DishName='" + DishName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", DishRate=" + DishRate +
                '}';
    }
}
