package Game.InteractiveObj;

import javax.swing.*;

public class Pillow {
    private JLabel openedPillowLabel;
    private JLabel closedPillowLabel;
    private ImageIcon closedPillowImg;
    private ImageIcon openedPillowImg;

    public Pillow(){

        closedPillowImg = new ImageIcon(new ImageIcon("src/Images/cushion.png").getImage());
        closedPillowLabel = new JLabel(closedPillowImg);
        closedPillowLabel.setBounds(256, 454, closedPillowImg.getIconWidth(), closedPillowImg.getIconHeight());
        closedPillowLabel.setOpaque(false);

        openedPillowImg = new ImageIcon(new ImageIcon("src/Images/cushion.png").getImage());
        openedPillowLabel = new JLabel(openedPillowImg);
        openedPillowLabel.setBounds(350, 454, openedPillowImg.getIconWidth(), openedPillowImg.getIconHeight());
        openedPillowLabel.setOpaque(false);

    }

    public JLabel getClosedPillowLabel(){
        return closedPillowLabel;
    }

    public void setPillow(JLabel label, boolean bool){
        label.setVisible(bool);
    }

    public JLabel getOpenedPillowLabel(){
        return openedPillowLabel;
    }

}
