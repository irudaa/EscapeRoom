package View.Rooms;

import View.Door.Door;

import javax.swing.*;
import java.awt.*;

public class AngleView {

    private JPanel panel;
    private Door doorEnd;

    private ImageIcon imgDoor;
    private ImageIcon imgRoom;
    private JLabel labelDoor;
    private JLabel labelRoom;

    private JLayeredPane room;

    private JFrame frame;
    /*
    * public AngleView(JPanel panel, Frame frame){
    *          this.panel = panel;

     * }
    * */
    public AngleView(JLayeredPane room, JFrame frame){
        this.room = room;
        this.frame = frame;
        setRoom();


    }

    public Door getDoor(){
        return doorEnd;
    }

    public void addDoor(){
        System.out.println("addDoor");
        room.add(doorEnd.getDoorImg(), new Integer(0), 0);
    }

    public void addRoom(){
        System.out.println("addRoom");
        room.add(labelRoom, new Integer(1), 0);
    }


    private int getX(){
        return doorEnd.getX();
    }

    private int getY(){
        return doorEnd.getY();
    }

    public JLayeredPane pane(){
        return room;
    }

    public void setRoom(){
        //create room
        System.out.println(" set up room");
        imgRoom = new ImageIcon(new ImageIcon("src/Images/Angle 1.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        labelRoom = new JLabel(imgRoom);

        //create Door in room
        imgDoor = new ImageIcon(new ImageIcon("src/Images/door-146676_640 1.png").getImage().getScaledInstance(400,800, Image.SCALE_DEFAULT));
        labelDoor = new JLabel(imgDoor);
        doorEnd = new Door(labelDoor);

       //setup room
        addRoom();
        addDoor();

    }




}
