package Game.Rooms;

import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Angle {

    private AngleView view;
    private JFrame frame;
    private JPanel panel;

    private InventoryView inv;

    public Angle(JPanel panel, JFrame frame, InventoryView inv){
        this.frame = frame;
        this.panel = panel;
        this.inv = inv;
        view = new AngleView(panel, frame, inv);
    }

    public AngleView getView() {
        return view;
    }

    public void activateButtons(){
        view.getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.getPrevious().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



    public JPanel getPane(){
        return view.getPane();
    }

}
