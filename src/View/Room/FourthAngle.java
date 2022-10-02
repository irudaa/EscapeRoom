package View.Room;

import View.Door.Door;

import javax.swing.*;
import java.awt.*;

public class FourthAngle{

    private JPanel panel;
    private Door doorEnd;

    private ImageIcon imgDoor;
    private ImageIcon imgRoom;
    private JLabel labelDoor;
    private JLabel labelRoom;

    public FourthAngle(JPanel panel, ImageIcon imgDoor, ImageIcon imgRoom){
        this.panel = panel;
        this.imgDoor = imgDoor;
        labelDoor = new JLabel(imgDoor);
        doorEnd = new Door(labelDoor);
        this.imgRoom = imgRoom;
        labelRoom = new JLabel(imgRoom);


    }

    public Door getDoor(){
        return doorEnd;
    }

    public void addDoor(){
        panel.add(doorEnd.getDoorImg(), BorderLayout.CENTER);
    }

    public void addRoom(){
        panel.add(labelRoom, BorderLayout.CENTER);
    }


    private int getX(){
        return doorEnd.getX();
    }

    private int getY(){
        return doorEnd.getY();
    }

    public JPanel panel(){
        return panel;
    }




}
