package com.gtu.nurhak;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here

        nBinaryHeap<Integer> test = new nBinaryHeap<Integer>(new CompHeap());
        /*test.insert(5);
        test.insert(3);
        test.insert(6);
        test.insert(2);
        test.insert(1);
        test.insert(0);
        test.insert(10);
        test.insert(12);*/
        test.insert(6);
        test.insert(5);
        test.insert(4);
        test.insert(3);
        test.insert(2);
        test.insert(1);
        test.insert(0);



        System.out.println(test.toString());
    }
}
