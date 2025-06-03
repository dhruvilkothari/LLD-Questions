public class Board {
    private static Board instance;
    private PieceType[][] board;
    private int size;

    private Board(int size) {
        this.size = size;
        board = new PieceType[size][size];
    }
    public static Board getInstance(int size) {
        if (instance == null) {
            instance = new Board(size);
        }
        return instance;
    }
    public boolean canMove(int row,int colum, PieceType pieceType){
        if(row < 0 || row>=size || colum<0 || colum>=size || board[row][colum]!=null)return false;
        board[row][colum] = pieceType;

        return true;
    }
    public boolean isWinnerFound(PieceType pieceType, int r,int c){
        boolean left = true;
        boolean right = true;
        boolean up = true;
        boolean down = true;

        for(int i=0;i<size;i++){
            if(board[r][i]!=pieceType){
                left = false;
                break;
            }
        }
        if(left)return true;
        for(int i=0;i<size;i++){
            if(board[i][c]!=pieceType){
                right = false;
                break;
            }
        }
        if(right)return true;
        for(int i=0,j=0;i<size;i++,j++){
            if(board[i][j]!=pieceType){
                up = false;
                break;
            }
        }
        if(up)return true;

        for(int i=0,j=size-1;i<size;i++,j--){
            if(board[i][j]!=pieceType){
                down = false;
                break;
            }
        }
        if(down)return true;
        return false;
    }
    public boolean canStillMove(){

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null)return true;
            }
        }

        return false;
    }
    public void printBoard() {

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null){
                    System.out.print(board[i][j]+" ");
                }else {
                    System.out.print("-1");
                }
            }
            System.out.println();
        }

//        for (int i = 0; i < size; i++) {
//            // Print row content
//            for (int j = 0; j < size; j++) {
//                if (board[i][j] != null) {
//                    System.out.print(" " + board[i][j] + " ");
//                } else {
//                    System.out.print("   "); // empty space
//                }
//                if (j < size - 1) System.out.print("|");
//            }
//            System.out.println(); // new line after each row
//
//            // Print separator line between rows
//            if (i < size - 1) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print("---");
//                    if (j < size - 1) System.out.print("+");
//                }
//                System.out.println();
//            }
//        }
    }





}
