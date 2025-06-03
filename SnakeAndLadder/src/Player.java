public class Player {
    private String name;
    private PlayingPiece playingPiece;
    public int start;

    public Player(String name,PlayingPiece playingPiece){
        this.playingPiece = playingPiece;
        this.name=  name;
        this.start = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    public void setStart(int finalPosition) {
        this.start=finalPosition;
    }
}
