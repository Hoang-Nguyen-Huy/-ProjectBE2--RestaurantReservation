package DataLayer.DAO;

import DataLayer.DM.Admin;
import DataLayer.DM.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffDAO implements DAOInterface<Staff> {
    public static StaffDAO getInstance() {
        return new StaffDAO();
    }

    @Override
    public int insert(Staff staff) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO staff(StaffName, StaffPhone, StaffRole)" +
                    "VALUES(?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, staff.getStaffName());
            pst.setString(2, staff.getStaffPhone());
            pst.setString(3, staff.getStaffRole());

            result = pst.executeUpdate();

            if(result != 0) {
                System.out.println("Add Staff successfully");
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Staff staff) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE staff" +
                    " SET " +
                    "StaffName = ?" +
                    ", StaffPhone = ?" +
                    ", StaffRole = ?" +
                    " WHERE StaffID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, staff.getStaffName());
            pst.setString(2, staff.getStaffPhone());
            pst.setString(3, staff.getStaffRole());
            pst.setInt(4, staff.getStaffID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " upate");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Staff staff) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM staff" +
                    " WHERE StaffID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, staff.getStaffID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " deleted");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Staff> selectAll() {
        ArrayList<Staff> result = new ArrayList<Staff>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM staff";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("StaffID");
                String name = rs.getString("StaffName");
                String phone = rs.getString("StaffPhone");
                String role = rs.getString("StaffRole");

                Staff staff1 = new Staff(id, name, phone, role);

                result.add(staff1);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Staff selectById(Staff staff) {
        Staff result = null;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM staff" +
                    " WHERE StaffID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, staff.getStaffID());
            int id = staff.getStaffID();
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("StaffName");
                String phone = rs.getString("StaffPhone");
                String role = rs.getString("StaffRole");

                result = new Staff(id, name, phone, role);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Staff> selectByCondition(String condition) {
        ArrayList<Staff> result = new ArrayList<Staff>();

        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM staff" +
                    " WHERE" + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("StaffID");
                String name = rs.getString("StaffName");
                String phone = rs.getString("StaffPhone");
                String role = rs.getString("StaffRole");

                Staff staff = new Staff(id, name, phone, role);

                result.add(staff);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
