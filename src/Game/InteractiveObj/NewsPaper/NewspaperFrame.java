package Game.InteractiveObj.NewsPaper;

import Game.InteractiveObj.NewsPaper.NewspaperPaint;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class NewspaperFrame {
    private JLayeredPane newspaperLayers;
    private NewspaperPaint newspaperPaint;

    private int x = 0;
    private int y = 0;
    private int width=800;
    private int height=420;
    private JFrame frame;


    public NewspaperFrame(JFrame frame) throws IOException {
        this.frame = frame;
        changeCursor();
        ImageIcon newspaperCodeImg = new ImageIcon( new ImageIcon("src/Images/Group 15.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        JLabel newspaperCode = new JLabel(newspaperCodeImg);
        newspaperPaint = new NewspaperPaint();



        newspaperCode.setBounds(0, 0, width, height);
        newspaperCode.setOpaque(false);


        newspaperPaint.setBounds(0, 0, width, height);
        newspaperPaint.setOpaque(false);

        newspaperLayers = frame.getLayeredPane();
        newspaperLayers.add(newspaperCode, new Integer(0));
        newspaperLayers.add(newspaperPaint, new Integer(1));
    }

    public void changeCursor(){
       Image magnifierCursorImage = new ImageIcon(new ImageIcon("").getImage()).getImage();
       Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(magnifierCursorImage, new Point(0, 0), "customCursor");
       frame.setCursor(customCursor);
    }
}
