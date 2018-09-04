
import java.util.ArrayList;

public class Switch {

    private ArrayList<Player> players = new ArrayList<>();
    private int noOfPlayers;
    private Deck deck;
    private int roundNumber;
    private int playerTurn;
    private boolean turnOver;
    Player currentPlayer;
    private boolean gameWon;
    private Card topCard;
    ArrayList<String> playerNames;




    public Switch(int noOfPlayers,ArrayList<String> playerNames){
        this.noOfPlayers = noOfPlayers;
        this.deck = new Deck(true);
        this.playerNames = playerNames;
        this.playerTurn = 0;
        this.roundNumber = 1;

        for(int i = 0; i < noOfPlayers;i ++){
            players.add(new Player(playerNames.get(i),this));

        }
        dealHands(7);

//        for(Player player :players){
//            System.out.print(player.getPlayerName()+ ":");
//            player.printHand();
//        }



        topCard = deck.getCardQueue().pop();

//        while(!gameWon){
//            turnOver = false;
//            currentPlayer = players.get(playerTurn);
//            System.out.println(currentPlayer.getPlayerName() + "'s Turn:");
//
//
//
//
//
//
//
//            turnOver = true;
//            if(turnOver) {
//
//                playerTurn++;
//                playerTurn = (playerTurn) % noOfPlayers;
//                if(playerTurn == 0) roundNumber ++;
//            }
//        }
        currentPlayer = players.get(playerTurn);
        System.out.println(currentPlayer.getPlayerName() + "'s Turn:");
        currentPlayer.printHand();

        System.out.println("Top Card:");
        topCard.printCard();
        System.out.println("Moves:");
        currentPlayer.generateMoves();
        currentPlayer.printMoves();



    }


    private void dealHands(int startNumber){
        for(int i = 0; i < startNumber; i++){
            for(Player player: players){
                player.addToHand(deck,1);
            }
        }

    }
    public Card getTopCard(){
        return this.topCard;
    }

}
