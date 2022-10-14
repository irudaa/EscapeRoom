package Game.Rooms;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Lighter;
import Game.InteractiveObj.Closet;
import Game.InteractiveObj.Mirror.Mirror;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;

public class RoomThree {
    private JPanel panel3;

    private ImageIcon imgRoom;
    private JLabel labelRoom;
    private JLayeredPane room;
    private JFrame frame;

    private Lighter lighter;
    private InventoryView inv;
    private Mirror mirror;
    private Closet closet;

    public RoomThree(JFrame frame, InventoryView inv) {
        CardLayout cardLayout = new CardLayout();
        panel3 = new JPanel(cardLayout);
        panel3.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        panel3.setOpaque(false);
        this.frame = frame;
        this.inv = inv;
        lighter = new Lighter(new Dimension(50, 50), new Point(150, 530), inv);
        room = new JLayeredPane();
        setRoomThree();
    }

    public void setRoomThree(){

        //create Door room
        imgRoom = new ImageIcon(new ImageIcon("src/Images/Angle 22.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        labelRoom = new JLabel(imgRoom);
        labelRoom.setBounds(0, 0, imgRoom.getIconWidth(), imgRoom.getIconHeight());
        room.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        room.setOpaque(false);
        labelRoom.setOpaque(false);

        //Create Object: Lighter
        lighter.isClicked();
        lighter.getLabel().setBounds((int)lighter.getPos().getX(), (int)lighter.getPos().getY(), (int) lighter.getSize().getWidth(), (int)lighter.getSize().getHeight());
        lighter.getLabel().setOpaque(false);


        //Create Mirror
        mirror = new Mirror();

        //Create Closet
        closet = new Closet();
        closet.setCloset(closet.getOpenedClosetLabel(), false);

        //setup room
        room.add(labelRoom, new Integer(0));
        room.add(closet.getOpenedClosetLabel(), new Integer(1));
        room.add(lighter.getLabel(), new Integer(2));
        room.add(closet.getClosedClosetLabel(), new Integer(3));
        room.add(mirror.getMirrorLabel(), new Integer(4));



        panel3.add(room);

    }

    public JLayeredPane getRoom(){ return room; }

    public Mirror getMirror(){
        return mirror;
    }

    public JPanel getPanel(){return panel3;}

    public Closet getCloset(){ return closet; }


}
