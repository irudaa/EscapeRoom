package Game.Inventory;

import Game.Collectibles.Key;
import Game.Collectibles.PickableObject;
import Game.InteractiveObj.Computer.ComputerFrame;
import Game.InteractiveObj.NewsPaper.Newspaper;
import Game.InteractiveObj.NewsPaper.NewspaperFrame;
import Game.InteractiveObj.Safe.SafeFrame;
import Game.Main.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
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

    private Point location, location1, location2;

    private int x, y, x1, y1, x2, y2;


    private ArrayList<PickableObject> isAquired = new ArrayList<>();
    private JLabel usbLabel;

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
       dragZoom();
       dragUsb();
    }

    public void createTemporaryVersion(){
        //key
        ImageIcon imageIcon = view.getKey().getImg();
        keyLabel = new JLabel(imageIcon);

        //flashlight
        ImageIcon imageIcon2 = view.getFlashlight().getImg();
        flashlightLabel = new JLabel(imageIcon2);

        //zoom
        ImageIcon imageIcon3 = view.getZoom().getImg();
        zoomLabel = new JLabel(imageIcon3);

        //lighter
        ImageIcon imageIcon4 = view.getLighter().getImg();
        lighterLabel = new JLabel(imageIcon4);

        //usb
        ImageIcon imageIcon5 = view.getUsb().getImg();
        usbLabel = new JLabel(imageIcon5);

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
                location = view.getKey().getLabel().getLocation();
                x= location.x -pressed1.getY()+ e.getX() ;
                y= location.y -pressed1.getY() + e.getY();
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
                if(mainView.getAngleClass().getFirstAngle().getDoor().contains(new Point(x, y))){
                    mainView.getAngleClass().getFirstAngle().getDoor().openDoor();
                }
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
                location1 = view.getLighter().getLabel().getLocation();
                x1= location1.x - pressed2.getY()+ event.getX() ;
                y1= location1.y - pressed2.getY() + event.getY() + 85;
                lighterLabel.setBounds(x1, y1, view.getLighter().getImg().getIconWidth(), view.getLighter().getImg().getIconHeight());
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

                if(mainView.getAngleClass().getSecondAngle().getNewspaper().contains(new Point(x1, y1))) {
                    JFrame newspaperFrame = new JFrame();
                    newspaperFrame.setSize(800, 420);
                    newspaperFrame.setVisible(true);
                    newspaperFrame.setLocationRelativeTo(null);
                    try {
                        new NewspaperFrame(newspaperFrame);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public void dragZoom(){
        view.getZoom().getLabel().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                // super.mouseDragged(e);
                zoomLabel.setVisible(true);
                Point location = view.getZoom().getLabel().getLocation();
                int x= location.x - pressed2.getY()+ event.getX()-15;
                int y= location.y - pressed2.getY() + event.getY() + 170;
                zoomLabel.setBounds(x, y, view.getZoom().getImg().getIconWidth(), view.getZoom().getImg().getIconHeight());
                zoomLabel.setOpaque(false);
                mainView.getPane().add(zoomLabel, new Integer(2));
                view.getZoom().getLabel().setVisible(false);
            }
        });

        view.getZoom().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                pressed2 = event;
            }
        });

        view.getZoom().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                zoomLabel.setVisible(false);
                view.getZoom().getLabel().setVisible(true);

            }
        });
    }

    public void dragUsb(){
        view.getUsb().getLabel().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                // super.mouseDragged(e);
                usbLabel.setVisible(true);
                location2 = view.getUsb().getLabel().getLocation();
                x2= location2.x - pressed2.getY()+ event.getX();
                y2= location2.y - pressed2.getY() + event.getY() + 400;
                usbLabel.setBounds(x2, y2, view.getUsb().getImg().getIconWidth(), view.getUsb().getImg().getIconHeight());
                usbLabel.setOpaque(false);
                mainView.getPane().add(usbLabel, new Integer(2));
                view.getUsb().getLabel().setVisible(false);
            }
        });

        view.getUsb().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                pressed2 = event;
            }
        });

        view.getUsb().getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                usbLabel.setVisible(false);
                view.getUsb().getLabel().setVisible(true);
                if(mainView.getAngleClass().getFirstAngle().getComputer().contains(new Point(x2, y2))) {
                    JFrame compFrame = new JFrame();
                    compFrame.setSize(800, 600);
                    compFrame.setVisible(true);
                    compFrame.setLocationRelativeTo(null);
                    try {
                        new ComputerFrame(compFrame);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }



}

