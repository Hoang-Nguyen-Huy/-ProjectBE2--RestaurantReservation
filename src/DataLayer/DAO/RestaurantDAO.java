package DataLayer.DAO;

import DataLayer.DM.Admin;
import DataLayer.DM.Restaurant;

import java.sql.*;
import java.util.ArrayList;

public class RestaurantDAO implements DAOInterface<Restaurant> {
    public static RestaurantDAO getInstance() {
        return new RestaurantDAO();
    }

    @Override
    public int insert(Restaurant restaurant) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO restaurant(RestaurantID, RestaurantName, Address, RestaurantPhone, RestaurantDescription, OpenTime, CloseTime)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, restaurant.getRestaurantID());
            pst.setString(2, restaurant.getRestaurantName());
            pst.setString(3, restaurant.getAddress());
            pst.setString(4, restaurant.getRestaurantPhone());
            pst.setString(5, restaurant.getRestaurantDescription());
            pst.setTime(6, restaurant.getOpenTime());
            pst.setTime(7, restaurant.getCloseTime());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " change");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Restaurant restaurant) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE restaurant" +
                    " SET " +
                    "RestaurantName = ?" +
                    ", Address = ?" +
                    ", RestaurantPhone = ?" +
                    ", RestaurantDescription = ?" +
                    ", OpenTime = ?" +
                    ", CloseTime = ?" +
                    " WHERE RestaurantID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, restaurant.getRestaurantName());
            pst.setString(2, restaurant.getAddress());
            pst.setString(3, restaurant.getRestaurantPhone());
            pst.setString(4, restaurant.getRestaurantDescription());
            pst.setTime(5, restaurant.getOpenTime());
            pst.setTime(6, restaurant.getCloseTime());
            pst.setInt(7, restaurant.getRestaurantID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " upate");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Restaurant restaurant) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM restaurant" +
                    " WHERE RestaurantID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, restaurant.getRestaurantID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " deleted");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Restaurant> selectAll() {
        ArrayList<Restaurant> result = new ArrayList<Restaurant>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM restaurant";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("RestaurantID");
                String name = rs.getString("RestaurantName");
                String address = rs.getString("Address");
                String phone = rs.getString("RestaurantPhone");
                String description = rs.getString("RestaurantDescription");
                Time open = rs.getTime("OpenTime");
                Time close = rs.getTime("CloseTime");

                Restaurant restaurant = new Restaurant(id, name, address, phone, description, open, close);


                result.add(restaurant);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Restaurant selectById(Restaurant restaurant) {
        Restaurant result = null;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM restaurant" +
                    " WHERE RestaurantID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, restaurant.getRestaurantID());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("RestaurantName");
                String address = rs.getString("Address");
                String phone = rs.getString("RestaurantPhone");
                String description = rs.getString("RestaurantDescription");
                Time open = rs.getTime("OpenTime");
                Time close = rs.getTime("CloseTime");

                result = new Restaurant(name, address, phone, description, open, close);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Restaurant> selectByCondition(String condition) {
        ArrayList<Restaurant> result = new ArrayList<Restaurant>();

        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM restaurant" +
                    " WHERE" + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("RestaurantID");
                String name = rs.getString("RestaurantName");
                String address = rs.getString("Address");
                String phone = rs.getString("RestaurantPhone");
                String description = rs.getString("RestaurantDescription");
                Time open = rs.getTime("OpenTime");
                Time close = rs.getTime("CloseTime");

                Restaurant restaurant = new Restaurant(id, name, address, phone, description, open, close);

                result.add(restaurant);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
