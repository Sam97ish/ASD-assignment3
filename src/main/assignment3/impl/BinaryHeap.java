package main.assignment3.impl;

import java.nio.BufferUnderflowException;

public class BinaryHeap {
    private Integer arr[];
    private int currentsize;

    BinaryHeap(int size){
        arr = new Integer[size];
        this.currentsize = 0;
    }

    /**
     * @role: inserts an element into binary heap.
     * @param x integer.
     * @complexity: O(LogN) worst-case, O(1) average-case.
     */
    public void insert(Integer x){

        if(currentsize == arr.length -1){
            //enlarge
            enlargeArray(arr.length *2 + 1);
        }

        //percolate up.
        int hole = ++currentsize;
        for(arr[0] = x; x.compareTo(arr[ hole/2 ]) < 0; hole /=2){
            arr[hole] = arr[hole/2];
        }
        arr[hole] = x;
    }

    /**
     * @role: enlarges the array
     * @param nm int.
     * @complexity: O(N).
     */
    private void enlargeArray(int nm){
        Integer tmp[] = new Integer[nm];
        for(int i =1; i <= currentsize; i++){
            tmp[i] = arr[i];
        }

        arr = tmp;
    }

    /**
     * @param i int.
     * @return the element at index i.
     * @complexity: O(1).
     */
    public int get(int i){
        return arr[i];
    }

    //for debugging purposes.
    public void printHeap(){

        for(int i =1; i <= currentsize; i++){
            System.out.println(arr[i] + " ");
        }

    }

    /**
     * @return min value in heap.
     * @complexity: O(1).
     */
    private int findMin(){
        return arr[1];
    }

    /**
     * @return true if heap is empty.
     * @complexity: O(1).
     */
    private boolean isEmpty(){
        return currentsize == 0;
    }

    /**
     * @role: perlocates down the heap to keep the heap property intact.
     * @param hole int.
     * @complexity : O(LogN).
     */
    private void percolateDown(int hole){
        int child;
        int tmp = arr[hole];
        for(; hole*2 <= currentsize; hole = child){
            child = hole * 2;
            if(child != currentsize && arr[child+1].compareTo(arr[child]) < 0){
                child++;
            }
            if(arr[child].compareTo(tmp) < 0){
                arr[hole] = arr[child];
            }else {
                break;
            }
        }
        arr[hole] = tmp;
    }

    /**
     * @role: deletes the min value of the heap.
     * @return the min value of the heap.
     * @complexity: O(LogN).
     */
    public int deleteMin(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }

        int minitem = findMin();

        arr[1]= arr[currentsize--];

        percolateDown(1);

        return minitem;
    }
}
