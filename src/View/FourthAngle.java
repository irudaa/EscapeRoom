package View;

import javax.swing.*;
import java.awt.*;

public class FourthAngle{

    private JFrame frame;
    private Door doorEnd;

    private ImageIcon img;
    private JLabel doorImg;

    public FourthAngle(JFrame frame){
        this.frame = frame;
        img = new ImageIcon(new ImageIcon("src/Images/aec41238a8d1302599ef086d0ce9d388.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        JLabel doorImg = new JLabel(img);
        doorEnd = new Door(doorImg, 5, 6);
        frame.add(doorEnd.getDoorImg());
    }

    private Door getDoor(){
        return doorEnd;
    }

    private int getX(){
        return doorEnd.getX();
    }

    private int getY(){
        return doorEnd.getY();
    }

    private JFrame getFrame(){
        return frame;
    }




}
