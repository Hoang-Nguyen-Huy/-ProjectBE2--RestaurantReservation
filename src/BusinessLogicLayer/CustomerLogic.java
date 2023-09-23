package BusinessLogicLayer;

import DataLayer.DAO.CustomerDAO;
import DataLayer.DAO.DishDAO;
import DataLayer.DAO.ReservationDAO;
import DataLayer.DAO.TableDAO;
import DataLayer.DM.Customer;
import DataLayer.DM.Dish;
import DataLayer.DM.Reservation;
import PresentationLayer.UI.CustomerMenuUI;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerLogic {
    Scanner sc = new Scanner(System.in);
    CustomerMenuUI ui = new CustomerMenuUI();
    private String fullName;
    private String email;
    private String phone;
    private String bookingDate;
    private String bookingTime;
    private String noPeople;
    private String requirement;


    public boolean checkInt(String choices) {
        try {
            Integer.parseInt(choices);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void runMenuCustomer () {
        boolean isRunningCustomer = true;
        while (isRunningCustomer) {
            ui.display();
            switch (ui.EnterChoices()) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    EnterCustomerInfo();
                    break;
                case 0:
                    isRunningCustomer = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-2");
                    break;
            }
        }
    }
    public void showMenu () {
        boolean isRunningShowDish = true;
        while(isRunningShowDish) {
            ui.displayShowDish();
            switch (ui.EnterChoices()) {
                case 1:
                    System.out.println("-----Show all Dish-----");
                    ArrayList<Dish> list1 = DishDAO.getInstance().selectAll();
                    for (Dish dish1 : list1) {
                        System.out.println(dish1.toString());
                    }
                    break;
                case 2:
                    System.out.println("-----Show all Dish with increasing PRICE-----");
                    ArrayList<Dish> list2 = DishDAO.getInstance().increasingPrice();
                    for (Dish dish2 : list2) {
                        System.out.println(dish2.toString());
                    }
                    break;
                case 3:
                    System.out.println("-----Show all Dish with decreasing PRICE-----");
                    ArrayList<Dish> list3 = DishDAO.getInstance().decreasingPrice();
                    for (Dish dish3 : list3) {
                        System.out.println(dish3.toString());
                    }
                    break;
                case 4:
                    System.out.println("-----Show all Dish with increasing RATE-----");
                    ArrayList<Dish> list4 = DishDAO.getInstance().increasingRate();
                    for (Dish dish4 : list4) {
                        System.out.println(dish4.toString());
                    }
                    break;
                case 5:
                    System.out.println("-----Show all Dish with decreasing RATE-----");
                    ArrayList<Dish> list5 = DishDAO.getInstance().decreasingRate();
                    for (Dish dish5 : list5) {
                        System.out.println(dish5.toString());
                    }
                    break;
                case 0:
                    isRunningShowDish = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-5");
                    break;

            }
        }
    }
    public void EnterCustomerInfo() {
        System.out.print("Enter full name: ");
        fullName = sc.nextLine();
        while(!CustomerValidation.isValidUsername(fullName)) {
            System.out.println("Please enter the valid name!!!");
            System.out.print("Enter full name: ");
            fullName = sc.nextLine();
        }

        System.out.print("Enter email: ");
        email = sc.next();
        while(!CustomerValidation.isValidEmail(email)) {
            System.out.println("Please enter the valid email!!!");
            System.out.print("Enter email: ");
            email = sc.next();
        }

        System.out.print("Enter phone number: ");
        phone = sc.next();
        while(!CustomerValidation.isValidPhone(phone)) {
            System.out.println("Please enter the valid phone number!!!");
            System.out.print("Enter phone number: ");
            phone = sc.next();
        }

        System.out.print("Enter date (YYYY-MM-DD): ");
        bookingDate = sc.next();
        while(!CustomerValidation.isValidDate(bookingDate)) {
            System.out.println("Please enter the valid booking date!!!");
            System.out.print("Enter date (YYYY-MM-DD): ");
            bookingDate = sc.next();
        }

        System.out.print("Enter time (HH:MM:SS): ");
        bookingTime = sc.next();
        while (!CustomerValidation.isValidTime(bookingTime)) {
            System.out.println("Please enter the valid booking time!!!");
            System.out.print("Enter time (HH:MM:SS): ");
            bookingTime = sc.next();
        }

        System.out.print("Enter number of people: ");
        noPeople = sc.next();
        while(!ReservationOderValidation.isValidNumberOfPeople(noPeople)) {
            System.out.println("Please enter the valid number of people: ");
            System.out.print("Enter number of people: ");
            noPeople = sc.next();
        }
        int numberOfPeople = Integer.parseInt(noPeople);

        System.out.print("Enter requirement: ");
        requirement = sc.next();
        while(!ReservationOderValidation.isValidRequirement(requirement)) {
            System.out.println("Your requirement is too long!!!");
            System.out.println("Enter requirement: ");
            requirement = sc.nextLine();
        }

        Reservation reservation = new Reservation(fullName, email, phone, Date.valueOf(bookingDate), Time.valueOf(bookingTime), numberOfPeople, requirement);
        Customer customer = new Customer(fullName, email, phone);

        if (ReservationDAO.getInstance().checkAvailableTable(reservation)) { // kiểm tra số lượng bàn available
            CustomerDAO.getInstance().insert(customer);  // nhập thông tin người dùng vào sql
            System.out.println("You have successfully booked a table!!!!");

            int customerID = CustomerDAO.getInstance().selectCustomerIDByPhone(customer);  // lấy customerID sau khi thông tin người dùng được nhập vào sql
            Reservation reservation1 = new Reservation(fullName, email, phone, Date.valueOf(bookingDate), Time.valueOf(bookingTime), numberOfPeople, requirement, customerID);
            ReservationDAO.getInstance().insert(reservation1); // nhập đơn đặt bàn vào sql

            TableDAO.getInstance().updateTableAfterReservation(numberOfPeople);

        } else {
            System.out.println("There are no available table left!!!!");
        }

    }


}
