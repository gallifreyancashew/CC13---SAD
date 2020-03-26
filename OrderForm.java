package imsystem;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class OrderForm extends JFrame implements ActionListener, ItemListener{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
    JRadioButton r1, r2, r6, r7;
    JCheckBox r3, r4, r5;
    JTextField t1a, t1b, t1c, t2, t3, t4, t5 ,t6, t7a, t7b, t7c, t8;
    JComboBox cb1, cb2;
    JButton b1;
    ButtonGroup packageType = new ButtonGroup();
    ButtonGroup payMethod = new ButtonGroup();
    double price = 0, finPrice = 0;
    
    OrderForm(){
        setTitle ("PHLPost Placement of Order");
        setSize (1000,400);
        setResizable (true);
        setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      package format
        l1 = new JLabel ("PACKAGE FORMAT");
        l2 = new JLabel ("Types of Package to be sent:");
        r1 = new JRadioButton ("Letters and Postcards");
        r1.setSelected(true);
        r2 = new JRadioButton ("Parcels and Packages");
        packageType.add(r1);
        packageType.add(r2);
        l3 = new JLabel ("Format");
        String [] format = {"Custom", "Standard", "Compact", "Parcel", "Maxi"};
        cb1 = new JComboBox (format);
        cb1.setEditable(false);
        cb1.addItemListener(this);
        l4 = new JLabel ("Dimensions");
            t1a = new JTextField (5);
            t1b = new JTextField (5);
            t1c = new JTextField (5);
        l5 = new JLabel ("Weight");
            t2 = new JTextField (10);
        l6 = new JLabel ("Add-ons");
        r3 = new JCheckBox ("Stamps");
        r3.addItemListener(this);
        r4 = new JCheckBox ("Labels");
        r4.addItemListener(this);
        r5 = new JCheckBox ("Packaging");
        r5.addItemListener(this);

        l7 = new JLabel ("Fees due: ");
        t3 = new JTextField (10);
        t3.setEditable(false);

        JPanel pan1 = new JPanel ();        
            pan1.add(l2);
            pan1.add(r1);
            pan1.add(r2);
        JPanel pan2 = new JPanel();
            pan2.add(l3);
            pan2.add(cb1);
        JPanel pan3 = new JPanel();
            pan3.add(l4);
            pan3.add(t1a);
            pan3.add(t1b);
            pan3.add(t1c);
        JPanel pan4 = new JPanel();
            pan4.add(l5);
            pan4.add(t2);
        JPanel pan5 = new JPanel();
            pan5.add(l6);
            pan5.add(r3);
            pan5.add(r4);
            pan5.add(r5);
        JPanel pan6 = new JPanel();
            pan6.add(l7);
            pan6.add(t3);
        JPanel leftPan = new JPanel();
            leftPan.add(l1);
            leftPan.add(pan1);
            leftPan.add(pan2);
            leftPan.add(pan3);
            leftPan.add(pan4);
            leftPan.add(pan5);
            leftPan.add(pan6);
        add(leftPan);
        
//        delivery details
        l8 = new JLabel ("                             DELIVERY DETAILS                             ");
        l9 = new JLabel ("Name of Receiver");
            t4 = new JTextField (28);
        l10 = new JLabel ("Complete Address");
            t5 = new JTextField (18);
        l11 = new JLabel ("Zipcode");
            t6 = new JTextField (4);
        l12 = new JLabel ("CONTACT DETAILS");
        l13 = new JLabel ("Phone No.:");
            t7a = new JTextField (20);
        l14 = new JLabel ("                                Telephone No.:");
            t7b = new JTextField (20); 
        l15 = new JLabel ("                               Email address:");
            t7c = new JTextField (20);
        l16 = new JLabel ("Payment Method");
        r6 = new JRadioButton ("Cash");
        r6.setSelected(true);
        r7 = new JRadioButton ("Credit Card");
            payMethod.add(r6);
            payMethod.add(r7);
            r6.addItemListener(this);
            r7.addItemListener(this);
        l17 = new JLabel ("Debit or Credit Card Provider");
        String [] card = {"American Express", "MasterCard", "Discover", "JCB"};
        cb2 = new JComboBox (card);
        cb2.setEditable(false);
        cb2.setEnabled(false);
        cb2.addActionListener(this);
        l18 = new JLabel ("Card Number");
        t8 = new JTextField (20);
        t8.setEditable(false);
        b1 = new JButton ("          Proceed          ");
            b1.addActionListener(this);
        
        JPanel pan7 = new JPanel ();        
            pan7.add(l9);
            pan7.add(t4);
        JPanel pan8 = new JPanel();
            pan8.add(l10);
            pan8.add(t5);
            pan8.add(l11);
            pan8.add(t6);
        JPanel pan9 = new JPanel();
            pan9.add(l12);
        JPanel pan10 = new JPanel();
            pan10.add(l13);
            pan10.add(t7a);
        JPanel pan11 = new JPanel();
            pan11.add(l14);
            pan11.add(t7b);
        JPanel pan12 = new JPanel ();
            pan12.add(l15);
            pan12.add(t7c);
        JPanel pan13 = new JPanel();
            pan13.add(l16);
            pan13.add(r6);
            pan13.add(r7);
        JPanel pan14 = new JPanel ();
            pan14.add(l17);
            pan14.add(cb2);
        JPanel pan15 = new JPanel ();
            pan15.add(l18);
            pan15.add(t8);
        JPanel rightPan = new JPanel();
            rightPan.add(l8, BorderLayout.CENTER);
            rightPan.add(pan7);
            rightPan.add(pan8);
            rightPan.add(pan9);
            rightPan.add(pan10);
            rightPan.add(pan11);
            rightPan.add(pan12);
            rightPan.add(pan13);
            rightPan.add(pan14);
            rightPan.add(pan15);
        rightPan.add(b1);
        
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        split.setDividerLocation(500);
        add(split, BorderLayout.CENTER);
        split.setTopComponent(leftPan);
        split.setBottomComponent(rightPan);
    }
    
    @Override
    public void itemStateChanged (ItemEvent e){
        Object o = e.getSource();
        int s = e.getStateChange();

        if (o == r3){ //stamps
            if (s == ItemEvent.SELECTED){
                price += 10; 
            } else {
                price -= 10;
            }
        } if (o == r4){ //labels
            if (s == ItemEvent.SELECTED){
                price += 20; 
            } else {
                price -= 20;
            }
        } if (o == r5){ //packaging
            if (s == ItemEvent.SELECTED){
                price += 50; 
            } else {
                price -= 50;
            }
        }        
        if (o == cb1){
            int index = cb1.getSelectedIndex();
            double prices [] = {20.00, 50.00, 70.00, 95.00, 160.00};
            if (index == 0){
                t1a.setEditable(true);
                t1b.setEditable(true);
                t1c.setEditable(true);
                t2.setEditable(true);
                //computations
                finPrice = price +prices[index];
                t3.setText("Php"+finPrice);
            } else {
                t1a.setEditable(false);
                t1b.setEditable(false);
                t1c.setEditable(false);
                t2.setEditable(false);
                finPrice = price +prices[index];
                t3.setText("Php"+finPrice);
            }
        }
        if (o == r6){ 
            cb2.setEnabled(false);
            t8.setEditable(false);
        } else if (o == r7){ 
            cb2.setEnabled(true);
            t8.setEditable(true);
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if (o==b1){
            dispose();
            JOptionPane.showMessageDialog(null, "Congratulations, your information has been sent!", 
                    "PHLPost Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main (String [] args){
        OrderForm a = new OrderForm();
//        SwingUtilities.updateComponentTreeUI(a);
        a.setVisible(true);
    }    
}
