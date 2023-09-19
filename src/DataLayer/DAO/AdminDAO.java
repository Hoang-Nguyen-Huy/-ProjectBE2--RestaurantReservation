package DataLayer.DAO;

import DataLayer.DM.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO implements DAOInterface<Admin>{

    public static AdminDAO getInstance() {
        return new AdminDAO();
    }

    @Override
    public int insert(Admin admin) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO admin(AdminID, AdminName, AdminEmail, AdminPassword)" +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, admin.getAdminID());
            pst.setString(2, admin.getAdminName());
            pst.setString(3, admin.getAdminEmail());
            pst.setString(4, admin.getAdminPassword());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " change");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Admin admin) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE admin" +
                    " SET " +
                    "AdminName = ?" +
                    ", AdminPassword = ?" +
                    " WHERE AdminID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, admin.getAdminName());
            pst.setString(2, admin.getAdminPassword());
            pst.setInt(3, admin.getAdminID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " upate");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Admin admin) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM admin" +
                    " WHERE AdminID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, admin.getAdminID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " deleted");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Admin> selectAll() {
        ArrayList<Admin> result = new ArrayList<Admin>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM admin";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("AdminID");
                String name = rs.getString("AdminName");
                String email = rs.getString("AdminEmail");
                String password = rs.getString("AdminPassword");

                Admin  admin1 = new Admin(id, name, email, password);

                result.add(admin1);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Admin selectById(Admin admin) {
        Admin result = null;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM admin" +
                    " WHERE AdminID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, admin.getAdminID());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("AdminName");
                String email = rs.getString("AdminEmail");
                String password = rs.getString("AdminPassword");

                result = new Admin(name, email, password);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Admin> selectByCondition(String condition) {
        ArrayList<Admin> result = new ArrayList<Admin>();

        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM admin" +
                    " WHERE" + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("AdminID");
                String name = rs.getString("AdminName");
                String email = rs.getString("AdminEmail");
                String password = rs.getString("AdminPassword");

                Admin  admin1 = new Admin(id, name, email, password);

                result.add(admin1);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
