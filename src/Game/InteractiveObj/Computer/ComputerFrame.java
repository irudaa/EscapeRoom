package Game.InteractiveObj.Computer;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ComputerFrame {
    private JPanel computerPanel;
    private JLayeredPane computerLayers;

    private int x = 0;
    private int y = 0;
    private int width = 800;
    private int height = 650;


    public ComputerFrame(JFrame frame) throws IOException {
        computerPanel =new JPanel();
        ImageIcon computerCodeImg = new ImageIcon( new ImageIcon("src/Images/Angle 35(1).png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        JLabel computerCode = new JLabel(computerCodeImg);

        computerCode.setBounds(0, 0, width, height);


        computerLayers = frame.getLayeredPane();
        computerLayers.add(computerCode, new Integer(1));
    }
}
