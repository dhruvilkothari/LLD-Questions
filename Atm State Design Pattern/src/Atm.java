public class Atm {
    private int id;
    private AtmState atmState;

    public Atm(int id) {
        this.id = id;
//        this.atmState = new IdleState();
    }
    public void insertCard() {
        this.atmState.insertCard();
    }
    public void ejectCard() {
        this.atmState.ejectCard();
    }
    public void insertPin(int pin) {
        this.atmState.insertPin(pin);
    }
    public void requestCash(int amount) {
        this.atmState.requestCash(amount);
    }
    public void cancelTransaction() {
        this.atmState.cancelTransaction();
    }

    public void setStateName(AtmState atmState) {
        this.atmState = atmState;

    }
}
