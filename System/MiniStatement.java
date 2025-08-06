package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    MiniStatement(String pinNumber) {

        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from login where pin = '"+pinNumber+"'");
            while (resultSet.next()){
                card.setText("Card Number: " +resultSet.getString("CardNumber").substring(0, 4) + "XXXXXXXX" + resultSet.getString("CardNumber").substring(12));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet resultSet = conn.statement.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while (resultSet.next()){
                mini.setText(mini.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>" );
                if (resultSet.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    bal -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            balance.setText("Your current account balance is ₹ " + bal);
        }catch (Exception ae){
            ae.printStackTrace();
        }

        mini.setBounds(20, 140, 400, 200);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
