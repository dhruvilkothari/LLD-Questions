import java.util.UUID;

public class Player {
    private  String name;
    private int score;
    private final String id;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.score = 0;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public String getId() {
        return id;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
