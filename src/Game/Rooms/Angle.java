package Game.Rooms;

import Game.InteractiveObj.Mirror.MirrorFrame;
import Game.InteractiveObj.Safe.SafeFrame;
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
        openBox();
        openCloset();
        openSafe();

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
                secondAngle.getSafe().setSafe(secondAngle.getSafe().getSafeLabel(), true);
            }
        });

        secondAngle.getPainting().getOpenedPaintingLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                secondAngle.getPainting().setPainting(secondAngle.getPainting().getClosedPaintingLabel(), true);
                secondAngle.getPainting().setPainting(secondAngle.getPainting().getOpenedPaintingLabel(), false);
                secondAngle.getSafe().setSafe(secondAngle.getSafe().getSafeLabel(), false);

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

    private void openBox(){
        fourthAngle.getBox().getClosedBoxLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fourthAngle.getBox().setBox(fourthAngle.getBox().getClosedBoxLabel(), false);
                fourthAngle.getBox().setBox(fourthAngle.getBox().getOpenedBoxLabel(), true);
            }
        });

        fourthAngle.getBox().getOpenedBoxLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fourthAngle.getBox().setBox(fourthAngle.getBox().getClosedBoxLabel(), true);
                fourthAngle.getBox().setBox(fourthAngle.getBox().getOpenedBoxLabel(), false);
            }
        });

    }

    private void openCloset(){
        thirdAngle.getCloset().getClosedClosetLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thirdAngle.getCloset().setCloset(thirdAngle.getCloset().getClosedClosetLabel(), false);
                thirdAngle.getCloset().setCloset(thirdAngle.getCloset().getOpenedClosetLabel(), true);
            }
        });

        thirdAngle.getCloset().getOpenedClosetLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thirdAngle.getCloset().setCloset(thirdAngle.getCloset().getClosedClosetLabel(), true);
                thirdAngle.getCloset().setCloset(thirdAngle.getCloset().getOpenedClosetLabel(), false);
            }
        });

    }

    private void openSafe(){
        secondAngle.getSafe().getSafeLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame safeFrame = new JFrame();
                safeFrame.setSize(800,600);
                safeFrame.setVisible(true);
                safeFrame.setLocationRelativeTo(null);
                try {
                    new SafeFrame(safeFrame, inv);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
