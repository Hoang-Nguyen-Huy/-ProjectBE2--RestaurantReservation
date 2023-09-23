package PresentationLayer.UI;

import BusinessLogicLayer.AdminMenuLogic;

import java.util.Scanner;

public class MainMenuUI {
    public void display () {
        System.out.println("[1] Customer");
        System.out.println("[2] Restaurant Owner");
        System.out.println("[0] Exit");
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
}
