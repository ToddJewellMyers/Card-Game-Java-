import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public void add(Card card) {
		hand.add(card);
	}
	
	public Card removeCard(Card card) {
		Card returnCard = card;
		hand.remove(card);
		return returnCard;
	}
	
	public Card removeAtIndex(int index) {
		Card returnCard = hand.get(index);
		hand.remove(index);
		return returnCard;
	}
	
	public int getSize() {
		return hand.size();
	}
	
	public int getValueAtIndex(int index) {
		int value = hand.get(index).getValue();
		return value;
	}
	
	public boolean isWinningHand() {
		
		int value = 0;
		int counter = 0;
		
		value = hand.get(0).getValue();
		
		for (int x = 0; x < hand.size(); x++) { 		      
			if(hand.get(x).getValue() == value) {
				counter++;
			}
	    }
		
		if(counter == 4) {
			return true;
		}else {
			return false;
		}
	}
	
	//Method for CPU hand for determining move to make
	public int determineMove(int value) {
		
		int counter = 0;
		
		for(int x = 0; x < getSize(); x++) {
			if(getValueAtIndex(x) == value) {
				counter++;
			}
		}
		
		if(counter > 0) {
			return 1;
		}else {
			return 2;
		}
	}
	
	//Method for CPU hand to determine what card to discard
	public Card discard() {
		
		Card returnCard = null;
		
		for(int x = 0; x < hand.size(); x++) {
			int value = hand.get(x).getValue();
			int counter = 0;
			for(int y = 0; y < hand.size(); y++) {
				if(value == hand.get(y).getValue()) {
					counter++;
				}
			}
			//Card with no pairs was found
			if (counter <= 1) {
				returnCard = hand.get(x);
				hand.remove(x);
			}
		}
		//No card without a pair was found, removing first card
		if(returnCard == null) {
			returnCard = hand.get(0);
			hand.remove(0);
		}
		return returnCard;
	}
	
	public String toString() {
		
		String handString = "";
		
		for (int counter = 0; counter < hand.size(); counter++) { 		      
			handString = handString.concat("\t" + hand.get(counter).toString());
	        handString = handString.concat("\n");
	    }  
		
		return handString;
	}
}
