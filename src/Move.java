

import java.util.ArrayList;
//import java.util.HashSet;

public class Move {
    private Player player;
    private Card topCard;
    private ArrayList<Card> hand;
    private boolean firstCardPlayed = false;
    ArrayList<Card> move;
    public Move(Player player, Card topCard,Card firstCard,ArrayList<Card> hand){
        this.player = player;
        this.topCard = topCard;
        this.hand = hand;
        move = new ArrayList<>();



        this.hand.remove(firstCard);


        addToMove(firstCardPlayed,firstCard);
        firstCardPlayed = true;
        for(Card card: this.hand){
            if(addToMove(firstCardPlayed,card)){
                this.hand.remove(card);

            }
            else{
                break;
            }
        }



    }
    public boolean addToMove(boolean firstCardPlayed,Card cardToAdd){
        boolean addToMove = false;
        ArrayList<Card> hand = player.getPlayerHand();
        if(!firstCardPlayed){
            if(cardToAdd.getSuit()== this.topCard.getSuit()||cardToAdd.getRank() == topCard.getRank()|| cardToAdd.getRank()== 1||cardToAdd.getRank() ==0){
                topCard = cardToAdd;
                move.add(cardToAdd);
                addToMove = true;

            }
        }else{
            if(cardToAdd.getRank() == topCard.getRank()|| cardToAdd.getRank() + 1 == topCard.getRank() || cardToAdd.getRank() - 1 == topCard.getRank())
                topCard = cardToAdd;
                move.add(cardToAdd);
                addToMove = true;

        }
        return addToMove;
    }
    public void printMove(){
        if(move.isEmpty()) return;
        for(Card card: move){
            card.printCard();
        }
    }
}
