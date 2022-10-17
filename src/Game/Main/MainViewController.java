package Game.Main;

import javax.swing.*;
import java.awt.event.*;

public class MainViewController extends JComponent {

    private MainView main;

    public MainViewController(MainView main){
        this.main = main;
        initGame();
    }

    private void initGame(){
        main.start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getStartPane().setVisible(false);
            }
        });

        main.getAngleClass().getFirstAngle().getSwitch().getClosedSwitchLabel().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                main.getStoryPaint().setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
    }


}
