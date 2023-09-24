package DataLayer.DAO;

import DataLayer.DM.Admin;
import DataLayer.DM.Reservation;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

            String sql = "INSERT INTO reservation(FullName, Email, Phone, BookingDate, BookingTime, NumberOfPeople, Requirement, CustomerID, TableID)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, reservation.getFullName());
            pst.setString(2, reservation.getEmail());
            pst.setString(3, reservation.getPhone());
            pst.setDate(4, reservation.getBookingDate());
            pst.setTime(5, reservation.getBookingTime());
            pst.setInt(6, reservation.getNumberOfPeople());
            pst.setString(7, reservation.getRequirement());
            pst.setInt(8, reservation.getCustomerID());
            pst.setInt(9, reservation.getTableID());



            result = pst.executeUpdate();

            System.out.println("Reservation was accepted!!!");

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

            String sql = "SELECT * FROM reservation";

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
                int customeriD = rs.getInt("CustomerID");
                int tableid = rs.getInt("TableID");

                Reservation reservation = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement, customeriD, tableid);


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
                int customerID = rs.getInt("CustomerID");

                result = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement, customerID);
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
                int customerID = rs.getInt("CustomerID");

                Reservation reservation = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement, customerID);


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
                int customerID = rs.getInt("CustomerID");

                Reservation reservation = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement, customerID);

                result.add(reservation);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkAvailableTable(Reservation reservation) {
        boolean result = false;
        int count = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT COUNT(*)" +
                    " FROM tableofrestaurant " +
                    " WHERE capacity >= ? AND tablestatus = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, reservation.getNumberOfPeople());
            pst.setString(2, "available");

            ResultSet rs = pst.executeQuery();


            if(rs.next()) {
                count = rs.getInt(1);
            }

            if (count < 1) {
                result = false;
            } else if (count >= 1) {
                result = true;
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Reservation> selectByRealDate (LocalDate currentDate) {
        ArrayList<Reservation> result = new ArrayList<Reservation>();

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM reservation" +
                    " WHERE BookingDate = ?";

            java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDate(1, sqlDate);

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
                int customeriD = rs.getInt("CustomerID");
                int tableID = rs.getInt("TableID");

                Reservation reservation = new Reservation(id, name, email, phone, BookingDate, BookingTime, noPeople, requirement, customeriD, tableID);


                result.add(reservation);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Integer> checkReservation(Reservation reservation) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT ReservationID, TableID FROM reservation" +
                    " WHERE bookingdate = ?" +
                    " AND bookingtime = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDate(1, reservation.getBookingDate());
            pst.setTime(2, reservation.getBookingTime());

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("ReservationID");
                int tableid = rs.getInt("TableID");

                result.add(tableid);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    public ArrayList<Integer> selectTableID(LocalDate currentDate, LocalTime currentTime) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT tableid from reservation" +
                    " WHERE bookingdate = ? AND bookingtime = ?";

            java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
            java.sql.Time sqlTime = java.sql.Time.valueOf(currentTime);

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDate(1, sqlDate);
            pst.setTime(2, sqlTime);

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                int tableid = rs.getInt("TableID");

                result.add(tableid);
            }


            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




}


