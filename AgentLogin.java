package imsystem;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AgentLogin extends JFrame implements ActionListener, ItemListener{
    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JCheckBox c1 = new JCheckBox("Remember Me");
    JButton b1, b2;
    public AgentLogin(){
        setVisible(true);
        setTitle ("Agent Login");
        setSize(300,200);
        setResizable(false);
        setLayout (new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new JLabel ("ID Number");
        t1 = new JTextField (10);
        l2 = new JLabel ("Password");
        p1 = new JPasswordField (10);
        c1.addItemListener(this);
        b1 = new JButton ("    Login    ");
        b1.addActionListener(this);
        JPanel pan = new JPanel ();
        add(pan, BorderLayout.WEST);
        pan.add(l1); pan.add(t1);
        
        JPanel pan1 = new JPanel ();
        add(pan1, BorderLayout.WEST);
        pan1.add(l2); pan1.add(p1);
        
        JPanel pan2 = new JPanel ();
        add(pan2, BorderLayout.CENTER);
        pan2.add(c1); pan2.add(b1);
        
        b2 = new JButton ("I'm a Client");
        b2.addActionListener(this);
        add(b2, BorderLayout.CENTER);
    }
    
    @Override
    public void itemStateChanged (ItemEvent e){
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if (o==b1){
            String pass = new String (p1.getPassword());
            if (pass.equals ("12345")){
                //order form
                dispose();
                OrderForm order = new OrderForm();
                order.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Password. Please try again.", 
                    "ERROR", JOptionPane.WARNING_MESSAGE);
                    p1.setText("");
            }
        } else if (o==b2){
            //closes current frame and proceedss to client login
            dispose();
            ClientLogin client = new ClientLogin();
            client.setVisible(true);
        }
    }
    public static void main (String [] args){
        AgentLogin a = new AgentLogin();
        a.setVisible(true);
    }
    
}