package classes;
import java.util.*;

public class Operator {
	
	List <Integer> quotient = new ArrayList <Integer>();
	List <Integer> remainder = new ArrayList <Integer>();
	
	List <Integer> longDivision (List <Integer> x, List <Integer> y) {
		
		boolean ok = false; // Assume y != 0.
		int m = x.size(); //the length of the first number
		int n = y.size();  //the length of the second number
		
		//clearing the previous quotient and remainder
		quotient.clear();
		remainder.clear();
		
		//checking that the second number is nonzero
		for (int i = 0 ; i < n; i++) 
			if(y.get(i) != 0)
				ok = true;
		
		//if the length of the second number is greater than the first one, then...
		if ( n < m && ok ) {
			quotient.add(0);
			List <Integer> remainder = new ArrayList <Integer> (x);		
			return null; 
		}
		else
			if ( ok) {
				
				
				
			
	/*List <Integer> getRemainder () {
		return quotient;
		
	}
	
	List */ //TODO
			
			
			
			
		}
			
		
		
		
	}

}
