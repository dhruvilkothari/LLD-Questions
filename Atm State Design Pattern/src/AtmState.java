public interface AtmState {
    String getStateName();

    public AtmState next(AtmContext atmContext);

}
