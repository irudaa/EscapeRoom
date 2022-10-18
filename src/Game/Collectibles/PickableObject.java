package Game.Collectibles;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class PickableObject extends JComponent {
    private boolean isFound;

    private Dimension dim;

    private Point pos;
    private int x, y;
    private String path = "bell";

    public PickableObject(Dimension dim, Point pos){
        this.dim = dim;
        this.pos = pos;
    }


    public Dimension getSize(){ return dim; }

    public Point getPos(){ return pos; }
    public boolean isFound(){ return isFound; }
    public void setFound(boolean bool){ isFound = bool;}

    public void playSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException, LineUnavailableException, IOException {
        System.out.println("sound");
        File f = new File("src/Music/bell.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

}
