package DTO;

public class Player {
    private String name;
    private String symbol;

    public String getName(){
        return this.name;
    }
    public String getSymbol(){
        return this.symbol;
    }

    public Player(String name, String symbol){
        this.name=name;
        this.symbol=symbol;

    }
}
