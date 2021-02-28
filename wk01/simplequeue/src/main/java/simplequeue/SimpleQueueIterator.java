package simplequeue;

import java.util.Iterator;

public class SimpleQueueIterator<T> implements Iterator {

    Node<T> current;

    // initialize pointer to head of the list for iteration
    public SimpleQueueIterator(SimpleQueue<T> list)
    {
        current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T data = current.data;
        current = current.next;
        return data;
    }
}
