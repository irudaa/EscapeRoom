package Game.Collectibles;

import javax.swing.*;
import java.awt.*;

public class Lighter extends Object{


    private Dimension dim;

    private Point pos;

    ImageIcon imageIcon;

    private JLabel label;

    public Lighter(Dimension dim, Point pos) {
        super(dim, pos);
        this.dim = dim;
        this.pos = pos;
        imageIcon = new ImageIcon();
        label = new JLabel(imageIcon);
    }
    public ImageIcon getImg(){ return imageIcon; }

}
