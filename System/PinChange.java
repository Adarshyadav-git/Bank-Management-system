package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinChange extends JFrame implements ActionListener{

    JPasswordField pinTextField, repinTextField;
    JButton Change, back;
    String pinNumber;
    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pinText = new JLabel("New Pin:");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(330, 320, 180, 25);
        pinTextField.setForeground(Color.black);
        pinTextField.setFont(new Font("System", Font.BOLD, 16));
        image.add(pinTextField);

        JLabel repinText = new JLabel("Re-Enter New Pin:");
        repinText.setForeground(Color.white);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setBounds(165, 360, 180, 25);
        image.add(repinText);

        repinTextField = new JPasswordField();
        repinTextField.setBounds(330, 360, 180, 25);
        repinTextField.setForeground(Color.black);
        repinTextField.setFont(new Font("System", Font.BOLD, 16));
        image.add(repinTextField);

        Change = new JButton("CHANGE");
        Change.setBounds(355, 485, 150, 30);
        Change.addActionListener(this);
        image.add(Change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Change) {
            try {
                String npin = pinTextField.getText();
                String rpin = repinTextField.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                    return;
                }

                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN");

                }

                Conn conn = new Conn();
                String query1 = "UPDATE bank SET PIN = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query2 = "UPDATE login SET PIN = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query3 = "UPDATE signupthree SET PIN = '"+rpin+"' where pin = '"+pinNumber+"'";

                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        }
    }
