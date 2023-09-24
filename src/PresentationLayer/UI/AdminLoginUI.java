package PresentationLayer.UI;

import BusinessLogicLayer.AdminLoginLogic;
import BusinessLogicLayer.AdminValidation;
import BusinessLogicLayer.AdminMenuLogic;
import java.util.Scanner;

public class AdminLoginUI {
    public void display(){
        System.out.println("---------LOGIN OWNER----------");
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
            display();
            System.out.print("Choose a number: ");
            choices = sc.nextLine();
        }
        return Integer.parseInt(choices);
    }


    public boolean displayLoginOwner(){
        boolean isLogin = true;
        while(isLogin) {
            String username = "";
            String password = "";
            Scanner sc = new Scanner(System.in);

            do {
                System.out.print("Username: ");
                username = sc.nextLine();
            } while(!AdminValidation.isUsernameValid(username));

            do {
                System.out.print("Password: ");
                password = sc.nextLine();
            } while(!AdminValidation.isPasswordValid(password));


                AdminLoginLogic adminLoginLogic = new AdminLoginLogic();
                if (adminLoginLogic.loginOwner(username, password)) {
                    System.out.println("Login successful!");
                    isLogin = false;
                    AdminMenuLogic adminMenuLogic = new AdminMenuLogic();
                    adminMenuLogic.runAdminMenu();
                } else {
                    System.out.println("Login failed. Please try again.");
                    isLogin = true;
                }


        }
        return isLogin;
    }
}
