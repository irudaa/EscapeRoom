package Game.Inventory;

import Game.Collectibles.PickableObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Inventory extends JComponent{
    private InventoryView view;
    private InventoryModel model;

    private boolean isActivated = false;

    private JPanel panel;
    int x_pressed = 0;
    int y_pressed = 0;


    private ArrayList<PickableObject> isAquired = new ArrayList<>();
    public Inventory(JPanel viewPanel){
       view = new InventoryView(viewPanel);
       this.panel = viewPanel;
       model = new InventoryModel();
       initInv();
       dragKey();
    }

    public boolean isActivated(){ return isActivated;}

    public ArrayList<PickableObject> getIsAquired(){ return isAquired; }

    public void addIsAquired(PickableObject obj){ isAquired.add(obj); }

    public void setActivated(boolean act){ isActivated = act; }

    public void initInv(){
        if(isActivated == true){
            model.showItem();
        }
    }

    public void dragKey(){

        view.item1.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                //and when the Jlabel is dragged
                x_pressed = e.getX();
                y_pressed = e.getY();
                view.item1.setBounds(x_pressed, y_pressed, 100, 100);            }
        });

    }

}
