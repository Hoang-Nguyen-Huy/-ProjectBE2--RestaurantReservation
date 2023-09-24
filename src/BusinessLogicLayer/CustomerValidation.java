package BusinessLogicLayer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerValidation {
    public static boolean isValidUsername (String username){
        if(username.isEmpty()){
            System.out.println("Full name can not be empty!");
            return false;
        }

        if (username.matches("^.*[0-9!@#$%^&*(){}_+-=*/.<>?|].*")){
            System.out.println("Username can only contain characters");
            return false;
        }

        return true;
    }


    public static boolean isValidEmail(String email) {

        if(email.isEmpty()){
            System.out.println("Email can not be empty!");
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if(!email.matches(emailRegex)){
            System.out.println("Email is not valid");
            return false;
        }

        return true;

    }

    public static boolean isValidPhone(String phone){

        if(phone.isEmpty()){
            System.out.println("Phone can not be empty!");
            return false;
        }

        if (!phone.matches("^[0-9]+$")) {
            System.out.println("Phone numbers can only contain digits");
            return false;
        }

        if(phone.length()!=10){
            System.out.println("Phone must be have 10 characters");
            return false;
        }
        return true;
    }

    public static boolean isValidDate(String date) {

        if(date.isEmpty()){
            System.out.println("Date can not be empty!");
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    public static boolean isValidTime(String time) {

        if(time.isEmpty()){
            System.out.println("Time can not be empty!");
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setLenient(false);

        try {
            sdf.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidNoPeople(String noPeople) {
        if (noPeople.isEmpty()) {
            System.out.println("Number of people can not be empty!");
            return false;
        }

        if (noPeople.matches("\\d+")) {
            int intValue = Integer.parseInt(noPeople);
            if (intValue < 1) {
                System.out.println("Number of people must be a positive integer!");
                return false;
            }
        } else {
            System.out.println("Number of people must be a positive integer!");
            return false;
        }

        return true;
    }

    public static boolean isValidRequirement(String requirement) {

        if (requirement.isEmpty()) {
            System.out.println("Requirement of people can not be empty!");
            return false;
        }

        if (requirement.length() > 250) {
            System.out.println("Your requirement is too long!!!");
            return false;
        }
        return true;
    }

}
