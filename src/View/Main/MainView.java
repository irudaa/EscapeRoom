package View.Main;

import View.Inventory.Inventory;
import View.Rooms.AngleView;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JFrame frame = new JFrame();
    private AngleView room;

    protected JButton start;

    protected JLabel blackSquare;

    private boolean isActive = false;

    protected JPanel windowPanel, inventoryPanel;

    protected JPanel fourthAnglePanel = new JPanel();

    private JLayeredPane lpane, roomPane;

    public MainView(){
        super("Let me Out!");
        frame = new JFrame();
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
       // addInventory();
        addDoorRoom();
        addFirstWindow();

        frame.setVisible(true);
        frame.pack();
    }


    public void addFirstWindow(){

        ImageIcon imgStart = new ImageIcon(new ImageIcon("src/Images/GA8bmPn.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        ImageIcon switchOnOff = new ImageIcon(new ImageIcon("src/Images/5a2c682d8b79d9.6951852315128596935713.png").getImage().getScaledInstance(280, 180, Image.SCALE_DEFAULT));
        blackSquare = new JLabel(imgStart);
        blackSquare.setLayout(new FlowLayout());
        start = new JButton(switchOnOff);
        start.setPreferredSize(new Dimension(280, 180));
        start.setLocation(new Point(200, 300));
        start.setContentAreaFilled(false);
        windowPanel = new JPanel();
        windowPanel.setLayout(new FlowLayout());
        blackSquare.add(start);
        windowPanel.add(blackSquare);
        windowPanel.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        lpane.add(windowPanel, new Integer(2), 2);

    }

    public void addInventory(){
        //Create inventory
        inventoryPanel = new JPanel();
        Inventory inventory = new Inventory(inventoryPanel);
        fourthAnglePanel.add(inventoryPanel, BorderLayout.WEST);
        lpane.add(inventoryPanel, new Integer(1), 0);
    }

    public void addDoorRoom(){
        roomPane = new JLayeredPane();
        room = new AngleView(roomPane, frame);
        roomPane.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        //fourthAnglePanel.add(roomPane, BorderLayout.CENTER);
        lpane.add(room.pane(), new Integer(0), 0);
    }


}
