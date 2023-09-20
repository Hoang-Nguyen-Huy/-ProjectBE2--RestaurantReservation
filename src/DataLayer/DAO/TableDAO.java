package DataLayer.DAO;


import DataLayer.DM.Admin;
import DataLayer.DM.TableOfRestaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TableDAO implements DAOInterface<TableOfRestaurant>{
    public static TableDAO getInstance() {
        return new TableDAO();
    }

    @Override
    public int insert(TableOfRestaurant tableOfRestaurant) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO tableofrestaurant(TableID, Capacity, TableType, TableStatus)" +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, tableOfRestaurant.getTableID());
            pst.setInt(2, tableOfRestaurant.getCapacity());
            pst.setString(3, tableOfRestaurant.getTableType());
            pst.setString(4, tableOfRestaurant.getTableStatus());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " change");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(TableOfRestaurant tableOfRestaurant) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE tableofrestaurant" +
                    " SET " +
                    "Capacity = ?" +
                    ", TableType = ?" +
                    ", TableStatus = ?" +
                    " WHERE TableID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, tableOfRestaurant.getCapacity());
            pst.setString(2, tableOfRestaurant.getTableType());
            pst.setString(3, tableOfRestaurant.getTableStatus());
            pst.setInt(4, tableOfRestaurant.getTableID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " upate");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(TableOfRestaurant tableOfRestaurant) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM tableofrestaurant" +
                    " WHERE TableID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, tableOfRestaurant.getTableID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " deleted");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<TableOfRestaurant> selectAll() {
        ArrayList<TableOfRestaurant> result = new ArrayList<TableOfRestaurant>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM tableofrestaurant";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("TableID");
                int capacity = rs.getInt("Capacity");
                String type = rs.getString("TableType");
                String status = rs.getString("TableStatus");

                TableOfRestaurant tableOfRestaurant1 = new TableOfRestaurant(id, capacity, type, status);

                result.add(tableOfRestaurant1);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public TableOfRestaurant selectById(TableOfRestaurant tableOfRestaurant) {
        TableOfRestaurant result = null;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM tableofrestaurant" +
                    " WHERE TableID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, tableOfRestaurant.getTableID());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("TableID");
                int capacity = rs.getInt("Capacity");
                String type = rs.getString("TableType");
                String status = rs.getString("TableStatus");

                result = new TableOfRestaurant(id, capacity, type, status);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<TableOfRestaurant> selectByCondition(String condition) {
        ArrayList<TableOfRestaurant> result = new ArrayList<TableOfRestaurant>();

        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM tableofrestaurant" +
                    " WHERE" + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("TableID");
                int capacity = rs.getInt("Capacity");
                String type = rs.getString("TableType");
                String status = rs.getString("TableStatus");

                TableOfRestaurant tableOfRestaurant = new TableOfRestaurant(id, capacity, type, status);

                result.add(tableOfRestaurant);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
