package simplequeue;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class Node<E> {

    //TODO
    E data;
    Node next;
  
    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
