package Game.Rooms;

import Game.Collectibles.Flashlight;
import Game.Collectibles.Usb;
import Game.InteractiveObj.BoxComp;
import Game.InteractiveObj.Pillow;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;

public class RoomFour extends JPanel{
    private JPanel panel4;

    private ImageIcon imgRoom;
    private JLabel labelRoom;
    private JLayeredPane room;
    private JFrame frame;
    private Pillow pillow;
    private Flashlight flashlight;
    private InventoryView inv;
    private BoxComp box;
    private Usb usb;

    public RoomFour(JFrame frame, InventoryView inv) {
        CardLayout cardLayout = new CardLayout();
        panel4 = new JPanel(cardLayout);
        panel4.setLayout(null);
        panel4.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        panel4.setOpaque(false);
        this.frame = frame;
        this.inv = inv;
        flashlight = new Flashlight(new Dimension(50, 35), new Point(310, 491), inv);
        usb = new Usb(new Dimension(50, 35), new Point(890, 540), inv);
        room = new JLayeredPane();
        setRoomThree();
    }

    public void setRoomThree(){

        //create Door room
        imgRoom = new ImageIcon(new ImageIcon("src/Images/Room4.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        labelRoom = new JLabel(imgRoom);
        labelRoom.setBounds(0, 0, imgRoom.getIconWidth(), imgRoom.getIconHeight());
        room.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        room.setOpaque(false);
        labelRoom.setOpaque(false);

        //create Pillow
        pillow = new Pillow();
        pillow.setPillow(pillow.getOpenedPillowLabel(), false);
        
        //create Box
        box = new BoxComp();
        box.setBox(box.getOpenedBoxLabel(), false);

        //Create Object: Flashlight
        flashlight.isClicked();
        flashlight.getLabel().setBounds((int)flashlight.getPos().getX(), (int)flashlight.getPos().getY(), (int)flashlight.getSize().getWidth(), (int)flashlight.getSize().getHeight());
        flashlight.getLabel().setOpaque(false);

        //Create Object: Usb
        usb.isClicked();
        usb.getLabel().setBounds((int)usb.getPos().getX(), (int)usb.getPos().getY(), (int)usb.getSize().getWidth(), (int)usb.getSize().getHeight());
        usb.getLabel().setOpaque(false);

        //setup room
        room.add(labelRoom, new Integer(0));
        room.add(pillow.getOpenedPillowLabel(), new Integer(1));
        room.add(flashlight.getLabel(), new Integer(2));
        room.add(pillow.getClosedPillowLabel(), new Integer(3));
        room.add(box.getOpenedBoxLabel(), new Integer(4));
        room.add(usb.getLabel(), new Integer(5));
        room.add(box.getClosedBoxLabel(), new Integer(6));
        panel4.add(room);

    }

    public JLayeredPane getRoom(){ return room; }

    public Pillow getPillow(){ return pillow; }

    public JPanel getPanel(){return panel4;}


    public BoxComp getBox() {
        return box;
    }
}