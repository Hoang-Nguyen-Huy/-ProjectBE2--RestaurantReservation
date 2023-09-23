package PresentationLayer.UI;

import BusinessLogicLayer.AdminLoginLogic;
import BusinessLogicLayer.AdminLoginValidation;
import java.util.Scanner;

public class AdminLoginUI {
    public void display(){
        System.out.println("[1] Login");
        System.out.println("[0] Go back");
    }

    public int EnterChoices() {
        AdminLoginLogic adminMenuLogic = new AdminLoginLogic();
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

    public void displayLoginOwner(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        if (AdminLoginValidation.isUsernameValid(username) && AdminLoginValidation.isPasswordValid(password)) {
            AdminLoginLogic adminLoginLogic = new AdminLoginLogic();
            if (adminLoginLogic.loginOwner(username, password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Please try again.");
            }
        } else {
            System.out.println("Invalid username or password format. Please check and try again.");
        }
    }
}