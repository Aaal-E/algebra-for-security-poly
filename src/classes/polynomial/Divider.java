package classes.polynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Polynomial;


public class Divider {
    Adder adder = new Adder();
    Multiplier mul = new Multiplier();

    /**
     * Returns an array with [d, x, y].
     */
    public int EEA(int a, int b) {

        // b = the mod ( so finding as + bt = 1, where t is the mult inverse mod "mod")
//
//        if (a < b) {
//            int aux = a;
//            a = b;
//            b = aux;
//        }

        int aP = Math.abs(a);
        int bP = Math.abs(b);
        int x1 = 1;
        int x2 = 0;
        int y1 = 0;
        int y2 = 1;

        while (bP > 0) {
            int q = Math.floorDiv(aP, bP);
            int r = aP - q * bP;

            aP = bP;
            bP = r;

            int x3 = x1 - q * x2;
            int y3 = y1 - q * y2;
            x1 = x2;
            x2 = x3;
            y1 = y2;
            y2 = y3;
        }

        int d = aP;
        int x = (a >= 0) ? x1 : -x1;
        int y = (b >= 0) ? y1 : -y1;

        while (x<b){
            x+=b;
        }
        x-=b;


        return x;
//        return new int[]{d, x, y};

        //give the multiplicative inverse of a, which is t, since a >=b.
        //return t % a;
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
        if (g.equals(Polynomial.ZERO))
            return null;
        for (int i = 0; i <= f.size() - g.size(); i++) {
            if (temp.size() < f.size() - i)
                q.add(0, 0);
            else
                q.add(0, temp.get(temp.size() - 1) * EEA(g.get(g.size()-1), mod));

            temp2.clear();
            for (int j = 0; j < (temp.size() - g.size()); j++)
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
