package Service;

import DTO.Move;
import DTO.TicTacToeBoard;

public class MoveValidatior {

    public boolean isValidMove(TicTacToeBoard board,Move move){
        int size=board.getBoard().length;
        if(move.getX()<size && move.getY()<size && move.getY()>=0 && move.getX()>=0){
            return board.getBoard()[move.getX()][move.getY()]==null;
        }
        return  false;
    }
}


