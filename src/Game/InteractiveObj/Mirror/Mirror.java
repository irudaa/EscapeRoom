package Game.InteractiveObj.Mirror;

import javax.swing.*;

public class Mirror {


    private JLabel mirrorLabel;
    private ImageIcon mirrorImg;

    public Mirror() {
        mirrorImg = new ImageIcon(new ImageIcon("src/Images/smallMirror.png").getImage());
        mirrorLabel = new JLabel(mirrorImg);
        mirrorLabel.setBounds(754, 275, mirrorImg.getIconWidth(), mirrorImg.getIconHeight());
        mirrorLabel.setOpaque(false);
    }

    public JLabel getMirrorLabel(){
        return mirrorLabel;
    }
}
