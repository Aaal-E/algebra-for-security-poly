package classes;

import java.util.ArrayList;
import java.util.List;

import classes.polynomial.Divider;

public class Field {
    
    static Divider div = new Divider();
    
    public static List<Integer> reduce(List<Integer> polynomial, List<Integer> characteristic, int mod){
        polynomial = Polynomial.reduce(polynomial, mod);
        polynomial = div.divide(polynomial, characteristic, mod).r;
        return polynomial;
    }
    
    public static List<Integer> random(int degree, List<Integer> characteristic, int mod){
        List<Integer> result = new ArrayList<>();
        
        if(degree >= characteristic.size()-1)
            return null;
        for(int i=0; i<degree; i++) {
            result.add((int) Math.floor((Math.random()*mod)));
        }
        
        return result;
    }
}
