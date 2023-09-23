package PresentationLayer.UI;

import BusinessLogicLayer.AdminMenuLogic;
import BusinessLogicLayer.CustomerLogic;
import PresentationLayer.UI.AdminMenuUI;

import java.util.Scanner;

public class CustomerMenuUI {

    public void display(){
        System.out.println("[1] Show Menu");
        System.out.println("[2] Reservation");
        System.out.println("[0] Go back");
    }

    public int EnterChoices() {
        CustomerLogic customerLogic = new CustomerLogic();
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a number: ");
        String choices = sc.nextLine();

        while(!customerLogic.checkInt(choices)) {
            System.out.println("Please enter an integer number!!!");
            System.out.print("Choose a number: ");
            choices = sc.nextLine();
        }
        return Integer.parseInt(choices);
    }

    public void displayShowDish () {
        System.out.println("[1] Show all Dish");
        System.out.println("[2] Show all Dish with increasing PRICE");
        System.out.println("[3] Show all Dish with decreasing PRICE");
        System.out.println("[4] Show all Dish with increasing RATE");
        System.out.println("[5] Show all Dish with decreasing RATE");
        System.out.println("[0] Go back");
    }

}
