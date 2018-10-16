package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Helper class with static methods for polynomials.
 */
public class Polynomial {
    public static final List<Integer> ZERO = Arrays.asList(0);
    public static final List<Integer> ONE = Arrays.asList(1);

    /**
     * Creates a polynomial from a collection of integers.
     * NOTE: the first given integer should have the highest coefficient! I.e. 2X+1 is input as 2, 1.
     */
    public static List<Integer> fromInts(int... polynomial) {
//        List<Integer> poly = new ArrayList<>(polynomial);
//        return Arrays.asList()
        return null;
    }

    public static void removeLeadingZeros(List<Integer> polynomial) {
        while (polynomial.size() > 1 && polynomial.get(polynomial.size() - 1) == 0) {
            polynomial.remove(polynomial.size() - 1);
        }
    }
    
    public static List<Integer> random(int degree, int mod){
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<degree+1; i++) {
            result.add((int) Math.floor((Math.random()*mod)));
        }
//        if(result.get(result.size()-1) == 0)
//            result.set(result.size()-1, 1);
        return result;
    }
    
    public static List<Integer> reduce(List<Integer> polynomial, int mod){
        for(int i=0;i<polynomial.size();i++) {
            int temp = polynomial.get(i)%mod;
            temp = (temp<0)? temp + mod: temp;
            polynomial.set(i, temp);
        }
        return polynomial;
    }
    
    
}
