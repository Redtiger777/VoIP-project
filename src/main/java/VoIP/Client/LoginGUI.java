package VoIP.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class LoginGUI extends JFrame {

    public LoginGUI() {
        initComponents();
        listeners();
    }

    private void listeners() {
        butLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                System.out.println("Hello World!");
            }
        });
    }

    private void initComponents() {
        // Initialise Components.
        panBlock = new JPanel();
        txfUsername = new JTextField();
        txfIPAddress = new JTextField();
        labIPAddress = new JLabel("Server IP Address :");
        labUsername = new JLabel("Username :");
        butLogin = new JButton("Login");
        labError = new JLabel();
        labHeader = new JLabel("Welcome to VoIP!");
        labBG = new JLabel();

        // Settings of Components
        labError.setText("<Error Message goes here>"); //TEMP
        labError.setForeground(new Color(255, 0, 0));
        labError.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            labBG.setIcon(new ImageIcon(getClass().getResource("/LoginBG.jpg")));
        } catch (Exception e) {
            labBG.setIcon(new ImageIcon(getClass().getResource("../Images/LoginBG.jpg")));
        }

        labHeader.setHorizontalAlignment(SwingConstants.CENTER);
        labHeader.setFont(new Font("Yrsa SemiBold", 1, 48));

        panBlock.setBounds(200, 150, 400, 300);
        panBlock.setSize(new Dimension(400, 300));
        panBlock.setBackground(new Color(255, 255, 255, 180));

        // Panel layout.
        GroupLayout panLayout = new GroupLayout(panBlock);
        panBlock.setLayout(panLayout);
        panLayout.setHorizontalGroup(
            panLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panLayout.createParallelGroup()
                    .addComponent(labHeader)
                    .addGroup(panLayout.createSequentialGroup()
                        .addComponent(labIPAddress, 140, 140, 140)
                        .addComponent(txfIPAddress, 210, 210, 210))
                    .addGroup(panLayout.createSequentialGroup()
                        .addComponent(labUsername, 140, 140, 140)
                        .addComponent(txfUsername, 210, 210, 210))
                    .addGroup(panLayout.createSequentialGroup()
                        .addComponent(labError, 265, 265, 265)
                        .addGap(10,10,10)
                        .addComponent(butLogin, 75, 75, 75)))
                .addGap(25, 25, 25)

        );
        panLayout.setVerticalGroup(
            panLayout.createSequentialGroup()
            .addGap(25,25,25)
            .addComponent(labHeader)
            .addGap(35,35,35)
            .addGroup(panLayout.createParallelGroup()
                .addComponent(labIPAddress, 25, 25, 25)
                .addComponent(txfIPAddress, 25, 25, 25))
            .addGap(20,20,20)
            .addGroup(panLayout.createParallelGroup()
                .addComponent(labUsername, 25, 25, 25)
                .addComponent(txfUsername, 25, 25, 25))
            .addGap(20,20,20)
            .addGroup(panLayout.createParallelGroup()
                .addComponent(labError, 25, 25, 25)
                .addComponent(butLogin, 25, 25, 25))
            .addGap(40,40,40)
        );

        // Frame Settings
        getContentPane().add(panBlock);
        getContentPane().add(labBG);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public static void main(String args[]) {
        new LoginGUI();
    }

    private JButton butLogin;
    private JLabel labBG;
    private JLabel labIPAddress;
    private JLabel labUsername;
    private JLabel labError;
    private JLabel labHeader;
    private JPanel panBlock;
    private JTextField txfUsername;
    private JTextField txfIPAddress;
}
