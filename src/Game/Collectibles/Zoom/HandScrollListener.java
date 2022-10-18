package Game.Collectibles.Zoom;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JViewport;

public class HandScrollListener extends MouseAdapter {
    private MouseEvent pressed;
    private final Cursor hndCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    private final Point pp = new Point();
    private JLabel image;

    public HandScrollListener(JLabel image) {
        this.image = image;
    }

    public void mouseDragged(final MouseEvent e) {
        JViewport vPort = (JViewport) e.getSource();
        Point cp = e.getPoint();
        int x = cp.x - pressed.getX() + e.getX();
        int y = cp.y - pressed.getY() + e.getY();

        Point vp = vPort.getViewPosition();
        vp.translate((pp.x - x)/10, (pp.y - y)/10);

        image.scrollRectToVisible(new Rectangle(vp, vPort.getSize()));
        pp.setLocation(cp);

    }

    public void mousePressed(MouseEvent e) {
        image.setCursor(hndCursor);
        pressed = e;


    }
}
