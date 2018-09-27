package classes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FormatterTest {

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
        checkToString("X", 1, 0);
    }

    @Test
    public void toStringXmin1() {
        checkToString("X-1", 1, -1);
    }

    @Test
    public void toStringMin2Xmin2() {
        checkToString("2X-2", 2, -2);
    }

    @Test
    public void toStringXcubedXsquaredXplus1() {
        checkToString("X^3+X^2+X+1", 1, 1, 1, 1);
    }

    @Test
    public void toStringRandom() {
        checkToString("6X^9+4X^7+2X^6-6X^4+5X^3+3X^2-4X^1-3", 6, 0, 4, 2, 0, -6, 5, 3, -4, -3);
    }


    private void checkToString(String expected, Integer... poly) {
        String result = new Formatter().toString(Arrays.asList(poly));
        assertEquals(expected, result);
    }

    @Test
    public void toPoly() {
    }
}