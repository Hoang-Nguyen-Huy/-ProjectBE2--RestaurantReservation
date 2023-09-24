package PresentationLayer.UI;

import BusinessLogicLayer.AdminMenuLogic;

import java.util.Scanner;

public class AdminMenuUI {
    public void display () {
        System.out.println("[1] Staff");
        System.out.println("[2] Reservation");
        System.out.println("[3] Table");
        System.out.println("[4] Menu");
        System.out.println("[5] Customer");
        System.out.println("[0] Go back");
    }

    public int EnterChoices() {
        AdminMenuLogic adminMenuLogic = new AdminMenuLogic();
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a number: ");
        String choices = sc.nextLine();

        while(!adminMenuLogic.checkInt(choices)) {
            System.out.println("Please enter an integer number!!!");
            System.out.print("Choose a number: ");
            choices = sc.nextLine();
        }
        return Integer.parseInt(choices);
    }
    public String EnterInfor () {
        Scanner sc = new Scanner(System.in);
        String infor = sc.nextLine();
        return infor;
    }

    public Double parseDouble() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String input = sc.nextLine();
                Double result = Double.parseDouble(input);
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number: ");
            }
        }
    }

    public void displayMenuStaff() {
        System.out.println("[1] Add more Staffs");
        System.out.println("[2] Show all Staffs");
        System.out.println("[3] Update Staffs information");
        System.out.println("[4] Delete Staffs");
        System.out.println("[0] Go Back");
    }

    public void displayMenuForUpdatingStaffs() {
        System.out.println("[1] Update name");
        System.out.println("[2] Update phone");
        System.out.println("[3] Update role");
        System.out.println("[4] Update all");
        System.out.println("[0] Go back");
    }

    public void displayMenuReservation() {
        System.out.println("[1] Show All Reservations");
        System.out.println("[2] Show Reservations By Phone");
        System.out.println("[3] Delete Reservations By Phone");
        System.out.println("[0] Go Back");
    }

    public void displayMenuTable() {
        System.out.println("[1] Add more Tables");
        System.out.println("[2] Show Tables");
        System.out.println("[3] Update Tables information");
        System.out.println("[4] Delete Tables");
        System.out.println("[0] Go Back");
    }

    public void displayMenuShowTable() {
        System.out.println("[1] Show all Tables");
        System.out.println("[2] Show Available Tables");
        System.out.println("[3] Show Unavailable Tables");
        System.out.println("[0] Go Back");
    }

    public void displayMenuUpdateTable() {
        System.out.println("[1] Update capacity");
        System.out.println("[2] Update type");
        System.out.println("[3] Update both");
        System.out.println("[0] Go back");
    }

    public void displayMenuDish() {
        System.out.println("[1] Add more Dish");
        System.out.println("[2] Show all Dish");
        System.out.println("[3] Update Dish information");
        System.out.println("[4] Delete Dish");
        System.out.println("[0] Go Back");
    }

    public void displayShowDish() {
        System.out.println("[1] Show all Dish");
        System.out.println("[2] Show all Dish with increasing PRICE");
        System.out.println("[3] Show all Dish with decreasing PRICE");
        System.out.println("[4] Show all Dish with increasing RATE");
        System.out.println("[5] Show all Dish with decreasing RATE");
        System.out.println("[0] Go back");
    }

    public void displayUpdateDish() {
        System.out.println("[1] Update all Dish information");
        System.out.println("[2] Update name");
        System.out.println("[3] Update price");
        System.out.println("[4] Update description");
        System.out.println("[5] Update rate");
        System.out.println("[0] Go back");
    }
    public void displayMenuCustomer() {
        System.out.println("[1] Show All Customers");
        System.out.println("[2] Delete Customers");
        System.out.println("[0] Go Back");
    }
}
