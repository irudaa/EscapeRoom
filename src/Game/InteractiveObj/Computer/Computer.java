package Game.InteractiveObj.Computer;

import javax.swing.*;
import java.awt.*;

public class Computer {
    private JLabel computerLabel;
    private ImageIcon computerImg;

    public Computer() {
        computerImg = new ImageIcon(new ImageIcon("src/Images/Group 5.png").getImage());
        computerLabel = new JLabel(computerImg);
        computerLabel.setBounds(316, 380, computerImg.getIconWidth(), computerImg.getIconHeight());
        computerLabel.setOpaque(false);
    }

    public JLabel getComputerLabel(){
        return computerLabel;
    }

    public boolean contains(Point p) {
        return (computerLabel.getLocation().getX() < p.getX() && computerLabel.getLocation().getY() < p.getY() &&
                computerLabel.getLocation().getX() + computerLabel.getWidth() > p.getX()  &&
                computerLabel.getLocation().getY() + computerLabel.getHeight() > p.getY());
    }
}
