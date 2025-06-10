

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team {
    private final String id;
    private final String name;
    private List<Player> players;
    private int teamScore;


    public Team(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.teamScore = 0;
        this.players =new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }
}
