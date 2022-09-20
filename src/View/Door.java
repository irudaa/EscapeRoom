package View;

import javax.swing.*;

public class Door {

    private ImageIcon img;
    private int x;
    private int y;
    private boolean isOpened = false;

    public Door(ImageIcon img, int x, int y){
        this.img = img;
        this.x = x;
        this.y = y;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public ImageIcon img(){
        return img;
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
