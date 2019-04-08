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


public class nBinaryHeap<E extends Comparable<E>> {

    private ArrayList<E> heap;
    Comparator<E> comparator = null;

    public nBinaryHeap(){
        heap = new ArrayList<>();
    }

    public nBinaryHeap(int capacity){
        if(capacity < 1){
            throw new IllegalArgumentException();
        }

        heap = new ArrayList<>(capacity);
    }

    public nBinaryHeap(Comparator comp){
        heap = new ArrayList<>();
        comparator = comp;
    }

    public nBinaryHeap(int capacity, Comparator<E> comp){
        this(capacity);
        this.comparator = comp;
    }

    private int compare(E left, E right){

        if(comparator != null){
            return comparator.compare(left,right);
        }else
        {
            return ((Comparable<E>) left).compareTo(right);
        }
    }

    private void siftUp() {
        int k = heap.size() - 1;
        while (k > 0) {
            int p = (k-1)/2;
            E item = heap.get(k);
            E parent = heap.get(p);
            //if (item.compareTo(parent) > 0) {
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

    public void insert(E item) {
        heap.add(item);
        siftUp();
    }

    private void siftDown() {
        int k = 0;
        int l = 2*k+1;
        while (l < heap.size()) {
            int max=l, r=l+1;
            if (r < heap.size()) { // there is a right child
                //if (heap.get(r).compareTo(heap.get(l)) > 0) {
                if (compare(heap.get(r),heap.get(l)) > 0) {
                    max++;
                }
            }
            //if (heap.get(k).compareTo(heap.get(max)) < 0) {
            if (compare(heap.get(k),heap.get(max)) > 0) {
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
        siftDown();
        return hold;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();

    }

    public String toString() {
        return heap.toString();
    }

}
