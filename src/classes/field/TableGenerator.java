package classes.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.polynomial.Adder;
import classes.polynomial.Multiplier;

public class TableGenerator {
    Adder adder = new Adder();
    Multiplier multiplier = new Multiplier();
    
    public List<List<List<Integer>>> createAddTable(List<Integer> characteristic, int mod){
        List<List<List<Integer>>> result = new ArrayList<>();
        List<List<Integer>> elements = new ArrayList<>();
        for(int i=0; i<characteristic.size()-1;i++) {
            for(int j=0; j<mod; j++) {
                elements.add(new ArrayList<Integer>(Arrays.asList(i, j)));
            }
        }
        
        for(int i=0;i<(characteristic.size()-1)*mod; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for(int j=0; j<(characteristic.size()-1)*mod; j++) {
                temp.add(adder.add(elements.get(i), elements.get(j), mod));
            }
            result.add(temp);
        }
        return result;
    }
    
    public List<List<List<Integer>>> createMulTable(List<Integer> characteristic, int mod){
        List<List<List<Integer>>> result = new ArrayList<>();
        List<List<Integer>> elements = new ArrayList<>();
        for(int i=0; i<characteristic.size()-1;i++) {
            for(int j=0; j<mod; j++) {
                elements.add(new ArrayList<Integer>(Arrays.asList(i, j)));
            }
        }
        
        for(int i=0;i<(characteristic.size()-1)*mod; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for(int j=0; j<(characteristic.size()-1)*mod; j++) {
                temp.add(multiplier.multiply(elements.get(i), elements.get(j), mod));
            }
            result.add(temp);
        }
        return result;
    }
}
