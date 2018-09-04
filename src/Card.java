
final public class Card {

    public enum Suit {
        CLUBS,DIAMONDS,HEARTS,SPADES
    }
    public enum Colour {
        BLACK,RED
    }
    private int rank;
    private Suit suit;
    private Colour colour;


    public Card(int rank, Suit suit){
        this.suit = suit;
        this.rank = rank;
        setColour(suit);


    }

    private void setColour(Suit suit){
        switch (suit) {
            case CLUBS: case SPADES:
                this.colour = Colour.BLACK;
                break;
            case DIAMONDS: case HEARTS:
                this.colour = Colour.RED;
                break;

        }
        return;

    }
    public void printCard(){
        String consoleName = "";
        if( rank<=10 && rank>= 2 ){
             consoleName = Integer.toString(rank);
        }
        else if(rank == 11){
            consoleName = "J";
        }
        else if(rank == 12){
            consoleName = "Q";
        }
        else if(rank == 13){
            consoleName = "K";
        }
        else if(rank == 0){
            consoleName = "Joker";
        }
        else if(rank == 1){
            consoleName = "A";
        }


        switch(this.suit){
            case SPADES:
                consoleName = consoleName.concat("♠");
                break;
            case CLUBS:
                consoleName = consoleName.concat("♣");
                break;
            case HEARTS:
                consoleName = consoleName.concat("♥");
                break;
            case DIAMONDS:
                consoleName = consoleName.concat("♦");
                break;
        }
        if(this.colour == colour.BLACK){

            System.out.println("\033[30m" + consoleName);
        }else{
            System.out.println("\033[31m" + consoleName);
        }



    }
    public Suit getSuit(){
        return this.suit;
    }
    public int getRank(){
        return this.rank;
    }


    public Colour getColour() {
        return this.colour;
    }


}
