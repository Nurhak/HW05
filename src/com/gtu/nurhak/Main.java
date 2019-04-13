package com.gtu.nurhak;


import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Main {

    private static int count_PQLEX=100;
    private static int count_PQEUC=100;
    private static int count_PQBMX=100;

    public static synchronized void incountPQLEX(){
        count_PQLEX--;
    }

    public static synchronized void incountPQBMX(){
       count_PQBMX--;

    }

    public static synchronized void incountPQEUC(){
        count_PQEUC--;
    }


    public static void main(String[] args) {


            System.out.print("Please enter the color image file path: ");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();

            nPriorityQueue<nPixel> PQLEX = new nPriorityQueue<>(new nLexicographicalComparison());
            nPriorityQueue<nPixel> PQEUC = new nPriorityQueue<>(new nEuclideanComparison());
            nPriorityQueue<nPixel> PQBMX = new nPriorityQueue<>(new nBitMixComparison());
            nPixel[][] image;


            String path = s;
            nConvertImage2Array array = new nConvertImage2Array(path);
            image = array.getArray();

            int height = array.getHeight();
            int width = array.getWidth();


            BufferedImage imagePQLEX = new BufferedImage(array.getWidth(), array.getHeight(), array.getImageType());
            nDisplayImage dispPQLEX = new nDisplayImage("PQLEX", height, width);

            BufferedImage imagePQEUC = new BufferedImage(array.getWidth(), array.getHeight(), array.getImageType());
            nDisplayImage dispPQEUC = new nDisplayImage("PQEUC", height, width);

            BufferedImage imagePQBMX = new BufferedImage(array.getWidth(), array.getHeight(), array.getImageType());
            nDisplayImage dispPQBMX = new nDisplayImage("PQBMX", height, width);


            Thread add = new Thread(new Runnable() {

                Thread remove_PQLEX = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                synchronized (PQLEX) {
                                    if (PQLEX.isEmpt()) {
                                        try {
                                            PQLEX.wait();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        nPixel temp = PQLEX.remove();
                                        System.out.println("Thread " + remove_PQLEX.getId() + "-PQLEX[removing] : " + temp.toString());
                                        PQLEX.notify();
                                        imagePQLEX.setRGB(j, i, temp.getRGB());
                                        dispPQLEX.showImage(imagePQLEX);
                                    }
                                }
                            }
                        }
                    }
                });


                Thread remove_PQEUC = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                synchronized (PQEUC) {
                                    if (PQEUC.isEmpt()) {
                                        try {
                                            PQEUC.wait();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        nPixel temp = PQEUC.remove();
                                        System.out.println("Thread " + remove_PQEUC.getId() + "-PQEUC[removing] : " + temp.toString());
                                        PQEUC.notify();
                                        imagePQEUC.setRGB(j, i, temp.getRGB());
                                        dispPQEUC.showImage(imagePQEUC);
                                    }
                                }
                            }
                        }
                    }
                });

                Thread remove_PQBMX = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                synchronized (PQBMX) {
                                    if (PQBMX.isEmpt()) {
                                        try {
                                            PQBMX.wait();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        nPixel temp = PQBMX.remove();
                                        System.out.println("Thread " + remove_PQBMX.getId() + "-PQBMX[removing] : " + temp.toString());
                                        PQBMX.notify();
                                        imagePQBMX.setRGB(j, i, temp.getRGB());
                                        dispPQBMX.showImage(imagePQBMX);
                                    }
                                }
                            }
                        }
                    }
                });


                @Override
                public void run() {
                    synchronized (PQLEX) {
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                PQLEX.offer(image[i][j]);
                                System.out.println("Thread 1 PQLEX[inserting] :" + image[i][j].toString());
                                incountPQLEX();
                                if (count_PQLEX == 0) {
                                    //removing thread starts.
                                    remove_PQLEX.start();
                                }
                                PQLEX.notify();
                            }
                        }
                    }
                    synchronized (PQBMX) {
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                PQBMX.offer(image[i][j]);
                                System.out.println("Thread 1 PQBMX[inserting] :" + image[i][j].toString());
                                incountPQBMX();
                                if (count_PQBMX == 0) {
                                    //removing thread starts.
                                    remove_PQBMX.start();
                                }
                                PQBMX.notify();
                            }
                        }
                    }

                   synchronized (PQEUC) {
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                PQEUC.offer(image[i][j]);
                                System.out.println("Thread 1 PQEUC[inserting] :" + image[i][j].toString());
                                incountPQEUC();
                                if (count_PQEUC == 0) {
                                    //removing thread starts.
                                    remove_PQEUC.start();
                                }
                                PQEUC.notify();
                            }
                        }
                    }

                }
            });


            // The adding to priority queue thread
            add.start();


           // If the CPU is not enough power to print images real-time this code snippet could be run. This code prints image after processed.
           /* try {
            add.join();
            dispPQBMX.showImage(imagePQBMX);
            dispPQEUC.showImage(imagePQEUC);
            dispPQLEX.showImage(imagePQLEX);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

}
