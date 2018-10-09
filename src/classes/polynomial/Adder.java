package classes.polynomial;

import java.util.List;
import java.util.ArrayList;

public class Adder {

    public List<Integer> add(List<Integer> f, List<Integer> g, int mod) {
        List<Integer> result = new ArrayList<Integer>(); 
        for (int i=0;i<(Math.min(f.size(),g.size()));i++){
            result.add(f.get(i)+g.get(i));
        }
        if (f.size()>g.size()) {
            for(int i = g.size(); i< f.size(); i++) {
                result.add(f.get(i));
            }
        } else {
            for(int i = f.size(); i< g.size(); i++) {
                result.add(g.get(i));
            }
        }
        //reduce?
        return result;
    }

    public List<Integer> subtract(List<Integer> f, List<Integer> g, int mod) {
        List<Integer> result = new ArrayList<Integer>(); 
        for (int i=0;i<(Math.min(f.size(),g.size()));i++){
            result.add(f.get(i)-g.get(i));
        }
        if (f.size()>g.size()) {
            for(int i = g.size(); i< f.size(); i++) {
                result.add(f.get(i));
            }
        } else {
            for(int i = f.size(); i< g.size(); i++) {
                result.add(-g.get(i));
            }
        }
        //reduce?
        return result;
    }
}
