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

    public void displayMenuForUpdatingStaffs() {
        System.out.println("[1] Update name");
        System.out.println("[2] Update phone");
        System.out.println("[3] Update role");
        System.out.println("[4] Update all");
        System.out.println("[0] Go back");
    }
    public void displayMenuStaff() {
        System.out.println("[1] Add more Staffs");
        System.out.println("[2] Show all Staffs");
        System.out.println("[3] Update Staffs information");
        System.out.println("[4] Delete Staffs");
        System.out.println("[0] Go Back");
    }



    public void displayMenuReservation() {
        System.out.println("[1] Show all Reservations");
        System.out.println("[2] Update Reservations");
        System.out.println("[0] Go Back");
    }

    public void displayMenuTable() {
        System.out.println("[1] Add more Tables");
        System.out.println("[2] Show all Tables");
        System.out.println("[3] Update Tables information");
        System.out.println("[4] Delete Tables");
        System.out.println("[0] Go Back");
    }

    public void displayMenuDish() {
        System.out.println("[1] Add more Dish");
        System.out.println("[2] Show all Dish");
        System.out.println("[3] Update Dish information");
        System.out.println("[4] Delete Dish");
        System.out.println("[0] Go Back");
    }

    public void displayMenuCustomer() {
        System.out.println("[1] Show all Customers");
        System.out.println("[2] Delete Customers");
        System.out.println("[0] Go Back");
    }
}
