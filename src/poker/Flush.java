/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author hp
 */
public class Flush extends Hand implements IHand {
  
    
    public Flush(String s)
    {
        super(s);
    }
    
    public boolean drawHand()
    {
        if ( stackArray.length != 5 )
           return (false);   

        char [] s = this.sortBySuit(); // Sort the cards by the suit values
        
        return( s[0] == s[4] );   // All cards has same suit
    }
}
