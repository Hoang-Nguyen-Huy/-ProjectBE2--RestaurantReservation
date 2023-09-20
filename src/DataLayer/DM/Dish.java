package DataLayer.DM;

public class Dish {
    private int DishID;
    private String DishName;
    private double price;
    private String description;
    private float DishRate;
    public Dish () {

    }
    public Dish(int DishID, String DishName, double price, String description, float DishRate) {
        this.DishID = DishID;
        this.DishName = DishName;
        this.price = price;
        this.description = description;
        this.DishRate = DishRate;

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

    public float getDishRate() {
        return DishRate;
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

    public void setDishRate(float DishRate) {
        this.DishRate = DishRate;
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
