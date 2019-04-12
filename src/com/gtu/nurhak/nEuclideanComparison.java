package com.gtu.nurhak;

import java.util.Comparator;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 11/Apr/2019 22:07
 ************************************************************************/

/**
 * This class compare two nPixel object according to their norm of the colors vector.
 * The color vector is, v = [R, G, B]
 * The Euclidean norm is e = (R^2 + G^2 + B^2)^(1/2)
 */
public class nEuclideanComparison implements Comparator<nPixel> {

    /**
     * Compare two nPixel object according to their norm.
     * @param left The object
     * @param right The object
     * @return 1 if the left > right, 0 if left = right, -1 if right > left.
     */
    public int compare(nPixel left, nPixel right){
        if( getNorm(left) > getNorm(right))
            return 1;
        else if ( getNorm(left) == getNorm(right))
            return 0;
        else
            return -1;
    }

    /**
     * Calculates the norrm of the color vector.
     * @param orig The vector
     * @return Norm of the vector.
     */
    private double getNorm(nPixel orig){
        return (Math.sqrt(Math.pow(orig.getRed(),2) + Math.pow(orig.getGreen(),2) + Math.pow(orig.getBlue(),2)));
    }
}
