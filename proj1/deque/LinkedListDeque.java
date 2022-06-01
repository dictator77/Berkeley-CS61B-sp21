package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    stuffNode sentinel;

    private class stuffNode {
        T item;
        stuffNode prev;
        stuffNode next;

        public stuffNode(T i, stuffNode p, stuffNode n) {
            item = i;
            prev = p;
            next = n;
        }

        private T getR(int index) {
            if (index == 0) {
                return item;
            }
            return this.next.getR(index - 1);
        }
    }

    public LinkedListDeque() {
        sentinel = new stuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public T getRecursive(int index) {
        if (size() <= index) {
            return null;
        }
        stuffNode temp = sentinel.next;
        return temp.getR(index);
    }

    @Override
    public void addFirst(T item) {
        stuffNode p = sentinel.next;
        sentinel.next = new stuffNode(item, sentinel, p);
        p.prev = sentinel.next;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        stuffNode p = sentinel.prev;
        sentinel.prev = new stuffNode(item, p, sentinel);
        p.next = sentinel.prev;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        stuffNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            if (p.next != sentinel) {
                System.out.print(" ");
            }
            p = p.next;
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        stuffNode p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size -= 1;
        return p.item;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        stuffNode p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        size -= 1;
        return p.item;
    }
    @Override
    public T get(int index) {
        if (size() <= index) {
            return null;
        }
        stuffNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }
    /*
    public Iterator<T> iterator() {

    }
    */
    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque) {
            if (size() != ((LinkedListDeque<T>) o).size()) {
                return false;
            }
            stuffNode p = this.sentinel.next;
            stuffNode q = ((LinkedListDeque<T>) o).sentinel.next;
            while (p != sentinel) {
                if (p.item != q.item) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
            return true;
        }
        return false;
    }

}
