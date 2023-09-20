package DataLayer.DAO;

import DataLayer.DM.Admin;
import DataLayer.DM.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DishDAO implements DAOInterface<Dish>{
    public static DishDAO getInstance() {
        return new DishDAO();
    }

    @Override
    public int insert(Dish dish) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO dish(DishID, DishName, DishPrice, DishDescription, DishRate)" +
                    "VALUES(?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, dish.getDishID());
            pst.setString(2,dish.getDishName());
            pst.setDouble(3, dish.getPrice());
            pst.setString(4, dish.getDescription());
            pst.setDouble(5, dish.getDishRate());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " change");

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

            System.out.println("There is " + result + " upate");

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

            System.out.println("There is " + result + " deleted");

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
