package DataLayer.DAO;

import DataLayer.DM.Admin;
import DataLayer.DM.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO implements DAOInterface<Customer> {
    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }

    @Override
    public int insert(Customer customer) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO customer(CustomerID, CustomerName, CustomerEmail, CustomerPhone)" +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, customer.getCustomerID());
            pst.setString(2, customer.getCustomerName());
            pst.setString(3, customer.getCustomerEmail());
            pst.setString(4, customer.getCustomerPhone());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " change");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Customer customer) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE customer" +
                    " SET " +
                    "CustomerName = ?" +
                    ", CustomerEmail = ?" +
                    ", CustomerPhone = ?" +
                    " WHERE AdminID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, customer.getCustomerName());
            pst.setString(2, customer.getCustomerEmail());
            pst.setString(3, customer.getCustomerPhone());
            pst.setInt(4, customer.getCustomerID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " upate");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Customer customer) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM customer" +
                    " WHERE CustomerID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, customer.getCustomerID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " deleted");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> result = new ArrayList<Customer>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM customer";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String name = rs.getString("CustomerName");
                String email = rs.getString("CustomerEmail");
                String phone = rs.getString("CustomerPhone");

                Customer customer1 = new Customer(id, name, email, phone);

                result.add(customer1);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Customer selectById(Customer customer) {
        Customer result = null;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM customer" +
                    " WHERE CustomerID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, customer.getCustomerID());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("CustomerName");
                String email = rs.getString("CustomerEmail");
                String phone = rs.getString("CustomerPhone");

                result = new Customer(name, email, phone);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Customer> selectByCondition(String condition) {
        ArrayList<Customer> result = new ArrayList<Customer>();

        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM customer" +
                    " WHERE" + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String name = rs.getString("CustomerName");
                String email = rs.getString("CustomerEmail");
                String phone = rs.getString("CustomerPhone");

                Customer customer1 = new Customer(id, name, email, phone);

                result.add(customer1);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
