package BusinessLogicLayer;

import DataLayer.DAO.*;
import DataLayer.DM.*;
import PresentationLayer.UI.AdminMenuUI;
import com.mysql.cj.xdevapi.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AdminMenuLogic {
    AdminMenuUI ui = new AdminMenuUI();
    Scanner sc = new Scanner(System.in);
    public boolean checkInt(String choices) {
        try {
            Integer.parseInt(choices);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void runAdminMenu() {
        boolean isRunning = true;
        while(isRunning) {
            ui.display();
            switch (ui.EnterChoices()) {
                case 1:
                    menuStaff();
                    break;
                case 2:
                    menuReservation();
                    break;
                case 3:
                    menuTable();
                    break;
                case 4:
                    menuMenu();
                    break;
                case 5:
                    menuCustomer();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-5");
                    break;
            }
        }
    }

    public void menuStaff() {
        boolean isRunningmenuStaff = true;
        while (isRunningmenuStaff) {
            ui.displayMenuStaff();
            switch (ui.EnterChoices()) {
                case 1:
                    String name = "";
                    String phone = "";
                    String role = "";

                    System.out.println("---------ADD STAFF----------");
                    do{
                        System.out.print("Enter full name: ");
                        name = sc.nextLine();
                    }while(!AdminValidation.isValidName(name));

                    do{
                        System.out.print("Enter phone: ");
                        phone = sc.nextLine();
                    }while(!AdminValidation.isValidPhone(phone));

                    do{
                        System.out.print("Enter role [Manager, Chef, Waitstaff]: ");
                        role = sc.nextLine();
                    }while(!AdminValidation.isValidRole(role));

                    Staff staff1 = new Staff(name, phone, role);
                    StaffDAO.getInstance().insert(staff1);
                    System.out.println("STAFF ADDED SUCCESSFULLY");
                    break;
                case 2:
                    System.out.println("---------LIST STAFF----------");
                    ArrayList<Staff> list = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list) {
                        System.out.println(staff.toString());
                    }
                    break;
                case 3:
                    menuUpdateStaff();
                    break;
                case 4:
                    System.out.println("---------LIST STAFF----------");
                    ArrayList<Staff> list4 = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list4) {
                        System.out.println(staff.toString());
                    }
                    System.out.print("Enter the StaffID that you want to delete. ");
                    int idDl = ui.EnterChoices();
                    Staff staffDl = new Staff(idDl);
                    StaffDAO.getInstance().delete(staffDl);
                    break;
                case 0:
                    isRunningmenuStaff = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-4");
                    break;
            }
        }
    }

    public void menuUpdateStaff() {
        boolean isRunningUpdate = true;
        while (isRunningUpdate) {
            ui.displayMenuForUpdatingStaffs();
            switch (ui.EnterChoices()) {
                case 1:
                    System.out.println("---------LIST STAFF----------");
                    ArrayList<Staff> list1 = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list1) {
                        System.out.println(staff.toString());
                    }
                    System.out.println("-----UPDATE STAFF NAME-----");
                    System.out.print("Enter the StaffID that you want to update. ");
                    int idUpName = ui.EnterChoices();

                    Staff staffUpName = new Staff(idUpName);
                    StaffDAO.getInstance().updateName(staffUpName);
                    break;
                case 2:
                    System.out.println("---------LIST STAFF----------");
                    ArrayList<Staff> list2 = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list2) {
                        System.out.println(staff.toString());
                    }
                    System.out.println("-----Update STAFF PHONE-----");
                    System.out.print("Enter the StaffID that you want to update. ");
                    int idUpPhone = ui.EnterChoices();

                    Staff staffUpPhone = new Staff(idUpPhone);
                    StaffDAO.getInstance().updatePhone(staffUpPhone);
                    break;
                case 3:
                    System.out.println("---------LIST STAFF----------");
                    ArrayList<Staff> list3 = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list3) {
                        System.out.println(staff.toString());
                    }
                    System.out.println("-----UPDATE STAFF ROLE-----");
                    System.out.print("Enter the StaffID that you want to update. ");
                    int idUpRole = ui.EnterChoices();

                    Staff staffUpRole = new Staff(idUpRole);
                    StaffDAO.getInstance().updateRole(staffUpRole);
                    break;
                case 4:
                    String name = "";
                    String phone = "";
                    String role = "";
                    Scanner sc = new Scanner(System.in);
                    System.out.println("---------LIST STAFF----------");
                    ArrayList<Staff> list4 = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list4) {
                        System.out.println(staff.toString());
                    }
                   System.out.println("-----UPDATE ALL INFORMATION-----");
                   System.out.print("Enter the StaffID that you want to update. ");
                   int id = ui.EnterChoices();

                    do{
                        System.out.print("Enter full name: ");
                        name = sc.nextLine();
                    }while(!AdminValidation.isValidName(name));

                    do{
                        System.out.print("Enter phone: ");
                        phone = sc.nextLine();
                    }while(!AdminValidation.isValidPhone(phone));

                    do{
                        System.out.print("Enter role [Manager, Chef, Waitstaff]: ");
                        role = sc.nextLine();
                    }while(!AdminValidation.isValidRole(role));

                   Staff staffUpAll = new Staff(id, name, phone, role);
                   StaffDAO.getInstance().update(staffUpAll);
                   break;
                case 0:
                    isRunningUpdate = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-4");
                    break;
            }
        }
    }

    public void menuReservation() {
        boolean isRunningReservation = true;
        while(isRunningReservation) {
            ui.displayMenuReservation();
            switch(ui.EnterChoices()) {
                case 1:
                    System.out.println("-----SHOW ALL RESERVATION-----");
                    ArrayList<Reservation> list1 = ReservationDAO.getInstance().selectAll();
                    for(Reservation reservation : list1) {
                        System.out.println(reservation.toString());
                    }
                    break;
                case 2:
                    System.out.println("-----SHOW ALL RESERVATION BY PHONE------");
                    System.out.print("Enter the phone number: ");
                    String phone = ui.EnterInfor();

                    Reservation reservationByPhone = new Reservation(phone);
                    ArrayList<Reservation> list2 = ReservationDAO.getInstance().selectByPhone(reservationByPhone);
                    for (Reservation reservation : list2) {
                        System.out.println(reservation.toString());
                    }
                    break;
                case 0:
                    isRunningReservation = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-2");
                    break;
            }
        }
    }

    public void menuTable() {
        boolean isRunningTable = true;
        while(isRunningTable) {
            ui.displayMenuTable();
            switch (ui.EnterChoices()) {
                case 1:
                    String sCapacity = "";
                    String type = "";
                    System.out.println("-----ADD MORE TABLES-----");
                    do{
                        System.out.print("Enter capacity of table: ");
                        sCapacity = sc.nextLine();
                    }while (!AdminValidation.isValidCapacity(sCapacity));

                    int capacity = Integer.parseInt(sCapacity);

                    do{
                        System.out.print("Enter type of table [Standard, Round, Outdoor]: ");
                        type = sc.nextLine();
                    }while (!AdminValidation.isValidTypeOfTable(type));

                    TableOfRestaurant tableOfRestaurant = new TableOfRestaurant(capacity, type);
                    TableDAO.getInstance().insert(tableOfRestaurant);
                    break;
                case 2:
                    menuShowTable();
                    break;
                case 3:
                    menuUpdateTable();
                    break;
                case 4:
                    System.out.println("-----DELETE TABLE-----");
                    ArrayList<TableOfRestaurant> list1 = TableDAO.getInstance().selectAll();
                    for(TableOfRestaurant table : list1) {
                        System.out.println(table.toString());
                    }
                    System.out.print("Enter table id for deleting. ");
                    int id = ui.EnterChoices();

                    TableOfRestaurant table = new TableOfRestaurant(id);
                    TableDAO.getInstance().delete(table);
                    break;
                case 0:
                    isRunningTable = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-4");
                    break;
            }
        }
    }

    public void menuShowTable() {
        boolean isRunningShowTable = true;
        while(isRunningShowTable) {
            ui.displayMenuShowTable();
            switch (ui.EnterChoices()) {
                case 1:
                    System.out.println("-----SHOW ALL TABLES-----");
                    ArrayList<TableOfRestaurant> list1 = TableDAO.getInstance().selectAll();
                    for(TableOfRestaurant table : list1) {
                        System.out.println(table.toString());
                    }
                    break;
                case 2:
                    System.out.println("-----SHOW AVAILABLE TABLE-----");
                    ArrayList<TableOfRestaurant> list2 = TableDAO.getInstance().selectByAvailable();
                    for (TableOfRestaurant tableAvailable : list2) {
                        System.out.println(tableAvailable.toString());
                    }
                    break;
                case 3:
                    System.out.println("-----SHOW UNAVAILABLE TABLE-----");
                    ArrayList<TableOfRestaurant> list3 = TableDAO.getInstance().selectByUnavailable();
                    for (TableOfRestaurant tableUnavailable : list3) {
                        System.out.println(tableUnavailable.toString());
                    }
                    break;
                case 0:
                    isRunningShowTable = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-3");
                    break;
            }
        }
    }

    public void menuUpdateTable() {
        boolean isRunningUpdateTalbe = true;
        while(isRunningUpdateTalbe) {
            ui.displayMenuUpdateTable();
            switch (ui.EnterChoices()) {
                case 1:
                    System.out.println("-----UPDATE CAPACITY-----");
                    ArrayList<TableOfRestaurant> list1 = TableDAO.getInstance().selectAll();
                    for(TableOfRestaurant table : list1) {
                        System.out.println(table.toString());
                    }
                    System.out.print("Enter table id for updating. ");
                    int id = ui.EnterChoices();
                    TableOfRestaurant table = new TableOfRestaurant(id);
                    TableDAO.getInstance().updateCapacity(table);
                    break;
                case 2:
                    System.out.println("-----UPDATE TYPE-----");
                    ArrayList<TableOfRestaurant> list2 = TableDAO.getInstance().selectAll();
                    for(TableOfRestaurant table1 : list2) {
                        System.out.println(table1.toString());
                    }
                    System.out.print("Enter table id for updating. ");
                    int id1 = ui.EnterChoices();
                    TableOfRestaurant table1 = new TableOfRestaurant(id1);
                    TableDAO.getInstance().updateType(table1);
                    break;
                case 3:
                    System.out.println("-----UPDATE BOTH-----");
                    ArrayList<TableOfRestaurant> list3 = TableDAO.getInstance().selectAll();
                    for(TableOfRestaurant table2 : list3) {
                        System.out.println(table2.toString());
                    }
                    System.out.print("Enter table id for updating. ");
                    int id2 = ui.EnterChoices();
                    System.out.print("Enter new capacity. ");
                    int capacity = ui.EnterChoices();
                    System.out.print("Enter new type: ");
                    String type = ui.EnterInfor();

                    TableOfRestaurant table2 = new TableOfRestaurant(id2, capacity, type);
                    TableDAO.getInstance().update(table2);
                    break;
                case 0:
                    isRunningUpdateTalbe = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-3");
                    break;
            }
        }
    }

    public void menuMenu() {
        boolean isRunningMenu = true;
        while(isRunningMenu) {
            ui.displayMenuDish();
            switch (ui.EnterChoices()) {
                case 1:
                    String name = "";
                    String sPrice = "";
                    String description = "";
                    String sRate = "";
                    System.out.println("----ADD MORE DISH-----");

                    do{
                        System.out.print("Enter name dish: ");
                        name = sc.nextLine();
                    }while (!AdminValidation.isValidName(name));

                    do{
                        System.out.print("Enter price: ");
                        sPrice = sc.nextLine();
                    }while (!AdminValidation.isValidDouble(sPrice));
                    double price = Double.parseDouble(sPrice);

                    do{
                        System.out.print("Enter description: ");
                        description = sc.nextLine();
                    }while (!AdminValidation.isValidDouble(description));

                    do{
                        System.out.print("Enter rate: ");
                        sRate = sc.nextLine();
                    }while (!AdminValidation.isValidDouble(sRate));
                    double rate = Double.parseDouble(sRate);


                    Dish dish = new Dish(name, price, description, rate);
                    DishDAO.getInstance().insert(dish);
                    break;
                case 2:
                    menuShowDish();
                    break;
                case 3:
                    menuUpdateDish();
                    break;
                case 4:
                    System.out.println("-----DELETE DISH-----");
                    ArrayList<Dish> list4 = DishDAO.getInstance().selectAll();
                    for (Dish dish4 : list4) {
                        System.out.println(dish4.toString());
                    }
                    System.out.print("Enter id to for deleting: ");
                    int id = ui.EnterChoices();
                    Dish dish1 = new Dish(id);
                    DishDAO.getInstance().delete(dish1);
                    break;
                case 0:
                    isRunningMenu = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-4");
                    break;
            }
        }
    }

    public void menuShowDish() {
        boolean isRunningShowDish = true;
        while(isRunningShowDish) {
            ui.displayShowDish();
            switch (ui.EnterChoices()) {
                case 1:
                    System.out.println("-----SHOW ALL DISH-----");
                    ArrayList<Dish> list1 = DishDAO.getInstance().selectAll();
                    for (Dish dish1 : list1) {
                        System.out.println(dish1.toString());
                    }
                    break;
                case 2:
                    System.out.println("-----SHOW ALL DISH WITH INCREASING PRICE-----");
                    ArrayList<Dish> list2 = DishDAO.getInstance().increasingPrice();
                    for (Dish dish2 : list2) {
                        System.out.println(dish2.toString());
                    }
                    break;
                case 3:
                    System.out.println("-----SHOW ALL DISH WITH DECREASING PRICE-----");
                    ArrayList<Dish> list3 = DishDAO.getInstance().decreasingPrice();
                    for (Dish dish3 : list3) {
                        System.out.println(dish3.toString());
                    }
                    break;
                case 4:
                    System.out.println("-----SHOW ALL DISH WITH INCREASING RATE-----");
                    ArrayList<Dish> list4 = DishDAO.getInstance().increasingRate();
                    for (Dish dish4 : list4) {
                        System.out.println(dish4.toString());
                    }
                    break;
                case 5:
                    System.out.println("-----SHOW ALL DISH WITH DECREASING RATE-----");
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

    public void menuUpdateDish() {
        boolean isRunningUpdate = true;
        while(isRunningUpdate) {
            ui.displayUpdateDish();
            switch (ui.EnterChoices()) {
                case 1:
                    String newName = "";
                    String sPrice = "";
                    String newDescription = "";
                    String sRate = "";
                    System.out.println("------UPDATE ALL DISH INFORMATION-----");
                    ArrayList<Dish> list1 = DishDAO.getInstance().selectAll();
                    for (Dish dish1 : list1) {
                        System.out.println(dish1.toString());
                    }
                    System.out.print("Enter the id for updating. ");
                    int id = ui.EnterChoices();
                    do{
                        System.out.print("Enter new name dish: ");
                        newName = sc.nextLine();
                    }while (!AdminValidation.isValidName(newName));

                    do{
                        System.out.print("Enter price: ");
                        sPrice = sc.nextLine();
                    }while (!AdminValidation.isValidDouble(sPrice));
                    double newPrice = Double.parseDouble(sPrice);

                    do{
                        System.out.print("Enter new description: ");
                        newDescription = sc.nextLine();
                    }while (!AdminValidation.isValidDouble(newDescription));

                    do{
                        System.out.print("Enter rate: ");
                        sRate = sc.nextLine();
                    }while (!AdminValidation.isValidDouble(sRate));
                    double newRate = Double.parseDouble(sRate);

                    Dish dish1 = new Dish(id, newName, newPrice, newDescription, newRate);
                    DishDAO.getInstance().update(dish1);
                    break;
                case 2:
                    System.out.println("-----UPDATE NAME-----");
                    ArrayList<Dish> list2 = DishDAO.getInstance().selectAll();
                    for (Dish dish2 : list2) {
                        System.out.println(dish2.toString());
                    }
                    System.out.print("Enter the id for updating. ");
                    int id2 = ui.EnterChoices();

                    Dish dish2 = new Dish(id2);
                    DishDAO.getInstance().updateName(dish2);
                    break;
                case 3:
                    System.out.println("-----UPDATE PRICE-----");
                    ArrayList<Dish> list3 = DishDAO.getInstance().selectAll();
                    for (Dish dish3 : list3) {
                        System.out.println(dish3.toString());
                    }
                    System.out.print("Enter the id for updating. ");
                    int id3 = ui.EnterChoices();

                    Dish dish3 = new Dish(id3);
                    DishDAO.getInstance().updatePrice(dish3);
                    break;
                case 4:
                    System.out.println("-----UPDATE DESCRIPTION-----");
                    ArrayList<Dish> list4 = DishDAO.getInstance().selectAll();
                    for (Dish dish4 : list4) {
                        System.out.println(dish4.toString());
                    }
                    System.out.print("Enter the id for updating. ");
                    int id4 = ui.EnterChoices();

                    Dish dish4 = new Dish(id4);
                    DishDAO.getInstance().updateDescription(dish4);
                    break;
                case 5:
                    System.out.println("-----UPDATE RATE-----");
                    ArrayList<Dish> list5 = DishDAO.getInstance().selectAll();
                    for (Dish dish5 : list5) {
                        System.out.println(dish5.toString());
                    }
                    System.out.print("Enter the id for updating. ");
                    int id5 = ui.EnterChoices();

                    Dish dish5 = new Dish(id5);
                    DishDAO.getInstance().updateRate(dish5);
                    break;
                case 0:
                    isRunningUpdate = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-5");
                    break;
            }
        }
    }

    public void menuCustomer() {
        boolean isRunningCustomer = true;
        while (isRunningCustomer) {
            ui.displayMenuCustomer();
            switch (ui.EnterChoices()) {
                case 1:
                    System.out.println("-----SHOW ALL CUSTOMERS-----");
                    ArrayList<Customer> list = CustomerDAO.getInstance().selectAll();
                    for (Customer customer : list) {
                        System.out.println(customer.toString());
                    }
                    break;
                case 2:
                    System.out.println("-----DELETE CUSTOMERS-----");
                    ArrayList<Customer> list2 = CustomerDAO.getInstance().selectAll();
                    for (Customer customer2 : list2) {
                        System.out.println(customer2.toString());
                    }
                    System.out.print("Enter the id for deleting. ");
                    int id = ui.EnterChoices();

                    Customer customer3 = new Customer(id);
                    CustomerDAO.getInstance().delete(customer3);
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


}
