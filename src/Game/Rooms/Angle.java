package Game.Rooms;

import javax.swing.*;

public class Angle {

    private AngleView view;
    private JFrame frame;
    private JLayeredPane pane;

    public Angle(JLayeredPane pane, JFrame frame){
        this.frame = frame;
        this.pane = pane;
        view = new AngleView(pane, frame);
    }

    public JLayeredPane getPane(){
        return view.getPane();
    }

}
