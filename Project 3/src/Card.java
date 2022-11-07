
public class Card {

	private int value;
	private int suit;
	
	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public String toString() {
		String card = "";
		
		//Appending value to string
		if(value == 1) {
			card = card.concat("Ace of ");
		}
		if(value >= 2 && value <= 10) {
			card = card.concat(value + " of ");
		}
		if(value == 11) {
			card = card.concat("Jack of ");
		}
		if(value == 12) {
			card = card.concat("Queen of ");
		}
		if(value == 13) {
			card = card.concat("King of ");
		}
		
		//Appending suit to string
		if(suit == 1) {
			card = card.concat("Hearts");
		}
		if(suit == 2) {
			card = card.concat("Diamonds");
		}
		if(suit == 3) {
			card = card.concat("Spades");
		}
		if(suit == 4) {
			card = card.concat("Clubs");
		}
		
		return card;
	}
	
}
