package com.gtu.nurhak;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/************************************************************************
 * Created by Nurhak ALTIN
 * Name of the Project: HW05
 * Package: com.gtu.nurhak  
 * TimeStamp: 12/Apr/2019 21:55
 ************************************************************************/


/**
 * This class display a BufferedImage.
 */
public class nDisplayImage {

    //Data Fields
    private ImageIcon icon;
    private JFrame frame;
    private JLabel lbl;
    private JLabel txt;


    //Constructors

    /**
     * Create a nDisplayImage object.
     * @param label The title of the Frame
     * @param height
     * @param width
     */
    public nDisplayImage(String label, int height, int width){
        this.icon = new ImageIcon();
        this.frame = new JFrame();
        frame.setSize(width,height);
        this.frame.setLayout(new FlowLayout());
        this.lbl = new JLabel();
        this.frame.setTitle(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Display an image.
     * @param img The image that will be displayed.
     */
    public  void showImage(BufferedImage img){
        this.icon.setImage(img);
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.repaint();
    }
}
