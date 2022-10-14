package Game.Collectibles;

import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usb extends PickableObject{


    private Dimension dim;

    private Point pos;

    private ImageIcon imageIcon;

    private JLabel label;

    private InventoryView inventory;


    public Usb(Dimension dim, Point pos, InventoryView inventory) {
        super(dim, pos);
        this.dim = dim;
        this.pos = pos;
        imageIcon = new ImageIcon(new ImageIcon("src/Images/usb-47552_640 1.png").getImage().getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), Image.SCALE_DEFAULT));
        label = new JLabel(imageIcon);
        super.setFound(false);
        this.inventory = inventory;

    }

    public Dimension getDim(){ return dim; }

    public Point getPos(){ return pos; }

    public ImageIcon getImg(){ return imageIcon; }

    public JLabel getLabel(){ return label; }

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
                    inventory.getUsb().setLabelVisible(true);
                }
            }
        });
    }

    public void setLabelVisible(boolean b) {
        label.setVisible(b);
    }
}
