package Game.Main;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPaint extends JComponent {
    BufferedImage startPaintImage;
    public MainPaint() throws IOException {

        this.setBackground(Color.white);

        try {
            startPaintImage = ImageIO.read(new File("src/Images/Angle 38.png"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        this.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent e){

            }

            public void mouseMoved(MouseEvent e){
                int x = e.getX();
                int y = e.getY();

                Graphics2D g2= startPaintImage.createGraphics();
                g2.setColor(Color.black);
                g2.fillRect(0, 0,1000,800);
                g2.setComposite(AlphaComposite.Clear);
                g2.fillOval(x, y,100,100);
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
        g2.drawImage(startPaintImage, 0, 0, this);
        g2.dispose();

    }
}

