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

    private Key key;

    private Lighter lighter;

    private Flashlight flashlight;

    private Zoom zoom;

    private JButton next, previous;


    public AngleView(JPanel room, JFrame frame, InventoryView inv){

        this.room = room;
        this.frame = frame;
        this.inv = inv;
        key = new Key(new Dimension(50, 20), new Point(778, 900), inv);
        lighter = new Lighter(new Dimension(50, 20), new Point(200, 900), inv);
        flashlight = new Flashlight(new Dimension(50, 20), new Point(400, 100), inv);
        zoom = new Zoom(new Dimension(50, 20), new Point(200, 500), inv);

    }

    public void initialiseAngles(){
        firstAngle = new RoomOne(room, frame, inv, key, zoom, lighter, flashlight);
    }

    public void addButtons(){

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/Images/start-button.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        next = new JButton(imageIcon);
        next.setBounds(1130,500, 50,50);
        next.setOpaque(false);

        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/Images/start-button2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        previous = new JButton(imageIcon2);
        previous.setBounds(10,500, 50,50);
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
