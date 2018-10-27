package classes.field;

import java.util.ArrayList;
import java.util.List;

import classes.Field;
import classes.Polynomial;
import classes.polynomial.*;

public class Arithmetic {
    Adder adder = new Adder();
    Multiplier multiplier = new Multiplier();
    Inverse inverse = new Inverse();

    
    public List<Integer> multiply(List<Integer> f, List<Integer> g, List<Integer> characteristic, int mod) {
        List<Integer> result = new ArrayList<>();
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
        result = multiplier.multiply(result, f, mod);
        result = Field.reduce(result, characteristic, mod);
        }
        return result;
    }
    
    public List<Integer> div(List<Integer> f, List<Integer> g, List<Integer> characteristic, int mod){
        List<Integer> ans = multiplier.multiply(f, inverse.findInverse(g, characteristic, mod), mod);
        ans = Field.reduce(ans, characteristic, mod);
        return ans;
    }
}
