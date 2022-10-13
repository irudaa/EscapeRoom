package Game.InteractiveObj;

import javax.swing.*;

public class Drawer {

    private JLabel openedDrawerLabel;
    private JLabel closedDrawerLabel;
    private ImageIcon closedDrawerImg;
    private ImageIcon openedDrawerImg;


    public Drawer(){
        closedDrawerImg = new ImageIcon(new ImageIcon("src/Images/closedDrawer.png").getImage());
        closedDrawerLabel = new JLabel(closedDrawerImg);
        closedDrawerLabel.setBounds(267, 512, closedDrawerImg.getIconWidth(), closedDrawerImg.getIconHeight());
        closedDrawerLabel.setOpaque(false);

        openedDrawerImg = new ImageIcon(new ImageIcon("src/Images/openedDrawer.png").getImage());
        openedDrawerLabel = new JLabel(openedDrawerImg);
        openedDrawerLabel.setBounds(267, 512, openedDrawerImg.getIconWidth(), openedDrawerImg.getIconHeight());
        openedDrawerLabel.setOpaque(false);

    }

    public JLabel getClosedDrawerLabel(){
        return closedDrawerLabel;
    }

    public void setDrawer(JLabel label, boolean bool){
        label.setVisible(bool);
    }
    public JLabel getOpenedDrawerLabel(){
        return openedDrawerLabel;
    }
}
