package Game.InteractiveObj;

import javax.swing.*;
import java.awt.*;

public class BoxComp {

    private JLabel openedBoxLabel;
    private JLabel closedBoxLabel;
    private ImageIcon closedBoxImg;
    private ImageIcon openBoxImg;


    public BoxComp(){
        closedBoxImg = new ImageIcon(new ImageIcon("src/Images/cardboard-box-155479_640 1.png").getImage());
        closedBoxLabel = new JLabel(closedBoxImg);
        closedBoxLabel.setBounds(824, 542, closedBoxImg.getIconWidth(), closedBoxImg.getIconHeight());
        closedBoxLabel.setOpaque(false);

        openBoxImg = new ImageIcon(new ImageIcon("src/Images/corrugated-packaging-box-500x500-removebg-preview.png").getImage().getScaledInstance(closedBoxImg.getIconWidth() + 80, closedBoxImg.getIconHeight() + 80, Image.SCALE_DEFAULT));
        openedBoxLabel = new JLabel(openBoxImg);
        openedBoxLabel.setBounds(780, 480, closedBoxImg.getIconWidth() +80, closedBoxImg.getIconHeight()+80);
        openedBoxLabel.setOpaque(false);

    }

    public JLabel getClosedBoxLabel(){
        return closedBoxLabel;
    }

    public void setBox(JLabel label, boolean bool){
        label.setVisible(bool);
    }
    public JLabel getOpenedBoxLabel(){
        return openedBoxLabel;
    }
}
