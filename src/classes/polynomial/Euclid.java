package classes.polynomial;

import java.util.ArrayList;
import java.util.List;

public class Euclid {

    public Result euclid(List<Integer> a, List<Integer> b, int p) {
        List<Integer> d = new ArrayList<>();
        List<Integer> answerA = new ArrayList<>();
        List<Integer> answerB = new ArrayList<>();

        // Do algorithm


        // Return result
        return new Result(d, answerA, answerB);
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
