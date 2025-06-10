import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Match {
    private final String id;
    private final String title;
    private final String venue;
    private final LocalDateTime startTime;
    private final List<Team> teams;
    private MatchStatus matchStatus;
    private ScoreCard scorecard;

    public Match(String title, String venue, LocalDateTime startTime, List<Team> teams) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.venue = venue;
        this.startTime = startTime;
        this.teams = teams;
        this.matchStatus = MatchStatus.NOT_STARTED;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVenue() {
        return venue;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    public ScoreCard getScorecard() {
        return scorecard;
    }

    public void setScorecard(ScoreCard scorecard) {
        this.scorecard = scorecard;
    }
}
