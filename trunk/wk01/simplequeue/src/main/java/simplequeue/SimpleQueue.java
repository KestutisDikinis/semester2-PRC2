package simplequeue;

import java.util.LinkedList;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class SimpleQueue<T> {
    //TODO
    LinkedList<Node> list = new LinkedList<>();


    public boolean isEmpty() {
        return list.getFirst() == null && list.getLast() == null;
    }
}
