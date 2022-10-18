package Game.Main;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Main {

    private static MainView newMainView;
    private static MainViewController mvc;
    public static void main(String[] args) throws IOException {
        newMainView = new MainView();
        mvc = new MainViewController(newMainView);
        restartGame();

    }

    public static void restartGame(){
        newMainView.getReplay().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newMainView.getEnd().setVisible(false);
                newMainView.getReplay().setVisible(false);
                newMainView.dispose();
                newMainView.getFrame().dispose();
                  try {
                    newMainView = new MainView();
                    mvc = new MainViewController(newMainView);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}