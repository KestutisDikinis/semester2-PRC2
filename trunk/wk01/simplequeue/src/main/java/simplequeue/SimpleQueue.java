package simplequeue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class SimpleQueue<E> implements Iterable<E>{
    //TODO
    private Node<E> front;
    private Node<E> rear;

    private int currentSize;

    public SimpleQueue() {
        front = null;
        rear = null;
        currentSize = 0;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    void put(E e){
        Node<E> oldRear = rear;
        rear = new Node(e);
        if(isEmpty()){
            front = rear;
        }else{
            oldRear.next = rear;
        }
        currentSize++;
    }

    public E peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return (E) front.data;
    }

    public E take(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        E data = (E) front.data;
        front=front.next;

        currentSize--;

        return data;
    }

    public Iterator<E> iterator()
    {
        return new SimpleQueueIterator<E>(this);
    }


    public Node<E> getHead() {
        return this.front;
    }
}
