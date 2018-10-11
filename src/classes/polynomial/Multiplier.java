package classes.polynomial;

import java.util.ArrayList;
import java.util.List;

import classes.Polynomial;

public class Multiplier {
    public List<Integer> multiply(List<Integer> f, List<Integer> g, int mod) {
        List<Integer> result = new ArrayList<Integer>(); 
        for (int i=0;i<(f.size()+g.size());i++){
            result.add(0);
        }
        
        for(int i=0; i<f.size();i++) {
            for(int j=0;j<g.size();j++) {
                result.set(i+j, result.get(i+j)+f.get(i)*g.get(j));
            }
        }
        result = Polynomial.reduce(result, mod);
        return result;
    }
}
