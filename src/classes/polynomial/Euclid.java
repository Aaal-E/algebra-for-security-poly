package classes.polynomial;

import java.util.ArrayList;
import java.util.List;

import classes.Polynomial;

public class Euclid {

    public Result euclid(List<Integer> f, List<Integer> g, int mod) {
        List<Integer> d;
        List<Integer> a;
        List<Integer> b;
        List<Integer> f_ = new ArrayList<>(f);
        List<Integer> g_ = new ArrayList<>(g);
        List<Integer> a1 = Polynomial.ONE;
        List<Integer> b1 = Polynomial.ZERO;
        List<Integer> a2 = Polynomial.ZERO;
        List<Integer> b2 = Polynomial.ONE;
        List<Integer> a3;
        List<Integer> b3;
        
        Divider divider = new Divider();
        Adder adder = new Adder();
        Multiplier multiplier = new Multiplier();

        // Do algorithm
        while (!Polynomial.isZero(g_)) {
            Divider.Result temp = divider.divide(f_, g_, mod);
            f_ = g_;
            g_ = temp.r;
            a3 = adder.subtract(a1, multiplier.multiply(temp.q, a2, mod), mod);
            b3 = adder.subtract(b1, multiplier.multiply(temp.q, b2, mod), mod);
            a1 = a2;
            b1 = b2;
            a2 = a3;
            b2 = b3;
        }
        d = Polynomial.reduce(f_, mod);
        a = Polynomial.reduce(a1, mod);
        b = Polynomial.reduce(b1, mod);

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
