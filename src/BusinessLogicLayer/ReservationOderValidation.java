package BusinessLogicLayer;



public class ReservationOderValidation {
    public static boolean isValidUsername (String username){
        if(username.isEmpty()){
            System.out.println("Full name can not be empty!");
            return false;
        }

        char[] usernameChar = username.trim().toCharArray();
        int usernameCharLen = usernameChar.length;
        int currentPosition = 0;

        if (isSupportedSymbolsUsername(usernameChar[0]) || isSupportedSymbolsUsername(usernameChar[usernameCharLen - 1])) {
            System.out.println("Cannot use these symbols at the beginning or the end of the username: '_', '.', '-'");
            return false;
        }

        for (char c : usernameChar) {
            if (!Character.isLetterOrDigit(c)) {
                if (!isSupportedSymbolsUsername(c)) {
                    System.out.println("Cannot use any symbols except '_', '.', '-'");
                    return false;
                }

                if (isSupportedSymbolsUsername(c) && isSupportedSymbolsUsername(usernameChar[currentPosition + 1])) {
                    System.out.println("These symbols ('_', '.', '-') cannot be consecutively");
                    return false;
                }
//              Note: có thể bỏ việc khoảng trắng :>
                if (Character.isWhitespace(c)) {
                    System.out.println("Username cannot contain whitespace");
                    return false;
                }
            }
            currentPosition++;
        }

        if (username.matches("[0-9-]+")){
            System.out.println("Username can not contain digits");
            return false;
        }

        return true;
    }

    private static boolean isSupportedSymbolsUsername(char c) {
        char[] supportedCharacters = new char[]{'_', '.', '-'};
        for (char supportedCharacter : supportedCharacters) {
            if (supportedCharacter == c)
                return true;
        }
        return false;
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

        if(phone.length()>10){
            System.out.println("Phone can not be larger than 10 characters");
            return false;
        }

        if (!phone.matches("[0-9-]+")){
            System.out.println("Phone numbers can only contain digits");
            return false;
        }
        return true;
    }

    public static boolean isValidNumberOfPeople(int NumberOfPeople){
        if (NumberOfPeople<1){
            System.out.println("Number Of People mus be larger than 0");
            return false;
        }
        return true;
    }

}
