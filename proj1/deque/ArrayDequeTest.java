package deque;

import afu.org.checkerframework.checker.igj.qual.I;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {
    @Test
    public void addTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }
        System.out.println(ad1.size());
        ad1.printDeque();
        assertEquals(10, ad1.size());
        Integer expected = 7;
        assertEquals(expected, ad1.get(7));
    }

    @Test
    public void removeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }
        for (int i = 0; i < 5; i++) {
            ad1.removeFirst();
        }
        assertEquals(5, ad1.size());
        ad1.printDeque();
    }
}
