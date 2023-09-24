package BusinessLogicLayer;

public class AdminValidation {
    public static boolean isUsernameValid(String username) {
        if(username.isEmpty()){
            System.out.println("Please input information!");
            return false;
        }
        return true;
    }

    public static boolean isPasswordValid(String password) {
        if(password.isEmpty()){
            System.out.println("Please input information!");
            return false;
        }
        return true;
    }

    public static boolean isValidName(String username){
        if(username.isEmpty()){
            System.out.println("Name can not be empty!");
            return false;
        }

        if (username.matches("^.*[0-9!@#$%^&*(){}_+-=*/.<>?|].*")){
            System.out.println("Name can only contain characters");
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

    public static boolean isValidRole(String role){
        if(role.isEmpty()){
            System.out.println("Role can not be empty!");
            return false;
        }

        if(!isSupportedRole(role)) return false;

        return true;
    }

    private static boolean isSupportedRole(String role) {
        String[] supportedRoles = new String[]{"Manager","Chef","Waitstaff"};
        for (String supportedString : supportedRoles) {
            if (supportedString.equals(role))
                return true;
        }
        return false;
    }

    public static boolean isValidCapacity(String capacity) {
        if (capacity.isEmpty()) {
            System.out.println("Capacity can not be empty!");
            return false;
        }

        if (capacity.matches("\\d+")) {
            int intValue = Integer.parseInt(capacity);
            if (intValue < 1) {
                System.out.println("Capacity must be a positive integer!");
                return false;
            }
        } else {
            System.out.println("Capacity must be a positive integer!");
            return false;
        }

        return true;
    }

    public static boolean isValidTypeOfTable (String type){
        if(type.isEmpty()){
            System.out.println("Role can not be empty!");
            return false;
        }

        if(!isSupportedTypeOfTable(type)) return false;

        return true;
    }

    private static boolean isSupportedTypeOfTable(String type) {
        String[] supportedTypes = new String[]{"Standard","Round","Outdoor"};
        for (String supportedString : supportedTypes) {
            if (supportedString.equals(type))
                return true;
        }
        return false;
    }

    public static boolean isValidDouble(String number){
        if(number.isEmpty()){
            System.out.println("This can not be empty!");
            return false;
        }

        try {
            double doubleValue = Double.parseDouble(number);
            if (doubleValue < 0){
                System.out.println("This must be a positive double!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("This must be a valid double!");
            return false;
        }

        return true;
    }

    public static boolean isValidDescription(String description) {

        if(description.isEmpty()){
            System.out.println("Description can not be empty!");
            return false;
        }

        if (description.length() > 1000) {
            System.out.println("Your description is too long!!!");
            return false;
        }
        return true;
    }

}
