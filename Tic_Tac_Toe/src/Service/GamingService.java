package Service;

import DTO.GameStatus;
import DTO.Move;
import DTO.Player;
import DTO.TicTacToeBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GamingService {

    MoveValidatior validationService = new MoveValidatior();
    WinCheck winCheck = new WinCheck();
    public void startGame(TicTacToeBoard board , PlayerProvider playerProvider){

        GameStatus gameStatus=new GameStatus(board);
        Scanner sc = new Scanner(System.in);
        Move move;
        int x,y;

        while(gameStatus.getWinner()==null && !board.isComplete()){
            System.out.print(board);
            boolean isValid=false;
            Player nextPlayer = playerProvider.getNextPlayer();
            do{
                System.out.printf("Its your Move %s , Enter the co-ordinates\n",nextPlayer.getName());
                x=sc.nextInt();
                y =sc.nextInt();
                move = new Move(nextPlayer,x,y);
                 isValid =validationService.isValidMove(board,move);
                 if(!isValid){
                     System.out.println("Ohh !! It wasn't a valid move, Please try again");
                 }
            }while(!isValid);

            makeMove(board,move);
            gameStatus.setWinner(winCheck.getWinner(board,move));
        }

        System.out.printf("Game has been Ended , Winner of game is %s\n",gameStatus.getWinner()==null?"Draw":gameStatus.getWinner().getName());
        System.out.print(board);

    }

    public void makeMove(TicTacToeBoard board , Move move) {
        board.updateBoard(move.getX(), move.getY(), move.getPlayer().getSymbol());
    }
}
