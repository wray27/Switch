
import java.util.*;
import java.util.Random;


public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private boolean jokersInDeck;
    private int deckLength = 52;
    private LinkedList<Card> cardQueue = new LinkedList<Card>();

    public Deck(boolean jokersInDeck){
        this.jokersInDeck = jokersInDeck;
        if  (jokersInDeck){
            deckLength = 54;
        }
        for(int i = 1; i < 14;i++){
            for (Card.Suit suit : Card.Suit.values()) {
                Card card = new Card(i,suit);
                deck.add(card);
            }
        }
        if(this.jokersInDeck) {
            deck.add(new Card(0, Card.Suit.CLUBS));
            deck.add(new Card(0, Card.Suit.DIAMONDS));
        }
        shuffle();
        cardQueue.addAll(deck);



    }

    public LinkedList<Card> getCardQueue(){

        return this.cardQueue;
    }
    public void shuffle(){
        Random rand = new Random();
        Card temp;

        int  n;



        for(int i = 0; i <deckLength; i++){
            n = rand.nextInt(deckLength -1);
            temp = deck.get(i);
            deck.set(i,deck.get(n));
            deck.set(n,temp);

        }

    }
    public void printDeck(){
//        int j = 1;

        for(Card card : this.deck){
           card.printCard();
//            System.out.println(j);
//            j++;
        }
    }
}
