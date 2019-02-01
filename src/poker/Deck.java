/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
import java.util.*;

/**
 *
 * @author hp
 */
public class Deck implements IDeck {
    private static final int SUIT = 4;
    private static final int FACE = 13;
    Card [][] card = new Card[FACE][SUIT];
    
    /**
     * Default constructor
     */
    Deck() {
        initialize();
    }

    /**
     * Initialize the deck
     */
    public void initialize()
    {
        for (int s = 0; s < Deck.SUIT; s++)
        {
            for (int f = 0; f < Deck.FACE; f++)
            {
                card[f][s] = new Card(f, s);
            }
        }
    }
    
    /**
     * Shuffle the cards
     */
    @Override
    public void shuffle() {
        for (int s = 0; s < Deck.SUIT; s++)
        {
            for (int f = 0; f < Deck.FACE; f++)
            {
                card[f][s] = new Card(f, s);
                Random random = new Random();
                int m = random.nextInt(f + 1);
                int n = random.nextInt(s + 1);

                Card temp = card[f][s];
                card[f][s] = card[m][n];
                card[m][n] = temp;
            }
        }
    }
    
    /**
     * Deal the cards
     * @param size
     * @return Card []
     */
    @Override
    public Card [] dealCards(int size) 
    {
        Card [] deal = new Card[size];
        int i = 0;
        this.shuffle();
        for (int s = 0; s < Deck.SUIT; s++)
        {
            for (int f = 0; f < Deck.FACE; f++)
            {
                if (i > size - 1)
                {
                    break;
                } else {
                    deal[i] = card[f][s];
                    ++i;
                }
            }
        }
        return deal;
    }
    
    /**
     * Gets the cards
     * @param size
     * @return String
     */
    public String getCards(int size)
    {
        return Arrays.toString(this.dealCards(size));
    }
    
    /**
     * Prints the cards
     * @param size 
     */
    public void printCards(int size)
    {
        System.out.println(this.getCards(size));
    }
    
    /**
     * Prints the deck
     */
    public void printDeck()
    {
        for (int s = 0; s < Deck.SUIT; s++)
        {
            for (int f = 0; f < Deck.FACE; f++)
            {
                this.card[f][s].printCard();
            }
        }
        System.out.println("");
    }

    /**
     * Gets the size of the deck
     * @return 
     */
    public int sizeOf(){
        return Deck.FACE * Deck.SUIT;
    }
    
}
