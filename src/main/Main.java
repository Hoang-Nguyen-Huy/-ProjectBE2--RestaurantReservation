package main;

import BusinessLogicLayer.AdminLoginLogic;
import BusinessLogicLayer.AdminMenuLogic;
import BusinessLogicLayer.CustomerLogic;
import BusinessLogicLayer.MainMenuLogic;
import DataLayer.DAO.*;
import DataLayer.DM.*;
import PresentationLayer.UI.AdminLoginUI;
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
        MainMenuLogic.getInstance().RunMainMenu();
    }
}