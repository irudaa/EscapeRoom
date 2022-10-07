package Game.Rooms;

import Game.Inventory.InventoryView;

import javax.swing.*;

public class Angle {

    private AngleView view;
    private JFrame frame;
    private JLayeredPane pane;

    private InventoryView inv;

    public Angle(JLayeredPane pane, JFrame frame, InventoryView inv){
        this.frame = frame;
        this.pane = pane;
        this.inv = inv;
        view = new AngleView(pane, frame, inv);
    }

    public JLayeredPane getPane(){
        return view.getPane();
    }

}
