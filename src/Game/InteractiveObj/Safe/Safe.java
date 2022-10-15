package Game.InteractiveObj.Safe;

import javax.swing.*;
import java.awt.*;

public class Safe {

    private JLabel safeLabel;
    private ImageIcon safeImg;


    public Safe() {
       safeImg = new ImageIcon(new ImageIcon("src/Images/Group 11.png").getImage());
       safeLabel = new JLabel(safeImg);
       safeLabel.setBounds(400, 195, safeImg.getIconWidth(), safeImg.getIconHeight());
       safeLabel.setOpaque(false);


    }

    public JLabel getSafeLabel(){
        return safeLabel;
    }



    public void setSafe(JLabel label, boolean bool){
        label.setVisible(bool);
    }
}
