package classes.polynomial;

import classes.Field;
import classes.Polynomial;

import java.util.List;

public class Equality {

    public static boolean equals(List<Integer> f, List<Integer> g, List<Integer> h, int mod) {
        if (Polynomial.isZero(h)) {
            // Case modulo zero polynomial
            // We assume in this case that f and g are not equal since g mod h = g mod 0 = undefined while f is defined
            return false;
        }
        return Field.polyEquals(f, g, h, mod);
    }
}
