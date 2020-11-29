import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatGUI extends JFrame {

    // Global variables declaration
    private JPanel pnlCentre;
    private JPanel pnlLeft;
    private JPanel pnlRight;
    private JTextArea txaChat;
    private JLabel lblHeader;
    private JLabel lblChannels;
    private JLabel lblOnlUsers;
    private JLabel lblCall;
    private JPanel headerPanel;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTextField txfMessage;
    private DefaultListModel<String> modOnlineUser;
    private DefaultListModel<String> modChannel;
    private JList<String> lstOnlineUser;
    private JList<String> lstChannel;
    private JButton btnSend;
    private MouseListener mouseListener;
    private String selectedLstItem = "";
    private String currChannel = "";
    private String usrName = "Jannie";

    public ChatGUI() {
        this.mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 1) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                        if (!selectedLstItem.equals(o.toString())) {
                            selectedLstItem = o.toString();
                            // Only do the action if it has not been selected
                            System.out.println("Single-clicked on: " + selectedLstItem);
                            if (theList.getName().equals("ChannelList")) {
                                changeHeader(selectedLstItem);
                                currChannel = selectedLstItem;
                                showCentreComp();
                                txfMessage.requestFocusInWindow();
                            }
                        }
                    }
                } else if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                        System.out.println("Double-clicked on: " + o.toString());
                    }
                }
            }
        };

        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Component creation
        pnlLeft = new JPanel();
        jScrollPane1 = new JScrollPane();
        pnlRight = new JPanel();
        jScrollPane2 = new JScrollPane();
        modChannel = new DefaultListModel<>();
        lstChannel = new JList<>(modChannel);
        modOnlineUser = new DefaultListModel<>();
        lstOnlineUser = new JList<>(modOnlineUser);
        pnlCentre = new JPanel();
        jScrollPane3 = new JScrollPane();
        txaChat = new JTextArea();
        txfMessage = new JTextField();
        btnSend = new JButton();
        headerPanel = new JPanel();
        lblHeader = new JLabel();
        lblChannels = new JLabel();
        lblOnlUsers = new JLabel();
        lblCall = new JLabel();

        // Action listeners
        lstOnlineUser.addMouseListener(mouseListener);
        lstChannel.addMouseListener(mouseListener);

        // Component initialization
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat screen");
        setFont(new Font("Ubuntu", 0, 10));
        setMinimumSize(new Dimension(800, 600));

        modChannel.addElement("Global");
        lstChannel.setName("ChannelList");
        lstOnlineUser.setName("");


        jScrollPane1.setViewportView(lstChannel);
        jScrollPane2.setViewportView(lstOnlineUser);
        jScrollPane3.setViewportView(txaChat);

        txaChat.setEditable(false);
        txaChat.setColumns(20);
        txaChat.setRows(5);
        txfMessage.setEnabled(true);
        txfMessage.setEditable(true);
        btnSend.setText("Send");

        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setText("Channel name");

        lblChannels.setHorizontalAlignment(SwingConstants.CENTER);
        lblChannels.setText("Channels");

        GroupLayout pnlLeftLayout = new GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblChannels, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChannels)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblOnlUsers.setHorizontalAlignment(SwingConstants.CENTER);
        lblOnlUsers.setText("Online users");

        GroupLayout pnlRightLayout = new GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblOnlUsers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOnlUsers)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        btnSend.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnSendMouseClicked(evt);
            }
        });

        lblCall.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnCallMouseClicked(evt);
            }
        });

        txfMessage.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                txfMessageKeyPressed(evt);
            }
        });


        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(lblHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCall, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.LEADING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCall, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHeader)
                .addGap(23, 23, 23))
        );

        //lblCall.setIcon(new ImageIcon(getClass().getResource("../Images/callGreenSmall.png")));
        lblCall.setIcon(new ImageIcon("../Images/callGreenSmall.png"));
        lblCall.setToolTipText("Call");
        lblCall.setMaximumSize(new Dimension(40, 40));
        lblCall.setMinimumSize(new Dimension(40, 40));

        GroupLayout pnlCentreLayout = new GroupLayout(pnlCentre);
        pnlCentre.setLayout(pnlCentreLayout);
        pnlCentreLayout.setHorizontalGroup(
            pnlCentreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
            .addGroup(pnlCentreLayout.createSequentialGroup()
                .addComponent(txfMessage)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend))
            .addComponent(headerPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlCentreLayout.setVerticalGroup(
            pnlCentreLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCentreLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMessage, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCentre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pnlCentre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        hideCentreComp();

    }
    private void displayWelcome() {

    }
    private void btnSendMouseClicked(MouseEvent evt) {
        String message = txfMessage.getText().trim();
        if (currChannel != "" && !message.equals("")) {
            txaChat.append(usrName + ": " + message + "\n");
            txfMessage.setText("");
        }
    }

    private void btnCallMouseClicked(MouseEvent evt) {
        if (currChannel != "") {
            JOptionPane.showMessageDialog(this, "This feature is under development");
        }
    }

    private void txfMessageKeyPressed(KeyEvent evt) {
        String message = txfMessage.getText().trim();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && currChannel != "" && !message.equals("")) {
            //System.out.println("Messege to be sent: " + message);
            txaChat.append(usrName + ": " + message + "\n");
            txfMessage.setText("");
        }
    }

    private void addListItem(DefaultListModel<String> targetLstModel, String text) {
        targetLstModel.addElement(text);
    }

    private void changeHeader(String newName) {
        lblHeader.setText(newName);
    }

    private ChatGUI getGUI() {
        return this;
    }

    private void hideCentreComp() {
        txaChat.setVisible(false);
        txfMessage.setVisible(false);
        btnSend.setVisible(false);
        lblHeader.setVisible(false);
        lblCall.setVisible(false);
    }

    private void showCentreComp() {
        txaChat.setVisible(true);
        txfMessage.setVisible(true);
        btnSend.setVisible(true);
        lblHeader.setVisible(true);
        lblCall.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatGUI().setVisible(true);
            }
        });
    }
}
