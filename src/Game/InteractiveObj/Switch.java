package Game.InteractiveObj;

import javax.swing.*;

public class Switch {

    private JLabel openedSwitchLabel;
    private JLabel closedSwitchLabel;
    private ImageIcon closedSwitchImg;
    private ImageIcon openedSwitchImg;


    public Switch(){
        closedSwitchImg = new ImageIcon(new ImageIcon("src/Images/switch-36000_640 1.png").getImage());
        closedSwitchLabel = new JLabel(closedSwitchImg);
        closedSwitchLabel.setBounds(50,360, closedSwitchImg.getIconWidth(), closedSwitchImg.getIconHeight());
        closedSwitchLabel.setOpaque(false);

        openedSwitchImg = new ImageIcon(new ImageIcon("src/Images/switch-36000_640 1.png").getImage());
        openedSwitchLabel = new JLabel(openedSwitchImg);
        openedSwitchLabel.setBounds(50,360, openedSwitchImg.getIconWidth(), openedSwitchImg.getIconHeight());
        openedSwitchLabel.setOpaque(false);

    }

    public JLabel getClosedSwitchLabel(){
        return closedSwitchLabel;
    }

    public JLabel getOpenedSwitchLabel(){ return getOpenedSwitchLabel();}

}