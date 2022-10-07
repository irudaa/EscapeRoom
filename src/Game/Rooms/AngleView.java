package Game.Rooms;

import Game.Collectibles.Key;
import Game.InteractiveObj.Door;
import Game.InteractiveObj.Mirror;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

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


    private double getX(){
        return doorEnd.getX();
    }

    private double getY(){
        return doorEnd.getY();
    }

    public JLayeredPane getPane(){
        return room;
    }

    public void setRoom(){

        //create Door room
        System.out.println("Set up room");
        imgRoom = new ImageIcon(new ImageIcon("src/Images/Angle1.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        labelRoom = new JLabel(imgRoom);
        labelRoom.setBounds(0, 0, imgRoom.getIconWidth(), imgRoom.getIconHeight());
        room.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        room.setOpaque(false);
        labelRoom.setOpaque(false);

        //create Door in room
        doorEnd = new Door(new Point(778, 210), new Dimension(250, 620));
        doorEnd.returnLabel().setBounds((int)doorEnd.getX(), (int)doorEnd.getY(), doorEnd.getDoorImg().getIconWidth(), doorEnd.getDoorImg().getIconHeight());
        doorEnd.returnLabel().setOpaque(false);

        //Create Object: Key
        Key key = new Key(new Dimension(50, 20), new Point(778, 900));
        key.returnLabel().setBounds((int)key.getPos().getX(), (int)key.getPos().getY(), (int) key.getSize().getWidth(), (int)key.getSize().getHeight());
        key.returnLabel().setOpaque(false);

        //Mirror
        Mirror mirror = new Mirror();

        //setup room
        room.add(labelRoom, 0);
        room.add(doorEnd.returnLabel(), 1);
        room.add(key.returnLabel(), 2);

        room.add(mirror, 3);


    }
}
