package classes.polynomial;

import java.util.ArrayList;
import java.util.List;

public class Divider {
    public Result divide(List<Integer> f, List<Integer> g, int mod) {

        List<Integer> q = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        // Do algorithm


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
    }
}
