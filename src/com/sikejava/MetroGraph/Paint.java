package com.sikejava.MetroGraph;

import javax.swing.*;
import java.awt.*;

/********************************************************************************
 * MetroGraph -- 
 * @version 2017/06/19 17:09
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/
public class Paint extends JFrame {

    public Paint() {
        this.getContentPane().add(new MetroGraphView());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setUndecorated(false);
        this.setBackground(Color.blue);
        this.setForeground(Color.blue);
        this.setSize(1600, 1000);
        this.setVisible(true);
        this.createBufferStrategy(2);


    }

    public static void main(String[] args) {

        Paint paint = new Paint();

    }


}
