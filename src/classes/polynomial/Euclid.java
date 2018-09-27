package classes.polynomial;

import java.util.ArrayList;
import java.util.List;

public class Euclid {

    public Result euclid(List<Integer> f, List<Integer> g, int mod) {
        List<Integer> d = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        // Do algorithm


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
