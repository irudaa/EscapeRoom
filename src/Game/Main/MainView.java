package Game.Main;

import Game.InteractiveObj.Switch;
import Game.Inventory.Inventory;
import Game.Rooms.Angle;
import Game.Rooms.AngleView;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class MainView extends JFrame {

    private JFrame frame;
    private Angle room;

    protected JButton start;

    protected JLabel blackSquare;

    private JLabel story;


    private boolean isActive = false;

    protected JPanel windowPanel, inventoryPanel;

    private JLayeredPane lpane;
    private JPanel roomPanel;

    private Inventory inventory;

    private JLayeredPane startPane;

    private int width;
    private int height;

    //private JButton next;
    //private JButton previous;

    private CardLayout cardLayout;
    private MainPaint storyPaint;

    private int counter;
    private JLabel end;
    private JButton buttonRestart;

    public MainView() throws IOException {
        super("Let me Out!");
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        width = 1000;
        height = 800;
        initGUI();
    }

    public void initGUI() throws IOException {
        //setting main qualities in place
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lpane = new JLayeredPane();
        frame.add(lpane);

        addRoom();
        addFirstWindow();
        setupStory();
        activateButtons();
        try {
            playBackgroundSound();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        endGame();
        frame.setVisible(true);
        frame.pack();

    }


    public void addFirstWindow(){

        startPane = new JLayeredPane();
        startPane.setBounds(0, 0, 1000, 800);

        //Background
        ImageIcon imgStart = new ImageIcon(new ImageIcon("src/Images/Angle 36.png").getImage().getScaledInstance(frame.getPreferredSize().width, frame.getPreferredSize().height, Image.SCALE_DEFAULT));
        blackSquare = new JLabel(imgStart);
        blackSquare.setBounds(0, 0, imgStart.getIconWidth(), imgStart.getIconHeight());
        blackSquare.setOpaque(false);

      //  start button
        ImageIcon switchOnOff = new ImageIcon(new ImageIcon("src/Images/Group 16.png").getImage().getScaledInstance(376, 108, Image.SCALE_DEFAULT));
        start = new JButton(switchOnOff);
        start.setBounds(312, 497, switchOnOff.getIconWidth(), switchOnOff.getIconHeight());
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);

        startPane.add(blackSquare, new Integer(0));
        startPane.add(start, new Integer(1));

        lpane.add(startPane, new Integer(5));

    }

    public void setupStory() throws IOException {
        //Background

        storyPaint = new MainPaint();
        storyPaint.setBounds(0, 0, width, height);
        storyPaint.setOpaque(false);
        lpane.add(storyPaint, new Integer(4));


    }

    public void addInventory(){
        //Create inventory
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new GridLayout(2, 1));
        inventory = new Inventory(inventoryPanel, frame, this);
        inventoryPanel.setBounds(1,2, 300,1000);
        inventoryPanel.setOpaque(false);
        lpane.add(inventoryPanel, new Integer(3));
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
        JPanel p4 = room.getFourthAngle().getPanel();

        roomPanel.add(p, "1");
        roomPanel.add(p2, "2");
        roomPanel.add(p3, "3");
        roomPanel.add(p4, "4");

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
                cardLayout.next(roomPanel);
                roomPanel.revalidate();

                try {
                    playNext();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        room.getView().getPrevious().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                cardLayout.previous(roomPanel);
                roomPanel.revalidate();

                try {
                    playNext();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public void playNext() throws IOException, UnsupportedAudioFileException, LineUnavailableException, LineUnavailableException, IOException {
            System.out.println("coin");
            File f = new File("src/Music/next.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
    }
    public static void playMagic() throws IOException, UnsupportedAudioFileException, LineUnavailableException, LineUnavailableException, IOException {
        System.out.println("open");
        File f = new File("src/Music/magic.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    public static void playSkill() throws IOException, UnsupportedAudioFileException, LineUnavailableException, LineUnavailableException, IOException {
        System.out.println("open");
        File f = new File("src/Music/skill.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }


    public void endGame(){
        ImageIcon img = new ImageIcon(new ImageIcon("src/Images/theEnd.png").getImage());
        end = new JLabel(img);
        end.setBounds(0, 0, 1000, 800);
        end.setOpaque(false);
        end.setVisible(false);
        ImageIcon img2 = new ImageIcon(new ImageIcon("src/Images/replay.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        buttonRestart = new JButton("Replay", img2);
        buttonRestart.setForeground(Color.white);
        buttonRestart.setBounds(800, 600, 200, 100);
        buttonRestart.setOpaque(false);
        buttonRestart.setVisible(false);
        buttonRestart.setContentAreaFilled(false);
        buttonRestart.setBorderPainted(false);
        lpane.add(end, new Integer(6));
        lpane.add(buttonRestart, new Integer(7));

    }

    public JLabel getEnd(){ return end; }

    public Angle getAngleClass(){ return room; }

    public JLayeredPane getPane(){ return lpane; }

    public JLayeredPane getStartPane(){return startPane;}

    public JPanel getRoomPanel(){ return roomPanel; }

    public JButton getReplay(){ return buttonRestart; }

    public MainPaint getStoryPaint(){
        return storyPaint;
    }
    public void playBackgroundSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException, LineUnavailableException, IOException {
        System.out.println("sound");
        File f = new File("src/Music/MysteriousMusic.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.open(audioIn);
        clip.start();
    }
    public Window getFrame(){
        return frame;
    }



}
