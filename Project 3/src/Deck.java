import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
		int valueCount = 0;
		int suitCount = 0;
		Card card;
		
		while(valueCount <= 12) {
			while(suitCount <= 3) {
				card = new Card(valueCount+1,suitCount+1);
				deck.add(card);
				suitCount++;
			}
			suitCount = 0;
			valueCount++;
		}
		
		Collections.shuffle(deck);
	}
	
	public Card removeAtIndex(int index) {
		Card returnCard = deck.get(index);
		deck.remove(index);
		return returnCard;
	}
	
	public Card getAtIndex(int index) {
		Card returnCard = deck.get(index);
		return returnCard;
	}
	
	public int getSize() {
		return deck.size();
	}
	
}
