package com.gtu.nurhak;

import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here

        nPriorityQueue<Integer> test = new nPriorityQueue<>();
        /*test.insert(5);
        test.insert(3);
        test.insert(6);
        test.insert(2);
        test.insert(1);
        test.insert(0);
        test.insert(10);
        test.insert(12);*/


        String path = "/Users/nurhakaltin/Downloads/HW_05_Files/example.png";

        try {

            DisplayImage abc = new DisplayImage(path);
        }catch (IOException e){
            System.out.println("kjsadnkjansd");
        }

        System.out.println(test.toString());
    }
}
