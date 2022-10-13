package Game.InteractiveObj;

import javax.swing.*;

public class Painting {
    private JLabel openedPaintingLabel;
    private JLabel closedPaintingLabel;
    private ImageIcon closedPaintingImg;
    private ImageIcon openedPaintingImg;

    public Painting(){

        closedPaintingImg = new ImageIcon(new ImageIcon("src/Images/drawing.png").getImage());
        closedPaintingLabel = new JLabel(closedPaintingImg);
        closedPaintingLabel.setBounds(180, 217, closedPaintingImg.getIconWidth(), closedPaintingImg.getIconHeight());
        closedPaintingLabel.setOpaque(false);

        openedPaintingImg = new ImageIcon(new ImageIcon("src/Images/Rectangle 47.png").getImage());
        openedPaintingLabel = new JLabel(openedPaintingImg);
        openedPaintingLabel.setBounds(180, 217, openedPaintingImg.getIconWidth(), openedPaintingImg.getIconHeight());
        openedPaintingLabel.setOpaque(false);

    }

    public JLabel getClosedPaintingLabel(){
        return closedPaintingLabel;
    }

    public void setPainting(JLabel label, boolean bool){
        label.setVisible(bool);
    }

    public JLabel getOpenedPaintingLabel(){
        return openedPaintingLabel;
    }

}
