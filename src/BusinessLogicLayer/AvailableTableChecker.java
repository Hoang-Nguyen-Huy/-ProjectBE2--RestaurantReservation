package BusinessLogicLayer;

import DataLayer.DAO.ReservationDAO;
import DataLayer.DAO.TableDAO;
import DataLayer.DM.Reservation;
import main.Main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AvailableTableChecker implements  Runnable {
    @Override
    public void run () {
        while(Main.isRunning) {
            ArrayList<Integer> tablid = new ArrayList<Integer>();
            tablid = ReservationDAO.getInstance().selectTableID(LocalDate.now(), LocalTime.now());
            TableDAO.getInstance().updateTableByRealDate(tablid);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
