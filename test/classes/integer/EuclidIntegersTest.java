package classes.integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class EuclidIntegersTest {

    @Test
    public void test() {
        EuclidIntegers.Result r;

        r = EuclidIntegers.run(5,2);
        assertEquals(1, r.d);
        assertEquals(1, r.x);
        assertEquals(-2, r.y);

        r = EuclidIntegers.run(2,5);
        assertEquals(1, r.d);
        assertEquals(-2, r.x);
        assertEquals(1, r.y);

        r = EuclidIntegers.run(4,2);
        assertEquals(2, r.d);
        assertEquals(0, r.x);
        assertEquals(1, r.y);
    }
}