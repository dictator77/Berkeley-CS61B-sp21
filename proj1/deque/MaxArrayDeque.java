package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T result = get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(result, get(i)) < 0) {
                result = get(i);
            }
        }
        return result;
    }
}