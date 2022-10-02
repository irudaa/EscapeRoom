package View.Main;

import View.Room.FourthAngle;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JFrame frame = new JFrame();
    private FourthAngle room;

    protected JButton start;

    protected JLabel blackSquare;

    private boolean isActive = false;

    protected JPanel windowPanel;

    protected JPanel fourthAnglePanel = new JPanel();

    private JLayeredPane lpane;

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
       // frame.setLayout(new BorderLayout());
        frame.add(lpane);
        lpane.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);

        //First Window shown
        addInventory();
        addDoorRoom();
        addFirstWindow();

      //frame.add(mainPanel, BorderLayout.CENTER);
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
        JPanel inventory = new JPanel();
        inventory.setPreferredSize(new Dimension(100, 600));
        Box inv = Box.createVerticalBox();

        //First Button
        Button item1 = new Button("button1");
        item1.setPreferredSize(new Dimension(100, 100));
        inv.add(item1);
        inventory.add(inv);
        inventory.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);

        fourthAnglePanel.add(inventory, BorderLayout.WEST);
        lpane.add(fourthAnglePanel, new Integer(1), 0);
    }

    public void addDoorRoom(){
        ImageIcon doorImg = new ImageIcon(new ImageIcon("src/Images/door-146676_640 1.png").getImage().getScaledInstance(400,800, Image.SCALE_DEFAULT));
        ImageIcon roomImg = new ImageIcon(new ImageIcon("src/Images/Angle 1.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        JPanel angle = new JPanel();
        angle.setLayout(new FlowLayout());
        room = new FourthAngle(angle, doorImg, roomImg);
        room.addRoom();
        room.addDoor();
        angle.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        fourthAnglePanel.add(angle, BorderLayout.CENTER);
        lpane.add(angle, new Integer(0), 0);
    }


}
