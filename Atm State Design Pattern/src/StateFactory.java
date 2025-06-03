public class StateFactory {

    public  static AtmState createState(String state, Atm atm){
        return switch (state) {
            case "READY_STATE" -> new ReadyState(atm);
            case "CARD_READING_STATE" -> new CardReadingState(atm);
            case "OPERATION_SELECTION_STATE" -> new OperationSelectionState(atm);
            default -> null;
        };
    }

}
