package Game.InteractiveObj.NewsPaper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewspaperPaint extends JComponent {
    BufferedImage newspaperPaintImage;
    public NewspaperPaint() throws IOException {

        this.setBackground(Color.white);

        try {
            newspaperPaintImage = ImageIO.read(new File("src/Images/blacksquare.jpg"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        this.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                int x = e.getX();
                int y = e.getY();

                Graphics2D g2= newspaperPaintImage.createGraphics();

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
        g2.drawImage(newspaperPaintImage, 0, 0, this);
        g2.dispose();

    }
}

