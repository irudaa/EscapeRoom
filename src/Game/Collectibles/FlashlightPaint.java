package Game.Collectibles;

import javax.swing.*;
import java.awt.*;

public class FlashlightPaint extends JComponent {

    private int x;
    private int y;

    public FlashlightPaint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g){
        g.setColor(new Color(195, 165, 225, 80));
        g.fillOval(x, y, 200, 200);
    }

    public boolean contains(Point p) {
        return (this.getLocation().getX() < p.getX() && this.getLocation().getY() < p.getY() &&
                this.getLocation().getX() + this.getWidth() > p.getX()  &&
                this.getLocation().getY() + this.getHeight() > p.getY());
    }
}
