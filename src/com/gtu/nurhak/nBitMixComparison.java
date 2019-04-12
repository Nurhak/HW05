package com.gtu.nurhak;

import java.util.Comparator;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 08/Apr/2019 23:15
 ************************************************************************/

/**
 * This class compare two nPixel object according to bitmix comparison which explained in the following paper.
 * @see <a href="https://www.researchgate.net/publication/262401144_Total_ordering_based_on_space_filling_curves_for_multivalued_morphology">TOTAL ORDERING BASED ON SPACE FILLING CURVES
 * FOR MULTIVALUED MORPHOLOGY</a>
 */
public class nBitMixComparison implements Comparator<nPixel> {

    /**
     * Compare two nPixel objects according to bitmix comparison.
     * @param left The object
     * @param right The object
     * @return 1 if the left > right, 0 if left = right, -1 if right > left.
     */
    public int compare(nPixel left, nPixel right){
        if(getEncode(left) > getEncode(right))
            return 1;
        else if (getEncode(left) == getEncode(right))
            return 0;
        else
            return -1;
    }

    /**
     * Returns the mixed bits of Red, Green and Blue values.
     * @param orig The nPixel object.
     * @return The mixed bits.
     */
    private int getEncode(nPixel orig){
        int encode = 0x0000;
         for(int k = 7 ; k >=0 ; k--){
             encode = encode | (orig.getRed() >> k) & 1;
             encode = (encode << 1) | (orig.getGreen() >> k) & 1;
             encode = (encode << 1) | (orig.getBlue() >> k) & 1;
             if(k != 0)
                 encode = encode << 1;
         }
         return encode;
    }

    /**
     * Get the Red value from the mixed bits.
     * @param encodeBits The mixed value.
     * @return The Red value.
     */
     private int getR(int encodeBits){
        int temp = 0x00;
        int count = 0;
        for(int i = 23; i >= 0 ; i = i-3){
            count++;
            temp = temp | (encodeBits >> i) & 1;
            if(count != 8)
                temp = temp << 1;
        }
        return temp;
    }

    /**
     * Get the Green value from the mixed bits.
     * @param encodeBits The mixed value.
     * @return The Green value.
     */
    private int getG(int encodeBits){
        int temp = 0x00;
        int count = 0;
        for(int i = 22; i >= 0 ; i = i-3){
            count++;
            temp = temp | (encodeBits >> i) & 1;
            if(count != 8)
                temp = temp << 1;
        }
        return temp;
    }

    /**
     * Get the Blue value from the mixed bits.
     * @param encodeBits The mixed value.
     * @return The Blue value.
     */
    private int getB(int encodeBits){
        int temp = 0x00;
        int count = 0;
        for(int i = 21; i >= 0 ; i = i-3){
            count++;
            temp = temp | (encodeBits >> i) & 1;
            if(count != 8)
                temp = temp << 1;
        }
        return temp;
    }
}
