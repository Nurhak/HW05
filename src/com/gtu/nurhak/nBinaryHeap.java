package com.gtu.nurhak;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak
 * TimeStamp: 07/Apr/2019 15:25
 ************************************************************************/

/**
 * This class is a binary heap abstract data structure. It allows to store data in natural order or given comparator method.
 * @param <E> Stored data type.
 */
public class nBinaryHeap<E extends Comparable<E>> {

    // Arraylist for storing data.
    private ArrayList<E> heap;

    // Comparator variable.
    Comparator<E> comparator = null;

    //Constructors

    /**
     * Create an empty heap.
     * Heap add elements according to natural order.
     */
    public nBinaryHeap(){
        heap = new ArrayList<>();
    }

    /**
     * Create an heap with specific capacity.
      * @param capacity The initial capacity of the heap.
     */
    public nBinaryHeap(int capacity){
        if(capacity < 1){
            throw new IllegalArgumentException();
        }

        heap = new ArrayList<>(capacity);
    }

    /**
     * Create an empty heap with a comparator.
     * @param comp The comparator.
     */
    public nBinaryHeap(Comparator comp){
        heap = new ArrayList<>();
        comparator = comp;
    }

    /**
     * Create a heap with specific capacity and the comparator method.
     * @param capacity The initial capacity of the heap.
     * @param comp The comparator.
     */
    public nBinaryHeap(int capacity, Comparator<E> comp){
        this(capacity);
        this.comparator = comp;
    }

    /**
     *  Compare two object depends on the comparator method.
     * @param left The one of the object that will be compared.
     * @param right The one of the object that will be compared.
     * @return 1 If the left > right, 0 If the right = 0 , -1 If the left < right.
     */
    private int compare(E left, E right){

        if(comparator != null){
            return comparator.compare(left,right);
        }else
        {
            return ((Comparable<E>) left).compareTo(right);
        }
    }

    /**
     * Check the parents of the child and swap them according to compare method.
     */
    private void checktoUp() {
        int k = heap.size() - 1;
        while (k > 0) {
            int p = (k-1)/2;
            E item = heap.get(k);
            E parent = heap.get(p);
            if (compare(item,parent) > 0) {
                // swap
                heap.set(k, parent);
                heap.set(p, item);

                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }

    /**
     * Insert an element to the heap
     * @param item The item will be inserted.
     * @return true if item inserted, false if item is not inserted.
     */
    public boolean insert(E item) {
        boolean result = heap.add(item);
        checktoUp();
        return result;
    }

    /**
     * Check the parents of the child and swap them according to compare method.
     */
    private void checktoDown() {
        int k = 0;
        int l = 2*k+1;
        while (l < heap.size()) {
            int max=l, r=l+1;
            if (r < heap.size()) { // there is a right child
                if (compare(heap.get(r),heap.get(l)) > 0) {
                    max++;
                }
            }
            if (compare(heap.get(k),heap.get(max)) < 0) {
                // switch
                E temp = heap.get(k);
                heap.set(k, heap.get(max));
                heap.set(max, temp);
                k = max;
                l = 2*k+1;
            } else {
                break;
            }
        }
    }

    /**
     * Delete the last element at the heap.
     * @return The element that will be deleted.
     * @throws NoSuchElementException If the heap is empty.
     */
    public E delete()
            throws NoSuchElementException {
        if (heap.size() == 0) {
            throw new NoSuchElementException();
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        E hold = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        checktoDown();
        return hold;
    }

    /**
     * Removes the smallest elemnent from the heap.
     * @return null if the heap is empty, or the element that is deleted.
     */
    public E poll(){
        if (heap.size() == 0) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        E hold = heap.get(0);
        heap.set(0, heap.remove(heap.size()-1));
        checktoDown();
        return hold;
    }

    /**
     * Gives the smallest element.
     * @return null if the heap is empty, or the smallest element.
     */
    public E peek(){
        if(heap.size() == 0){
            return null;
        }else {
            return heap.get(heap.size()-1);
        }
    }

    /**
     * Gives the smallest element.
     * @return The smallest element.
     * @throws NoSuchElementException if the heap is empty.
     */
    public E element(){
        if(heap.size() == 0){
            throw new NoSuchElementException();
        }else {
            return heap.get(heap.size()-1);
        }
    }

    /**
     * Removes all elements from the heap.
     */
    public void clear(){
        this.heap.clear();
    }

    /**
     * Gives the size of the heap.
     * @return The size of the heap.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Checks the heap is empty or not.
     * @return True if heap is empty, False if heap is not empty.
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Converts heap to string.
     * @return String format of the heap data.
     */
    public String toString() {
        return heap.toString();

    }


}
