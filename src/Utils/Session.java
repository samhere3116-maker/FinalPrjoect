package Utils;
import Data.UserData;
public class Session {  
    public static UserData userData = new UserData();
    public static String currentUsername = "";
    public static void setCurrentUser(String username) {
        currentUsername = username;
        userData = new UserData();
    }
    public static String getCurrentUser() {
        return currentUsername;
    }
    public static boolean isLoggedIn() {
        return !currentUsername.isEmpty();
    }
}
   


