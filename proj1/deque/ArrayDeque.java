package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int front;
    private int back;
    private int capacity;
    private T[] items;

    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        front = 0;
        back = 1;
        size = 0;
    }
    /*
    public T getRecursive(int index) {

    }
    */
    private void resize(int cap) {
        T[] tempItems = (T[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            tempItems[i + 1] = items[(front + 1 + i + capacity) % capacity];
        }
        items = tempItems;
        front = 0;
        back = size + 1;
        capacity = cap;
    }
    @Override
    public void addFirst(T item) {
        items[front] = item;
        front = (front + capacity - 1) % capacity;
        size = size + 1;
        if (size + 1 == capacity) {
            resize(size * 2);
        }
    }
    @Override
    public void addLast(T item) {
        items[back] = item;
        back = (back + 1) % capacity;
        size = size + 1;
        if (size + 1 == capacity) {
            resize(size * 2);
        }
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(front + i + 1) % capacity]);
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % capacity;
        size = size - 1;
        T temp = items[front];
        if (size < capacity / 4 && size > 3) {
            resize(size * 2);
        }
        return temp;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        back = (back + capacity - 1) % capacity;
        size = size - 1;
        T temp = items[back];
        if (size < capacity / 4 && size > 3) {
            resize(size * 2);
        }
        return temp;
    }
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(front + 1 + index) % capacity];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int wizPos;

        ArrayDequeIterator() {
            wizPos = 0;
        }
        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque) {
            if (size() != ((ArrayDeque<T>) o).size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!(((ArrayDeque<?>) o).get(i).equals(get(i)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
