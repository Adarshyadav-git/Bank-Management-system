package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextfield, fnameTextfield, emailTextfield,addressTextfield, cityTextfield, stateTextfield, pincodeTextfield;
    JDateChooser dateChooser;
    JRadioButton male, female, other, married, unmarried;
    JButton next;

    public SignUpOne() {

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 900L) + 1000L);
        setLayout(null);

        JLabel fromNo = new JLabel("APPLICATION FORM NO : " +random);
        fromNo.setFont(new Font("Raleway", Font.BOLD, 38));
        fromNo.setBounds(140,20,600, 40);
        add(fromNo);

        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290,80,400, 30);
        add(personDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100, 30);
        add(name);

        nameTextfield = new JTextField();
        nameTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextfield.setBounds(300, 140, 400, 30);
        add(nameTextfield);

        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200, 30);
        add(fname);

        fnameTextfield = new JTextField();
        fnameTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextfield.setBounds(300, 190, 400, 30);
        add(fnameTextfield);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100,240,200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel Gender = new JLabel("Gender :");
        Gender.setFont(new Font("Raleway", Font.BOLD, 20));
        Gender.setBounds(100,290,200, 30);
        add(Gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 80, 30 );
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(500, 290, 80, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);


        JLabel Email= new JLabel("Email Address :");
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100,340,200, 30);
        add(Email);

        emailTextfield = new JTextField();
        emailTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextfield.setBounds(300, 340, 400, 30);
        add(emailTextfield);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup Mstatus = new ButtonGroup();
        Mstatus.add(married);
        Mstatus.add(unmarried);

        JLabel Address = new JLabel("Address :");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100,440,200, 30);
        add(Address);

        addressTextfield = new JTextField();
        addressTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextfield.setBounds(300, 440, 400, 30);
        add(addressTextfield);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200, 30);
        add(city);

        cityTextfield = new JTextField();
        cityTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextfield.setBounds(300, 490, 400, 30);
        add(cityTextfield);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200, 30);
        add(state);

        stateTextfield = new JTextField();
        stateTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextfield.setBounds(300, 540, 400, 30);
        add(stateTextfield);

        JLabel pincode = new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200, 30);
        add(pincode);

        pincodeTextfield = new JTextField();
        pincodeTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextfield.setBounds(300, 590, 400, 30);
        add(pincodeTextfield);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextfield.getText();
        String fname = fnameTextfield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }

        String email = emailTextfield.getText();

        String mstatus = null;
        if (married.isSelected()){
            mstatus = "Married";
        } else if (unmarried.isSelected()) {
            mstatus = "Unmarried";
        }

        String address = addressTextfield.getText();
        String city = cityTextfield.getText();
        String state = stateTextfield.getText();
        String pincode = pincodeTextfield.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
                String query = "Insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+mstatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.statement.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
     new SignUpOne();
    }
}
