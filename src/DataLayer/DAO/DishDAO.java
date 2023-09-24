package DataLayer.DAO;

import BusinessLogicLayer.AdminValidation;
import DataLayer.DM.Admin;
import DataLayer.DM.Dish;
import PresentationLayer.UI.AdminMenuUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DishDAO implements DAOInterface<Dish>{
    AdminMenuUI ui = new AdminMenuUI();
    Scanner sc = new Scanner(System.in);
    public static DishDAO getInstance() {
        return new DishDAO();
    }

    @Override
    public int insert(Dish dish) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO dish(DishName, DishPrice, DishDescription, DishRate)" +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,dish.getDishName());
            pst.setDouble(2, dish.getPrice());
            pst.setString(3, dish.getDescription());
            pst.setDouble(4, dish.getDishRate());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.println("Add dish successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Dish dish) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE dish" +
                    " SET " +
                    "DishName = ?" +
                    ", DishPrice = ?" +
                    ", DishDescription = ?" +
                    ", DishRate = ?" +
                    " WHERE DishID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,dish.getDishName());
            pst.setDouble(2, dish.getPrice());
            pst.setString(3, dish.getDescription());
            pst.setDouble(4, dish.getDishRate());
            pst.setInt(5, dish.getDishID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.println("Update successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateName(Dish dish) {
        int result = 0;
        String newName = "";
        do{
            System.out.print("Enter new name dish: ");
            newName = sc.nextLine();
        }while (!AdminValidation.isValidName(newName));

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE dish" +
                    " SET " +
                    "DishName = ?" +
                    " WHERE DishID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,newName);
            pst.setInt(2, dish.getDishID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.print("Update name successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatePrice(Dish dish) {
        int result = 0;

        String sPrice = "";
        do{
            System.out.print("Enter new price: ");
            sPrice = sc.nextLine();
        }while (!AdminValidation.isValidDouble(sPrice));
        double newPrice = Double.parseDouble(sPrice);

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE dish" +
                    " SET " +
                    "DishPrice = ?" +
                    " WHERE DishID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDouble(1,newPrice);
            pst.setInt(2, dish.getDishID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.print("Update price successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateDescription(Dish dish) {
        int result = 0;
        String newDescription = "";

        do{
            System.out.print("Enter the new description: ");
            newDescription = sc.nextLine();
        }while (!AdminValidation.isValidDouble(newDescription));

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE dish" +
                    " SET " +
                    "DishDescription = ?" +
                    " WHERE DishID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,newDescription);
            pst.setInt(2, dish.getDishID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.print("Update description successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateRate(Dish dish) {
        int result = 0;
        String sRate = "";
        do{
            System.out.print("Enter new rate: ");
            sRate = sc.nextLine();
        }while (!AdminValidation.isValidDouble(sRate));
        double newRate = Double.parseDouble(sRate);

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE dish" +
                    " SET " +
                    "DishName = ?" +
                    " WHERE DishID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDouble(1,newRate);
            pst.setInt(2, dish.getDishID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.print("Update rate successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Dish dish) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM dish" +
                    " WHERE DishID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, dish.getDishID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.println("Delete successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Dish> selectAll() {
        ArrayList<Dish> result = new ArrayList<Dish>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM dish";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DishID");
                String name = rs.getString("DishName");
                double price = rs.getDouble("DishPrice");
                String description = rs.getString("DishDescription");
                float rate = rs.getFloat("DishRate");

                Dish dish = new Dish(id, name, price, description, rate);

                result.add(dish);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Dish> increasingPrice () {
        ArrayList<Dish> result = new ArrayList<Dish>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM dish ORDER BY DishPrice";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DishID");
                String name = rs.getString("DishName");
                double price = rs.getDouble("DishPrice");
                String description = rs.getString("DishDescription");
                float rate = rs.getFloat("DishRate");

                Dish dish = new Dish(id, name, price, description, rate);

                result.add(dish);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Dish> decreasingPrice() {
        ArrayList<Dish> result = new ArrayList<Dish>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM dish ORDER BY DishPrice DESC";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DishID");
                String name = rs.getString("DishName");
                double price = rs.getDouble("DishPrice");
                String description = rs.getString("DishDescription");
                float rate = rs.getFloat("DishRate");

                Dish dish = new Dish(id, name, price, description, rate);

                result.add(dish);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Dish> increasingRate() {
        ArrayList<Dish> result = new ArrayList<Dish>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM dish ORDER BY DishRate";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DishID");
                String name = rs.getString("DishName");
                double price = rs.getDouble("DishPrice");
                String description = rs.getString("DishDescription");
                float rate = rs.getFloat("DishRate");

                Dish dish = new Dish(id, name, price, description, rate);

                result.add(dish);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Dish> decreasingRate() {
        ArrayList<Dish> result = new ArrayList<Dish>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM dish ORDER BY DishRate DESC";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DishID");
                String name = rs.getString("DishName");
                double price = rs.getDouble("DishPrice");
                String description = rs.getString("DishDescription");
                float rate = rs.getFloat("DishRate");

                Dish dish = new Dish(id, name, price, description, rate);

                result.add(dish);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Dish selectById(Dish dish) {
        Dish result = null;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM dish" +
                    " WHERE DishID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, dish.getDishID());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DishID");
                String name = rs.getString("DishName");
                double price = rs.getDouble("DishPrice");
                String description = rs.getString("DishDescription");
                float rate = rs.getFloat("DishRate");

                result = new Dish(id, name, price, description, rate);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Dish> selectByCondition(String condition) {
        ArrayList<Dish> result = new ArrayList<Dish>();

        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM dish" +
                    " WHERE" + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("DishID");
                String name = rs.getString("DishName");
                double price = rs.getDouble("DishPrice");
                String description = rs.getString("DishDescription");
                float rate = rs.getFloat("DishRate");

                Dish dish = new Dish(id, name, price, description, rate);

                result.add(dish);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
