import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main{
        
   /**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"♠", "♥", "♦", "♣"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
      
      
   public static void main(String[] args)
   {
     //beginningDeck is the Deck we start with.  When we deal, it gets split into two 
     //Decks for each player 
     Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
     beginningDeck.shuffle();
     //System.out.println(beginningDeck);

     //There are nine cards on the table using an array
     Card[] cardsOnTable = new Card[9];          
     
     for (int i = 0; i < 9; i++)
     {
       cardsOnTable[i] = beginningDeck.deal();
     }
     System.out.print(" ");
     for (int i = 0; i < 9; i++)
       System.out.print(i+"    ");
     System.out.println();
     for (int i = 0; i < 9; i++)
        System.out.print(cardsOnTable[i]+((i!=8)?", ":"\n"));
    Scanner in = new Scanner(System.in);
     //Make sure we get two or three entries
     int size = 0;
     String[] inAr;
     while ((size!=3)&&(size!=2))
     {
        System.out.print("Enter two or three cards to remove: ");
        inAr =  in.nextLine().split(" ");
        size = inAr.length;
     }
     System.out.println("got "+size+" index values to work with");

    for(int z = 0; z < size; z++){
      for (int i = 0; i < cardsOnTable.length; i++) {
        if(!cardsOnTable[i].rank().equals(inAr[z]) ){
          

        }
        else{
          
        } 
      }
    }
   }     
}