package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, Withdraw, FastCash, miniStatement, PinChange, BalanceEnquiry, Exit;
    String pinNumber;
    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        Withdraw = new JButton("Cash Withdraw");
        Withdraw.setBounds(355, 415, 150, 30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        FastCash = new JButton("Fast Cash");
        FastCash.setBounds(170, 450, 150, 30);
        FastCash.addActionListener(this);
        image.add(FastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        PinChange = new JButton("Pin Change");
        PinChange.setBounds(170, 485, 150, 30);
        PinChange.addActionListener(this);
        image.add(PinChange);

        BalanceEnquiry = new JButton("Balance Enquiry");
        BalanceEnquiry.setBounds(355, 485, 150, 30);
        BalanceEnquiry.addActionListener(this);
        image.add(BalanceEnquiry);

        Exit = new JButton("Exit");
        Exit.setBounds(355, 520, 150, 30);
        Exit.addActionListener(this);
        image.add(Exit);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Exit){
            System.exit(0);
        } else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (e.getSource() == Withdraw) {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        } else if (e.getSource() == FastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (e.getSource() == PinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (e.getSource() == BalanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (e.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
