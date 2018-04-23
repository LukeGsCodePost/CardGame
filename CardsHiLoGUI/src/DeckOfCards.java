
public class DeckOfCards   
{ 
    private Card[] deck=new Card[52];
    private int used;
    
    public DeckOfCards() {
        // Creates an unshuffled deck with card objects.
 	 
    deck = new Card[52];
    int cardCt = 0; // How many cards have been created so far.
    for ( int suit = 0; suit <= 3; suit++ ) {    //for suit
       for ( int rank = 1; rank <= 13; rank++ ) {  //for rank
          deck[cardCt] = new Card(rank,suit);  //add each card to deck
          cardCt++;
       }
    }
    used = 0;
 }
 
	public static int getRank(){   //rank getter 
		
		int rank = 1;
		return rank;
		
	};
	public static int getSuit(){   //suit getter
		int suit = 1;
		return suit;
		
	};


	  public void shuffle() {
          // shuffles the created deck in a random order 
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        used = 0;
    }
    
 
      public Card  deal() {   //deals top card
      if (used == 52)
         shuffle();
      used++;
      return deck[used - 1];  //returns dealt card
   
  }
      public void isEmpty(){    //is empty method when the deck is empty it prints to the console
    	  if (used == 52)
    		
    	        System.out.println("is empty, new game started, the deck is shuffled");
      }
      
    
      
   
      }
