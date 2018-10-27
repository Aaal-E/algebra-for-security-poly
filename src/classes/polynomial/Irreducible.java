package classes.polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import classes.Polynomial;

public class Irreducible {
    Euclid euclid = new Euclid();
    Adder adder = new Adder();

    /*
      Input: polynomial f in Fq[X] of degree n > 1
    Output: �true� if f is irreducible, �else�
    Step 1: t = 1
    Step 2: while gcd(f, X^q^t - X) = 1 do t = t + 1
    Step 3: if t = n then output �true� else output �false�
     */
    public boolean isIrreducible(List<Integer> f, int mod) {
        // If degree <= 1, return irreducible
        if (Polynomial.degree(f) <= 1) {
            return true;
        }

        int t = 1;
        List<Integer> X = Arrays.asList(0, 1);

        // (while loop breaks when gcd != 1)
        while (true) {
            // Construct polynomial X^{mod^t}
            int degree = (int) Math.pow(mod, t);
            List<Integer> poly = new ArrayList<>(degree + 1);
            poly.addAll(Collections.nCopies(degree, 0));
            poly.add(1);

            // Subtract X from X^{q^t}
            poly = adder.subtract(poly, X, mod);

            // Take gcd of f and X^{q^t} - X
            List<Integer> gcd = euclid.euclid(f, poly, mod).d;

            // Check if gcd == 1, if not, break
            if (!gcd.equals(Polynomial.ONE)) {
                break;
            }

            // Else if gcd==1, increment t
            t++;
        }

        // Return t == deg(f)
        return t == Polynomial.degree(f);
    }


    public List<Integer> findIrreducible(int deg, int mod) {
        List<Integer> result = Polynomial.random(deg, mod);
        if (isIrreducible(result, mod))
            return result;
        else
            return findIrreducible(deg, mod);
    }
}
