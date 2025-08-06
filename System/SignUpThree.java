package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton savingAcc, FixedDepAcc, CurrentAcc, RecurringDepAcc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    public SignUpThree( String formno) {
        this.formno = formno;
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);

        JLabel AccountDetails= new JLabel("Page 3: Account Details");
        AccountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AccountDetails.setBounds(280, 40, 400, 40);
        add(AccountDetails);

        JLabel AccountType = new JLabel("Account Type");
        AccountType.setFont(new Font("Raleway", Font.BOLD, 20));
        AccountType.setBounds(100, 140, 200, 30);
        add(AccountType);

        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        savingAcc.setBackground(Color.white);
        savingAcc.setBounds(100, 200, 200, 25 );
        add(savingAcc);

        FixedDepAcc = new JRadioButton("Fixed Deposit Account");
        FixedDepAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        FixedDepAcc.setBackground(Color.white);
        FixedDepAcc.setBounds(300, 200, 300, 25 );
        add(FixedDepAcc);

        CurrentAcc = new JRadioButton("Current Account");
        CurrentAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        CurrentAcc.setBackground(Color.white);
        CurrentAcc.setBounds(100, 250, 200, 25 );
        add(CurrentAcc);

        RecurringDepAcc = new JRadioButton("Recurring Deposit Account");
        RecurringDepAcc.setFont(new Font("Raleway", Font.BOLD, 15));
        RecurringDepAcc.setBackground(Color.white);
        RecurringDepAcc.setBounds(300, 250, 300, 25 );
        add(RecurringDepAcc);

        ButtonGroup AccountBtn = new ButtonGroup();
        AccountBtn.add(savingAcc);
        AccountBtn.add(FixedDepAcc);
        AccountBtn.add(CurrentAcc);
        AccountBtn.add(RecurringDepAcc);

        JLabel CardNum = new JLabel("Card Number");
        CardNum.setFont(new Font("Raleway", Font.BOLD, 20));
        CardNum.setBounds(100, 330, 200, 30);
        add(CardNum);

        JLabel Number = new JLabel("XXXX-XXXX-XXXX-4184");
        Number.setFont(new Font("Raleway", Font.BOLD, 20));
        Number.setBounds(330, 330, 300, 30);
        add(Number);

        JLabel CardDetails = new JLabel("Your 16 Digit Card Number");
        CardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        CardDetails.setBounds(100, 360, 300, 30);
        add(CardDetails);

        JLabel CardPin = new JLabel("PIN:");
        CardPin.setFont(new Font("Raleway", Font.BOLD, 20));
        CardPin.setBounds(100, 400, 200, 30);
        add(CardPin);

        JLabel PinDetails = new JLabel("Your 4 Digit PIN");
        PinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        PinDetails.setBounds(100, 430, 300, 30);
        add(PinDetails);

        JLabel PinNumber = new JLabel("XXXX");
        PinNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        PinNumber.setBounds(330, 400, 300, 30);
        add(PinNumber);

        JLabel Services = new JLabel("Services Required");
        Services.setFont(new Font("Raleway", Font.BOLD, 18));
        Services.setBounds(100, 480, 300, 30);
        add(Services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD, 14));
        c1.setBounds(100, 520, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD, 14));
        c2.setBounds(350, 520, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD, 14));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD, 14));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD, 14));
        c5.setBounds(100, 580, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD, 14));
        c6.setBounds(350, 520, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD, 12));
        c7.setBounds(100, 630, 500, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Ralewy", Font.BOLD, 14));
        submit.setBounds(420, 700, 100, 30 );
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Ralewy", Font.BOLD, 14));
        cancel.setBounds(100, 700, 100, 30 );
        cancel.addActionListener(this);
        add(cancel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String accountType = null;
            if (savingAcc.isSelected()){
                accountType = "Saving Account";
            } else if (FixedDepAcc.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (CurrentAcc.isSelected()) {
                accountType = "Current Account";
            } else if (RecurringDepAcc.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() %90000000L) + 5040936000000000L);
            String Pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()){
                facility = facility + "ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility =  facility + "EMAIL & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + "Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + "E-Statement";
            }

            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                }else {
                    Conn conn = new Conn();
                    String Query1 = "insert into signupthree values('" +formno+"', '"+accountType+"', '"+cardnumber+"', '"+Pinnumber+"', '"+facility+"')";
                    String Query2 = "insert into login values('" +formno+"', '"+cardnumber+"', '"+Pinnumber+"')";

                    conn.statement.executeUpdate(Query1);
                    conn.statement.executeUpdate(Query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + Pinnumber);

                    setVisible(false);
                    new Deposit(Pinnumber).setVisible(false);

                }
            }catch (Exception se){
                se.printStackTrace();
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
