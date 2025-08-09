package Service;

import DTO.Player;

import java.util.*;

public class PlayerProvider {

    private Queue<Player> playersQueue;

    public PlayerProvider(List<Player> playerList){
        this.playersQueue = new LinkedList<>(playerList);
    }

    public  Player getNextPlayer(){
        Player nextPlayer = playersQueue.poll();
        playersQueue.add(nextPlayer);
        return  nextPlayer;
    }

}
