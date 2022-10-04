package Game.Collectibles;

import javax.swing.*;
import java.awt.*;

public class Key extends Object{

    private Dimension dim;

    private Point pos;

    private ImageIcon imageIcon;

    private JLabel label;


    public Key(Dimension dim, Point pos) {
        super(dim, pos);
        this.dim = dim;
        this.pos = pos;
        imageIcon = new ImageIcon(new ImageIcon("src/Images/brass-1293947_640 1.png").getImage().getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), Image.SCALE_DEFAULT));;
        label = new JLabel(imageIcon);
        super.setFound(false);
    }

    public ImageIcon getImg(){ return imageIcon; }

    public JLabel returnLabel(){ return label; }

    public void objectFound(){
        if(super.isFound() == true){
            label.setVisible(false);
        }
    }

}
