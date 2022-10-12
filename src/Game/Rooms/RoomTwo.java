package Game.Rooms;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Key;
import Game.Collectibles.Lighter;
import Game.Collectibles.Zoom;
import Game.InteractiveObj.Door;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;

public class RoomTwo extends JPanel{

    private JPanel panel2;

    private ImageIcon imgRoom;
    private JLabel labelRoom;
    private JLayeredPane room;
    private JFrame frame;

    private Lighter lighter;
    private Flashlight flashlight;
    private InventoryView inv;
    public RoomTwo(JFrame frame, InventoryView inv) {
        CardLayout cardLayout = new CardLayout();
        panel2 = new JPanel(cardLayout);
        panel2.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        panel2.setOpaque(false);
        this.frame = frame;
        this.inv = inv;
        lighter = new Lighter(new Dimension(50, 20), new Point(200, 900), inv);
        flashlight = new Flashlight(new Dimension(50, 20), new Point(400, 100), inv);
        room = new JLayeredPane();
        setRoomTwo();
    }

    public void setRoomTwo(){

        //create Door room
        imgRoom = new ImageIcon(new ImageIcon("src/Images/Room2.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        labelRoom = new JLabel(imgRoom);
        labelRoom.setBounds(0, 0, imgRoom.getIconWidth(), imgRoom.getIconHeight());
        room.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        room.setOpaque(false);
        labelRoom.setOpaque(false);

        //Create Object: Lighter
        lighter.isClicked();
        lighter.getLabel().setBounds((int)lighter.getPos().getX(), (int)lighter.getPos().getY(), (int) lighter.getSize().getWidth(), (int)lighter.getSize().getHeight());
        lighter.getLabel().setOpaque(false);

        //Create Object: Flashlight
        flashlight.isClicked();
        flashlight.getLabel().setBounds((int)flashlight.getPos().getX(), (int)flashlight.getPos().getY(), (int)flashlight.getSize().getWidth(), (int)flashlight.getSize().getHeight());
        flashlight.getLabel().setOpaque(false);

        //setup room
        room.add(labelRoom, new Integer(0));
        room.add(lighter.getLabel(), new Integer(2));
        room.add(flashlight.getLabel(), new Integer(4));

        panel2.add(room);

    }

    public JLayeredPane getRoom(){ return room; }

    public JPanel getPanel(){return panel2;}


}
