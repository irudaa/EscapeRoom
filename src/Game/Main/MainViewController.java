package Game.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainViewController extends JComponent {

    private MainView main;

    private JLabel switchLabel;

    public MainViewController(MainView main){
        this.main = main;
        switchLabel = new JLabel(new ImageIcon(main.getStoryPaint().getSwitch()));
        initGame();
    }

    private void initGame(){
        main.start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getStartPane().setVisible(false);
            }
        });

        main.getStoryPaint().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(main.getStoryPaint().contains(new Point(e.getX(), e.getY()))){
                    System.out.println("entered");
                    main.getStoryPaint().setVisible(false);
                }
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
