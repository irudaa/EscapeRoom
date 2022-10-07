package Game.InteractiveObj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class Mirror extends JPanel {
    ImageIcon mirrorImage;
    ImageIcon mirrorCode;

    int x;
    int y;
    int width = 600;
    int height = 800;

    public Mirror(){
        mirrorCode = new ImageIcon( new ImageIcon("src/Images/mirrorCode.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));;
        mirrorImage = new ImageIcon( new ImageIcon("src/Images/blackMirror.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));;

        Graphics g = this.getGraphics();

        this.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                //g.fillOval(x,y,5,5);
                g.clearRect(x,y,5,5);
                g.dispose();
            }
         });


    }

    public void paintComponent (Graphics g)
    {
        g.drawImage(mirrorImage.getImage(), 0, 0, null);
    }

}
