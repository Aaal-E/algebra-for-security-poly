package classes.field;

import java.util.ArrayList;
import java.util.List;

import classes.Field;
import classes.polynomial.*;

public class Arithmetic {
    Adder adder = new Adder();
    Multiplier multiplier = new Multiplier();

    
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
        List<Integer> result = new ArrayList<>();
        result = adder.subtract(f, g, mod);
        result = Field.reduce(result, characteristic, mod);
        return result;
    }
    
    
}
