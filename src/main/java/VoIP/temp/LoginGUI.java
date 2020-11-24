//package VoIP.Client;

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
        tabMain = new JTabbedPane();
        panLogin = new JPanel();
        panRegister = new JPanel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        labLogUsername = new JLabel();
        labLogPassword = new JLabel();
        butLogin = new JButton();
        labLogError = new JLabel();
        labLogHeader = new JLabel();
        butForgotPassword = new JButton();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        labRegUsername = new JLabel();
        labRegPassword = new JLabel();
        butRegister = new JButton();
        labRegError = new JLabel();
        labRegHeading = new JLabel();
        labRegEmail = new JLabel();
        jTextField5 = new JTextField();
        labBackground = new JLabel();

        // Settings of Components
        tabMain.addTab("Register", panRegister);

        tabMain.setBounds(190, 160, 410, 270);

        labBackground.setIcon(new ImageIcon(getClass().getResource("/LoginBG.jpg"))); // NOI18N

        labBackground.setBounds(0, 0, 800, 600);

        tabMain.setPreferredSize(new Dimension(400, 300));

        panLogin.setPreferredSize(new Dimension(400, 300));

        labLogUsername.setText("Username");

        labLogPassword.setText("Password");

        butLogin.setText("Login");

        labLogError.setForeground(new Color(255, 0, 0));
        labLogError.setHorizontalAlignment(SwingConstants.CENTER);
        labLogError.setText("<Error Message goes here>");

        labLogHeader.setFont(new Font("Yrsa SemiBold", 1, 48)); // NOI18N
        labLogHeader.setHorizontalAlignment(SwingConstants.CENTER);
        labLogHeader.setText("Welcome Back");

        butForgotPassword.setText("Forgot Password?");

        panLogin.setBackground(new Color(255, 255, 255, 200));
        tabMain.addTab("Login", panLogin);

        panRegister.setPreferredSize(new Dimension(400, 300));

        labRegUsername.setText("Username");

        labRegPassword.setText("Password");

        butLogin.setBackground(new Color(255, 255, 255, 200));
        butRegister.setText("Login");

        labRegError.setForeground(new Color(255, 0, 0));
        labRegError.setHorizontalAlignment(SwingConstants.CENTER);
        labRegError.setText("<Error Message goes here>");

        labRegHeading.setFont(new Font("Yrsa SemiBold", 1, 48)); // NOI18N
        labRegHeading.setHorizontalAlignment(SwingConstants.CENTER);
        labRegHeading.setText("Welcome to VoIP!");

        labRegEmail.setText("Email: ");

        panLogin.setBackground(new Color(255, 255, 255, 200));

        // Panel Layouts
        GroupLayout panLoginLayout = new GroupLayout(panLogin);
        panLogin.setLayout(panLoginLayout);
        panLoginLayout.setHorizontalGroup(
            panLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panLoginLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panLoginLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(butForgotPassword)
                    .addGroup(panLoginLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labLogHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panLoginLayout.createSequentialGroup()
                            .addComponent(labLogError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(butLogin, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panLoginLayout.createSequentialGroup()
                            .addComponent(labLogPassword)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panLoginLayout.createSequentialGroup()
                            .addComponent(labLogUsername)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 68, Short.MAX_VALUE))
        );
        panLoginLayout.setVerticalGroup(
            panLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panLoginLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labLogHeader, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labLogUsername)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labLogPassword))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butForgotPassword)
                .addGap(2, 2, 2)
                .addGroup(panLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butLogin)
                    .addComponent(labLogError))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout panRegisterLayout = new GroupLayout(panRegister);
        panRegister.setLayout(panRegisterLayout);
        panRegisterLayout.setHorizontalGroup(
            panRegisterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRegisterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panRegisterLayout.createSequentialGroup()
                        .addComponent(labRegHeading, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(panRegisterLayout.createSequentialGroup()
                        .addGroup(panRegisterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panRegisterLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panRegisterLayout.createSequentialGroup()
                                    .addComponent(labRegError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(butRegister, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panRegisterLayout.createSequentialGroup()
                                    .addComponent(labRegUsername)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panRegisterLayout.createSequentialGroup()
                                .addComponent(labRegEmail)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panRegisterLayout.createSequentialGroup()
                                .addComponent(labRegPassword)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panRegisterLayout.setVerticalGroup(
            panRegisterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panRegisterLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labRegHeading, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panRegisterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(labRegUsername)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRegisterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labRegEmail))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panRegisterLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labRegPassword)
                    .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panRegisterLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labRegError)
                    .addComponent(butRegister))
                .addContainerGap())
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
    private JLabel labBackground;
    private JLabel labRegEmail;
    private JButton butForgotPassword;
    private JLabel labLogUsername;
    private JLabel labLogPassword;
    private JLabel labLogError;
    private JLabel labLogHeader;
    private JLabel labRegUsername;
    private JLabel labRegPassword;
    private JLabel labRegError;
    private JLabel labRegHeading;
    private JPanel panLogin;
    private JPanel panRegister;
    private JTabbedPane tabMain;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
}
