package classes.polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Polynomial;

public class Irreducible {
    Euclid euclid = new Euclid();
    Adder adder = new Adder();
    /*
      Input: polynomial f in Fq[X] of degree n > 1
    Output: ‘true’ if f is irreducible, ‘else’
    Step 1: t = 1
    Step 2: while gcd(f, X^q^t - X) = 1 do t = t + 1
    Step 3: if t = n then output ‘true’ else output ‘false’
     */
    public boolean isIrreducible(List<Integer> f, int mod) {
        int t = 1;
        List<Integer> temp = new ArrayList<>();
        List<Integer> X = new ArrayList<>(Arrays.asList(1,0)); 
        for(int i = 0; i<mod;i++)
            temp.add(0);
        
        temp = adder.subtract(temp, X, mod);
        while (euclid.euclid(f, temp, mod).d != Polynomial.ONE) {
            t = t+1;
            temp.clear();
            for(int i = 0; i<Math.pow(mod, t); i++)
                temp.add(0);
            temp = adder.subtract(temp, X, mod);      
        }
        return t == f.size()-1;
    }


    public List<Integer> findIrreducible(int deg, int mod) {

        return null;
    }
}
