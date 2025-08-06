package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JTextField amount;
    JButton Withdraw, back;
    String pinnumber;

    Withdraw(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the Amount you want to deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(210, 350, 250, 20);
        add(amount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(355, 485, 150, 30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(180, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setSize(900, 900);
        setLocation(300,0);
        setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "please Enter the amount you want to Withdraw");
            }else{

                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + number + "')";
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
