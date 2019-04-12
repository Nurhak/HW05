package com.gtu.nurhak;

import java.awt.*;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 11/Apr/2019 21:16
 ************************************************************************/

/**
 * This class stores the colored image pixel values.
 */
public class nPixel implements Comparable<nPixel> {

    //Data Fields
    private int red;
    private int green;
    private int blue;

    //Constructors

    /**
     * Creates an nPixel object with the Red, Green and the Blue values.
     * @param red The Red value.
     * @param green The Green value.
     * @param blue The Blue value.
     */
    public nPixel(int red, int green, int blue) {
        setRed(red);
        setBlue(blue);
        setGreen(green);
    }

    /**
     * Returns the red value of the pixel.
     * @return The Red value of the Pixel.
     */
    public int getRed() {
        return red;
    }

    /**
     * Sets the Red value of the Pixel.
     * @param red The Red value.
     */
    public  void setRed(int red) {
        if( red <= 255 && red >= 0 )
            this.red = red;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Returns the green value of the pixel.
     * @return The Green value of the Pixel.
     */
    public int getGreen() {
        return green;
    }

    /**
     * Sets the Green value of the Pixel.
     * @param green The Green value.
     */
    public void setGreen(int green) {
        if( green <= 255 && green >= 0 )
            this.green = green;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Returns the blue value of the pixel.
     * @return The Blue value of the Pixel.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Sets the Blue value of the Pixel.
     * @param blue The Blue value.
     */
    public void setBlue(int blue) {
        if( blue <= 255 && blue >= 0 )
            this.blue = blue;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Returns the RGB value of the pixel.
     * @return The RGB value of the Pixel.
     */
    public int getRGB(){
        Color temp = new Color(getRed(), getGreen(), getBlue()); // Color white
        return temp.getRGB();
    }

    /**
     * Returns a string representation of the object.
     * @return string representation of the object.
     */
    @Override
    public String toString(){
        return ("[ " +getRed()+", "+getGreen()+", "+getBlue()+" ]");

    }

    /**
     * Compares this object with the specified object for order.
     * @return 0.
     */
    public int compareTo(nPixel o) {
        return 0;
    }
}
