package Data;
import java.util.ArrayList;
public class UserData {
   
    private final ArrayList<String> moodHistory = new ArrayList<>();
    private final ArrayList<String> gameHistory = new ArrayList<>();
    private final ArrayList<String> feedbackHistory = new ArrayList<>();
    
    public void addMood(String mood) {
        moodHistory.add(mood);
    }
    
    public void addGame(String game) {
        gameHistory.add(game);
    }
    
    public void addFeedback(String feedback) {
        feedbackHistory.add(feedback);
    }
    
    public String getLastGame() {
        if (gameHistory.isEmpty()) {
            return null;
        }
        return gameHistory.get(gameHistory.size() - 1);
    }
    
    public String getLastMood() {
        if (moodHistory.isEmpty()) {
            return null;
        }
        return moodHistory.get(moodHistory.size() - 1);
    }
    
    public ArrayList<String> getMoodHistory() {
        return moodHistory;
    }
    public ArrayList<String> getGameHistory() {
        return gameHistory;
    }
    public ArrayList<String> getFeedbackHistory() {
        return feedbackHistory;
    }
}  

