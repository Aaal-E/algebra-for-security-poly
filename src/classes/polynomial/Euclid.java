package classes.polynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Polynomial;

public class Euclid {

    /**
     * Extended Euclidian Algorithm for polynomials.
     * <p>
     * Source: Hans Cuypers, Hans Sterk, Rob Eggermont, Algebra for Security Algorithm 1.2.11
     */
    public Result euclid(List<Integer> f, List<Integer> g, int mod) {
        // Reduce f and g (this will also copy)!
        f = Polynomial.reduce(f, mod);
        g = Polynomial.reduce(g, mod);

        if (Polynomial.isZero(f) && Polynomial.isZero(g)) {
            return null;
        }


        List<Integer> x = Polynomial.ONE;
        List<Integer> y = Polynomial.ZERO;
        List<Integer> u = Polynomial.ZERO;
        List<Integer> v = Polynomial.ONE;

        Divider divider = new Divider();
        Adder adder = new Adder();
        Multiplier multiplier = new Multiplier();

        // Do algorithm
        while (!Polynomial.isZero(g)) {
            List<Integer> q, xP, yP;

            Divider.Result temp = divider.divide(f, g, mod);

            q = temp.q;
            f = g;
            g = temp.r;
            xP = x;
            yP = y;
            x = u;
            y = v;
            u = adder.subtract(xP, multiplier.multiply(q, u, mod), mod);
            v = adder.subtract(yP, multiplier.multiply(q, v, mod), mod);
        }

        // (No need to reduce here since that already happened during the algorithm.)
        List<Integer> d = f;
        List<Integer> a = x;
        List<Integer> b = y;

        // Divide d, a and b with the leading coefficient of d.
        // This ensures that the leading coefficient of the gcd is one, which is the gcd that is requested.
        // This is done using the divide algorithm because that one correctly handles the multiplicative inverse.
        // We also could've directly multiplied each coefficient with the multiplicative inverse and reduce the result.
        int divideBy = Polynomial.leadingCoefficient(d);
        if (divideBy != 0 && divideBy != 1) {
            List<Integer> divideByPolynomial = Collections.singletonList(divideBy);
            d = divider.divide(d, divideByPolynomial, mod).q;
            a = divider.divide(a, divideByPolynomial, mod).q;
            b = divider.divide(b, divideByPolynomial, mod).q;
        }

        // Return result
        return new Result(d, a, b);
    }

    /**
     * Stores the result for Extended Euclidian algorithm.
     */
    public class Result {
        public final List<Integer> d;
        public final List<Integer> a;
        public final List<Integer> b;

        public Result(List<Integer> d, List<Integer> a, List<Integer> b) {
            this.d = d;
            this.a = a;
            this.b = b;
        }
    }
}
