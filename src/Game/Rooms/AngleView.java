package Game.Rooms;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Key;
import Game.Collectibles.Lighter;
import Game.Collectibles.Zoom;
import Game.InteractiveObj.Door;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;

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



    public void addButtons(){

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/Images/start-button.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        next = new JButton(imageIcon);
        next.setBounds(930,400, 50,50);
        next.setOpaque(false);

        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/Images/start-button2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        previous = new JButton(imageIcon2);
        previous.setBounds(10,400, 50,50);
        previous.setOpaque(false);

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
