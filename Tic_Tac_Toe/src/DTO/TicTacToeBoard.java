package DTO;


public class TicTacToeBoard {

    private int dimension;
    private String[][] board;

    public TicTacToeBoard(int dimension){
        this.dimension=dimension;
        board=new String[dimension][dimension];

    }

    public String[][] getBoard(){
        return this.board;
    }
    public void updateBoard(int x, int y , String symbol){
        this.board[x][y] = symbol;
    }

    @Override
    public String toString() {
        String print="";
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                print+=board[i][j]==null?"-":board[i][j];
            }
            print+="\n";
        }
        print+="\n";
        return print;
    }

    public boolean isComplete(){
        int len=board.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(board[i][j]==null){
                    return false;
                }
            }

        }
        return true;
    }
}
