package View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel mainPanel;
    private FourthAngle room;
    public MainView(){
        super("Let me Out!");
        frame = new JFrame();
        mainPanel = new JPanel();
        initGUI();
    }

    private void initGUI(){
        //setting main qualities in place
        frame.setPreferredSize(new Dimension(1200, 1000));
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setMaximumSize(new Dimension(1400, 1200));
        frame.setBounds(600,400,600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());

        //First Window shown

        addFirstWindow();
        //   addInventory();
        //  addDoorRoom();

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
    }


    public void addFirstWindow(){

        ImageIcon imgStart = new ImageIcon(new ImageIcon("src/Images/GA8bmPn.png").getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT));
        ImageIcon switchOnOff = new ImageIcon(new ImageIcon("src/Images/5a2c682d8b79d9.6951852315128596935713.png").getImage().getScaledInstance(120, 80, Image.SCALE_DEFAULT));
        JLabel blackSquare = new JLabel(imgStart);
        blackSquare.setLayout(new FlowLayout());
        JButton start = new JButton(switchOnOff);
        start.setPreferredSize(new Dimension(120, 80));
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);

        blackSquare.add(start);
        mainPanel.add(blackSquare, BorderLayout.CENTER);

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

        mainPanel.add(inventory, BorderLayout.WEST);
    }

    public void addDoorRoom(){
        ImageIcon doorImg = new ImageIcon(new ImageIcon("src/Images/door-146676_640 1.png").getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT));
        ImageIcon roomImg = new ImageIcon(new ImageIcon("src/Images/Angle 1.png").getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        room = new FourthAngle(mainPanel, doorImg, roomImg);
        room.addRoom();
        // room.addDoor();
    }


}
