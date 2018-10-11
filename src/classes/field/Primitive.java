package classes.field;

import java.util.List;

import classes.Field;
import classes.Polynomial;

public class Primitive {
    /*Input: Field F of order q and prime divisors p1, . . . pk of q - 1 and a in F
    Output: �true� if a is primitive, �false� otherwise
    Step 1: i = 1
    Step 2: while a^(q-1/pi) != 1 and i <= n do
    i = i + 1
    Step 3: if i <= n output �false� else �true�*/
    
    Arithmetic calc = new Arithmetic();
    
    public boolean isPrimitive(List<Integer> a, /*whichever way we want to input this,*/ List<Integer> characteristic, int mod) {
        
    	
    	int order = (int) (Math.pow(mod, characteristic.size()) );
    	int primeDivisors = 0;
        int divisorCount = 0;
        
    	for ( int j = 1; j <= (order-1)/2; j++) {
        	divisorCount = 0;
        	
        	for ( int d = 1; d <= j/2; d++)
        		if( j % d == 0)
        		  divisorCount ++;
        	if(divisorCount == 2)
        		primeDivisors ++;
        }
        	//getting  how many prime divisors we have to divide by
    	
    	int i = 1;
        while ( calc.pow(a, a.size()-2, characteristic, mod).equals(Polynomial.ONE) && (i<=primeDivisors) /*what is this n???*/){
            i++;
        }
        return i>primeDivisors;
    }
    
    public List<Integer> findPrimitive(int degree, List<Integer> characteristic, int mod){
        List<Integer> a = Polynomial.random(degree, mod);
        Field.reduce(a, characteristic, mod);
        while(!isPrimitive(a, characteristic, mod))
            a = Polynomial.random(degree, mod);
            Field.reduce(a, characteristic, mod);
        return a;
    }
    //if 
}
