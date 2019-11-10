package m2;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VoiceMailSystemUi extends JFrame {
    private final int FIELD_WIDTH = 10;
    private JFrame frame;
    private JButton adminButton;
    private JButton enterButton;
    private JButton callerButton;
    private JButton userButton;
    private JButton create, setPass, play, delete, next, greeting, setGreeting, changeGreeting, greeting1, greeting2, greeting3, leaveMess;
    private JTextField passcodeTextField, mailboxPassword;
    private JTextField mailboxTextField;
    private JTextField leaveAMessageTextField, playMessageTextfield;
    private MailBoxSystem mailboxSystem;



    //private JTextField extTextField;
    private JLabel welcomeMessage, greetings, Ext, password;

    public VoiceMailSystemUi() {
        super("Voice Mail System");
        // Initialize our back end
    	mailboxSystem = new MailBoxSystem();
    	
    	// Initialize the frame
    	init();
    	createMainMenu();
        initComponents();
    }
    
    private void createMainMenu() {
        frame.add(welcomeMessage);
        
        adminButton = new JButton("Admin");
        userButton = new JButton("User");
        callerButton = new JButton("Caller");   
        
        frame.add(adminButton);
        frame.add(userButton);
        frame.add(callerButton); 
        
        adminButton.addActionListener(adminListener);
        userButton.addActionListener(userListener);
        callerButton.addActionListener(callerListener);

    	
    }
    
    private void init() {
    	frame = new JFrame();
    	frame.setLayout(new FlowLayout());
        frame.setBounds(300, 200, 400, 300);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MailBox System");
        welcomeMessage = new JLabel("Welcome");
    } 

    private void initComponents() {
        leaveAMessageTextField = new JTextField(FIELD_WIDTH);
        playMessageTextfield = new JTextField(FIELD_WIDTH);
        leaveMess = new JButton("Leave a message");
        greetings = new JLabel("Greeting");
        enterButton = new JButton("Enter");
        next = new JButton("Next message");
        passcodeTextField = new JTextField(FIELD_WIDTH);
        mailboxPassword = new JTextField(FIELD_WIDTH);
        mailboxTextField = new JTextField(FIELD_WIDTH);
        Ext = new JLabel("Please enter extension");
        password = new JLabel("Please enter password ");
        create = new JButton("Create Mailbox");
        setPass = new JButton("Set Password");
        play = new JButton("Play or delete Message");
        delete = new JButton("Delete Message");
        greeting = new JButton("Alter greeting");
        setGreeting = new JButton("Set Greeting");
        changeGreeting = new JButton("Delete greeting");
        greeting1 = new JButton("Greeting 1");
        greeting2 = new JButton("Greeting 2");
        greeting3 = new JButton("Greeting 3");
        
        frame.setVisible(true);

    }
    
    public ActionListener callerListener = new
    ActionListener() {

        public void actionPerformed(ActionEvent e) {
            frame.add(leaveMess);
            leaveMess.addActionListener(leaveMessListenerCaller);
            adminButton.setVisible(false);
            userButton.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();

        }
    };

    public ActionListener leaveMessListenerCaller = new
    ActionListener() {


        public void actionPerformed(ActionEvent e) {
            frame.add(leaveAMessageTextField);
            frame.add(enterButton);
            leaveMess.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();
            enterButton.addActionListener(leaveMsgListener);


        }
    };
    public ActionListener leaveMsgListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Message msg = new Message(leaveAMessageTextField.getText());
            //2mailSystem.add(msg);

        }

    };
    public ActionListener adminListener = new
    ActionListener() {
        public void actionPerformed(ActionEvent event) {

            frame.add(passcodeTextField);
            frame.add(password);

            frame.add(enterButton);
           

            callerButton.setVisible(false);
            userButton.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();
            
            enterButton.addActionListener(enterListenerAdmin);
        }
    };
    public ActionListener userListener = new
    ActionListener() {
        public void actionPerformed(ActionEvent event) {

            frame.add(Ext);
            frame.add(mailboxPassword);
            frame.add(password);
            frame.add(mailboxTextField);
            frame.add(enterButton);

            adminButton.setVisible(false);
            frame.revalidate();
            frame.pack();
            frame.repaint();
            callerButton.setVisible(false);
            enterButton.addActionListener(enterListenerUser);
        }
    };


    public ActionListener enterListenerAdmin = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	if(mailboxSystem.isPasswordCorrect(passcodeTextField.getText())) {
        		frame.add(create);
                frame.add(setPass);

                enterButton.setVisible(false);
                passcodeTextField.setVisible(false);
                password.setVisible(false);
                Ext.setVisible(false);
                mailboxTextField.setVisible(false);

                enterButton.setVisible(false);
                frame.revalidate();
                frame.pack();
                frame.repaint();
                create.addActionListener(createMailboxListener);
                setPass.addActionListener(setPassListener);
        	}

        }

    };
    public ActionListener createMailboxListener = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	mailboxSystem.createMailbox();
        }
    };
    public ActionListener setPassListener = new
    ActionListener() {

        //display list of accounts and action listener to which you want to change
        public void actionPerformed(ActionEvent e) {


        }
    };
    public ActionListener enterListenerUser = new
    ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	int ext = Integer.parseInt(mailboxTextField.getText());
        	
        	Mailbox currentMailBox = mailboxSystem.getMailBox(ext);
        	
        	if (currentMailBox != null && currentMailBox.isPasswordCorrect(mailboxPassword.getText())) {
        		frame.add(play);
                frame.add(greeting);

                enterButton.setVisible(false);
                mailboxPassword.setVisible(false);
                password.setVisible(false);
                Ext.setVisible(false);
                mailboxTextField.setVisible(false);


                frame.revalidate();
                frame.pack();
                frame.repaint();
                play.addActionListener(playMailboxListener);
                greeting.addActionListener(greetingMailListener);
        	}

        }

    };


    public ActionListener playMailboxListener = new
    ActionListener() {

        //display all messages 
        public void actionPerformed(ActionEvent e) {
            frame.add(playMessageTextfield);
            frame.add(delete);
            frame.add(next);
           // playMessageTextfield.setText(t);

            play.setVisible(false);

            greeting.setVisible(false);

        }
    };

    //public ActionListener deleteMailListener = new
    //    ActionListener() {

    //public void actionPerformed(ActionEvent e) {

    //			play.setVisible(false);
    //			delete.setVisible(false);
    //			greeting.setVisible(false);
    //}
    //};

    public ActionListener greetingMailListener = new
    ActionListener() {

        //display greetings  
        public void actionPerformed(ActionEvent e) {
            frame.add(setGreeting);
            frame.add(changeGreeting);
            play.setVisible(false);
            delete.setVisible(false);
            greeting.setVisible(false);
            setGreeting.addActionListener(setGreetingListener);
            changeGreeting.addActionListener(changeGreetingListener);

        }
    };
    public ActionListener setGreetingListener = new
    ActionListener() {
        //display greeting and select which one to select
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.add(greeting1);
            frame.add(greeting2);
            frame.add(greeting3);
            setGreeting.setVisible(false);
            changeGreeting.setVisible(false);


        }
    };
    public ActionListener changeGreetingListener = new
    ActionListener() {
        //pick a greeting and change it
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.add(greeting1);
            frame.add(greeting2);
            frame.add(greeting3);
            setGreeting.setVisible(false);
            changeGreeting.setVisible(false);

        }
    };

    public static void main(String[] argu) {
        new VoiceMailSystemUi();
    }

}