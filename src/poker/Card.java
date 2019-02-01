/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in thimport java.util.*;e editor.
 */
package poker;
import java.util.*;

/**
 *
 * @author hp
 */
public class Card implements ICard {
    
    private static final String[] SUITS = {
        "H", "D", "C", "S"
    };
    private static final String[] RANKS = {
        "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"
    };
    
    private String card = "";
    
    /**
     * Default constructor
     */
    public Card()
    {
        Random random = new Random();
        this.setCard(this.getCard(random.nextInt(13), random.nextInt(3)));
    }
    
    /**
     * Override constructor
     * @param rank
     * @param suit 
     */
    public Card(int rank, int suit){
        this.setCard(this.getCard(rank, suit));
    }
    
    /**
     * Gets the Card
     * @param rank
     * @param suit
     * @return 
     */
    public String getCard(int rank, int suit)
    {
        return Card.RANKS[rank] + Card.SUITS[suit];
    }
    
    /**
     * Sets the Card
     * @param card 
     */
    public void setCard(String card)
    {
        this.card = card;      
    }
    
    /**
     * Converts the Card to String
     * @return String
     */
    public String toString()
    {
        return this.card;
    }
    
    /**
     * Prints the card
     */
    public void printCard()
    {
       System.out.print(this.toString() + " ");         
    }
    
}
