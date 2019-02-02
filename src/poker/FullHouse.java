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
public class FullHouse extends Hand implements IHand {

    public FullHouse(String s) {
        super(s);
    }

    @Override
    public boolean drawHand() {
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
    
}
