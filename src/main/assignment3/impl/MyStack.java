package main.assignment3.impl;

public class MyStack <E> {

    private Node top;

    public boolean isEmpty(){
        return top  == null;
    }

    public E peek(){
        return (E) top.data;
    }


    public void push(E data){
        Node node  = new Node(data);
        node.next = top;
        top = node;
    }

    public E pop () {
        if (top != null) {
            E data = (E) top.data;
            top = top.next;
            return data;
        } else
            return null;
    }

    private static class Node <E>{
        private E data;
        private Node next;

        Node(E data){
            this.data = data;
        }
    }
}
