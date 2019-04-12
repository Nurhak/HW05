package com.gtu.nurhak;

import java.util.Comparator;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 11/Apr/2019 21:49
 ************************************************************************/

/**
 * A lexicographical comparison is the kind of comparison generally used to sort words alphabetically in dictionaries; It involves comparing sequentially the elements that have the same position in both ranges against each other until one element is not equivalent to the other. The result of comparing these first non-matching elements is the result of the lexicographical comparison.
 *
 * If both sequences compare equal until one of them ends, the shorter sequence is lexicographically less than the longer one.
 *
 * The elements are compared using operator< for the first version, and comp for the second. Two elements, a and b are considered equivalent if (!(a<b) && !(b<a)) or if (!comp(a,b) && !comp(b,a)).
 */
public class nLexicographicalComparison implements Comparator<nPixel> {

    /**
     * Compares two nPixel objects lexicographically.
     * @param left The object
     * @param right The object
     * @return 1 if the left > right, 0 if left = right, -1 if right > left.
     */
    public int compare(nPixel left, nPixel right){
        return order(left,right);
    }

    /**
     * Returns the lexicographically order.
     * @param left The object
     * @param right The object
     * @return the lexicographically order
     */
    private int order(nPixel left, nPixel right){
        if(left.getRed() > right.getRed()){
            return 1;
        }else if(left.getRed() == right.getRed()){
            if(left.getGreen() > right.getGreen()){
                return 1;
            }else if(left.getGreen() == right.getGreen())
            {
                if(left.getBlue() > right.getBlue()){
                    return 1;
                }else if(left.getBlue() == right.getBlue()){
                    return 0;
                }else
                    return -1;
            }else
                return -1;
        }else
            return -1;
    }
}
