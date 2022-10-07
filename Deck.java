/**
 * This class is for the deck used in the game
 * @author  Ying Jiang, Justin Lee, Emily Klapper
 * @since 2021-2-3
 */
import java.util.ArrayList;
public class Deck 
{
  /**
   * The cards in the deck
   */
  private static ArrayList <Card> deck= new ArrayList<Card>();

  /**
   * A list of possible suits of the cards
   */
  String[] SUITS = {"♠", "♥", "♦", "♣"};
        
  /**
   * A list of possible ranks for the cards
   */
  String[] RANKS = 	{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

  /**
   * The deck constructor
   */
  public Deck()
  { deck.removeAll(deck);
    for (int i = 0; i< 4; i++) {
      for (int j = 0; j < 13; j++) {
        deck.add(new Card(SUITS[i],RANKS[j]));
      }
    }
  }
  public Deck(ArrayList<Card> Array){
  deck = Array;
  }

  /**
   * A method that will add a card to any exsisting deck
   */ 
  public void addToDeck(Card a){
  deck.add(a);
  }
  
  /**
   * Returns the deck of cards
   */
 public ArrayList<Card> Array(){
   return deck;}
   
  /**
   * Shuffles the cards in the deck 30 times.
   */
 public static void shuffle() {
    Card temp;
    for(int i=0;i<30;i++)
    {
      int first = (int)(Math.random() * (deck.size()));
      int second = (int)(Math.random() * (deck.size()));
      temp = deck.get(first);
      deck.set(first, deck.get(second));
      deck.set(second, temp);
    }
  }

  /**
   * Deals a card from the deck, will return null if the deck is empty
   */
  public Card deal() {
		if (isEmpty()) {
			return null;
		}
		Card c = deck.remove(deck.size()-1);
		return c;
	}

  /**
   * Will return whether the deck is empty or not
   */
  public boolean isEmpty() {
		return deck.size() == 0;
	}
  
  /**
   * Returns the size of the deck
   */
   public int getSize(){
   return deck.size();
  }
}