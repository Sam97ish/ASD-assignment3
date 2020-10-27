package main.assignment3.impl;

import java.util.NoSuchElementException;

public class MyQueue<AnyType>{
    Node<AnyType> front,rear;
    int listSize;

    public MyQueue()
    {
        front = null;
        rear = null;
        listSize = 0;
    }

    static class Node<AnyType>{
        AnyType info;
        Node<AnyType> next;
        Node<AnyType> prev;

        Node(AnyType info){
            this.info = info;
            this.next = null;
            this.prev = null;
        }

        Node(AnyType info, Node<AnyType> next){
            this.info = info;
            this.next = next;
        }

        public void setNext(Node<AnyType> next){
            this.next = next;
        }

        public void setPrev(Node<AnyType> next){
            this.prev = next;
        }

        public Node<AnyType> getNext() {
            return next;
        }

        public Node<AnyType> getPrev() {
            return prev;
        }

        public AnyType getInfo(){
            return this.info;
        }

        public void setInfo(AnyType info) {
            this.info = info;
        }

    }

    public boolean isEmpty()
    {
        return front == null;
    }

    public void push(AnyType value)
    {
        Node<AnyType> ptr = new Node<AnyType>(value);

        if(front == null){
            front = ptr;
            rear = front;

            front.setPrev(null);
            front.setNext(null);
        }else{

            front.setPrev(ptr);
            ptr.setNext(front);
            front = ptr;

        }


    }

    public AnyType pop()
    {
        Node<AnyType> ptr = rear;
        listSize--;
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }

        rear = rear.getPrev();

        if (rear == null)
            front = null;
        return ptr.getInfo();
    }
}
