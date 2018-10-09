package classes.polynomial;

import java.util.ArrayList;
import java.util.List;

import classes.Polynomial;



public class Divider {
    Adder adder = new Adder();
    Multiplier mul = new Multiplier();
    public Result divide(List<Integer> f, List<Integer> g, int mod) {

        List<Integer> q = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(f);
        List<Integer> temp2 = new ArrayList<>();
        // Do algorithm
        if(g.equals(Polynomial.ZERO))
            return null;
        for(int i = 0; i<=f.size()-g.size(); i++) {
//            if(g.get(g.size()-1)==0)
//                q.add(0);
//            else
                q.add(0, temp.get(f.size()-i-1)/g.get(g.size()-1));
            for(int j = 0; j<i; j++)
                temp2.add(0);
            temp2.add(q.get(0));
            temp = adder.subtract(temp, mul.multiply(temp2, g, mod), mod);
        }
        r = adder.subtract(f, mul.multiply(q, g, mod), mod);
        //reduce
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
