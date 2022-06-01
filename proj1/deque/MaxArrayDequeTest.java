package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void addTest() {
        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < 10; i++) {
            mad1.addLast(i);
        }
        Integer expected = 9;
        assertEquals(expected, mad1.max());
        expected = 0;
        assertEquals(expected, mad1.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));
    }
}
