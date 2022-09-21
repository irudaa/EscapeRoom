package View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JFrame frame = new JFrame();
    private FourthAngle room;
    public MainView(){
        super("Let me Out!");
        initGUI();
        frame = new JFrame();
        room = new FourthAngle(frame);
    }

    private void initGUI(){
        //setting main qualities in place
     JPanel mainPanel = new JPanel();  /*  
        frame.setPreferredSize(new Dimension(1200, 1000));
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setMaximumSize(new Dimension(1400, 1200));
        frame.setBounds(600,400,600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
*/
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
    }



}
