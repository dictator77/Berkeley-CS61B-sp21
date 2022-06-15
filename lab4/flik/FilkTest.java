package flik;

import org.junit.Test;

import static flik.Flik.isSameNumber;
import static org.junit.Assert.*;

public class FilkTest {
    @Test
    public void testFilk() {
        Integer a = 128;
        Integer b = 128;
        assertTrue(isSameNumber(a, b));
    }
}
