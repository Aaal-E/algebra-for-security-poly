package classes;

import java.util.List;

import classes.polynomial.Divider;

public class Field {
    
    static Divider div = new Divider();
    
    public static List<Integer> reduce(List<Integer> polynomial, List<Integer> characteristic, int mod){
        polynomial = Polynomial.reduce(polynomial, mod);
        polynomial = div.divide(polynomial, characteristic, mod).r;
        return polynomial;
    }
}
