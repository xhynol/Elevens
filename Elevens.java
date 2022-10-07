/**
 * 
 * @author  Justin Lee, Ying Jiang, Emily Klapper
 * @since 2021-2-3
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Array; 

public class Elevens{
Deck b = new Deck();
Card[] cardsOnTable = new Card[9];
boolean moves = true;
boolean nocard = false;

  /**
   * Initializes and then runs the game
   */
  public Elevens(){
    startGame();
    onTable();  
  }

  /**
   * Initializes the game
   */
  public void startGame(){
    Deck a = new Deck();
    a.shuffle();
    b = a;
    for (int i = 0; i < 9; i++)
     {
       cardsOnTable[i] = b.deal();}
       System.out.print(" ");
  
  }

  /**
   * Runs the game
   */
  public void onTable()
  {
    Scanner in = new Scanner(System.in);
    moves = outOfMoves();
    while((moves == true)||(nocard = false))
    {
      int size = 0;
      String[] inAr = new String [0];
      String inEr = "";
      int cardsInTable = 0;    
      while ((size!=3)&&(size!=2))
      {
        while(cardsInTable!=3&&cardsInTable!=2)
        {
          for (int i = 0; i < 9; i++)
          {
            System.out.print(cardsOnTable[i]+((i!=8)?", ":"\n"));
          }  
          System.out.print("Enter two or three cards on the table to remove: ");
          inEr = in.nextLine();
          inAr =  inEr.split(" ");
          size = inAr.length; 
          boolean allCardsOnTable=false; 
          for(int z = 0; z< size; z++)
          {
            for (int i = 0; i < cardsOnTable.length; i++) 
            {
              if(inAr[z].equals(cardsOnTable[i].getRank()))
              {
                cardsInTable++;
              }
              if(cardsInTable==size)
              {
                allCardsOnTable=true;
                break;
              }
            }
          }
          if(allCardsOnTable==false)
          {
            System.out.println("One of the cards entered is not on the table");
          }
        }    
        int sum = 0;
        if(size == 2){
        for(int i = 0; i < 2;i++)
        {
          sum+= cardsOnTable[findIndexCard(cardsOnTable,inAr[i])].getValue();
        }
        if(sum == 11)
        {
          for(int x = 0; x < 2; x++)
          {
            for (int i = 0; i < cardsOnTable.length; i++) 
            {
              if(inAr[x].equals(cardsOnTable[i].getRank()))
                {
                  Array.set(cardsOnTable,i,b.deal());
                  break;
                }
            }
          }
          System.out.println("removed " +inEr);
        }
        else
        {
          System.out.println("That doesn't add up to 11");}
        }
        if(size ==3)
        {
          int numberOfKInTable=0;
          int numberOfQInTable=0;
          int numberOfJInTable=0;
          for(Card cardsOnTheTable:cardsOnTable)
          {
            if (cardsOnTheTable.getRank().equals("K"))
            {
              numberOfKInTable+=1;
            }
            if(cardsOnTheTable.getRank().equals("Q"))
            {
              numberOfQInTable+=1;
            }
            if(cardsOnTheTable.getRank().equals("J"))
            {
              numberOfJInTable+=1;
            }
          }
          if(numberOfJInTable>0&&numberOfQInTable>0&&numberOfKInTable>0)
          {
            int kCount=0;
            int qCount=0;
            int jCount=0;
            for(int i=0;i<cardsOnTable.length;i++)
            { 
              if(kCount==0&&(cardsOnTable[i].getRank().indexOf("K"))>-1)
              {
                Array.set(cardsOnTable,i,b.deal());
                kCount++;
              }
              if(qCount==0&&(cardsOnTable[i].getRank().indexOf("Q"))>-1)
              {
                Array.set(cardsOnTable,i,b.deal());
                qCount++;
              }
              if(jCount==0&&(cardsOnTable[i].getRank().indexOf("J"))>-1)
              {
                Array.set(cardsOnTable,i,b.deal());
                jCount++;
              }
            }
            System.out.println("removed " +inEr);
          }
          else
          {
            System.out.println("you can only remove K Q J together");
          }
        }
      }
      moves = outOfMoves();
      nocard = noCards();
    }
    if(moves == false)
    {
      for (int i = 0; i < 9; i++)
      {
        System.out.print(cardsOnTable[i]+((i!=8)?", ":"\n"));}
        System.out.println("Game Over No possible moves");
    }
    if(nocard == true)
    {
      System.out.println("good game you won");
    }
  }
  
  /**
   * check if there are card on table and in deck
   */
  public boolean noCards(){
    boolean deckEmpty = b.isEmpty();
    boolean cardsOnTableEmpty = true;
    for(int i = 0; i < 9; i++){
      if(!(cardsOnTable[i].getRank().equals("null"))){
        cardsOnTableEmpty = false;
      }
    }
    return (deckEmpty && cardsOnTableEmpty);
  }

  /**
   * Checks if there are moves left
   */
  public boolean outOfMoves(){ 
    int o = 0;
    int f = 0;
    for(int i =0; i < 9; i++){
      o = cardsOnTable[i].getValue();
      for(int y =0; y < 9; y++){
        if((cardsOnTable[y])==null){
          (cardsOnTable[y]) = new Card("null","null");
        }
        f = (cardsOnTable[y]).getValue();
        
        if((o + f) == 11){
          return true;
        }
      }
    }
    if( (findIndexCard(cardsOnTable,"K") > -1)&&(findIndexCard(cardsOnTable,"Q")>-1)&&(findIndexCard(cardsOnTable,"J")>-1)){
      return true;
    }
    return false;
  }
/**
   * Find index of String in Card array
   */
 public int findIndexCard(Card arr[], String a) 
  {
    int len = arr.length; 
    int i = 0;  
    while (i < len) 
    { 
      if (arr[i].getRank().equals(a)) 
      { 
        return i; 
      } 
      else 
      { 
        i = i + 1; 
      } 
    } 
  return -1; 
  }
}
