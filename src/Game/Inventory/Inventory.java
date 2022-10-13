package Game.Inventory;

import Game.Collectibles.Key;
import Game.Collectibles.PickableObject;
import Game.Main.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Inventory extends JComponent{

    private int mouseX=0,mouseY=0;

    private InventoryView view;
    private InventoryModel model;

    private Point startPoint;

    private JFrame frame;

    private boolean isActivated = false;

    private MainView mainView;

    private JPanel panel;

    private Image img;
    private MouseEvent pressed1;
    private MouseEvent pressed2;


    private JLabel keyLabel;
    private JLabel flashlightLabel;

    private JLabel zoomLabel;
    private JLabel lighterLabel;


    private ArrayList<PickableObject> isAquired = new ArrayList<>();

    public Inventory(JPanel viewPanel, JFrame frame, MainView mainView){
       view = new InventoryView(viewPanel, this);
       this.panel = viewPanel;
       model = new InventoryModel();
       this.frame = frame;
       this.mainView = mainView;

       initInv();
       createTemporaryVersion();
       dragKey();
       dragFlashlight();
       dragLighter();
    }

    public void createTemporaryVersion(){
        //key
        ImageIcon imageIcon = view.getKey().getImg();
        keyLabel = new JLabel(imageIcon);

        //flashlight
        ImageIcon imageIcon2 = view.getFlashlight().getImg();
        flashlightLabel = new JLabel(imageIcon2);

        //zoom
        ImageIcon imageIcon3 = view.getFlashlight().getImg();
        zoomLabel = new JLabel(imageIcon3);

        //lighter
        ImageIcon imageIcon4 = view.getLighter().getImg();
        lighterLabel = new JLabel(imageIcon4);

    }


    public InventoryView getView(){ return view; }



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

    public void dragKey(){
        view.getKey().getLabel().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
             //   super.mouseDragged(e);
                keyLabel.setVisible(true);
                Point location = view.getKey().getLabel().getLocation();
                int x= location.x -pressed1.getY()+ e.getX() ;
                int y= location.y -pressed1.getY() + e.getY();
                keyLabel.setBounds(x, y, view.getKey().getImg().getIconWidth(), view.getKey().getImg().getIconHeight());
                keyLabel.setOpaque(false);
                mainView.getPane().add(keyLabel, new Integer(2));
                view.getKey().getLabel().setVisible(false);
            }
        });

        view.getKey().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressed1 = e;
            }
        });

        view.getKey().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                keyLabel.setVisible(false);
                view.getKey().getLabel().setVisible(true);

            }
        });
    }

    public void dragFlashlight(){
        view.getFlashlight().getLabel().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
               // super.mouseDragged(e);
                flashlightLabel.setVisible(true);
                Point location = view.getFlashlight().getLabel().getLocation();
                int x= location.x - pressed2.getY()+ event.getX() ;
                int y= location.y - pressed2.getY() + event.getY() + 300;
                System.out.println("x: " +x + ",y :" + y);
                flashlightLabel.setBounds(x, y, view.getFlashlight().getImg().getIconWidth(), view.getFlashlight().getImg().getIconHeight());
                flashlightLabel.setOpaque(false);
                mainView.getPane().add(flashlightLabel, new Integer(2));
                view.getFlashlight().getLabel().setVisible(false);
            }
        });

        view.getFlashlight().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                pressed2 = event;
            }
        });

        view.getFlashlight().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                flashlightLabel.setVisible(false);
                view.getFlashlight().getLabel().setVisible(true);

            }
        });
    }

    public void dragLighter(){
        view.getLighter().getLabel().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                // super.mouseDragged(e);
                lighterLabel.setVisible(true);
                Point location = view.getLighter().getLabel().getLocation();
                int x= location.x - pressed2.getY()+ event.getX() ;
                int y= location.y - pressed2.getY() + event.getY() + 85;
                System.out.println("x: " +x + ",y :" + y);
                lighterLabel.setBounds(x, y, view.getLighter().getImg().getIconWidth(), view.getLighter().getImg().getIconHeight());
                lighterLabel.setOpaque(false);
                mainView.getPane().add(lighterLabel, new Integer(2));
                view.getLighter().getLabel().setVisible(false);
            }
        });

        view.getLighter().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                pressed2 = event;
            }
        });

        view.getLighter().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lighterLabel.setVisible(false);
                view.getLighter().getLabel().setVisible(true);

            }
        });
    }

}

