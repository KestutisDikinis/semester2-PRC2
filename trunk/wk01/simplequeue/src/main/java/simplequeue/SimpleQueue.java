package simplequeue;

import java.util.LinkedList;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandehombergh@gmail.com}
 */
public class SimpleQueue<E> {
    //TODO
    private Node front;
    private Node rear;

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
        Node oldRear = rear;
        rear = new Node(e);
        if(isEmpty()){
            front = rear;
        }else{
            oldRear.next = rear;
        }
        currentSize++;
    }

    public E peek(){
        return (E) front.data;
    }

    public E take(){
        E data = (E) front.data;
        front=front.next;
        if(isEmpty()){
            rear = null;
        }
        currentSize--;

        return data;
    }
}
