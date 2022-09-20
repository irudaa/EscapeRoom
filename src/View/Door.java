package View;

import javax.swing.*;

public class Door {

    private ImageIcon img;

    private JLabel doorImg;
    private int x;
    private int y;
    private boolean isOpened = false;

    public Door(JLabel doorImg, int x, int y){

        this.doorImg = doorImg;
        this.x = x;
        this.y = y;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public JLabel getDoorImg(){
        return doorImg;
    }

    public boolean isOpened(){
        return isOpened;
    }

    public boolean setIsOpened(boolean set){
        if(isOpened != set){
            isOpened = set;
        }
        return isOpened;
    }

}
