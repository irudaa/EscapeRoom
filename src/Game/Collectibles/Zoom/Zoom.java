package Game.Collectibles.Zoom;

import Game.Collectibles.PickableObject;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Zoom extends PickableObject {


    private Dimension dim;

    private Point pos;

    ImageIcon imageIcon;

    private JLabel label;

    private InventoryView inventory;

    public Zoom(Dimension dim, Point pos, InventoryView inventory){
        super(dim, pos);
        this.dim = dim;
        this.pos = pos;
        imageIcon = new ImageIcon(new ImageIcon("src/Images/magnifying-glass-303408_640 1.png").getImage().getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), Image.SCALE_DEFAULT));
        label = new JLabel(imageIcon);
        this.inventory = inventory;
        super.setFound(false);
    }
    public ImageIcon getImg(){ return imageIcon; }

    public JLabel getLabel(){
        return label;
    }

    public void objectFound(){
        if(super.isFound() == true){
            label.setVisible(false);

        }
    }
    public void isClicked(){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
                    setFound(true);
                    objectFound();
                    inventory.getZoom().setLabelVisible(true);
                }
            }
        });
    }

    public void setLabelVisible(boolean b) {
        label.setVisible(b);
    }
}
