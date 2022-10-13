package Game.Inventory;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Key;
import Game.Collectibles.Lighter;
import Game.Collectibles.Zoom;
import Game.ImageSelection;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InventoryView extends JComponent{

    private ImageIcon square;
    private JLabel inventory;
    private JPanel inventorySkeleton;

    public JLabel item, item1, item2;

    private Key key;
    private Lighter lighter;
    private Zoom zoom;
    private Flashlight flashlight;

    private Inventory inv;

    private Box vertical;
    public InventoryView(JPanel inventorySkeleton, Inventory inv){
        this.inventorySkeleton = inventorySkeleton;
        vertical = Box.createVerticalBox();
        vertical.setBounds(1,2, 1200, 1000);
        inventorySkeleton.add(vertical);
        this.inv = inv;
        invView();
    }

    public JPanel getInventorySkeleton() {
        return inventorySkeleton;
    }

    public Key getKey(){ return key; }

    public Lighter getLighter(){ return lighter; }

    public Flashlight getFlashlight(){ return flashlight; }
    public Zoom getZoom(){ return zoom; }


    public void invView() {
        //Create inventory

        inventorySkeleton.setPreferredSize(new Dimension(100, 1000));
        ImageIcon imgSquare = new ImageIcon(new ImageIcon("src/Images/Rectangle 54.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));


        //First Item
        key = new Key(new Dimension(100, 50), new Point(0, 0), this);
        key.setLabelVisible(false);
        inv.addObj(key);
        JLabel square = new JLabel(imgSquare);
        square.setLayout(new FlowLayout());
        square.setBorder(new LineBorder(Color.BLACK));
        square.add(key.getLabel());
        vertical.add(square);

        //Second item
        lighter = new Lighter(new Dimension(100, 100), new Point(0, 0), this);
        lighter.setLabelVisible(false);
        inv.addObj(lighter);
        JLabel square1 = new JLabel(imgSquare);
        square1.setLayout(new FlowLayout());
        square1.setBorder(new LineBorder(Color.BLACK));
        square1.add(lighter.getLabel());
        vertical.add(square1);

        //Third item
        zoom = new Zoom(new Dimension(100, 100), new Point(0, 0), this);
        zoom.setLabelVisible(false);
        inv.addObj(zoom);
        JLabel square2 = new JLabel(imgSquare);
        square2.setLayout(new FlowLayout());
        square2.setBorder(new LineBorder(Color.BLACK));
        square2.add(zoom.getLabel());
        vertical.add(square2);


        //Fourth item
        flashlight = new Flashlight(new Dimension(100, 70), new Point(0, 0), this);
        flashlight.setLabelVisible(false);
        inv.addObj(flashlight);
        JLabel square3 = new JLabel(imgSquare);
        square3.setLayout(new FlowLayout());
        square3.setBorder(new LineBorder(Color.BLACK));
        square3.add(flashlight.getLabel());
        vertical.add(square3);

    }
}
