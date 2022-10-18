package Game.Collectibles.Zoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoomFrame extends JFrame{

    private JPanel imagePanel;
    private JButton close;
    private JLabel roomLabel;
        int width = 1000;
        int height = 800;
        JScrollPane jScrollPane;
        ImageIcon roomImage;

        JFrame frame;
        public ZoomFrame(){
            this.setPreferredSize(new Dimension(width, height));

            frame = this;

            //current Room Image

            imagePanel =new JPanel();
            imagePanel.setLayout(new FlowLayout());

            roomImage = new ImageIcon( new ImageIcon("src/Images/Room1.png").getImage().getScaledInstance(width*3, height*3, Image.SCALE_DEFAULT));
            roomLabel = new JLabel(roomImage);
            roomLabel.setLayout(new FlowLayout());

            imagePanel.setBounds(0,0, roomImage.getIconWidth(), roomImage.getIconHeight());

            ImageIcon closeButton = new ImageIcon(new ImageIcon("src/Images/close.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            close = new JButton(closeButton);
            close.setBorderPainted(false);
            close.setBorder(null);
            close.setContentAreaFilled(false);
            close.setBounds(100,100,50,50);
            activeCloseButton();

            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });

            roomLabel.add(close);
            imagePanel.add(roomLabel);
            addScrollBar();

            pack();
            setVisible(true);
            setLocationRelativeTo(null);


        }

        public void addScrollBar(){
            jScrollPane = new JScrollPane(imagePanel);
            HandScrollListener scrollListener = new HandScrollListener(roomLabel);
            jScrollPane.getViewport().addMouseMotionListener(scrollListener);
            jScrollPane.getViewport().addMouseListener(scrollListener);

            jScrollPane.getVerticalScrollBar().setUnitIncrement(10);
            jScrollPane.getHorizontalScrollBar().setUnitIncrement(10);

            jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

            this.add(jScrollPane);
        }

        public void activeCloseButton(){
            close.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });

        }

}
