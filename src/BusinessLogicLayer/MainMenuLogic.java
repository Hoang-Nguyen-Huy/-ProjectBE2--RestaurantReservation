package BusinessLogicLayer;

import PresentationLayer.UI.CustomerMenuUI;
import PresentationLayer.UI.MainMenuUI;

public class MainMenuLogic {
    MainMenuUI ui = new MainMenuUI();
    AdminMenuLogic adminMenuLogic = new AdminMenuLogic();
    CustomerLogic customerLogic = new CustomerLogic();

    AdminLoginLogic adminLoginLogic = new AdminLoginLogic();

    public boolean checkInt(String choices) {
        try {
            Integer.parseInt(choices);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static MainMenuLogic getInstance() {
        return new MainMenuLogic();
    }

    public void RunMainMenu() {
        boolean isRunningMain = true;
        while(isRunningMain) {
            ui.display();
            switch (ui.EnterChoices()) {
                case 1:
                    customerLogic.runMenuCustomer();
                    break;
                case 2:
                    adminLoginLogic.menuOwner();
                    break;
                case 0:
                    isRunningMain = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-2");
                    break;
            }
        }
    }



}
