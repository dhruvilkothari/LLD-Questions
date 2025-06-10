import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreCard {
    private final String id;
    private final Match match;
    private final HashMap<String, Integer> teamScores;
    private  List<Inning> innings;

    public ScoreCard(String id, Match match) {
        this.id = id;
        this.match = match;
        this.teamScores = new HashMap<>();
        this.innings = new ArrayList<>();
    }
    public void addInnings(Inning innings) {
        this.innings.add(innings);
    }

    public String getId() {
        return id;
    }

    public Match getMatch() {
        return match;
    }

    public HashMap<String, Integer> getTeamScores() {
        return teamScores;
    }

    public List<Inning> getInnings() {
        return innings;
    }

    public void addInning(Inning inning) {
        innings.add(inning);
    }
}
