package com.gtu.nurhak;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 09/Apr/2019 23:14
 ************************************************************************/


import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class DisplayImage {

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private BufferedImage img;
    private String path;

    public DisplayImage(String path) throws IOException
    {
        setPath(path);
        this.readImage();
        System.out.println(this.img.getWidth());
        System.out.println(this.img.getHeight());
        this.convertImagetoArray();
    }

    public void showImage(BufferedImage img){
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(img.getWidth(),img.getHeight());
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public BufferedImage readImage (){
        try{
             this.img=ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println("File ("+path+") couldn't find");
        }
        return img;
    }

    public long[][] convertImagetoArray(){

        int width = this.img.getWidth();
        int height = this.img.getHeight();

        long[][] array = new long[height][width];

        if(this.img != null){

            BufferedImage temp = this.img;

            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {

                    int p = temp.getRGB(col,row);
                    //get alpha
                    int a = (p>>24) & 0xff;

                    //get red
                    int r = (p>>16) & 0xff;

                    //get green
                    int g = (p>>8) & 0xff;

                    //get blue
                    int b = p & 0xff;

                    String encode = encodeBits(r,g,b);

                    int r_temp = getR(encode);

                    System.out.println("r= "+r+"temp = "+r_temp);

                    /*System.out.println("g= "+g+"temp = "+g_temp);
                    System.out.println("b= "+b+"temp = "+b_temp);*/

                    array[row][col] = Integer.valueOf(encode,2);
                }
            }

            return array;

        }else {
            System.out.println("image couldn read!!");
        }
        return null;
    }


    private String encodeBits(int r, int g, int b){

        StringBuilder s = new StringBuilder();
        for(int i = 0; i < 8 ; i++){
            int bitR = getBit(r,i);
            int bitG = getBit(g,i);
            int bitB = getBit(b,i);
            s.append(bitR);
            s.append(bitG);
            s.append(bitB);
        }
        System.out.println(s.toString());
        return s.toString();
    }

    private int getR(String encodeBits){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 24; i = i + 3 ){
            s.append(encodeBits.charAt(i));
        }
        System.out.println(s.toString());
        return Integer.valueOf(s.toString(),2);
    }

    private int getG(String encodeBits){
        return 0;
    }

    private int getB(String encodeBits){
        return 0;
    }

    private int getBit(int n, int k) {
        return (n >> k) & 1;
    }
}
