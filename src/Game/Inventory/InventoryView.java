package Game.Inventory;

import javax.swing.*;
import java.awt.*;

public class InventoryView extends JComponent{

    private ImageIcon square;
    private JLabel inventory;
    private JPanel inventorySkeleton;

    private Box vertical;
    public InventoryView(JPanel inventorySkeleton){
        this.inventorySkeleton = inventorySkeleton;
        vertical = Box.createVerticalBox();
        inventorySkeleton.add(vertical);
        invView();
    }


    public void invView() {
        //Create inventory

        inventorySkeleton.setPreferredSize(new Dimension(100, 1000));
        inventorySkeleton.setBackground(Color.lightGray);

        //First Item
        JLabel item1 = new JLabel("button1");
        item1.setMinimumSize(new Dimension(100, 100));
        vertical.add(item1);

        //Second item
        JLabel item2 = new JLabel("button2");
        item2.setPreferredSize(new Dimension(100, 100));
        vertical.add(item2);

        //Third item
        JLabel item3 = new JLabel("button3");
        item3.setPreferredSize(new Dimension(100, 100));
        vertical.add(item3);

    }
}
