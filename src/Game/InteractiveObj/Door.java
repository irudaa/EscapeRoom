package Game.InteractiveObj;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class Door {

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
        doorImg = new ImageIcon(new ImageIcon("src/Images/door-146676_6401.png").getImage().getScaledInstance((int) size.getWidth(), (int) size.getHeight(), Image.SCALE_DEFAULT));;
        door = new JLabel(doorImg);
    }

    public double getX(){
        return pos.getX();
    }

    public double getY(){
        return pos.getY();
    }

    public double sizeX(){
        return size.getWidth();
    }
    public double sizeY(){
        return size.getHeight();
    }



    public ImageIcon getDoorImg(){
        return doorImg;
    }

    public JLabel returnLabel(){
        return door;
    }

    public void setDoorImg(ImageIcon img){
        doorImg = img;
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
        if(isOpened == true){
            ImageIcon doorOpen = new ImageIcon();
            //setDoorImg();
        }
    }

}
