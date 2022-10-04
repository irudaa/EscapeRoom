package Game.Collectibles;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;

public class Object {
    private boolean isFound;

    private Dimension dim;

    private Point pos;
    private int x, y;

    public Object(Dimension dim, Point pos){

        this.dim = dim;
        this.pos = pos;
    }


    public Dimension getSize(){ return dim; }

    public Point getPos(){ return pos; }
    public boolean isFound(){ return isFound; }
    public void setFound(boolean bool){ isFound = bool; }
}
