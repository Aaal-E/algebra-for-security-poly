package classes.polynomial;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DividerTest {

    @Test
    public void test() {
        //assertEquals(3, new Divider().EEA(2, 5));
        //assertEquals(3, new Divider().EEA(5, 2));
        System.out.println(new Divider().EEA(2,5));
        System.out.println(new Divider().EEA(5,2));
    }
}