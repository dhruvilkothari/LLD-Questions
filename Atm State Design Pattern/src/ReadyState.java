public class ReadyState implements AtmState{
    private Atm atm;
    public ReadyState(Atm atm) {
        this.atm = atm;
    }
    @Override
    public void insertCard() {
        System.out.println("Card is inserted");
        this.atm.setStateName(new CardReadingState(this.atm));

    }

    @Override
    public void ejectCard() {
        System.out.println("Card Cannot be ejected");
        return;

    }

    @Override
    public void insertPin(int pin) {
        System.out.println("Pin Cannot be Entered");


    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Cash Cannot be requested");

    }

    @Override
    public void cancelTransaction() {
        System.out.println("Transaction Cannot be cancelled");

    }

    @Override
    public String getStateName() {
        return "READY_STATE";
    }

    @Override
    public void setStateName(AtmState atmState) {

    }
}
