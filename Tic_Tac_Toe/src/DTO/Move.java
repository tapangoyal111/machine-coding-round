package DTO;

public class Move {

    private int x;
    private int y;
    private Player player;

    public Move(Player player, int x, int y){
        this.player=player;
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Player getPlayer(){
        return this.player;
    }



}
