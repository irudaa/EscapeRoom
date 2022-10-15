package Game.Collectibles;

import javax.swing.*;
import java.awt.*;


public class PickableObject extends JComponent {
    private boolean isFound;

    private Dimension dim;

    private Point pos;
    private int x, y;

    public PickableObject(Dimension dim, Point pos){
        this.dim = dim;
        this.pos = pos;
    }


    public Dimension getSize(){ return dim; }

    public Point getPos(){ return pos; }
    public boolean isFound(){ return isFound; }
    public void setFound(boolean bool){ isFound = bool;}

}
