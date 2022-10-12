package Game.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                        main.windowPanel.setVisible(false);
                    }
                });
    }


}
