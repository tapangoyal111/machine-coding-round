package DTO;

public class GameStatus {

    private TicTacToeBoard board;
    private ResultStatus status;

    private Player winner;

    public GameStatus(TicTacToeBoard board){
        this.board=board;
        this.status=ResultStatus.IN_PROGRESS;
        this.winner=null;
    }



    public Player getWinner(){
        return this.winner;
    }

    public void setStatus(ResultStatus status){
        this.status=status;
    }

    public ResultStatus getStatus(){
        return this.status;
    }


    public void setWinner(Player winner){
        this.winner=winner;
    }


}
