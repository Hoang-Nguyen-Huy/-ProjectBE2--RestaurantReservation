package main;

import BusinessLogicLayer.AdminMenuLogic;
import DataLayer.DAO.*;
import DataLayer.DM.*;
import PresentationLayer.UI.AdminMenuUI;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdminMenuLogic adminMenuLogic = new AdminMenuLogic();
        adminMenuLogic.runAdminMenu();
    }
}