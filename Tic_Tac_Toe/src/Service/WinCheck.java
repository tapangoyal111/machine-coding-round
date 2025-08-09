package Service;

import DTO.Move;
import DTO.Player;
import DTO.TicTacToeBoard;

public class WinCheck {

    public Player getWinner(TicTacToeBoard board, Move move){
        Player currentPlayer = move.getPlayer();
        String symbol=currentPlayer.getSymbol();

        if(isRowMatched(move.getX(), board,symbol)){
            return currentPlayer;
        } else if (isColumnMatched(move.getY(), board,symbol)) {
            return currentPlayer;
        }else if(move.getY()== move.getX() && isDiagMatched(board,symbol)){
            return currentPlayer;
        } else if (isRevDiagMatched(board,symbol)) {
            return currentPlayer;

        }
        else{
            return null;
        }

    }

    private boolean isRowMatched(int row , TicTacToeBoard board, String sym){
        int size=board.getBoard().length;
        String[][] currentBoard= board.getBoard();
        for(int i=0;i<size;i++){
            if(sym!=currentBoard[row][i]){

                return false;
            }
        }
        return true;
    }

    private boolean isColumnMatched(int col , TicTacToeBoard board, String sym){
        int size=board.getBoard().length;
        String[][] currentBoard= board.getBoard();
        for(int i=0;i<size;i++){
            if(sym!=currentBoard[i][col]){

                return false;
            }
        }
        return true;
    }
    private boolean isDiagMatched(TicTacToeBoard board, String sym){
        int size=board.getBoard().length;
        String[][] currentBoard= board.getBoard();

        for(int i=0;i<size;i++){
            if(sym!=currentBoard[i][i]){

                return false;
            }
        }
        return true;
    }

    private boolean isRevDiagMatched( TicTacToeBoard board, String sym){
        int size=board.getBoard().length;
        String[][] currentBoard= board.getBoard();

        for(int i=0;i<size;i++){
            if(sym!=currentBoard[i][size-i-1]){

                return false;
            }
        }
        return true;
    }

}
