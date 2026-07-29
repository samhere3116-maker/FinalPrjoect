package Data;
import Models.UserAccount;
import java.io.*;
import java.util.ArrayList;
public class UserFileHandler {
    
    private static final String FILE_PATH = "users.txt";
    
    public static boolean registerUser(String username, String password) {
    
        if (userExists(username)) {
            return false; 
        }
 
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(username + "," + password);
            bw.newLine();
            return true; 
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean loginUser(String username, String password) {
        ArrayList<UserAccount> users = getAllUsers();
        for (UserAccount user : users) {
            if (user.getUsername().equals(username) && 
                user.getPassword().equals(password)) {
                return true; 
            }
        }
        return false; 
    }
    
    public static boolean userExists(String username) {
        ArrayList<UserAccount> users = getAllUsers();
        for (UserAccount user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
  
    public static ArrayList<UserAccount> getAllUsers() {
        ArrayList<UserAccount> users = new ArrayList<>();       
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new UserAccount(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
        }
        return users;
    }
   
public static void saveHistory(String username, String mood,
                               String game, String feedback) {
    java.util.Date now = new java.util.Date();
    String date = new java.text.SimpleDateFormat("dd-MMM-yyyy").format(now);
    String time = new java.text.SimpleDateFormat("hh:mm a").format(now);
    try (java.io.FileWriter fw = new java.io.FileWriter("history.txt", true);
         java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {
        bw.write(username + "," + mood + "," + game + "," + 
                 feedback + "," + date + "," + time);
        bw.newLine();       
    } catch (java.io.IOException e) {
        System.out.println("Error saving history: " + e.getMessage());
    }
}
public static String getLastHistory(String username) {
    String lastLine = null;
    try (java.io.BufferedReader br = new java.io.BufferedReader(
            new java.io.FileReader("history.txt"))) {       
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith(username + ",")) {
                lastLine = line;
            }
        }       
    } catch (java.io.IOException e) {
        return null;
    }
    return lastLine;
}
public static boolean updatePassword(String username, String newPassword) {
    try {
        
        java.util.ArrayList<String> lines = new java.util.ArrayList<>();
        java.io.BufferedReader br = new java.io.BufferedReader(
            new java.io.FileReader("users.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(username)) {
                
                lines.add(username + "," + newPassword);
            } else {
                lines.add(line);
            }
        }
        br.close();
        java.io.BufferedWriter bw = new java.io.BufferedWriter(
            new java.io.FileWriter("users.txt", false));
        for (String l : lines) {
            bw.write(l);
            bw.newLine();
        }
        bw.close();
        return true;

    } catch (java.io.IOException e) {
        System.out.println("Error updating password: " + e.getMessage());
        return false;
    }
}
}

