package Game.Main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MainViewController extends JComponent {

    private MainView main;

    private JLabel switchLabel;

    public MainViewController(MainView main){
        this.main = main;
        switchLabel = new JLabel(new ImageIcon(main.getStoryPaint().getSwitch()));
        initGame();
        endGame();
    }

    private void initGame(){
        main.start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getStartPane().setVisible(false);
                try {
                    main.playNext();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        main.getStoryPaint().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(main.getStoryPaint().contains(new Point(e.getX(), e.getY()))){
                    System.out.println("entered");
                    main.getStoryPaint().setVisible(false);

                }
            }

        });
    }

    private void endGame(){
        main.getAngleClass().getFirstAngle().getDoor().getOpenedDoorLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                main.getEnd().setVisible(true);
                main.getReplay().setVisible(true);
                try {
                    main.playSkill();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });
    }





}
