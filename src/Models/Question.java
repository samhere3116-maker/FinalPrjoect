package Models;
public class Question {      
    private final String questionText;
    private final String optionA;
    private final String optionB;
    private final String optionC;   
    public Question(String questionText, String optionA, String optionB, String optionC) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
    }   
    public String getQuestionText()
    { 
        return questionText;
    }
    public String getOptionA() 
    { 
        return optionA;
    }
    public String getOptionB() 
    { 
        return optionB;
    }
    public String getOptionC() 
    {
        return optionC;
    }
}  

