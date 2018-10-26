package classes.polynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Polynomial;



public class Divider {
    Adder adder = new Adder();
    Multiplier mul = new Multiplier();
    
    public int EEA (int a, int b) {
    	
    	int aux;
    	
    	// b = the mod ( so finding as + bt = 1, where t is the mult inverse mod "mod")
    	
    	if (a < b) {
    		
    		aux = a;
    	    a = b;
    	    b = aux;
    	}    
    
    	int r = a, r1 = b, s = 1, s1 = 0, t = 0, t1 = 1, r2, d, q;
    	
    	while ( r1!= 0) {
    		q = Math.floorDiv(r, r1);
    		r2 = r % r1;
    		
    		r = r1;
    		s = s1;
    		t = t1;
    		r1 = r2;
    		s1 = s - s1*q;
    		t1 = t - t1*q;	
    	}
    	
    	d = r;
    	
    	if (t < 0) {
    		
    		
    	}
    	
    	//give the multiplicative inverse of a, which is t, since a >=b.
    	return t % a;
    }
    
    public Result divide(List<Integer> f, List<Integer> g, int mod) {
        // For safety make unmodifiable
        f = Collections.unmodifiableList(f);
        g = Collections.unmodifiableList(g);


        List<Integer> q = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(f);
        List<Integer> temp2 = new ArrayList<>();
        // Do algorithm
        if(g.equals(Polynomial.ZERO))
            return null;
        for(int i = 0; i<=f.size()-g.size(); i++) {
            if(temp.size()<f.size()-i)
                q.add(0,0);
            else
                q.add(0, temp.get(temp.size()-1)/g.get(g.size()-1));
            
            temp2.clear();
            for(int j = 0; j<(temp.size()-g.size()); j++)
                temp2.add(0);
            temp2.add(q.get(0));
            temp = adder.subtract(temp, mul.multiply(temp2, g, mod), mod);
            
        }
        r = adder.subtract(f, mul.multiply(q, g, mod), mod);
        q = Polynomial.reduce(q, mod);
        r = Polynomial.reduce(r, mod);
        // Return result
        return new Result(q, r);
    }

    /**
     * Stores the result for the divide operation.
     */
    public class Result {
        public final List<Integer> q;
        public final List<Integer> r;

        public Result(List<Integer> q, List<Integer> r) {
            this.q = q;
            this.r = r;
        }

        @Override
        public String toString() {
            return q.toString() + " " + r.toString();
        }
    }
}
