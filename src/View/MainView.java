package View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JFrame frame = new JFrame();
    public MainView(){
        super("Let me Out!");
        initGUI();
        // mainFrame = this.frame;
    }

    private void initGUI(){
        //setting main qualities in place
        JPanel mainPanel = new JPanel();
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setBounds(600,400,600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        pack();
    }



}
