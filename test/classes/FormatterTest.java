package classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FormatterTest {

    @Rule
    public Timeout globalTimeout= new Timeout(500);

    @Test
    public void toString0() {
        checkToString("0", 0);
    }

    @Test
    public void toString1() {
        checkToString("1", 1);
    }

    @Test
    public void toStringMin1() {
        checkToString("-1", -1);
    }

    @Test
    public void toStringXplus1() {
        checkToString("X+1", 1, 1);
    }

    @Test
    public void toStringXplus0() {
        checkToString("X", 0, 1);
    }

    @Test
    public void toStringXmin1() {
        checkToString("X-1", -1, 1);
    }

    @Test
    public void toStringMin2Xmin2() {
        checkToString("2X-2", -2, 2);
    }

    @Test
    public void toStringXcubedXsquaredXplus1() {
        checkToString("X^3+X^2+X+1", 1, 1, 1, 1);
    }

    @Test
    public void toStringRandom() {
        checkToString("6X^9+4X^7+2X^6-6X^4+5X^3+3X^2-4X-3", -3, -4, 3, 5, -6, 0, 2, 4, 0, 6);
    }


    private void checkToString(String expected, Integer... poly) {
        String result = new Formatter().toString(Arrays.asList(poly));
        assertEquals(expected, result);
    }

    @Test
    public void toPoly0() {
        poly("{0}", 0);
    }

    @Test
    public void toPoly1() {
        poly("{1}", 1);
    }

    @Test
    public void toPolyMin1() {
        poly("{-1}", -1);
    }

    @Test
    public void toPoly1plus1() {
        poly("{1,1}", 1, 1);
    }

    @Test
    public void toPoly1min1() {
        poly("{1,-1}", -1, 1);
    }

    @Test
    public void toPolyMin1plus1() {
        poly("{-1,1}", 1, -1);
    }

    @Test
    public void toPolyMin1min1() {
        poly("{-1,-1}", -1, -1);
        poly("-X-1", -1, -1);
    }

    @Test
    public void toPolyXcubedXsquaredXplus1() {
        poly("{1,1,1,1}", 1, 1, 1, 1);
        poly("X^3+X^2+X+1", 1, 1, 1, 1);
    }

    @Test
    public void toPolyRandom() {
        poly("{-234,0,23,-144,0,0,0,1,1,2,6}", 6, 2, 1, 1, 0, 0, 0, -144, 23, 0, -234);
        poly("-234X^10+23X^8-144X^7+X^3+X^2+2X+6", 6, 2, 1, 1, 0, 0, 0, -144, 23, 0, -234);
    }

    @Test
    public void toPolyLeading0() {
        poly("{0,1,2,3}", 3, 2, 1);
    }

    private void poly(String poly, Integer... expected) {
        List<Integer> result = new Formatter().toPoly(poly);
        assertEquals(Arrays.asList(expected), result);
    }
}