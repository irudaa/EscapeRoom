package Game.Rooms;

import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Angle {

    private CardLayout cl;
    private AngleView view;
    private JFrame frame;
    private JPanel panel;
    private RoomOne firstAngle;
    private RoomTwo secondAngle;
    private RoomThree thirdAngle;


    private InventoryView inv;

    public Angle( JFrame frame, InventoryView inv){
        this.frame = frame;
        this.inv = inv;
       // this.cl = cl;
        view = new AngleView(frame, inv);
        firstAngle = view.startRoomOne();
        secondAngle = view.startRoomTwo();
        thirdAngle = view.startRoomThree();

    }

    public AngleView getView() {
        return view;
    }


    public RoomOne getFirstAngle() {
        return firstAngle;
    }

    public RoomTwo getSecondAngle() {
        return secondAngle;
    }

    public RoomThree getThirdAngle(){
        return thirdAngle;
    }

    public JPanel getPane(){
        return view.getPane();
    }

}
