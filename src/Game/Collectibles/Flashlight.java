package Game.Collectibles;

import javax.swing.*;
import java.awt.*;

public class Flashlight extends Object {


    private Dimension dim;

    private Point pos;

    ImageIcon imageIcon;

    private JLabel label;

    public Flashlight(Dimension dim, Point pos) {
        super(dim, pos);
        this.dim = dim;
        this.pos = pos;
        this.imageIcon = new ImageIcon();
        label = new JLabel(imageIcon);
    }

    public ImageIcon getImg(){ return imageIcon; }

    public JLabel returnLabel(){
        return label;
    }

}
