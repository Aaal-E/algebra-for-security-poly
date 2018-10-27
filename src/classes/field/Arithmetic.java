package classes.field;

import java.util.ArrayList;
import java.util.List;

import classes.Field;
import classes.Logger;
import classes.Polynomial;
import classes.polynomial.*;

public class Arithmetic {
    Adder adder = new Adder();
    Multiplier multiplier = new Multiplier();
    Inverse inverse = new Inverse();

    
    public List<Integer> multiply(List<Integer> f, List<Integer> g, List<Integer> characteristic, int mod) {
        List<Integer> result;
        result = multiplier.multiply(f, g, mod);
        result = Field.reduce(result, characteristic, mod);
        return result;
    }
    
    public List<Integer> add(List<Integer> f, List<Integer> g, List<Integer> characteristic, int mod) {
        List<Integer> result = new ArrayList<>();
        result = adder.add(f, g, mod);
        result = Field.reduce(result, characteristic, mod);
        return result;
    }
    
    public List<Integer> subtract(List<Integer> f, List<Integer> g, List<Integer> characteristic, int mod) {
        List<Integer> result = adder.subtract(f, g, mod);
        result = Field.reduce(result, characteristic, mod);
        return result;
    }
    
    public List<Integer> pow(List<Integer> f, int pow, List<Integer> characteristic, int mod) {
        List<Integer> result = new ArrayList<>(Polynomial.ONE);
        for(int i = 0; i<pow; i++) {
            result = multiply(result, f, characteristic, mod);
        }
        Polynomial.checkRepresentation(result);
        Logger.log("pow result: %s", result);
        return result;
    }
    
    public List<Integer> div(List<Integer> f, List<Integer> g, List<Integer> characteristic, int mod){
        if (Polynomial.isZero(g)) {
            return null;
        }

        List<Integer> ans = multiplier.multiply(f, inverse.findInverse(g, characteristic, mod), mod);
        ans = Field.reduce(ans, characteristic, mod);
        return ans;
    }
}
