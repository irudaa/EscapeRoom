package Game.InteractiveObj.NewsPaper;

import Game.InteractiveObj.NewsPaper.NewspaperPaint;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class NewspaperFrame {
    private JPanel newspaperPanel;
    private JLayeredPane newspaperLayers;
    private NewspaperPaint newspaperPaint;

    private List<Point> points;

    private int x = 0;
    private int y = 0;
    private int width=800;
    private int height=420;


    public NewspaperFrame(JFrame frame) throws IOException {
        newspaperPanel =new JPanel();
        ImageIcon newspaperCodeImg = new ImageIcon( new ImageIcon("src/Images/Group 15.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        JLabel newspaperCode = new JLabel(newspaperCodeImg);
        newspaperPaint = new NewspaperPaint();

        newspaperCode.setBounds(0, 0, width, height);

        newspaperPaint.setBackground(Color.white);
        newspaperPaint.setBounds(0, 0, width, height);

        newspaperLayers = frame.getLayeredPane();
        newspaperLayers.add(newspaperCode, new Integer(1));
        newspaperLayers.add(newspaperPaint, new Integer(2));
    }
}
