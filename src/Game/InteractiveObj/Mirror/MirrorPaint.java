package Game.InteractiveObj.Mirror;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MirrorPaint extends JComponent {
    BufferedImage mirrorPaintImage;
    public MirrorPaint() throws IOException {

        this.setBackground(Color.white);

        try {
            mirrorPaintImage = ImageIO.read(new File("src/Images/blackMirror.png"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                int x = e.getX();
                int y = e.getY();

                Graphics2D g2= mirrorPaintImage.createGraphics();
                g2.setComposite(AlphaComposite.Clear);
                g2.fillRect(x, y,30,30);
                g2.dispose();
                try {
                    playErase();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();



            }
        });
    }

    @Override
    protected void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.drawImage(mirrorPaintImage, 0, 0, this);
        g2.dispose();

    }
    public void playErase() throws IOException, UnsupportedAudioFileException, LineUnavailableException, LineUnavailableException, IOException {
        System.out.println("sound");
        File f = new File("src/Music/erase.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
}
