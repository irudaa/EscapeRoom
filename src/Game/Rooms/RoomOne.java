package Game.Rooms;

import Game.Collectibles.Zoom.Zoom;
import Game.InteractiveObj.Computer.Computer;
import Game.InteractiveObj.Door;
import Game.InteractiveObj.Drawer;
import Game.InteractiveObj.Switch;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;

public class RoomOne{

    private JPanel panel1;
    private Door doorEnd;
    private ImageIcon imgRoom;
    private JLabel labelRoom;
    private Drawer drawer;
    private JLayeredPane room;
    private JFrame frame;
    private Zoom zoom;
    private InventoryView inv;
    private Computer computer;
    private Switch switchStart;

    public RoomOne(JFrame frame, InventoryView inv) {
        CardLayout cardLayout = new CardLayout();
        panel1 = new JPanel(cardLayout);
        panel1.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        panel1.setOpaque(false);
        this.frame = frame;
        this.inv = inv;
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

        //
        doorEnd = new Door(new Point(644, 162), new Dimension(201, 436));
        doorEnd.getClosedDoorLabel().setBounds((int)doorEnd.getX(), (int)doorEnd.getY(), doorEnd.getDoorImg().getIconWidth(), doorEnd.getDoorImg().getIconHeight());
        doorEnd.setDoor(doorEnd.getOpenedDoorLabel(), false);
        doorEnd.getClosedDoorLabel().setOpaque(false);


        //Create Object: Zoom
        zoom.isClicked();
        zoom.getLabel().setBounds((int)zoom.getPos().getX(), (int)zoom.getPos().getY(), (int) zoom.getSize().getWidth(), (int)zoom.getSize().getHeight());
        zoom.getLabel().setOpaque(false);

       //setup Drawer
        drawer = new Drawer();
        drawer.setDrawer(drawer.getOpenedDrawerLabel(), false);
        
        //setup Computer
        computer = new Computer();

        //turn on Switch
        switchStart = new Switch();

        //setup room
        room.add(labelRoom, new Integer(0));
        room.add(doorEnd.getClosedDoorLabel(), new Integer(1));
        room.add(drawer.getOpenedDrawerLabel(), new Integer(1));
        room.add(doorEnd.getOpenedDoorLabel(), new Integer(1));
        room.add(switchStart.getClosedSwitchLabel(), new Integer(1));
        room.add(zoom.getLabel(), new Integer(2));
        room.add(drawer.getClosedDrawerLabel(), new Integer(3));
        room.add(computer.getComputerLabel(), new Integer(4));

        panel1.add(room);
    }

    public Drawer getDrawer(){ return drawer; }

    public Door getDoor(){ return doorEnd; }
    public JPanel getPanel(){return panel1;}
    public JLayeredPane getRoom(){ return room; }

    public Computer getComputer() {
        return computer;
    }

    public Switch getSwitch() {
        return switchStart;
    }


}
