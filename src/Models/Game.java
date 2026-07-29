package Models;
public class Game {
    String name;
    String moodType;
    public Game(String name, String moodType) {
        this.name = name;
        this.moodType = moodType;
    }
    public String getName() {
        return name;
    }
    public String getMoodType() {
        return moodType;
    }
}  

