import DTO.Player;
import DTO.TicTacToeBoard;
import Service.GamingService;
import Service.PlayerProvider;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Let's Start Tic-Tac Toe");
        System.out.println("Enter the Dimension of Board");
        TicTacToeBoard board=new TicTacToeBoard(sc.nextInt());

        System.out.println("Enter Player1 Name and Symbol");
        Player player1=new Player(sc.next(),sc.next());

        System.out.println("Enter Player2 Name and Symbol");
        Player player2=new Player(sc.next(),sc.next());

        PlayerProvider playerProvider = new PlayerProvider(Arrays.asList(player1,player2));

        GamingService gamingService = new GamingService();
        gamingService.startGame(board,playerProvider);




    }
}
