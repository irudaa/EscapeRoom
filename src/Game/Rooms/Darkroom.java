package Game.Rooms;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Darkroom extends JComponent {
    private BufferedImage description;
    private Point previousPoint;
    BufferedImage mirrorPaintImage;
    public Darkroom() throws IOException {

        this.setBackground(Color.white);

        try {
            description = ImageIO.read(new File("src/Images/lightScene.png"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        this.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {

                if (previousPoint ==null) {

                }
                int x = e.getX();
                int y = e.getY();

                Graphics2D g2= description.createGraphics();

                g2.setComposite(AlphaComposite.Clear);
                g2.fillRect(x,y,30,30);
                g2.dispose();
                repaint();
            }

            public void mouseExisted(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                Graphics2D g2= description.createGraphics();

                g2.setComposite(AlphaComposite.Clear);
                g2.fillRect(x,y,30,30);
                g2.dispose();
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
}
