package Game.InteractiveObj;

import Game.Collectibles.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Door {

    private JLabel openedDoorLabel;
    private ImageIcon openedDoorImg;
    private ImageIcon img;

    private ImageIcon doorImg;
    private int x;
    private int y;

    private Point pos;

    private Dimension size;
    private boolean isOpened = false;

    private JLabel door;

    public Door(Point pos, Dimension size){

        this.pos = pos;
        this.size = size;
        doorImg = new ImageIcon(new ImageIcon("src/Images/door-146676_6401.png").getImage().getScaledInstance((int) size.getWidth(), (int) size.getHeight(), Image.SCALE_DEFAULT));
        door = new JLabel(doorImg);

        openedDoorImg = new ImageIcon(new ImageIcon("src/Images/kindpng_207337.png").getImage().getScaledInstance((int) size.getWidth(), (int) size.getHeight(), Image.SCALE_DEFAULT));
        openedDoorLabel = new JLabel(openedDoorImg);
        openedDoorLabel.setBounds(644, 162, openedDoorImg.getIconWidth(), openedDoorImg.getIconHeight());
        openedDoorLabel.setOpaque(false);
    }

    public double getX(){
        return pos.getX();
    }

    public double getY(){
        return pos.getY();
    }

    public Point getPosition(){ return pos; }

    public Dimension getDim(){ return size; }

    public double sizeX(){
        return size.getWidth();
    }
    public double sizeY(){
        return size.getHeight();
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


    public boolean isOpened(){
        return isOpened;
    }

    public void setIsOpened(boolean set){
        if(isOpened != set){
            isOpened = set;
        }
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
