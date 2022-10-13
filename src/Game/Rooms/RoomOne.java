package Game.Rooms;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Key;
import Game.Collectibles.Lighter;
import Game.Collectibles.Zoom;
import Game.InteractiveObj.Door;
import Game.InteractiveObj.Drawer;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;

public class RoomOne{

    private JPanel panel1;
    private Door doorEnd;

    private ImageIcon imgDoor;
    private ImageIcon imgRoom;
    private JLabel labelDoor;
    private JLabel labelRoom;

    private Drawer drawer;
    private JLayeredPane room;
    private JFrame frame;

    private Key key;
    private Zoom zoom;
    private Lighter lighter;
    private Flashlight flashlight;
    private InventoryView inv;

    public RoomOne(JFrame frame, InventoryView inv) {
        CardLayout cardLayout = new CardLayout();
        panel1 = new JPanel(cardLayout);
        panel1.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        panel1.setOpaque(false);
        this.frame = frame;
        this.inv = inv;
        key = new Key(new Dimension(50, 20), new Point(200, 500), inv);
        zoom = new Zoom(new Dimension(50, 20), new Point(330, 520), inv);
        room = new JLayeredPane();
        setRoomOne();
    }

    public void setRoomOne(){
    System.out.println("enter");
        //create Door room
        imgRoom = new ImageIcon(new ImageIcon("src/Images/Room1.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        labelRoom = new JLabel(imgRoom);
        labelRoom.setBounds(0, 0, imgRoom.getIconWidth(), imgRoom.getIconHeight());
        room.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        room.setOpaque(false);
        labelRoom.setOpaque(false);

        //create Door in room
        doorEnd = new Door(new Point(644, 162), new Dimension(201, 436));
        doorEnd.returnLabel().setBounds((int)doorEnd.getX(), (int)doorEnd.getY(), doorEnd.getDoorImg().getIconWidth(), doorEnd.getDoorImg().getIconHeight());
        doorEnd.returnLabel().setOpaque(false);

        //Create Object: Key
        key.isClicked();
        key.getLabel().setBounds((int)key.getPos().getX(), (int)key.getPos().getY(), (int) key.getSize().getWidth(), (int)key.getSize().getHeight());
        key.getLabel().setOpaque(false);

        //Create Object: Zoom
        zoom.isClicked();
        zoom.getLabel().setBounds((int)zoom.getPos().getX(), (int)zoom.getPos().getY(), (int) zoom.getSize().getWidth(), (int)zoom.getSize().getHeight());
        zoom.getLabel().setOpaque(false);

       //setup Drawer
        drawer = new Drawer();
        drawer.setDrawer(drawer.getOpenedDrawerLabel(), false);

        //setup room
        room.add(labelRoom, new Integer(0));
        room.add(doorEnd.returnLabel(), new Integer(1));
        room.add(drawer.getOpenedDrawerLabel(), new Integer(1));

        room.add(zoom.getLabel(), new Integer(2));
        room.add(drawer.getClosedDrawerLabel(), new Integer(3));
      //  room.add(drawer.getOpenedDrawerLabel(), new Integer(1));
        room.add(key.getLabel(), new Integer(4));



        panel1.add(room);
    }

    public JLabel getLabelRoom() {
        return labelRoom;
    }

    public Drawer getDrawer(){ return drawer; }

    public JPanel getPanel(){return panel1;}
    public JLayeredPane getRoom(){ return room; }
}
