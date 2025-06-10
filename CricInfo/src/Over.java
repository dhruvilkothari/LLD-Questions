import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Over {
    private String id;
    private List<Ball> balls;

    public Over() {
        this.id = UUID.randomUUID().toString();
        this.balls = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}
