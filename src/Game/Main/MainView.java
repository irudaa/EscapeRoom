package Game.Main;

import Game.Inventory.Inventory;
import Game.Rooms.Angle;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JFrame frame = new JFrame();
    private Angle room;

    protected JButton start;

    protected JLabel blackSquare;

    private boolean isActive = false;

    protected JPanel windowPanel, inventoryPanel;

    protected JPanel fourthAnglePanel = new JPanel();

    private JLayeredPane lpane, roomPane;

    private Inventory inventory;

    public MainView(){
        super("Let me Out!");
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        fourthAnglePanel = new JPanel();
        initGUI();
    }

    private void initGUI(){
        //setting main qualities in place
        frame.setPreferredSize(new Dimension(1200, 1000));
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setMaximumSize(new Dimension(1400, 1200));
        frame.setBounds(600,400,600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lpane = new JLayeredPane();
        frame.add(lpane);
        lpane.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);

        //First Window shown
        addDoorRoom();
        addFirstWindow();
        //addInventory();

        frame.setVisible(true);
        frame.pack();
    }


    public void addFirstWindow(){

        ImageIcon imgStart = new ImageIcon(new ImageIcon("src/Images/GA8bmPn.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        ImageIcon switchOnOff = new ImageIcon(new ImageIcon("src/Images/5a2c682d8b79d9.6951852315128596935713.png").getImage().getScaledInstance(200, 120, Image.SCALE_DEFAULT));
        blackSquare = new JLabel(imgStart);
        blackSquare.setLayout(new FlowLayout());
        start = new JButton(switchOnOff);
        start.setPreferredSize(new Dimension(280, 180));
        start.setLocation(new Point(200, 300));
        start.setContentAreaFilled(false);
        windowPanel = new JPanel();
        windowPanel.setLayout(new FlowLayout());
        JTextArea story = new JTextArea(24, 80);
        story.setBackground(Color.black);
        story.setEditable(false);
        story.append("\nHe wakes up to find himself in a bizarre room. He doesn't remember who he is nor what he is doing there.");
        story.append("\nThe room smells funny and old, it doesn’t seem to be lived in. ");
        story.append( "\nHe wonders where he is, who he is, why he is here. He wonders if they will ever let him out.");
        story.setForeground(Color.white);
        story.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        blackSquare.add(story);
        blackSquare.add(start);
        windowPanel.add(blackSquare);
        windowPanel.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        lpane.add(windowPanel, new Integer(2));

    }

    public void addInventory(){
        //Create inventory
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(2, 1));
        inventory = new Inventory(inventoryPanel, frame);
        inventoryPanel.setBounds(1,2, 300,1000);
        inventoryPanel.setOpaque(false);
        lpane.add(inventoryPanel, new Integer(1));
    }

    public void addDoorRoom(){
        roomPane = new JLayeredPane();
        addInventory();
        room = new Angle(roomPane, frame, inventory.getView());
        room.getPane().setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        room.getPane().setOpaque(false);
        lpane.add(room.getPane(), new Integer(0));

    }


}
