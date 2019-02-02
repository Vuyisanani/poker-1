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
public class Game {
    
    static int CARDS = 5;
    
    public void autoPlay()
    {
        Deck deck = new Deck();
        deck.printCards(CARDS);
        deck.printDeck();
        
        // Using Procedural Approach
        Hand player1 = new Hand(deck, CARDS);
        
        if (player1.flush())
        {
            System.out.println("Flush");
        }
        
        if (player1.straight())
        {
            System.out.println("Straight");
        }
        
        if (player1.pair())
        {
            System.out.println("Pairs");
        }
        
        if (player1.twoPair())
        {
            System.out.println("Two Pair");
        }
        
        if (player1.threeOfAKind())
        {
            System.out.println("Three of a Kind");
        }
        
        if (player1.fourOfAKind())
        {
            System.out.println("Four of a Kind");
        }
        
        if (player1.fullHouse())
        {
            System.out.println("Full House");
        }
    }
    
    public void manualPlay()
    {
        // Using Inheritance and SOLID principles
        System.out.print("Manually set the hand of cards: ");
 
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        Flush flush = new Flush(in);
        
        if (flush.drawHand())
        {
            System.out.println("Flush");
        }
        
        Straight straight = new Straight(in);
        if (straight.drawHand())
        {
            System.out.println("Straight");
        }
        
        Pair pair = new Pair(in);
        if (pair.drawHand())
        {
            System.out.println("Pair");
        }
        
        TwoPair twoPair = new TwoPair(in);
        if (twoPair.drawHand())
        {
            System.out.println("Two Pair");
        }
        
        ThreeOfAKind threeOfAKind = new ThreeOfAKind(in);
        if (threeOfAKind.drawHand())
        {
            System.out.println("Three of a Kind");
        }
        
        FourOfAKind fourOfAKind = new FourOfAKind(in);
        if (fourOfAKind.drawHand())
        {
            System.out.println("Four of a Kind");
        }
        
        FullHouse fullHouse = new FullHouse(in);
        if (fullHouse.drawHand())
        {
            System.out.println("Full House");
        }
    }
}
