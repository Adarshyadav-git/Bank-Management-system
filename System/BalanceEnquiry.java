package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinNumber;

    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Double.parseDouble(resultSet.getString("amount"));
                } else {
                    balance -= Double.parseDouble(resultSet.getString("amount"));
                }
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        JLabel text = new JLabel("Your Account Balance is ₹ "+ balance);
        text.setForeground(Color.white);
        text.setBounds(170, 300, 400, 30);
        image.add(text);

        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
