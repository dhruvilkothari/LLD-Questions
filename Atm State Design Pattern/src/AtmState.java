public interface AtmState {
    public void insertCard();
    public void ejectCard();
    public void insertPin(int pin);
    public void requestCash(int amount);
    public void cancelTransaction();
    public String getStateName();
    public void setStateName(AtmState atmState);
}
