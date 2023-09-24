package main;

import BusinessLogicLayer.*;
import DataLayer.DAO.*;
import DataLayer.DM.*;
import PresentationLayer.UI.AdminLoginUI;
import PresentationLayer.UI.AdminMenuUI;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

public class Main {
    public static volatile boolean isRunning = true;
    public static void main(String[] args) {

        Thread timeCheckerThread = new Thread(new AvailableTableChecker());
        timeCheckerThread.start();

        MainMenuLogic.getInstance().RunMainMenu();

        isRunning = false;
        try {
            timeCheckerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}