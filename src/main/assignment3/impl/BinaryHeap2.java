package main.assignment3.impl;
import main.assignment3.BinaryHeap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap2<T extends Comparable<T>> implements BinaryHeap<T> {

    private List<T> ls;

    public BinaryHeap2() {
        this.ls = new ArrayList<T>();
        this.ls.add(null);
    }


    @Override
    public void insert(T t) {
        this.ls.add(t);
        percolateUp();
    }

    private void percolateUp(){
        int index = this.ls.size()-1;
        while(index >1 && check(this.ls.get(index/2),this.ls.get(index))){

            swapRef(index/2,index);

            index = index/2;

        }
    }

    private void percolateUp2(int indx){
        int index = indx;
        while(index >1 && check(this.ls.get(index/2),this.ls.get(index))){

            swapRef(index/2,index);

            index = index/2;

        }
    }

    private int search(T elm){

        return ls.indexOf(elm);
    }

    public void decresekey(T elm){
        int index = search(elm);
        percolateUp2(index);
    }

    @Override
    public T deleteMin() {
        if(!isEmpty()) {
            T t = this.ls.get(1);
            swapRef(1,this.ls.size()-1);
            this.ls.remove(this.ls.size()-1);
            percolateDown(1);
            return t;
        }
        return null;
    }

    @Override
    public T findMin() {
        if(!isEmpty()) {
            return this.ls.get(1);
        }
        return null;
    }

    private void percolateDown(int index){
        int j;
        while(index*2 <= this.ls.size()-1){
            j = index*2;
            if(j < this.ls.size()-1 && check(this.ls.get(j),this.ls.get(j+1)))
                j++;
            if(!check(this.ls.get(index),this.ls.get(j)))
                break;
            swapRef(j,index);
            index = j;
        }
    }

    @Override
    public boolean isEmpty() {
        return ls.size()<=1;
    }

    @Override
    public int size() {
        return this.ls.size()-1;
    }

    private boolean check(Comparable t1, Comparable t2){

            return t1.compareTo(t2)>0;

    }

    private void swapRef(int i, int j){
        T swap = this.ls.get(i);
        this.ls.set(i, this.ls.get(j));
        this.ls.set(j, swap);
    }
}
