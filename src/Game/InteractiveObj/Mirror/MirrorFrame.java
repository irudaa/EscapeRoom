package Game.InteractiveObj.Mirror;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MirrorFrame {

    private JPanel mirrorPanel;
    private JLayeredPane mirrorLayers;
    private MirrorPaint mirrorPaint;

    private List<Point> points;

    private int x = 0;
    private int y = 0;
    private int width=800;
    private int height=650;


    public MirrorFrame(JFrame frame) throws IOException {
        mirrorPanel =new JPanel();
        ImageIcon mirrorCodeImg = new ImageIcon( new ImageIcon("src/Images/mirrorCode.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        JLabel mirrorCode = new JLabel(mirrorCodeImg);
        mirrorPaint = new MirrorPaint();

        mirrorCode.setBounds(0, 0, width, height);

        mirrorPaint.setBackground(Color.white);
        mirrorPaint.setBounds(508, 225, width, height);

        mirrorLayers = frame.getLayeredPane();
        mirrorLayers.add(mirrorCode, new Integer(1));
        mirrorLayers.add(mirrorPaint, new Integer(2));
    }
}
