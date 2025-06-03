import java.util.ArrayList;
import java.util.List;

public class Board {
    private int [][]board;
    private static Board instance;
    private List<Ladder> ladders;
    private List<Snake> snakes;
    int size;
    private static Object lock = new Object();
    private Board(int size){
        this.size = size;
        board = new int[size][size];
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
    }
    public static Board getInstance(int size){
        synchronized (lock){
            if(instance==null){
                instance = new Board(size);
            }
        }
        return instance;
    }
    public void addSnake(Snake snake){
        snakes.add(snake);
    }
    public void addLadder(Ladder ladder){
        ladders.add(ladder);
    }

    public int findNextPosition(int start, int diceValue){
        int finalPostion =  start+diceValue;
        for(Ladder p : ladders){
            if(p.getStart() == finalPostion){
                System.out.println("Climbing Ladder from "+ finalPostion+" to "+ p.getEnd());
                finalPostion = p.getEnd();
                break;
            }
        }
        for (Snake s: snakes){
            if(s.getStart() == finalPostion){
                System.out.println("Snake Bite from "+ finalPostion+" to "+ s.getEnd());
                finalPostion = s.getEnd();

                break;
            }
        }
        return finalPostion;

    }



}
