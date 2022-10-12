package Game.Main;

import Game.Inventory.Inventory;
import Game.Rooms.Angle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JFrame frame;
    private Angle room;

    protected JButton start;

    protected JLabel blackSquare;

    private boolean isActive = false;

    protected JPanel windowPanel, inventoryPanel;

    private JLayeredPane lpane;
    private JPanel roomPanel;

    private Inventory inventory;

    private int width;
    private int height;

    //private JButton next;
    //private JButton previous;

    private CardLayout cardLayout;
    public MainView(){
        super("Let me Out!");
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        width = 1000;
        height = 800;
        initGUI();
    }

    private void initGUI(){
        //setting main qualities in place
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        //frame.setBounds(600,400,600,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lpane = new JLayeredPane();
        frame.add(lpane);
       // lpane.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        //First Window shown
        addRoom();
        addFirstWindow();
        activateButtons();

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
        lpane.add(windowPanel, new Integer(3));

    }

    public void addInventory(){
        //Create inventory
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(2, 1));
        inventory = new Inventory(inventoryPanel, frame);
        inventoryPanel.setBounds(1,2, 300,1000);
        inventoryPanel.setOpaque(false);
        lpane.add(inventoryPanel, new Integer(2));
    }


    public void addRoom(){
        cardLayout = new CardLayout();
        roomPanel = new JPanel();
        roomPanel.setLayout(cardLayout);
        roomPanel.setBounds(0, 0, frame.getPreferredSize().width, frame.getPreferredSize().height);
        roomPanel.setOpaque(false);

        addInventory();
        room = new Angle(frame, inventory.getView());
        JPanel p = room.getFirstAngle().getPanel();
        JPanel p2 = room.getSecondAngle().getPanel();
        JPanel p3 = room.getThirdAngle().getPanel();

        roomPanel.add(p, "1");
        roomPanel.add(p2, "2");
        roomPanel.add(p3, "3");
        //room.getFirstAngle().setName("firstPanel");
       // room.getSecondAngle().setName("secondPanel");
        cardLayout.show(roomPanel, "1");
        roomPanel.revalidate();

        lpane.add(room.getView().getNext(), new Integer(1));
        lpane.add(room.getView().getPrevious(), new Integer(1));
        lpane.add(roomPanel, new Integer(0));

    }

    public void activateButtons(){
        room.getView().getNext().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("ent");
                cardLayout.next(roomPanel);
                roomPanel.revalidate();
            }
        });

        room.getView().getPrevious().addActionListener(new ActionListener() {

          //  CardLayout cl =  (CardLayout)(roomPanel.getLayout());
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enttt");
                cardLayout.previous(roomPanel);
                roomPanel.revalidate();
            }
        });
    }

    public Angle getRoom(){ return room; }




}
