package Game.InteractiveObj;

import javax.swing.*;

public class Closet {

    private JLabel openedClosetLabel;
    private JLabel closedClosetLabel;
    private ImageIcon closedClosetImg;
    private ImageIcon openedClosetImg;


    public Closet(){
        closedClosetImg = new ImageIcon(new ImageIcon("src/Images/closedCloset.png").getImage());
        closedClosetLabel = new JLabel(closedClosetImg);
        closedClosetLabel.setBounds(48,144, closedClosetImg.getIconWidth(), closedClosetImg.getIconHeight());
        closedClosetLabel.setOpaque(false);

        openedClosetImg = new ImageIcon(new ImageIcon("src/Images/openedCloset.png").getImage());
        openedClosetLabel = new JLabel(openedClosetImg);
        openedClosetLabel.setBounds(48,144, openedClosetImg.getIconWidth(), openedClosetImg.getIconHeight());
        openedClosetLabel.setOpaque(false);

    }

    public JLabel getClosedClosetLabel(){
        return closedClosetLabel;
    }

    public void setCloset(JLabel label, boolean bool){
        label.setVisible(bool);
    }
    public JLabel getOpenedClosetLabel(){
        return openedClosetLabel;
    }
}