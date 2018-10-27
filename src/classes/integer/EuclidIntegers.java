package classes.integer;

public class EuclidIntegers {


    /**
     * Extended Euclidian Algorithm for integers.
     *
     * Source: Benne de Weger, Algorithmic Number Theory Algorithm 2.2
     */
    public static Result run(int a, int b) {

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

        /*
        while (x<b){
            x+=b;
        }
        x-=b;
        */

        return new Result(d, x, y);

        //give the multiplicative inverse of a, which is t, since a >=b.
        //return t % a;
    }

    public static class Result {
        public final int d;
        public final int x;
        public final int y;

        public Result(int d, int x, int y) {
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }
}
