import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Inning {
    private final String id;
    private String battingId;
    private String bowlingId;
    private List<Over> overs;

    public Inning(String battingTeamId, String bowlingTeamId) {
        this.id = UUID.randomUUID().toString();
        this.overs = new ArrayList<>();
        this.battingId = battingTeamId;
        this.bowlingId = bowlingTeamId;

    }

}
