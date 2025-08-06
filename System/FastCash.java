package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton Rs100, Rs500, Rs1000, Rs2000, Rs5000, Rs10000, Back;
    String pinNumber;
    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdraw Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        Rs100 = new JButton("Rs 100");
        Rs100.setBounds(170, 415, 150, 30);
        Rs100.addActionListener(this);
        image.add(Rs100);

        Rs500 = new JButton("Rs 500");
        Rs500.setBounds(355, 415, 150, 30);
        Rs500.addActionListener(this);
        image.add(Rs500);

        Rs1000 = new JButton("Rs 1000");
        Rs1000.setBounds(170, 450, 150, 30);
        Rs1000.addActionListener(this);
        image.add(Rs1000);

        Rs2000 = new JButton("Rs 2000");
        Rs2000.setBounds(355, 450, 150, 30);
        Rs2000.addActionListener(this);
        image.add(Rs2000);

        Rs5000 = new JButton("Rs 5000");
        Rs5000.setBounds(170, 485, 150, 30);
        Rs5000.addActionListener(this);
        image.add(Rs5000);

        Rs10000 = new JButton("Rs 10000");
        Rs10000.setBounds(355, 485, 150, 30);
        Rs10000.addActionListener(this);
        image.add(Rs10000);

        Back = new JButton("BACK");
        Back.setBounds(355, 520, 150, 30);
        Back.addActionListener(this);
        image.add(Back);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != Back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                        c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
