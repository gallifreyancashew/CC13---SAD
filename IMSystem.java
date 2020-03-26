package imsystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class IMSystem extends JFrame implements ItemListener, ActionListener {
    //arrays for saving information
    public int n = 10, ctr = 2;
    public String firstName [] = new String [n];
    public String midName [] = new String [n];    
    public String lastName [] = new String [n];    
    public String email [] = new String [n];  
    public int month [] = new int [n];    
    public int day [] = new int [n];    
    public int year [] = new int [n];    
    public int postcode [] = new int [n];
    public String password [] = new String [n];
    public String accType [] = new String [n];

    //for registration form
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5a, t5b, t5c, t6;
    JPasswordField p1, p2;
    JRadioButton r1, r2;
    ButtonGroup accountType = new ButtonGroup();
    JButton b1, b2; 
    
    IMSystem(){
        setTitle("PHLPost Registration Form");
        setSize(1000,250);
        setResizable(false);
        setVisible(true);
        setLayout (new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lbl1 = new JLabel ("Welcome to PHLPost!"+
                "   Please fill out all your personal information below.");
        add(lbl1, BorderLayout.CENTER);
    //pre-existing customer profiles
        firstName[0] = "Juan";
        midName[0] = "Miguel";
        lastName[0] = "Dela Cruz";
        email[0]="juandelacruz@gmail.com";
        month[0]= 1;
        day[0]=1;
        year[0]=2000;
        postcode[0]=2600;
        password[0]="12345";
        accType[0]="Personal Account";
        
        firstName[1] = "Karel Cassandra";
        midName[1] = "Soriano";
        lastName[1] = "Cruz";
        email[1]="karel.zor.el@gmail.com";
        month[1]= 12;
        day[1]=17;
        year[1]=1999;
        postcode[1]=2600;
        password[1]="abc123";
        accType[1]="Personal Account";
    //text fields    
        l1 = new JLabel ("First Name"); t1 = new JTextField (20);
        l2 = new JLabel ("Middle Name"); t2 = new JTextField (20);
        l3 = new JLabel ("Last Name"); t3 = new JTextField (20);
    //email
        l4 = new JLabel ("Email Address"); t4 = new JTextField (20);      
        l5 = new JLabel ("Date of Birth"); t5a = new JTextField (3); t5b = new JTextField (3); t5c = new JTextField (3);
        l6 = new JLabel ("Postcode"); t6 = new JTextField (20);
        l7 = new JLabel ("Password"); p1 = new JPasswordField (20);
        l8 = new JLabel ("Confirm Password"); p2 = new JPasswordField (20);
        JPanel pan1 = new JPanel();
        pan1.add(l1); 
        pan1.add(t1); 
        pan1.add(l2); 
        pan1.add(t2); 
        pan1.add(l3); 
        pan1.add(t3);
        add(pan1, BorderLayout.CENTER);
        JPanel pan2 = new JPanel();
        pan2.add(l4); 
        pan2.add(t4); 
        pan2.add(l5); 
        pan2.add(t5a); 
        pan2.add(t5b); 
        pan2.add(t5c); 
        pan2.add(l6); 
        pan2.add(t6);
        add(pan2, BorderLayout.CENTER);  
        JPanel pan3 = new JPanel();
        pan3.add(l7); 
        pan3.add(p1); 
        pan3.add(l8); 
        pan3.add(p2);
        add(pan3, BorderLayout.CENTER);
    //radio buttons
        JLabel lbl2 = new JLabel ("Please choose what type of account you would like to create:");
        r1 = new JRadioButton ("Personal Account");
        r2 = new JRadioButton ("Business Account");
        r1.setSelected(true);
        accountType.add(r1);
        accountType.add(r2);
        r1.addItemListener(this);
        r2.addItemListener(this);
        JPanel pan4 = new JPanel ();
        pan4.add(lbl2); 
        pan4.add(r1); 
        pan4.add(r2);
        add(pan4, BorderLayout.CENTER);
    //buttons
        b1 = new JButton ("                Continue                 ");
        b1.addActionListener(this);
        b2 = new JButton ("        I already have an account        ");
        b2.addActionListener(this);
        JPanel pan5 = new JPanel();
        pan5.add(b1); 
        pan5.add(b2);
        add(pan5, BorderLayout.PAGE_END);
    }
    
    @Override
    public void itemStateChanged (ItemEvent e){
        //for personal and business accounts
        Object source = e.getSource();
            if (source == r1){
                accType[ctr]= "Personal Account";
            } else if (source == r2){
                accType[ctr]= "Business Account";
            }        
        }
    
    @Override    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
            if (source == b1) {
                String pass = new String(p1.getPassword());
                String word = new String(p2.getPassword());
                if (pass.equals(word)&&ctr<20){
                    ctr++;
                    firstName[ctr] = t1.getText();
                    midName[ctr] = t2.getText();
                    lastName[ctr] = t3.getText();
                    String m = t5a.getText();
                    int mon = Integer.parseInt(m);
                    month[ctr] = mon;
                    String d = t5b.getText();
                    int da = Integer.parseInt(d);
                    day[ctr] = da;
                    String y = t5c.getText();
                    int ye = Integer.parseInt(y);
                    year[ctr] = ye;
                    String po = t6.getText();
                    int pos = Integer.parseInt(po);
                    postcode[ctr] = pos;
                    password[ctr] = pass;
                    JOptionPane.showMessageDialog(null, "You are now successfully registered in the PHLPost Customer Roster.", 
                    "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    ClientLogin client = new ClientLogin();
                    client.setVisible(true);
//                } else if (pass.equals("")&&word.equals("")){
//                    JOptionPane.showMessageDialog(null, "Please fill in all necessary fields.", 
//                    "ERROR", JOptionPane.WARNING_MESSAGE);
//                    p1.setText("");
//                    p2.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Your passwords do not match. Please try again.", 
                    "ERROR", JOptionPane.WARNING_MESSAGE);
                    p1.setText("");
                    p2.setText("");
                }
            } else if (source == b2){
                //proceed to log in page
                dispose();
                ClientLogin client = new ClientLogin();
                client.setVisible(true);
            }
    }
    public static void main(String[] args) {       
        IMSystem a = new IMSystem();
        a.setVisible(true);
    }
}
