package BusinessLogicLayer;


import PresentationLayer.UI.AdminLoginUI;

import java.util.HashMap;
import java.util.Map;

public class AdminLoginLogic {
    private final Map<String, String> adminAccounts = new HashMap<>();

    AdminLoginUI ui = new AdminLoginUI();

    public AdminLoginLogic() {
        adminAccounts.put("admin", "adminpassword");
    }

    public boolean checkInt(String choices) {
        try {
            Integer.parseInt(choices);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void menuOwner(){
        boolean isRunningMenuOwner = true;
        while(isRunningMenuOwner){
            ui.display();
            switch (ui.EnterChoices()){
                case 1:
                    ui.displayLoginOwner();
                    break;
                case 0:
                    isRunningMenuOwner = false;
                    break;
                default:
                    System.out.println("Please enter a number from 0-1");
                    break;
            }
        }
    }
    public boolean loginOwner(String username, String password) {
        if (adminAccounts.containsKey(username) && adminAccounts.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
