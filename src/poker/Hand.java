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
public class Hand {
    
    String stack;
    String[] stackArray;
    
    public Hand(String s)
    {
       stack = s;
       stackArray = stack.split("\\s*,\\s*"); 
    }
    
    public Hand(Deck deck, int size)
    {
        stack = deck.getCards(size);
        stackArray = stack.split("\\s*,\\s*");
    }
    
    public char [] sortBySuit()
    {
        char [] s = this.getSuit();
        char help;
        for (int i = 0; i < s.length; i++){
            int min_j = i;   

            for (int j = i+1 ; j < s.length; j++ )               
            {
               if ( s[j] < s[min_j] )
               {
                  min_j = j;  
               }
               
            }
            help = s[i];
            s[i] = s[min_j];
            s[min_j] = help; 
        }
        return s;
    }
    
    public char [] sortByFace()
    {
        char [] f = this.getFace();
        char help;
        for (int i = 0; i < f.length; i++){
            int min_j = i;   

            for (int j = i+1 ; j < f.length; j++ )               
            {
               if ( f[j] < f[min_j] )
               {
                  min_j = j;  
               }
            }
            help = f[i];
            f[i] = f[min_j];
            f[min_j] = help; 
        }
        return f;
    }
    
    public char [] getFace()
    {   
        char [] f = new char[stackArray.length];
        for(int i = 0; i < stackArray.length; i++)
        {
            f[i] = stackArray[i].charAt(0);
        }
        return f;
    }
    
    public char [] getSuit(){
        char [] s = new char[stackArray.length];
        for(int i = 0; i < stackArray.length; i++)
        {
            s[i] = stackArray[i].charAt(stackArray[i].length() - 1);
        }
        return s;
    }
    
    public boolean pair()
    {
        boolean a1, a2, a3, a4;
        char [] f = this.getFace();
        if ( f.length != 5 )
           return(false);

        if ( this.fourOfAKind() || this.fullHouse() || this.threeOfAKind() || this.twoPair() )
           return(false);        // The hand is not one pair (but better)       

        this.sortByFace();

        /* --------------------------------
           Checking: a a x y z
           -------------------------------- */                            
        a1 = f[0] == f[1] ;

        /* --------------------------------
           Checking: x a a y z
           -------------------------------- */
        a2 = f[1] == f[2] ;

        /* --------------------------------
           Checking: x y a a z
           -------------------------------- */
        a3 = f[2] == f[3] ;

        /* --------------------------------
           Checking: x y z a a
           -------------------------------- */
        a4 = f[3] == f[4] ;

        return( a1 || a2 || a3 || a4 );
    }
    
    public boolean twoPair()
    {
        boolean a1, a2, a3;
        char [] f = this.getFace();

        if ( f.length != 5 )
           return(false);

        if ( this.fourOfAKind() || this.fullHouse() || this.threeOfAKind() )
            return(false);        // The hand is not 2 pairs (but better)      

        f = this.sortByFace();

      /* --------------------------------
         Checking: a a  b b x
	 -------------------------------- */                       
      a1 = f[0] == f[1] &&
           f[2] == f[3] ;

      /* ------------------------------
         Checking: a a x  b b
	 ------------------------------ */
      a2 = f[0] == f[1] &&
           f[3] == f[4];

      /* ------------------------------
         Checking: x a a  b b
	 ------------------------------ */
      a3 = f[1] == f[2] &&
           f[3] == f[4] ;

      return( a1 || a2 || a3 );
    }
    
    public boolean threeOfAKind()
    {
        boolean a1, a2, a3;
        char [] f = this.getFace();
        if ( f.length != 5 )
           return(false);

        f = this.sortByFace();         // Sort by Face first

      /* ------------------------------------------------------
         Check for: x x x a b
	 ------------------------------------------------------- */    
      a1 = f[0] == f[1] &&
           f[1] == f[2] &&
	   f[3] != f[0] &&
	   f[4] != f[0] &&
	   f[3] != f[4] ;

      /* ------------------------------------------------------
         Check for: a x x x b
	 ------------------------------------------------------- */   
      a2 = f[1] == f[2] &&
           f[2] == f[3] &&
	   f[0] != f[1] &&
	   f[4] != f[1] &&
	   f[0] != f[4] ;

      /* ------------------------------------------------------
         Check for: a b x x x
	 ------------------------------------------------------- */   
      a3 = f[2] == f[3] &&
           f[3] == f[4] &&
	   f[0] != f[2] &&
	   f[1] != f[2] &&
	   f[0] != f[1] ;

      return( a1 || a2 || a3 );
    }
   
    public boolean fourOfAKind()
    {
        boolean a1, a2;
        char [] f = this.getFace();
        if ( f.length != 5 )
            return(false);

        f = this.sortByFace();         // Sort by Face first

      /* ------------------------------------------------------
         Check for: 4 cards of the same rank 
	            + higher ranked unmatched card 
	 ------------------------------------------------------- */     
      a1 = f[0] == f[1] &&
           f[1] == f[2] &&
           f[2] == f[3] ;


      /* ------------------------------------------------------
         Check for: lower ranked unmatched card 
	            + 4 cards of the same rank 
	 ------------------------------------------------------- */   
      a2 = f[1] == f[2] &&
           f[2] == f[3] &&
           f[3] == f[4] ;

      return( a1 || a2 );
    }
    
    public boolean fullHouse(){
        boolean a1, a2;
        
        char [] f = this.getFace();

        if ( stackArray.length != 5 )
           return(false);

        f = this.sortByFace();      // Sort by Face first

        /*------------------------------------------------------
           Check for: x x x y y
	 *-------------------------------------------------------*/  
        a1 = f[0] == f[1] &&
             f[1] == f[2] &&
             f[3] == f[4];

        /*-------------------------------------------------------
           Check for: x x y y y
	 *-------------------------------------------------------*/ 
        a2 = f[0] == f[1] &&
             f[2] == f[3] &&
             f[3] == f[4];

      return( a1 || a2 );
        
    }
    
    public boolean straight()
    {
        int i, testFace;
        char [] f;
        if ( stackArray.length != 5 )
            return(false);

        f = this.sortByFace();      // Sort the poker hand by the face of each card      
        if ( f[4] == 13 )
        {
           boolean a = f[0] == 2 && f[1] == 3 &&
                       f[2] == 4 && f[3] == 5 ;
           boolean b = f[0] == 10 && f[1] == 11 &&        
                       f[2] == 12 && f[3] == 13 ;

           return ( a || b );
        }
        else
        {
           testFace = f[0] + 1;

           for ( i = 1; i < 5; i++ )
           {
              if ( f[i] != testFace )
                 return(false);        // Straight failed...

              testFace++;   // Next card in hand
           }

           return(true);        // Straight found !
        }
    }
    
    public boolean flush()
    {
        if ( stackArray.length != 5 )
           return (false);   

        char [] s = this.sortBySuit(); // Sort the cards by the suit values
        
        return( s[0] == s[4] );   // All cards has same suit
    } 
}
