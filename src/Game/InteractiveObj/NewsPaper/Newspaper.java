package Game.InteractiveObj.NewsPaper;

import javax.swing.*;
import java.awt.*;

public class Newspaper {
    private JLabel newspaperLabel;
    private ImageIcon newspaperImg;

    public Newspaper() {
        newspaperImg = new ImageIcon(new ImageIcon("src/Images/passport-576913_640.png").getImage());
        newspaperLabel = new JLabel(newspaperImg);
        newspaperLabel.setBounds(687, 453, newspaperImg.getIconWidth(), newspaperImg.getIconHeight());
        newspaperLabel.setOpaque(false);
    }

    public JLabel getNewspaperLabel(){
        return newspaperLabel;
    }

    public boolean contains(Point p) {
        return (newspaperLabel.getLocation().getX() < p.getX() && newspaperLabel.getLocation().getY() < p.getY() &&
                newspaperLabel.getLocation().getX() + newspaperLabel.getWidth() > p.getX()  &&
                newspaperLabel.getLocation().getY() + newspaperLabel.getHeight() > p.getY());
    }
}
