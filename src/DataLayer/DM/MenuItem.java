package DataLayer.DM;

public class MenuItem {
    private int MenuID;
    private String MenuCategory;

    public MenuItem () {

    }
    public MenuItem(int MenuID, String MenuCategory) {
        this.MenuID = MenuID;
        this.MenuCategory = MenuCategory;
    }

    public int getMenuID() {
        return MenuID;
    }

    public String getMenuCategory() {
        return MenuCategory;
    }


    public void setMenuID(int MenuID) {
        this.MenuID = MenuID;
    }

    public void setMenuCategory(String MenuCategory) {
        this.MenuCategory = MenuCategory;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "MenuID=" + MenuID +
                ", MenuCategory='" + MenuCategory + '\'' +
                '}';
    }
}
