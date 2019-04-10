package com.gtu.nurhak;

import java.util.Comparator;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 07/Apr/2019 15:25
 ************************************************************************/


public class nPriorityQueue<E extends Comparable<E>> {

    // The binary heap.
    nBinaryHeap<E> binaryHeap;

    /**
     * Creates emppty PriorityQueue with natural ordering.
     */
    public  nPriorityQueue(){
        binaryHeap = new nBinaryHeap<>();
    }

    /**
     * Creates an PriorityQueue with a specific initial capacity.
     * @param capacity The initial capacity.
     */
    public nPriorityQueue(int capacity){
        binaryHeap = new nBinaryHeap<>(capacity);
    }

    /**
     * Creates a PriorityQueue with comparator.
     * @param comp ç
     */
    public nPriorityQueue(Comparator comp){
        binaryHeap = new nBinaryHeap<>(comp);
    }

    /**
     * Creates an PriorityQueue with a specific initial capacity and a comparator.
     * @param comp The initial capacity.
     * @param capacity The initial capacity.
     */
    public nPriorityQueue(Comparator comp, int capacity){
        binaryHeap = new nBinaryHeap<>(capacity, comp);
    }

    /**
     * Add an element to the PriorityQueue
     * @param e The item that will be inserted.
     * @return True if item is inserted, False if the item is not inserted.
     */
    public boolean add(E e){
        return binaryHeap.insert(e);
    }

    /**
     *
     * Add an element to the PriorityQueue
     * @param e The item that will be inserted.
     * @return True if item is inserted, False if the item is not inserted.
     */
    public boolean offer (E e){
        return binaryHeap.insert(e);
    }

    /**
     * Clear the PriorityQueue.
     */
    public void clear(){
        binaryHeap.clear();
    }

    /**
     * Removes the smallest entry from the PriorityQueue.
     * @return The smallest entry.
     * @throws java.util.NoSuchElementException if the PriorityQueue is empty.
     */
    public E remove(){
        return binaryHeap.delete();
    }

    /**
     * Removes the smallest entry from the PriorityQueue.
     * @return The smallest entry, null if the PriorityQueue is empty.
     */
    public E poll(){
        return binaryHeap.poll();
    }

    /**
     * Gives the smallest entry from the PriorityQueue.
     * @return the smallest entry, null if the PriorityQueue is empty.
     */
    public E peek(){
        return binaryHeap.peek();
    }

    /**
     * Gives the smallest entry from the PriorityQueue.
     * @return The smallest entry.
     * @throws java.util.NoSuchElementException if the PriorityQueue is empty.
     */
    public E element(){
        return binaryHeap.element();
    }

    /**
     * Converts the PriorityQueue to string.
     * @return String format of the PriorityQueue data.
     */
    public String toString(){
        return binaryHeap.toString();
    }
}
