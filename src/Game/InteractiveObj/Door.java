package Game.InteractiveObj;

import Game.Collectibles.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Door {

    private JLabel openedDoorLabel;
    private ImageIcon openedDoorImg;
    private ImageIcon doorImg;

    private Point pos;
    private Dimension size;
    private boolean isOpened = false;

    private JLabel door;

    public Door(Point pos, Dimension size){

        this.pos = pos;
        this.size = size;
        doorImg = new ImageIcon(new ImageIcon("src/Images/closedDoor.png").getImage().getScaledInstance((int) size.getWidth(), (int) size.getHeight(), Image.SCALE_DEFAULT));
        door = new JLabel(doorImg);
        openedDoorImg = new ImageIcon(new ImageIcon("src/Images/openedDoor.png").getImage());
        openedDoorLabel = new JLabel(openedDoorImg);
        openedDoorLabel.setBounds(503, 101,openedDoorImg.getIconWidth()+30,openedDoorImg.getIconHeight()+30);
        openedDoorLabel.setOpaque(false);
    }

    public double getX(){
        return pos.getX();
    }

    public double getY(){
        return pos.getY();
    }

    public ImageIcon getDoorImg(){
        return doorImg;
    }

    public JLabel getClosedDoorLabel(){
        return door;
    }

    public void setDoor(JLabel label, boolean bool){
        label.setVisible(bool);
    }
    public JLabel getOpenedDoorLabel(){
        return openedDoorLabel;
    }

    public void openDoor(){
        setDoor(getOpenedDoorLabel(), true);
        setDoor(getClosedDoorLabel(), false);
    }


    public boolean contains(Point p) {
        return (door.getLocation().getX() < p.getX() && door.getLocation().getY() < p.getY() &&
                door.getLocation().getX() + door.getWidth() > p.getX()  &&
                door.getLocation().getY() + door.getHeight() > p.getY());
    }



}
