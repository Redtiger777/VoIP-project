import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatGUI extends JFrame {
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
        LeftPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        RightPanel = new JPanel();
        jScrollPane2 = new JScrollPane();
        modChannel = new DefaultListModel<>();
        lstChannel = new JList<>(modChannel);
        modOnlineUser = new DefaultListModel<>();
        lstOnlineUser = new JList<>(modOnlineUser);
        CentrePanel = new JPanel();
        jScrollPane3 = new JScrollPane();
        chatTextArea = new JTextArea();
        messageField = new JTextField();
        sendButton = new JButton();
        headerPanel = new JPanel();
        headerLabel = new JLabel();

        // Action listeners
        lstOnlineUser.addMouseListener(mouseListener);
        lstChannel.addMouseListener(mouseListener);

        // Component initialization
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat screen");
        setFont(new java.awt.Font("Ubuntu", 0, 10));
        setMinimumSize(new java.awt.Dimension(800, 600));

        modChannel.addElement("Global");
        lstChannel.setName("ChannelList");
        lstOnlineUser.setName("");


        jScrollPane1.setViewportView(lstChannel);
        jScrollPane2.setViewportView(lstOnlineUser);
        jScrollPane3.setViewportView(chatTextArea);

        chatTextArea.setEditable(true);
        chatTextArea.setColumns(20);
        chatTextArea.setRows(5);
        messageField.setEnabled(true);
        messageField.setEditable(true);
        sendButton.setText("Send");

        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setText("Channel name");

        GroupLayout LeftPanelLayout = new GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout RightPanelLayout = new GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        sendButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                sendButtonMouseClicked(evt);
            }
        });

        messageField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                messageFieldKeyPressed(evt);
            }
        });


        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerLabel)
                .addContainerGap())
        );

        GroupLayout CentrePanelLayout = new GroupLayout(CentrePanel);
        CentrePanel.setLayout(CentrePanelLayout);
        CentrePanelLayout.setHorizontalGroup(
            CentrePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
            .addGroup(CentrePanelLayout.createSequentialGroup()
                .addComponent(messageField)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton))
            .addComponent(headerPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CentrePanelLayout.setVerticalGroup(
            CentrePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(CentrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CentrePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LeftPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CentrePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(CentrePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LeftPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        messageField.requestFocusInWindow();
    }

    private void sendButtonMouseClicked(MouseEvent evt) {
        System.out.println("The button has been clicked");
        int currIndex = modOnlineUser.getSize() + 1;
        modOnlineUser.addElement("Client " + currIndex);
    }

    private void messageFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && currChannel != "") {
            System.out.println("Messege to be sent: " + messageField.getText());
        }
    }

    private void addListItem() {

    }

    private void changeHeader(String newName) {
        headerLabel.setText(newName);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatGUI().setVisible(true);
            }
        });
    }

    // Global variables declaration
    private JPanel CentrePanel;
    private JPanel LeftPanel;
    private JPanel RightPanel;
    private JList<String> lstChannel;
    private JTextArea chatTextArea;
    private JLabel headerLabel;
    private JPanel headerPanel;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTextField messageField;
    private DefaultListModel<String> modOnlineUser;
    private DefaultListModel<String> modChannel;
    private JList<String> lstOnlineUser;
    private JButton sendButton;
    private MouseListener mouseListener;
    private String selectedLstItem = "";
    private String currChannel = "";
}
