package Game.Rooms;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Key;
import Game.Collectibles.Lighter;
import Game.Collectibles.Zoom.Zoom;
import Game.InteractiveObj.Door;
import Game.Inventory.InventoryView;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AngleView extends JComponent{

    private JPanel panel;
    private Door doorEnd;
    private JPanel room;

    private JFrame frame;

    private InventoryView inv;

    private RoomOne firstAngle;

    private RoomTwo secondAngle;

    private Key key;

    private Lighter lighter;

    private Flashlight flashlight;

    private Zoom zoom;

    private JButton next, previous;


    public AngleView(JFrame frame, InventoryView inv){
      //  this.room = room;
        this.frame = frame;
        this.inv = inv;
        addButtons();

    }

    public RoomOne startRoomOne(){
        RoomOne one = new RoomOne(frame, inv);
        return one;
    }

    public RoomTwo startRoomTwo(){
        RoomTwo two = new RoomTwo(frame, inv);
        return two;
    }

    public RoomThree startRoomThree(){
        RoomThree three = new RoomThree(frame, inv);
        return three;
    }

    public RoomFour startRoomFour(){
        RoomFour four = new RoomFour(frame, inv);
        return four;
    }



    public void addButtons(){

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/Images/rightButton.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        next = new JButton(imageIcon);
        next.setBounds(930,700, 40,40);
        next.setContentAreaFilled(false);
        next.setOpaque(false);
        next.setBorder(null);

        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/Images/leftButton.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        previous = new JButton(imageIcon2);
        previous.setBounds(10,700, 40,40);
        previous.setContentAreaFilled(false);
        previous.setOpaque(false);
        previous.setBorder(null);

    }


    public JButton getNext(){
        return next;
    }

    public JButton getPrevious(){
        return previous;
    }


    public Door getDoor(){
        return doorEnd;
    }

    private double getDoorX(){
        return doorEnd.getX();
    }

    private double getDoorY(){
        return doorEnd.getY();
    }

    public JPanel getPane(){
        return room;
    }

}
