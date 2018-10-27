package classes.field;

import classes.Polynomial;
import classes.polynomial.Euclid;
import classes.polynomial.Multiplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inverse {
    Euclid euclid = new Euclid();

    public List<Integer> findInverse(List<Integer> element, List<Integer> characteristic, int mod) {
        Euclid.Result eea = euclid.euclid(element, characteristic, mod);

        if (eea.d.equals(Polynomial.ONE)) {
            return eea.a;
        } else {
            return null;
        }
    }

}
