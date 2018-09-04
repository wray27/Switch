

import java.util.ArrayList;
import java.util.*;
public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private String playerName;
    private int playerID;
    private Switch game;
    private ArrayList<Move> moves;

    private static int playerCount = 0;

    public Player(String playerName, Switch game){
        this.playerName = playerName;
        this.playerID = playerCount;
        this.game = game;
        playerCount ++;

    }
    public void generateMoves(){
        for(Card card : hand){
            Move newMove = new Move(this,game.getTopCard(),card,hand);
            moves.add(newMove);
        }
    }
    public void addToHand(Deck deck, int numberOfCards){
        //DO Not FORGET EDGE CASE WHEN QUEUE IS EMPTY
        for(int i = 0; i <numberOfCards; i ++) {
            hand.add(deck.getCardQueue().pop());

        }
    }

    public String getPlayerName(){
        return this.playerName;
    }
    public void printHand(){

        for(Card card: hand){
            card.printCard();
        }
    }
    public void printMoves(){
        if(moves.isEmpty()) return;
        for(Move move: moves){

            move.printMove();
        }
    }
    public ArrayList<Card> getPlayerHand(){
        return this.hand;
    }


}
