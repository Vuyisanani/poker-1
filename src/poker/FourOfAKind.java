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
public class FourOfAKind extends Hand implements IHand {

    public FourOfAKind(String s) {
        super(s);
    }

    @Override
    public boolean drawHand() {
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
}