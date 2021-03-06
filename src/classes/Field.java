package classes;

import java.util.List;

import classes.polynomial.Divider;

public class Field {

    static Divider div = new Divider();

    public static List<Integer> reduce(List<Integer> polynomial, List<Integer> characteristic, int mod) {
        polynomial = Polynomial.reduce(polynomial, mod);
        polynomial = div.divide(polynomial, characteristic, mod).r;
        return polynomial;
    }

    public static boolean polyEquals(List<Integer> f, List<Integer> g, List<Integer> characteristic, int mod) {
        return reduce(f, characteristic, mod).equals(reduce(g, characteristic, mod));
    }


}
