package Game.Inventory;

import Game.Collectibles.Key;
import Game.Collectibles.PickableObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Inventory extends JComponent implements MouseListener, MouseMotionListener{

    private int mouseX=0,mouseY=0;

    private InventoryView view;
    private InventoryModel model;

    private Point startPoint;

    private JFrame frame;

    private boolean isActivated = false;

    private JPanel panel;

    private Image img;

    private ArrayList<PickableObject> isAquired = new ArrayList<>();
    public Inventory(JPanel viewPanel, JFrame frame){
       view = new InventoryView(viewPanel, this);
       this.panel = viewPanel;
       model = new InventoryModel();
       this.frame = frame;
       initInv();
       dragKey();
    }

    public boolean isActivated(){ return isActivated;}

    public InventoryView getView(){ return view; }

    public InventoryModel getModel(){
        return model;
    }

    public ArrayList<PickableObject> getIsAquired(){ return isAquired; }

    public void addObj(PickableObject obj){
        if(obj != null){
            isAquired.add(obj);
        }
    }

public Inventory getInventory(){ return this; }

    public void setActivated(boolean act){ isActivated = act; }

    public void initInv(){
        if(isActivated == true){
            model.showItem();
        }
    }

    public void dragKey() {
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }


    public void mouseClicked( MouseEvent e ){}
    public void mousePressed( MouseEvent e ){    }
    public void mouseReleased( MouseEvent e ){}
    public void mouseEntered( MouseEvent e ){}
    public void mouseExited( MouseEvent e ){}
    public void mouseDragged( MouseEvent e ){}

    @Override
    public void mouseMoved( MouseEvent e ){
        repaint();
        mouseX=e.getX();
        mouseY=e.getY();
        repaint();
    }


    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(view.getKey().getImg().getImage(), mouseX,mouseY,
                view.getKey().getImg().getImage().getWidth(this), view.getKey().getImg().getImage().getHeight(this),this);
    }

}

