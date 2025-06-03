public class OperationSelectionState implements AtmState{
    private Atm atm;

    public OperationSelectionState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {

    }

    @Override
    public void ejectCard() {

    }

    @Override
    public void insertPin(int pin) {

    }

    @Override
    public void requestCash(int amount) {

    }

    @Override
    public void cancelTransaction() {

    }

    @Override
    public String getStateName() {
        return "";
    }

    @Override
    public void setStateName(AtmState atmState) {

    }
}
