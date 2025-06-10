import java.util.HashMap;

public class MatchService {
    private static MatchService instance;
    private HashMap<String , Match> matchHashMap;

    private MatchService(){
        matchHashMap = new HashMap<>();
    }
    public MatchService getInstance(){
        if(instance == null){
            instance = new MatchService();
        }
        return instance;
    }

    public static void setInstance(MatchService instance) {
        MatchService.instance = instance;
    }

    public HashMap<String, Match> getMatchHashMap() {
        return matchHashMap;
    }

    public void setMatchHashMap(HashMap<String, Match> matchHashMap) {
        this.matchHashMap = matchHashMap;
    }
    public void updateMatchStatus(String matchId, MatchStatus status) {
        Match match = matchHashMap.get(matchId);
        if (match != null) {
            match.setMatchStatus(status);
        }
    }
}
