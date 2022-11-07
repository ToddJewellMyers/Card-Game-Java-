import java.util.ArrayList;
import java.util.Scanner;

public class Project3 {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		ArrayList<Card> discardPile = new ArrayList<Card>();
		Hand player = new Hand();
		Hand cpu = new Hand();
		Scanner in = new Scanner(System.in);
		
		//Deal initial 4 cards
		for(int x = 0; x <= 3; x++) {
			player.add(deck.removeAtIndex(0));
			cpu.add(deck.removeAtIndex(0));
		}
		
		//Game loops while no players has a winning hand
		while(player.isWinningHand() == false && cpu.isWinningHand() == false) {
		
		//Players turn
			System.out.println("Your cards are: ");
			System.out.println(player.toString());
			//Discard pile is empty
			if(discardPile.size() == 0) {
				System.out.println("The discard pile is currently empty -- you must draw a card");
				System.out.println("You drew the " + deck.getAtIndex(0));
				player.add(deck.removeAtIndex(0));
				System.out.println("Now your cards are: ");
				System.out.println(player.toString());
				System.out.println("Which one do you want to discard? (1-5) ");
				int discardChoice = in.nextInt();
				discardPile.add(player.removeAtIndex(discardChoice-1));
			}
			//Discard pile is not empty
			else {
				int discardSize = discardPile.size();
				int move;
				System.out.println("The top card in the discard pile is the " + discardPile.get(discardSize-1));
				System.out.println("Do you want to pick up the " + discardPile.get(discardSize-1) + " (1) or draw a card (2)?");
				move = in.nextInt();
				
				//Player chose the discard pile
				if(move == 1) {
					player.add(discardPile.remove(discardPile.size()-1));
					System.out.println("Now your cards are: ");
					System.out.println(player.toString());
					System.out.println("Which one do you want to discard? (1-5) ");
					int discardChoice = in.nextInt();
					discardPile.add(player.removeAtIndex(discardChoice-1));
				}
				//Player chose to draw
				if(move == 2) {
					System.out.println("You drew the " + deck.getAtIndex(0));
					player.add(deck.removeAtIndex(0));
					System.out.println("Now your cards are: ");
					System.out.println(player.toString());
					System.out.println("Which one do you want to discard? (1-5) ");
					int discardChoice = in.nextInt();
					discardPile.add(player.removeAtIndex(discardChoice-1));
				}
			}
			
			//Check if player has won after their turn
			if(player.isWinningHand() == true) {
				System.out.println("Player Wins!");
				break;
			}
			
			//Check if deck is empty
			if(deck.getSize() == 0) {
				System.out.println("It's a draw!");
				break;
			}
			
		//CPU turn
			int discardvalue = discardPile.get(discardPile.size()-1).getValue();
			int cpumove = cpu.determineMove(discardvalue);
			
			//CPU chooses the discard pile
			if(cpumove == 1) {
				System.out.println("I will pick up the " + discardPile.get(discardPile.size()-1).toString());
				cpu.add(discardPile.remove(discardPile.size()-1));
				Card tempcard = cpu.discard();
				System.out.println("I will discard the " + tempcard.toString());
				discardPile.add(tempcard);
			}
			//CPU chooses to draw
			else {
				System.out.println("I will draw a new card");
				cpu.add(deck.removeAtIndex(0));
				Card tempcard = cpu.discard();
				System.out.println("I will discard the " + tempcard.toString());
				discardPile.add(tempcard);
			}
			
			//Check if CPU has won after their turn
			if(cpu.isWinningHand() == true) {
				System.out.println("I Win!");
				break;
			}
			
			//Check if deck is empty
			if(deck.getSize() == 0) {
				System.out.println("It's a draw!");
				break;
			}
		}
		
		in.close();
		
	}

}
