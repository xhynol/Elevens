/**
 * This class is for each individual card in the decks 
 * @author  Ying Jiang, Justin Lee, Emily Klapper
 * @since 2021-2-3
 */
public class Card
{
  /**
   * the suit of the card 
   */
  private String suit;
  /**
   *the rank of the card (the number you would see on the card)
   */
  private String rank;

  /** 
   * Constructor for the card class
   * @param suit the suit of the card
   * @param rank the rank of the card 
   */
  public Card(String suit,String rank)
  {
    this.suit=suit;
    this.rank=rank;
  }

  /**
   * Getter method, returns the rank
   */
  public String getRank()
  {
    return rank;
  }
  /**
   * Getter method, returns the suit
   */
  public String getSuit()
  {
    return suit;
  }

  /**
   * toString method
   */
  public String toString()
  {
    return rank + " " + suit; 
  }

  /**
   * Assigns a value to the card based on the rank
   */
  public int getValue(){
    int n = 0;
    if(this.rank.equals("A")){
      n = 1;}
    if(this.rank.equals("2")){
      n = 2;}
    if(this.rank.equals("3")){
      n = 3;}
    if(this.rank.equals("4")){
      n = 4;}
    if(this.rank.equals("5")){
      n = 5;}
    if(this.rank.equals("6")){
      n = 6;}
    if(this.rank.equals("7")){
      n = 7;}
    if(this.rank.equals("8")){
      n = 8;}
    if(this.rank.equals("9")){
      n = 9;}
    if(this.rank.equals("10")){
      n = 10;}
    if(this.rank.equals("J")){
      n = 0;}
    if(this.rank.equals("Q")){
      n = 0;}
    if(this.rank.equals("K")){
      n = 0;}
   
    return n;
  }

}

