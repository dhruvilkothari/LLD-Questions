import java.util.Deque;
import java.util.LinkedList;

public class SnakeLaddergame {

    private Board board;
    private Deque<Player> players;
    private Dice dice;

    public SnakeLaddergame(int size){
        board = Board.getInstance(size);
        players = new LinkedList<>();
        Player p1 = new Player("DK1", new BluePlayingPiece());
        Player p2 = new Player("DK2", new GreenPlayingPiece());
        Player p3 = new Player("DK3", new YellowPlayingPiece());
        Player p4 = new Player("DK4", new RedPlayingPiece());
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        dice = new Dice(2);
        initilizeSnakeAndLadder();
    }

    private void initilizeSnakeAndLadder() {
        Snake snake1 = new Snake(99, 78);
        Snake snake2 = new Snake(92, 73);
        Snake snake3 = new Snake(87, 56);
        Snake snake4 = new Snake(65, 52);
        Snake snake5 = new Snake(48, 26);
        Snake snake6 = new Snake(36, 19);
        Snake snake7 = new Snake(29, 11);
        board.addSnake(snake1);
        board.addSnake(snake2);
        board.addSnake(snake3);
        board.addSnake(snake4);
        board.addSnake(snake5);
        board.addSnake(snake6);
        board.addSnake(snake7);

        Ladder l1 = new Ladder(3, 22);
        Ladder l2 = new Ladder(5, 25);
        Ladder l3 = new Ladder(11, 49);
        Ladder l4 = new Ladder(20, 38);
        Ladder l5 = new Ladder(28, 55);
        Ladder l6 = new Ladder(36, 44);
        Ladder l7 = new Ladder(51, 72);
        board.addLadder(l1);
        board.addLadder(l2);
        board.addLadder(l3);
        board.addLadder(l4);
        board.addLadder(l5);
        board.addLadder(l6);
        board.addLadder(l7);


    }

    public String gameStart(){
        Player winner = null;
        boolean isWinnerFound = false;
        while (isWinnerFound!=true){

            Player p1 = players.pollFirst();
            int diceValue = dice.getSum();
            System.out.println("DICE VALUE FOR PLAYER "+p1.getName()+" is "+ diceValue);
            int finalPosition = board.findNextPosition(p1.start, diceValue);
            System.out.println("FINAL POSTION FOR PLAYER" + p1.getName()+" is"+ finalPosition);
            if(finalPosition>= board.size*board.size){
                winner = p1;
                break;
            }
            p1.setStart(finalPosition);
            players.addLast(p1);
        }
        return winner.getName();
    }


}
