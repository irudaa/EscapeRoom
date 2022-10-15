package Game.InteractiveObj.Safe;
import Game.Collectibles.Key;
import Game.InteractiveObj.Mirror.MirrorFrame;
import Game.Inventory.Inventory;
import Game.Inventory.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

public class SafeFrame {

    private Key key;
    private JLabel safeOpen;
    // private JPanel safePanel;
        private JLayeredPane safeLayers;

        private List<Point> points;

        private int x = 0;
        private int y = 0;
        private int width=800;
        private int height=650;

        private JPanel numbers;

        private JTextField password;

        private String mainSentence = "Type the code.";
        private String correctPass = "3675";
        private String error = " Wrong! ";
        private String enteredPass = "";
        private JLabel safeCode;

        private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, enter;

    GridBagConstraints constraints = new GridBagConstraints( );

    public SafeFrame(JFrame frame, InventoryView inv) throws IOException {
      //  Closed Safe

        ImageIcon safeCodeImg = new ImageIcon( new ImageIcon("src/Images/Angle 10.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        safeCode = new JLabel(safeCodeImg);

        //Open Safe
        ImageIcon safeOpenImg = new ImageIcon( new ImageIcon("src/Images/Angle 19.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        safeOpen = new JLabel(safeOpenImg);
        safeOpen.setVisible(false);

        numbers = new JPanel(new GridBagLayout());
        numbers.setBounds(240, 80, 400, 500);
        numbers.setOpaque(false);

        password = new JTextField(mainSentence);
        password.setDisabledTextColor(Color.black);
        password.setCaretColor(Color.LIGHT_GRAY);
        password.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        password.setSize(246, 40);
        password.setBounds(265, 155, 300, 60);
        password.setEnabled(false);

        key = new Key(new Dimension(100, 50), new Point(450, 450), inv);
        key.getLabel().setBounds((int)key.getPos().getX(), (int)key.getPos().getY(), (int) key.getSize().getWidth(), (int)key.getSize().getHeight());
        key.getLabel().setOpaque(false);
        key.isClicked();
        key.getLabel().setVisible(false);
        initializeButtons();

        safeCode.setBounds(0, 0, width, height);
        safeOpen.setBounds(0, 0, width, height);
        safeLayers = frame.getLayeredPane();
        safeLayers.add(safeCode, new Integer(1));
        safeLayers.add(safeOpen, new Integer(1));
        safeLayers.add(numbers, new Integer(2));
        safeLayers.add(password, new Integer(3));
        safeLayers.add(key.getLabel(), new Integer(4));


    }

    public void initializeButtons(){
        button1 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button1.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button1.setContentAreaFilled(false);
        addGB(button1, x = 0, y = 0);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "1";
                password.setText(enteredPass);
            }
        });


        button2 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button2.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button2.setContentAreaFilled(false);
        addGB(button2, x = 1, y = 0);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "2";
                password.setText(enteredPass);

            }
        });


        button3 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button3.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button3.setContentAreaFilled(false);
        addGB(button3, x = 2, y = 0);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "3";
                password.setText(enteredPass);

            }
        });


        button4 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button4.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button4.setContentAreaFilled(false);
        addGB(button4, x = 0, y = 1);
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "4";
                password.setText(enteredPass);

            }
        });


        button5 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button5.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button5.setContentAreaFilled(false);
        addGB(button5, x = 1, y = 1);
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "5";
                password.setText(enteredPass);

            }
        });

        button6 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button6.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button6.setContentAreaFilled(false);
        addGB(button6, x = 2, y = 1);
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "6";
                password.setText(enteredPass);

            }
        });

        button7 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button7.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button7.setContentAreaFilled(false);
        addGB(button7, x = 0, y = 2);
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "7";
                password.setText(enteredPass);

            }
        });

        button8 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button8.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button8.setContentAreaFilled(false);
        addGB(button8, x = 1, y = 2);
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "8";
                password.setText(enteredPass);

            }
        });

        button9 = new JButton(new ImageIcon( new ImageIcon("src/Images/Button9.png").getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT)));
        button9.setContentAreaFilled(false);
        addGB(button9, x = 2, y = 2);
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enteredPass = enteredPass + "9";
                password.setText(enteredPass);

            }
        });

        enter = new JButton(new ImageIcon( new ImageIcon("src/Images/Group 12.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
        enter.setContentAreaFilled(false);
        addGB(enter, x = 4, y = 2);
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(enteredPass.equals(correctPass)){
                    safeCode.setVisible(false);
                    numbers.setVisible(false);
                    password.setVisible(false);
                    safeOpen.setVisible(true);
                    key.getLabel().setVisible(true);
                    System.out.println(key.getLabel().isVisible());
                }else{
                    password.setText(error);
                    enteredPass = "";
                }
            }
        });
    }

    void addGB(Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        numbers.add(component, constraints);
    }



    public JPanel getNumbers(){
        return numbers;
    }

}
