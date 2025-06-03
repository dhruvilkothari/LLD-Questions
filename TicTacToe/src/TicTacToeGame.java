import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    private Board board;
    private Deque<Player> players;
    Scanner scanner;
    public TicTacToeGame(int size){
        players = new LinkedList<>();
        board = Board.getInstance(size);
        Player player1 = new Player("DHRUVIL", new PieceX());
        Player player2 = new Player("Kothari", new PieceY());
        players.add(player1);
        players.add(player2);
        scanner = new Scanner(System.in);
    }

    public String start(){

        boolean isWinnerFound = false;
        while(isWinnerFound!=true){
            board.printBoard();
            Player p1 = players.pollFirst();
            if(board.canStillMove()==false){
                break;
            }
            System.out.println("Player "+ p1.getName()+" chance");
            System.out.println("Enter row and column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            boolean isValidMove = board.canMove(row, column, p1.getPlayingPiece().getPieceType());
            if(isValidMove){
                players.addLast(p1);
            }else {
                players.addFirst(p1);
                continue;
            }
            boolean winnerFound = board.isWinnerFound(p1.getPlayingPiece().getPieceType(), row,column);
            if(winnerFound){
                board.printBoard();
                return p1.getName();
            }
        }
        return "Tie";
    }

}
