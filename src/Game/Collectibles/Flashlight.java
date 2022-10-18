package Game.Collectibles;

import Game.Inventory.InventoryView;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Flashlight extends PickableObject {


    private Dimension dim;

    private Point pos;

    ImageIcon imageIcon;

    private JLabel label;

    private InventoryView inventory;

    public Flashlight(Dimension dim, Point pos, InventoryView inventory) {
        super(dim, pos);
        this.dim = dim;
        this.pos = pos;
        imageIcon = new ImageIcon(new ImageIcon("src/Images/light-310703_640 1.png").getImage().getScaledInstance((int) dim.getWidth(), (int) dim.getHeight(), Image.SCALE_DEFAULT));
        label = new JLabel(imageIcon);
        super.setFound(false);
        this.inventory = inventory;
    }

    public Point getPosition(){
        return pos;
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
                    inventory.getFlashlight().setLabelVisible(true);
                    try {
                        Flashlight.super.playSound();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (UnsupportedAudioFileException ex) {
                        throw new RuntimeException(ex);
                    } catch (LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public void setLabelVisible(boolean b) {
        label.setVisible(b);
    }

}
