/*implement card logic
 * DeckofCards is a collection of cards.
 *
 */
public class Card {



	//Rank and Suit of card.
	private int rank = 0;
	private int suit = 0;

	
    public Card(int r, int s){
    //Assign rank and suit.

    	rank = r;
    	suit = s;
    }
    
    //Getters and Setters for rank and suit.
    public int getRank(){
    	
    	return rank;
    }//getRank
    public int getSuit(){
    	
    	return suit;
    }//getSuit
    
    //Method to determine if rank is less
    
    public boolean rankIsLessThan(Card c){
    	boolean rankIsLess = false;
    	
    	if(rank < c.getRank()){
    		rankIsLess = true;
    	}//if
		return rankIsLess;
    }//rankIsLessThan
    
  

    public boolean rankIsMoreThan(Card c){
boolean rankIsMore = false;
    	
    	if(rank > c.getRank()){
    		rankIsMore = true;
    	}//if
		return rankIsMore;
    }//rankIsMore
    
   

    public boolean suitIsLessThan(Card c){
boolean suitIsLess = false;
    	
    	if(suit < c.getSuit()){
    		suitIsLess = true;
    	}//if
		return suitIsLess;
    
    }//suitIsLess
  

    public boolean suitIsMoreThan(Card c){
boolean suitIsMore = false;
    	
    	if(suit > c.getSuit()){
    		suitIsMore = true;
    	}//if
		return suitIsMore;
    }
//suitIsMore
    
    public String toString(Card c){
   
  //allows cards to be converted from int to strings 	
 String cardSuit = null;            //null allows game to function
 String cardRank;
    	
    	int cRank = getRank();
    	int cSuit = getSuit();  
    	
    	switch (cSuit){
    	case 0: 
    		cardSuit = "hearts";
    		break;
    		
    	case 1: 
    		cardSuit = "diamonds";
    		break;
    	case 2: 
    		cardSuit = "clubs";
    		break;
    	case 3: 
    		cardSuit = "spades";
    		break;
    		
    		
    	}//switch card suit
    	
    	switch (cRank){
    		
    	case 1:
    		cardRank = "ace";
    		break;
    	case 2:
    		cardRank = "2";
    		break;
    	case 3:
    		cardRank = "3";
    		break;
    	case 4:
    		cardRank = "4";
    		break;
    	case 5:
    		cardRank = "5";
    		break;
    	case 6:
    		cardRank = "6";
    		break;
    	case 7:
    		cardRank = "7";
    		break;
    	case 8:
    		cardRank = "8";
    		break;
    	case 9:
    		cardRank = "9";
    		break;
    	case 10:
    		cardRank = "10";
    		break;
    	case 11:
    		cardRank = "Jack";
    		break;
    	case 12:
    		cardRank = "Queen";
    		break;
    	case 13:
    		cardRank = "King";
    		break;
    		//switch rankd and suit
    		default: cardRank = "n/a";
    	}
    	//display concation
    	String cardString = cardRank + "_of_" + cardSuit;

    	//returns a card
    	return cardString;
	}//toString
    
	}//Card