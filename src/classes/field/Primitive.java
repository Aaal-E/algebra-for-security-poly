package classes.field;

import java.util.List;

import classes.Field;

public class Primitive {
    /*Input: Field F of order q and prime divisors p1, . . . pk of q - 1 and a in F
    Output: ‘true’ if a is primitive, ‘false’ otherwise
    Step 1: i = 1
    Step 2: while a^(q-1/pi) != 1 and i <= n do
    i = i + 1
    Step 3: if i <= n output ‘false’ else ‘true’*/
    
    Arithmetic calc = new Arithmetic();
    
    public boolean isPrimitive(List<Integer> a, /*whichever way we want to input this,*/ List<Integer> characteristic, int mod) {
        int i = 1;
        while (calc.pow(a, a.size()-2/*/p.get(i)*/, characteristic, mod)&& i<=n /*what is this n???*/){
            i++;
        }
        return i>n;
    }
    
    public List<Integer> findPrimitive(int degree, List<Integer> characteristic, int mod){
        List<Integer> a = Field.random(degree, characteristic, mod);
        while(!isPrimitive(a, characteristic, mod))
            a = Field.random(degree, characteristic, mod);
        return a;
    }
}
