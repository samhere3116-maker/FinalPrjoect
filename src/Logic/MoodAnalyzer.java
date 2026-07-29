package logic;
import Models.Question;
import java.util.ArrayList;
public class MoodAnalyzer {
    public String analyzeMood(int[] answers, ArrayList<Question> questions) {        
        int calmScore = 0;
        int focusedScore = 0;
        int activeScore = 0;
        int stressedScore = 0;
        int sadScore = 0;
        int angryScore = 0;
        int happyScore = 0;       
        for (int i = 0; i < answers.length; i++) {
            String questionText = questions.get(i).getQuestionText();
            int answer = answers[i];
            if (questionText.equals("How do you feel right now?") ||
                questionText.equals("How is your breathing?") ||
                questionText.equals("What describes your body right now?")) {
                if (answer == 0) calmScore += 2;
                else if (answer == 1) calmScore += 1;
            }
            if (questionText.equals("How sharp is your concentration?") ||
                questionText.equals("Do you feel like solving problems?") ||
                questionText.equals("How motivated do you feel right now?")) {
                if (answer == 0) focusedScore += 2;
                else if (answer == 1) focusedScore += 1;
            }
            if (questionText.equals("How is your energy level?") ||
                questionText.equals("Do you feel like competing or winning?") ||
                questionText.equals("How excited are you right now?")) {
                if (answer == 0) activeScore += 2;
                else if (answer == 1) activeScore += 1;
            }
            if (questionText.equals("How overwhelmed do you feel?") ||
                questionText.equals("Are you feeling pressure right now?") ||
                questionText.equals("How patient are you feeling?")) {
                if (answer == 0) stressedScore += 2;
                else if (answer == 1) stressedScore += 1;
            }
            if (questionText.equals("How is your mood right now?") ||
                questionText.equals("Do you feel like doing anything?") ||
                questionText.equals("How connected do you feel to others?")) {
                if (answer == 0) sadScore += 2;
                else if (answer == 1) sadScore += 1;
            }
            if (questionText.equals("How frustrated are you feeling?") ||
                questionText.equals("How is your temper right now?") ||
                questionText.equals("Do you feel like venting or releasing energy?")) {
                if (answer == 0) angryScore += 2;
                else if (answer == 1) angryScore += 1;
            }
            if (questionText.equals("How joyful are you feeling?") ||
                questionText.equals("Do you feel like celebrating or having fun?") ||
                questionText.equals("How positive is your mindset right now?")) {
                if (answer == 0) happyScore += 2;
                else if (answer == 1) happyScore += 1;
            }
        }
        int maxScore = Math.max(calmScore,Math.max(focusedScore,Math.max(activeScore, Math.max(stressedScore,Math.max(sadScore,Math.max(angryScore, happyScore))))));
        if (maxScore == 0) return "CALM"; 
        if (maxScore == calmScore) return "CALM";
        if (maxScore == focusedScore) return "FOCUSED";
        if (maxScore == activeScore) return "ACTIVE";
        if (maxScore == stressedScore) return "STRESSED";
        if (maxScore == sadScore)  return "SAD";
        if (maxScore == angryScore) return "ANGRY";
        if (maxScore == happyScore) return "HAPPY";       
        return "CALM"; 
    }
}
