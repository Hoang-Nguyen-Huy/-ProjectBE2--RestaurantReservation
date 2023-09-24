package DataLayer.DAO;


import DataLayer.DM.Admin;
import DataLayer.DM.Reservation;
import DataLayer.DM.TableOfRestaurant;
import PresentationLayer.UI.AdminMenuUI;
import jdk.nashorn.internal.scripts.JD;

import java.nio.charset.CodingErrorAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class TableDAO implements DAOInterface<TableOfRestaurant>{

    AdminMenuUI ui = new AdminMenuUI();
    public static TableDAO getInstance() {
        return new TableDAO();
    }

    @Override
    public int insert(TableOfRestaurant tableOfRestaurant) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO tableofrestaurant(Capacity, TableType)" +
                    "VALUES(?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, tableOfRestaurant.getCapacity());
            pst.setString(2, tableOfRestaurant.getTableType());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.println("Add table successfully");
            }

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
                    " WHERE TableID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, tableOfRestaurant.getCapacity());
            pst.setString(2, tableOfRestaurant.getTableType());
            pst.setInt(3, tableOfRestaurant.getTableID());

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

    public int updateCapacity(TableOfRestaurant tableOfRestaurant) {
        int result = 0;

        System.out.print("Enter new capacity to update. ");
        int capacity = ui.EnterChoices();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE tableofrestaurant" +
                    " SET " +
                    "Capacity = ?" +
                    " WHERE TableID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, capacity);
            pst.setInt(2, tableOfRestaurant.getTableID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.println("Update capacity successfully!!!");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateType(TableOfRestaurant tableOfRestaurant) {
        int result = 0;

        System.out.print("Enter new type: ");
        String newType = ui.EnterInfor();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE tableofrestaurant" +
                    " SET " +
                    "TableType = ?" +
                    " WHERE TableID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, newType);
            pst.setInt(2, tableOfRestaurant.getTableID());

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.println("Update type successfully!!!");
            }

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

            if (result != 0 ) {
                System.out.println("Deleted successfully!!!");
            }

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

    public ArrayList<TableOfRestaurant> selectByAvailable() {
        ArrayList<TableOfRestaurant> result = new ArrayList<TableOfRestaurant>();

        try {
            Connection con = JDBCUtil.getConnection();


            String sql = "SELECT * FROM tableofrestaurant " +
                    " WHERE TableStatus = 'available'";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

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

    public ArrayList<TableOfRestaurant> selectByUnavailable() {
        ArrayList<TableOfRestaurant> result = new ArrayList<TableOfRestaurant>();

        try {
            Connection con = JDBCUtil.getConnection();


            String sql = "SELECT * FROM tableofrestaurant " +
                    " WHERE TableStatus = 'unavailable'";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

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

    public int updateTableAfterReservation(int NoPeople) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE tableofrestaurant tr" +
                    " JOIN (" +
                    " SELECT TableID, Capacity" +
                    " FROM tableofrestaurant" +
                    " WHERE Capacity >= " + NoPeople +
                    " AND TableStatus = 'available' " +
                    " ORDER BY Capacity ASC" +
                    " LIMIT 1" +
                    " ) t ON tr.TableID = t.TableID " +
                    " SET tr.TableStatus = 'unavailable'";

            PreparedStatement pst = con.prepareStatement(sql);

            result = pst.executeUpdate();

            if (result != 0) {
                System.out.println(result + " table has been reserved for you");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int selectTableIDByCapacity(Reservation reservation, ArrayList<Integer> diffTableID) {
        int result = 0;

        try {
            Connection con = JDBCUtil.getConnection();

            // Kiểm tra nếu diffTableID rỗng hoặc chỉ chứa giá trị 0
            if (diffTableID.isEmpty() || diffTableID.stream().allMatch(id -> id == 0)) {
                // Tạo danh sách mới với một phần tử bằng 0
                diffTableID = new ArrayList<>(Collections.singletonList(0));
            }

            String sql = "SELECT TableID FROM tableofrestaurant " +
                    "WHERE capacity >= ? AND tableid NOT IN (" + String.join(",", Collections.nCopies(diffTableID.size(), "?")) + ") " +
                    "AND tablestatus = 'available' " +
                    "ORDER BY capacity ASC LIMIT 1";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, reservation.getNumberOfPeople());

            int parameterIndex = 2;
            for (int id : diffTableID) {
                pst.setInt(parameterIndex++, id);
            }

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int tableID = rs.getInt("TableID");
                result = tableID;
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




    public int updateTableByRealDate(ArrayList<Integer> tableID) {
        int result = 0;
        try {

            if (tableID == null || tableID.isEmpty() || tableID.contains(0)) {
                return 0; // Trả về 0 để biểu thị rằng không có gì được thực hiện
            }

            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE tableofrestaurant SET tablestatus = 'unavailable' WHERE tableid IN (" +
                    String.join(",", Collections.nCopies(tableID.size(), "?")) + ")";

            PreparedStatement pst = con.prepareStatement(sql);

            int parameterIndex = 1;
            for (int id : tableID) {
                pst.setInt(parameterIndex++, id);
            }

            result = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
