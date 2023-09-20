package BusinessLogicLayer;

import DataLayer.DAO.StaffDAO;
import DataLayer.DM.Staff;
import PresentationLayer.UI.AdminMenuUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenuLogic {
    AdminMenuUI ui = new AdminMenuUI();
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
                case 0:
                    isRunning = false;
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
                    System.out.println("Add more Staffs");
                    System.out.print("Enter full name: ");
                    String name = ui.EnterInfor();
                    System.out.print("Enter phone: ");
                    String phone = ui.EnterInfor();
                    System.out.print("Enter role: ");
                    String role = ui.EnterInfor();
                    Staff staff1 = new Staff(name, phone, role);
                    StaffDAO.getInstance().insert(staff1);
                    break;
                case 2:
                    System.out.println("Show all Staffs");
                    ArrayList<Staff> list = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list) {
                        System.out.println(staff.toString());
                    }
                    break;
                case 3:
                    menuUpdateStaff();
                    break;
                case 0:
                    isRunningmenuStaff = false;
                    break;
            }
        }
    }

    public void menuUpdateStaff() {
        boolean isRunningUpdate = true;
        while (isRunningUpdate) {
            ui.displayMenuForUpdatingStaffs();
            switch (ui.EnterChoices()) {
                case 4:
                    System.out.println("Show all Staffs");
                    ArrayList<Staff> list = StaffDAO.getInstance().selectAll();
                    for(Staff staff : list) {
                        System.out.println(staff.toString());
                    }
                   System.out.println("Update all information");
                   System.out.print("Enter the StaffID that you want to update: ");
                   int id = ui.EnterChoices();
                   System.out.print("Enter new full name: ");
                   String name = ui.EnterInfor();
                   System.out.print("Enter new phone: ");
                   String phone = ui.EnterInfor();
                   System.out.print("Enter new role: ");
                   String role = ui.EnterInfor();

                   Staff staffUpAll = new Staff(id, name, phone, role);
                   StaffDAO.getInstance().update(staffUpAll);
                   break;
                case 0:
                    isRunningUpdate = false;
                    break;
            }
        }
    }
    
}
