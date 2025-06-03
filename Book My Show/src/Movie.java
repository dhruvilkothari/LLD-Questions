public class Movie {
    private final int movieId;
    private String movieName;
    private final  String movieDuration;

    public Movie(int movieId, String movieName, String movieDuration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDuration() {
        return movieDuration;
    }
}
