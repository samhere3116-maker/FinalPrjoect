package Data;
import Models.Question;
import java.util.ArrayList;
import java.util.Collections;
public class QuestionBank {
    private final ArrayList<Question> allQuestions = new ArrayList<>();   
    public QuestionBank() {       
        allQuestions.add(new Question(
            "How do you feel right now?",
            "Peaceful and calm",
            "Somewhere in between",
            "Restless or uneasy"));
        
        allQuestions.add(new Question(
            "How is your breathing?",
            "Slow and relaxed",
            "Normal",
            "Fast and tense"));
        
        allQuestions.add(new Question(
            "What describes your body right now?",
            "Completely relaxed",
            "Neutral",
            "Tense and stiff"));
        
      
        allQuestions.add(new Question(
            "How sharp is your concentration?",
            "Crystal clear",
            "Average",
            "All over the place"));
        
        allQuestions.add(new Question(
            "Do you feel like solving problems?",
            "Yes absolutely",
            "Maybe",
            "Not at all"));
        
        allQuestions.add(new Question(
            "How motivated do you feel right now?",
            "Very motivated",
            "Somewhat",
            "Not motivated"));
        
        
        allQuestions.add(new Question(
            "How is your energy level?",
            "Very high",
            "Medium",
            "Very low"));
        
        allQuestions.add(new Question(
            "Do you feel like competing or winning?",
            "Yes definitely",
            "Maybe",
            "No not really"));
        
        allQuestions.add(new Question(
            "How excited are you right now?",
            "Super excited",
            "Neutral",
            "Not excited at all"));
        
        
        allQuestions.add(new Question(
            "How overwhelmed do you feel?",
            "Very overwhelmed",
            "A little",
            "Not at all"));
        
        allQuestions.add(new Question(
            "Are you feeling pressure right now?",
            "Extremely stressed",
            "Somewhat",
            "No pressure at all"));
        
        allQuestions.add(new Question(
            "How patient are you feeling?",
            "Very impatient",
            "Normal",
            "Very patient"));
        
        
        allQuestions.add(new Question(
            "How is your mood right now?",
            "Sad and low",
            "Neutral",
            "Happy and good"));
        
        allQuestions.add(new Question(
            "Do you feel like doing anything?",
            "No motivation at all",
            "A little",
            "Yes very motivated"));
        
        allQuestions.add(new Question(
            "How connected do you feel to others?",
            "Very lonely",
            "Somewhat",
            "Very connected"));
        
        allQuestions.add(new Question(
            "How frustrated are you feeling?",
            "Very frustrated",
            "A little",
            "Not at all"));
        
        allQuestions.add(new Question(
            "How is your temper right now?",
            "Very irritated",
            "Neutral",
            "Completely calm"));
        
        allQuestions.add(new Question(
            "Do you feel like venting or releasing energy?",
            "Yes desperately",
            "Maybe",
            "No I am fine"));
        
        
        allQuestions.add(new Question(
            "How joyful are you feeling?",
            "Very happy",
            "Neutral",
            "Not happy at all"));
        
        allQuestions.add(new Question(
            "Do you feel like celebrating or having fun?",
            "Yes absolutely",
            "Maybe",
            "No not really"));
        
        allQuestions.add(new Question(
            "How positive is your mindset right now?",
            "Very positive",
            "Neutral",
            "Very negative"));
    }   
    public ArrayList<Question> getRandomQuestions() {
        ArrayList<Question> copy = new ArrayList<>(allQuestions);
        Collections.shuffle(copy);
        return new ArrayList<>(copy.subList(0, 5));
    }
}