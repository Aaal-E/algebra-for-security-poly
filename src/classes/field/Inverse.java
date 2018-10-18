package classes.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.polynomial.Euclid;
import classes.polynomial.Multiplier;

public class Inverse {
    Euclid euclid = new Euclid();
    Multiplier multiplier = new Multiplier();
    
    public List<Integer> findInverse(List<Integer> element, List<Integer> characteristic, int mod){
        classes.polynomial.Euclid.Result result = euclid.euclid(element, characteristic, mod);
        List<Integer> temp = new ArrayList<>();
        List<Integer> modlist = new ArrayList<Integer>(Arrays.asList(mod));
        temp = euclid.euclid(result.a, modlist, mod).a;
        
        return multiplier.multiply(result.a, temp, mod);
    }

    public int findInverse(int f, int mod) {
        return 0;
    }
}
