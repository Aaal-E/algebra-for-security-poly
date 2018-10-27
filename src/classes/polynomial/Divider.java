package classes.polynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Polynomial;
import classes.integer.EuclidIntegers;


public class Divider {
    Adder adder = new Adder();
    Multiplier multiplier = new Multiplier();


    /**
     * Long division for polynomials.
     *
     * Source: Hans Cuypers, Hans Sterk, Algebra for Security (2015) Algorithm 1.2.6
     */
    public Result divide(List<Integer> f, List<Integer> g, int mod) {
        // Reduce f and g!
        f = Polynomial.reduce(f, mod);
        g = Polynomial.reduce(g, mod);

        // Check for division by zero
        if (Polynomial.isZero(g)) {
            return null;
        }

        // Initialize the quotient to zero
        List<Integer> q = new ArrayList<>(Polynomial.ZERO);
        // Initialize remainder to f
        List<Integer> r = new ArrayList<>(f);

        while (Polynomial.degree(r) >= Polynomial.degree(g)) {
            // Calculate the coefficient for the new term
            // Divide lc(r) by lc(g), i.e. multiply lc(r) by the multiplicative inverse of lc(g)
            int inverse = multiplicativeInverse(Polynomial.leadingCoefficient(g), mod);
            int termCoefficient = Polynomial.leadingCoefficient(r) * inverse;

            // Construct new term to add to the quotient
            int termDegree = Polynomial.degree(r) - Polynomial.degree(g);
            List<Integer> term;
            if (termDegree == -1 || termCoefficient == 0) {
                // For degree -1 or zero coefficient, construct the zero polynomial
                term = new ArrayList<>(Polynomial.ZERO);
            } else {
                // Else create the polynomial termCoefficient * X^termDegree
                term = new ArrayList<>(termDegree + 1);
                term.addAll(Collections.nCopies(termDegree, 0));
                term.add(termCoefficient);
            }
            // Reduce the term
            term = Polynomial.reduce(term, mod);

            // Add new term to the quotient (this also does integer reduction)
            q = adder.add(q, term, mod);

            // Subtract new term times g from the remainder (this also does integer reduction)
            r = adder.subtract(r, multiplier.multiply(term, g, mod), mod);
        }

        // (No need to reduce q and r anymore since that is already done by the adder.)

        return new Result(q, r);
    }

    /**
     * Returns the multiplicative inverse with given modulus using Extended Euclidian Algorithm for integers.
     */
    private int multiplicativeInverse(int a, int m) {
        return EuclidIntegers.run(a, m).x;
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
