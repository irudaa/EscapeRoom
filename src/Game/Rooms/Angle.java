package Game.Rooms;

import Game.InteractiveObj.Mirror.MirrorFrame;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Angle extends JComponent{

    private AngleView view;
    private JFrame frame;
    private RoomOne firstAngle;
    private RoomTwo secondAngle;
    private RoomThree thirdAngle;

    private RoomFour fourthAngle;

    private InventoryView inv;


    public Angle( JFrame frame, InventoryView inv){
        this.frame = frame;
        this.inv = inv;
        view = new AngleView(frame, inv);
        firstAngle = view.startRoomOne();
        secondAngle = view.startRoomTwo();
        thirdAngle = view.startRoomThree();
        fourthAngle = view.startRoomFour();
        openDrawer();
        openMirror();
        openPainting();
        openPillow();

    }

    public void openDrawer(){
        firstAngle.getDrawer().getClosedDrawerLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                firstAngle.getDrawer().setDrawer(firstAngle.getDrawer().getClosedDrawerLabel(), false);
                firstAngle.getDrawer().setDrawer(firstAngle.getDrawer().getOpenedDrawerLabel(), true);
            }
        });

        firstAngle.getDrawer().getOpenedDrawerLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                firstAngle.getDrawer().setDrawer(firstAngle.getDrawer().getClosedDrawerLabel(), true);
                firstAngle.getDrawer().setDrawer(firstAngle.getDrawer().getOpenedDrawerLabel(), false);
            }
        });
    }

    private void openMirror(){
        thirdAngle.getMirror().getMirrorLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame mirrorFrame = new JFrame();
                mirrorFrame.setSize(800,600);
                mirrorFrame.setVisible(true);
                mirrorFrame.setLocationRelativeTo(null);
                try {
                    new MirrorFrame(mirrorFrame);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void openPainting(){
        secondAngle.getPainting().getClosedPaintingLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                secondAngle.getPainting().setPainting(secondAngle.getPainting().getClosedPaintingLabel(), false);
                secondAngle.getPainting().setPainting(secondAngle.getPainting().getOpenedPaintingLabel(), true);
            }
        });

        secondAngle.getPainting().getOpenedPaintingLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                secondAngle.getPainting().setPainting(secondAngle.getPainting().getClosedPaintingLabel(), true);
                secondAngle.getPainting().setPainting(secondAngle.getPainting().getOpenedPaintingLabel(), false);
            }
        });

    }


    private void openPillow(){
        fourthAngle.getPillow().getClosedPillowLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fourthAngle.getPillow().setPillow(fourthAngle.getPillow().getClosedPillowLabel(), false);
                fourthAngle.getPillow().setPillow(fourthAngle.getPillow().getOpenedPillowLabel(), true);
            }
        });

        fourthAngle.getPillow().getOpenedPillowLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fourthAngle.getPillow().setPillow(fourthAngle.getPillow().getClosedPillowLabel(), true);
                fourthAngle.getPillow().setPillow(fourthAngle.getPillow().getOpenedPillowLabel(), false);
            }
        });

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

    public RoomFour getFourthAngle() {
        return fourthAngle;
    }

}
