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

    public LoginGUI getGUI() {
        return this;
    }

    private void listeners() {
        butLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                // TODO: Check if credialtials are there.
                try {
                /* Applies the system look and feel */
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
                } catch (UnsupportedLookAndFeelException e) {
                   System.out.println("System look and feel unsupported.\n" + e);
                } catch (ClassNotFoundException e) {
                   System.out.println("System look and feel class could not be found.\n" + e);
                } catch (InstantiationException e) {
                   System.out.println("System look and feel could not be initialized.\n" + e);
                } catch (IllegalAccessException e) {
                   System.out.println("Illegal Access Exception.\n" + e);
                }

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ChatGUI();
                        getGUI().dispose();
                    }
                });
            }
        });

        butRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                // TODO: Check if info is filled in correctly
                new ChatGUI();
                getGUI().dispose();
            }
        });
    }

    private void initComponents() {
        // Initialise Main Components.
        UIManager.put("TabbedPane.contentOpaque", false);
        labBackground   = new JLabel();
        tabMain         = new JTabbedPane();

        // Initialise Login Components
        panLogin        = new JPanel();
        txfLogUsername  = new JTextField();
        txfLogPassword  = new JTextField();
        labLogUsername  = new JLabel();
        labLogPassword  = new JLabel();
        butLogin        = new JButton();
        labLogError     = new JLabel();
        labLogHeader    = new JLabel();
        butFrgtPassword = new JButton();

        // Initialise Register Components
        panRegister     = new JPanel();
        txfRegUsername  = new JTextField();
        txfRegPassword  = new JTextField();
        labRegUsername  = new JLabel();
        labRegPassword  = new JLabel();
        butRegister     = new JButton();
        labRegError     = new JLabel();
        labRegHeader   = new JLabel();
        labRegEmail     = new JLabel();
        txfRegEmail     = new JTextField();

        // Settings of Main Components
        try {
            labBackground.setIcon(new ImageIcon(getClass().getResource("/LoginBG.jpg")));
        } catch (Exception e) {
            labBackground.setIcon(new ImageIcon(getClass().getResource("../Images/LoginBG.jpg")));
        }
        labBackground.setBounds(0, 0, 800, 600);

        tabMain.addTab("Login", panLogin);
        tabMain.addTab("Register", panRegister);
        tabMain.setBounds(190, 160, 410, 270);
        tabMain.setPreferredSize(new Dimension(400, 300));
        tabMain.setBackground(new Color(255, 255, 255, 200));

        // Settings of Login Components
        panLogin.setPreferredSize(new Dimension(400, 300));
        panLogin.setBackground(new Color(255, 255, 255, 200));

        labLogHeader.setFont(new Font("Yrsa SemiBold", 1, 48));
        labLogHeader.setHorizontalAlignment(SwingConstants.CENTER);
        labLogHeader.setText("Welcome Back");
        labLogUsername.setText("Username: ");
        labLogPassword.setText("Password: ");
        labLogError.setForeground(new Color(255, 0, 0)); // RED
        labLogError.setText("<Error Message goes here>"); //TEMP: To be removed.
        labLogError.setHorizontalAlignment(SwingConstants.CENTER);

        butLogin.setText("Login");
        butFrgtPassword.setText("Forgot Password?");

        // Settings of Login Components
        panRegister.setPreferredSize(new Dimension(400, 300));
        panRegister.setBackground(new Color(255, 255, 255, 200));

        labRegHeader.setFont(new Font("Yrsa SemiBold", 1, 48));
        labRegHeader.setHorizontalAlignment(SwingConstants.CENTER);
        labRegHeader.setText("Welcome to VoIP!");
        labRegUsername.setText("Username: ");
        labRegEmail.setText("Email: ");
        labRegPassword.setText("Password: ");
        labRegError.setForeground(new Color(255, 0, 0));
        labRegError.setHorizontalAlignment(SwingConstants.CENTER);
        labRegError.setText("<Error Message goes here>");

        butRegister.setText("Register");

        // Panel Layouts
        GroupLayout layLogin = new GroupLayout(panLogin);
        panLogin.setLayout(layLogin);

        layLogin.setHorizontalGroup(
            layLogin.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layLogin.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(labLogHeader, 350, 350, 350)
                    .addGroup(layLogin.createSequentialGroup()
                        .addComponent(labLogError, 250, 250, 250)
                        .addComponent(butLogin, 100, 100, 100))
                    .addGroup(layLogin.createSequentialGroup()
                        .addComponent(labLogPassword, 85, 85, 85)
                        .addComponent(txfLogPassword, 265, 265, 265))
                    .addGroup(layLogin.createSequentialGroup()
                        .addComponent(labLogUsername, 85, 85, 85)
                        .addComponent(txfLogUsername, 265, 265, 265))
                    .addComponent(butFrgtPassword))
                .addGap(25, 25, 25)
        );

        layLogin.setVerticalGroup(
            layLogin.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labLogHeader)
                .addGroup(layLogin.createParallelGroup()
                    .addComponent(labLogUsername)
                    .addComponent(txfLogUsername))
                .addGap(12, 12, 12)
                .addGroup(layLogin.createParallelGroup()
                    .addComponent(labLogPassword)
                    .addComponent(txfLogPassword))
                .addGap(12, 12, 12)
                .addComponent(butFrgtPassword)
                .addGap(12, 12, 12)
                .addGroup(layLogin.createParallelGroup()
                    .addComponent(labLogError)
                    .addComponent(butLogin))
                .addGap(25, 25, 25)
            );


        GroupLayout layRegister = new GroupLayout(panRegister);
        panRegister.setLayout(layRegister);
        layRegister.setHorizontalGroup(
            layRegister.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layRegister.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(labRegHeader, 350, 350, 350)
                    .addGroup(layRegister.createSequentialGroup()
                        .addComponent(labRegError, 250, 250, 250)
                        .addComponent(butRegister, 100, 100, 100))
                    .addGroup(layRegister.createSequentialGroup()
                        .addComponent(labRegPassword, 85, 85, 85)
                        .addComponent(txfRegPassword, 265, 265, 265))
                    .addGroup(layRegister.createSequentialGroup()
                        .addComponent(labRegUsername, 85, 85, 85)
                        .addComponent(txfRegUsername, 265, 265, 265))
                    .addGroup(layRegister.createSequentialGroup()
                        .addComponent(labRegEmail, 85, 85, 85)
                        .addComponent(txfRegEmail, 265, 265, 265)))
                .addGap(25, 25, 25)
        );
        /*
        layRegister.setHorizontalGroup(
            layRegister.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layRegister.createSequentialGroup()
                .addContainerGap()
                .addGroup(layRegister.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layRegister.createSequentialGroup()
                        .addComponent(labRegHeader, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(layRegister.createSequentialGroup()
                        .addGroup(layRegister.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layRegister.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layRegister.createSequentialGroup()
                                    .addComponent(labRegError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(butRegister, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layRegister.createSequentialGroup()
                                    .addComponent(labRegUsername)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfRegUsername, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layRegister.createSequentialGroup()
                                .addComponent(labRegEmail)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfRegEmail, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layRegister.createSequentialGroup()
                                .addComponent(labRegPassword)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfRegPassword, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );*/
        layRegister.setVerticalGroup(
            layRegister.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labRegHeader)
                .addGroup(layRegister.createParallelGroup()
                    .addComponent(labRegUsername)
                    .addComponent(txfRegUsername))
                .addGap(12, 12, 12)
                .addGroup(layRegister.createParallelGroup()
                    .addComponent(labRegPassword)
                    .addComponent(txfRegPassword))
                .addGap(12, 12, 12)
                .addGroup(layRegister.createParallelGroup()
                    .addComponent(labRegEmail)
                    .addComponent(txfRegEmail))
                .addGap(12, 12, 12)
                .addGroup(layRegister.createParallelGroup()
                    .addComponent(labRegError)
                    .addComponent(butRegister))
                .addGap(25, 25, 25)
            );

        // Frame Settings
        getContentPane().add(tabMain);
        getContentPane().add(labBackground);
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
    private JButton butRegister;
    private JButton butFrgtPassword;
    private JLabel labLogPassword;
    private JLabel labRegPassword;
    private JLabel labLogUsername;
    private JLabel labRegUsername;
    private JLabel labBackground;
    private JLabel labLogHeader;
    private JLabel labRegHeader;
    private JLabel labLogError;
    private JLabel labRegError;
    private JLabel labRegEmail;
    private JPanel panRegister;
    private JPanel panLogin;
    private JTextField txfLogUsername;
    private JTextField txfLogPassword;
    private JTextField txfRegUsername;
    private JTextField txfRegPassword;
    private JTextField txfRegEmail;
    private JTabbedPane tabMain;
}
