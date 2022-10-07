package Game.Rooms;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Key;
import Game.Collectibles.Lighter;
import Game.Collectibles.Zoom;
import Game.InteractiveObj.Door;
import Game.Inventory.InventoryView;

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

    private InventoryView inv;

    public AngleView(JLayeredPane room, JFrame frame, InventoryView inv){
        this.room = room;
        this.frame = frame;
        this.inv = inv;
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
        Key key = new Key(new Dimension(50, 20), new Point(778, 900), inv);
        key.isClicked();
        key.getLabel().setBounds((int)key.getPos().getX(), (int)key.getPos().getY(), (int) key.getSize().getWidth(), (int)key.getSize().getHeight());
        key.getLabel().setOpaque(false);

        //Create Object: Lighter
        Lighter lighter = new Lighter(new Dimension(50, 20), new Point(200, 900), inv);
        lighter.isClicked();
        lighter.getLabel().setBounds((int)lighter.getPos().getX(), (int)lighter.getPos().getY(), (int) lighter.getSize().getWidth(), (int)lighter.getSize().getHeight());
        lighter.getLabel().setOpaque(false);

        //Create Object: Zoom
        Zoom zoom = new Zoom(new Dimension(50, 20), new Point(200, 500), inv);
        zoom.isClicked();
        zoom.getLabel().setBounds((int)zoom.getPos().getX(), (int)zoom.getPos().getY(), (int) lighter.getSize().getWidth(), (int)zoom.getSize().getHeight());
        zoom.getLabel().setOpaque(false);

        //Create Object: Flashlight
        Flashlight flashlight = new Flashlight(new Dimension(50, 20), new Point(400, 1000), inv);
        flashlight.isClicked();
        flashlight.getLabel().setBounds((int)flashlight.getPos().getX(), (int)flashlight.getPos().getY(), (int)flashlight.getSize().getWidth(), (int)zoom.getSize().getHeight());
        flashlight.getLabel().setOpaque(false);


        //setup room
        room.add(labelRoom, new Integer(0));
        room.add(doorEnd.returnLabel(), new Integer(1));
        room.add(key.getLabel(), new Integer(2));
        room.add(lighter.getLabel(), new Integer(3));
        room.add(zoom.getLabel(), new Integer(4));


    }



}
