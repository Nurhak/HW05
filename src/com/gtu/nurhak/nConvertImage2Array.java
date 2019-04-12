package com.gtu.nurhak;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 09/Apr/2019 23:14
 ************************************************************************/


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * This class read an image from the path and converts its to the nPixel type 2D array.
 */
public class nConvertImage2Array {

    //Data Fields
    private String path;

    private BufferedImage img;

    private int width;
    private int height;

    private nPixel[][] array;

    private int imageType;


    //Constructors

    /**
     * Creates an nConvertImage2Array with a image file path and convert to 2D array.
     * @param path The image file path.
     */
    public nConvertImage2Array(String path) {
        setPath(path);
        readImage();
        setHeight();
        setWidth();
        setImageType();
        convertImage2Array();
    }

    /**
     * Returns the image type.
     * @return
     */
    public int getImageType() {
        return imageType;
    }

    /**
     * Sets the image type.
     */
    public void setImageType() {
        this.imageType = this.img.getType();
    }

    /**
     * Returns 2D nPixel array.
     * @return 2D nPixel array.
     */
    public nPixel[][] getArray() {
        return array;
    }

    /**
     * Returns the image path.
     * @return the image path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the image path.
     * @param path the image path.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Returns the image width.
     * @return the image width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the image width.
     */
    public void setWidth() {
        this.width = this.img.getWidth();
    }

    /**
     * Returns the image height.
     * @return the image height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the image height.
     */
    public void setHeight() {
        this.height = this.img.getHeight();
    }


    /**
     * Returns the read BufferedImage.
     * @return the read BufferedImage.
     */
    public BufferedImage readImage (){
        try{
             this.img=ImageIO.read(new File(path));
        }catch (IOException e){
            return null;
        }
        return img;
    }


    /**
     * Converts Buffered Image to the 2D nPixel array.
     * @return the 2D nPixel array.
     */
    public nPixel[][] convertImage2Array(){

        this.array = new nPixel[height][width];

        if(this.img != null){

            BufferedImage temp = this.img;

            for (int row = 0; row < this.height; row++) {
                for (int col = 0; col < this.width; col++) {

                    int p = temp.getRGB(col,row);
                    //get alpha
                    int a = (p>>24) & 0xff;

                    //get red
                    int r = (p>>16) & 0xff;

                    //get green
                    int g = (p>>8) & 0xff;

                    //get blue
                    int b = p & 0xff;

                    array[row][col] = new nPixel(r,g,b);
                }
            }

            return array;

        }else {
            return null;
        }
    }

}
