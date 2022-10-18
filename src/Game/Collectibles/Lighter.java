package Game.Collectibles;

import Game.Inventory.InventoryView;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Lighter extends PickableObject {


    private Dimension dim;

    private Point pos;

    ImageIcon imageIcon;

    private JLabel label;

    private InventoryView inventory;

    public Lighter(Dimension dim, Point pos, InventoryView inventory) {
        super(dim, pos);
        this.dim = dim;
        this.pos = pos;
        imageIcon = new ImageIcon(new ImageIcon("src/Images/pocket-lighter-24217_640 1.png").getImage().getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), Image.SCALE_DEFAULT));
        label = new JLabel(imageIcon);
        super.setFound(false);
        this.inventory = inventory;
    }
    public ImageIcon getImg(){ return imageIcon; }

    public JLabel getLabel(){ return label; }

    public void objectFound(){
        if(super.isFound() == true){
            label.setVisible(false);

        }
    }
    public void isClicked(){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
                    setFound(true);
                    objectFound();
                    inventory.getLighter().setLabelVisible(true);
                    playBell();
                }
            }
        });
    }

    private void playBell() {

        String soundName = "src/Music/bell.wav";
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        } catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        clip.start();
    }

    public void setLabelVisible(boolean b) {
        label.setVisible(b);
    }

}
