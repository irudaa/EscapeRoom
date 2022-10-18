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
    BufferedImage imgSwitch;
    private  boolean clicked;
    public MainPaint() throws IOException {


        try {
            startPaintImage = ImageIO.read(new File("src/Images/Angle 38.png"));
            imgSwitch = ImageIO.read(new File("src/Images/switch-36000_640 1.png"));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicked = true;
            }
        });



        this.addMouseMotionListener(new MouseMotionAdapter(){

            public void mouseMoved(MouseEvent e){
                if(clicked){
                int x = e.getX();
                int y = e.getY();

                    Graphics2D g2= startPaintImage.createGraphics();
                    g2.setColor(new Color(0,0,0,50));
                    g2.fillRect(0, 0,1000,800);
                    g2.setComposite(AlphaComposite.Clear);
                    g2.fillOval(x - 100, y - 100,200,200);
                    g2.dispose();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.drawImage(startPaintImage, 0, 0, this);
       // g.drawImage(imgSwitch, 50,360, this);
        g2.dispose();

    }


    public Image getSwitch(){
        return imgSwitch;
    }


    public boolean contains(Point p) {
        return (50 < p.getX() && 360 < p.getY() &&
                50 + 41 > p.getX()  &&
                360 + 63 > p.getY());
    }
}

