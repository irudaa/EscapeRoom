package View.Inventory;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class InventoryView {

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

        //First Button
        Button item1 = new Button("button1");
        item1.setPreferredSize(new Dimension(100, 100));
        vertical.add(item1);

    }
}
