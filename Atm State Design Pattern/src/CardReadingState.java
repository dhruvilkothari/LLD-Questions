public class CardReadingState implements AtmState{

    private Atm atm;

    public CardReadingState(Atm atm) {
        this.atm = atm;
    }
    @Override
    public void insertCard() {
        System.out.println("Card is already inserted");
        return;

    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        this.atm.setStateName(new ReadyState(this.atm));

    }

    @Override
    public void insertPin(int pin) {

        if(validatePin(pin)){
            this.atm.setStateName(StateFactory.createState("OPERATION_SELECTION_STATE", this.atm));
        }

    }

    private boolean validatePin(int pin) {
        return true;
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Operation Not Selected");
        return;

    }

    @Override
    public void cancelTransaction() {
        this.atm.setStateName(new ReadyState(this.atm));

    }

    @Override
    public String getStateName() {
        return "CARD_READING_STATE";
    }

    @Override
    public void setStateName(AtmState atmState) {

    }
}
