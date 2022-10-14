package Game.InteractiveObj;

import javax.swing.*;

public class Safe {

    private JLabel safeLabel;
    private ImageIcon safeImg;

    public Safe() {
       safeImg = new ImageIcon(new ImageIcon("src/Images/Group 11.png").getImage());
       safeLabel = new JLabel(safeImg);
       safeLabel.setBounds(754, 275, safeImg.getIconWidth(), safeImg.getIconHeight());
       safeLabel.setOpaque(false);
    }

    public JLabel getSafeLabel(){
        return safeLabel;
    }
}
