package classes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PolynomialTest {

    @Test
    public void removeLeadingZeros() {
        List<Integer> test;

        // 0
        test = new ArrayList<>(Arrays.asList(0));
        Polynomial.removeLeadingZeros(test);
        assertEquals(Arrays.asList(0), test);

        // 0,0
        test = new ArrayList<>(Arrays.asList(0,0));
        Polynomial.removeLeadingZeros(test);
        assertEquals(Arrays.asList(0), test);


        // 0,1

        // 1,0
        test = new ArrayList<>(Arrays.asList(1,0));
        Polynomial.removeLeadingZeros(test);
        assertEquals(Arrays.asList(1), test);


        // 1,1,0



    }
}