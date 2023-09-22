package BusinessLogicLayer;

public class AdminLoginValidation {
    public static boolean isUsernameValid(String username) {
        return !username.isEmpty();
    }

    public static boolean isPasswordValid(String password) {
        return !password.isEmpty();
    }
}
