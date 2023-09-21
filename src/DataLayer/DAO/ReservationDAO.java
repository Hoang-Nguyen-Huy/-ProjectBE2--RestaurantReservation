package DataLayer.DAO;

import DataLayer.DM.Admin;
import DataLayer.DM.Reservation;

import java.sql.*;
import java.util.ArrayList;

public class ReservationDAO implements DAOInterface<Reservation>{

    public static ReservationDAO getInstance() {
        return new ReservationDAO();
    }

    @Override
    public int insert(Reservation reservation) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO reservation(ReservationID, FullName, Email, Phone, BookingDate, BookingTime, NumberOfPeople, Requirement)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, reservation.getReservationID());
            pst.setString(2, reservation.getFullName());
            pst.setString(3, reservation.getEmail());
            pst.setString(4, reservation.getPhone());
            pst.setDate(5, reservation.getBookingDate());
            pst.setTime(6, reservation.getBookingTime());
            pst.setInt(7, reservation.getNumberOfPeople());
            pst.setString(8, reservation.getRequirement());



            result = pst.executeUpdate();

            System.out.println("There is " + result + " change");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Reservation reservation) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE reservation" +
                    " SET " +
                    "FullName = ?" +
                    ", Email = ?" +
                    ", Phone = ?" +
                    ", BookingDate = ?" +
                    ", BookingTime = ?" +
                    ", NumberOfPeople = ?" +
                    ", Requirement = ?" +
                    " WHERE ReservationID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, reservation.getFullName());
            pst.setString(2, reservation.getEmail());
            pst.setString(3, reservation.getPhone());
            pst.setDate(4, reservation.getBookingDate());
            pst.setTime(5, reservation.getBookingTime());
            pst.setInt(6, reservation.getNumberOfPeople());
            pst.setString(7, reservation.getRequirement());
            pst.setInt(8, reservation.getReservationID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " upate");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Reservation reservation) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM reservation" +
                    " WHERE ReservationID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, reservation.getReservationID());

            result = pst.executeUpdate();

            System.out.println("There is " + result + " deleted");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Reservation> selectAll() {
        ArrayList<Reservation> result = new ArrayList<Reservation>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM resevation";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ReservationID");
                String name = rs.getString("FullName");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                Date BookingDate = rs.getDate("BookingDate");
                Time BookingTime = rs.getTime("BookingTime");
                int noPeople = rs.getInt("NumberOfPeople");
                String requirement = rs.getString("Requirement");

                Reservation reservation = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement);


                result.add(reservation);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Reservation selectById(Reservation reservation) {
        Reservation result = null;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM reservation" +
                    " WHERE ReservationID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, reservation.getReservationID());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ReservationID");
                String name = rs.getString("FullName");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                Date BookingDate = rs.getDate("BookingDate");
                Time BookingTime = rs.getTime("BookingTime");
                int noPeople = rs.getInt("NumberOfPeople");
                String requirement = rs.getString("Requirement");

                result = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Reservation> selectByPhone(Reservation reservation1) {
        ArrayList<Reservation> result = new ArrayList<Reservation>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM resevation" +
                    " WHERE Phone = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, reservation1.getPhone());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ReservationID");
                String name = rs.getString("FullName");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                Date BookingDate = rs.getDate("BookingDate");
                Time BookingTime = rs.getTime("BookingTime");
                int noPeople = rs.getInt("NumberOfPeople");
                String requirement = rs.getString("Requirement");

                Reservation reservation = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement);


                result.add(reservation);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Reservation> selectByCondition(String condition) {
        ArrayList<Reservation> result = new ArrayList<Reservation>();

        try {
            Connection con = JDBCUtil.getConnection();

            Statement st = con.createStatement();

            String sql = "SELECT * FROM reservation" +
                    " WHERE" + condition;

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ReservationID");
                String name = rs.getString("FullName");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                Date BookingDate = rs.getDate("BookingDate");
                Time BookingTime = rs.getTime("BookingTime");
                int noPeople = rs.getInt("NumberOfPeople");
                String requirement = rs.getString("Requirement");

                Reservation reservation = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement);

                result.add(reservation);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}


