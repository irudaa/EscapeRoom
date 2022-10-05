package Game.Inventory;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InventoryView extends JComponent{

    private ImageIcon square;
    private JLabel inventory;
    private JPanel inventorySkeleton;

    public JLabel item, item1, item2;

    //public JLabel item1;

    private Box vertical;
    public InventoryView(JPanel inventorySkeleton){
        this.inventorySkeleton = inventorySkeleton;
        vertical = Box.createVerticalBox();
        vertical.setBounds(1,2, 1200, 1000);
        inventorySkeleton.add(vertical);
        invView();
    }


    public void invView() {
        //Create inventory

        inventorySkeleton.setPreferredSize(new Dimension(100, 1000));
        ImageIcon imgSquare = new ImageIcon(new ImageIcon("src/Images/Rectangle 54.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));


        //First Item
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/Images/brass-1293947_640 1.png").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        item = new JLabel(imageIcon);
        JLabel square = new JLabel(imgSquare);
        square.setLayout(new FlowLayout());
        square.setBorder(new LineBorder(Color.BLACK));
        square.add(item);
        vertical.add(square);

        //Second item
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("src/Images/brass-1293947_640 1.png").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        item1 = new JLabel(imageIcon1);
        JLabel square1 = new JLabel(imgSquare);
        square1.setLayout(new FlowLayout());
        square1.setBorder(new LineBorder(Color.BLACK));
        square1.add(item1);
        vertical.add(square1);


        //Third item
        JLabel item3 = new JLabel("Inventory Items");
        item3.setPreferredSize(new Dimension(100, 100));
        item3.setBorder(new LineBorder(Color.BLACK));
        vertical.add(item3);

    }
}
