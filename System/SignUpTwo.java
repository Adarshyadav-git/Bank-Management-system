package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{

    JTextField aadharTextfield, panTextfield;
    JRadioButton senior, nosenior, eyes, eno;
    JButton next;
    JComboBox religionBox, categoryBox, incomeBox, qualificationBox, occupationBox;
    String formno;

    public SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140,100, 30);
        add(religion);

        String valreligion[] = {"Hindu", "Muslim", "Christian", "other"};
        religionBox = new JComboBox<>(valreligion);
        religionBox.setBounds(300, 140, 400, 30);
        religionBox.setBackground(Color.white);
        add(religionBox);

        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190,200, 30);
        add(category);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Others"};
        categoryBox = new JComboBox<>(valcategory);
        categoryBox.setBounds(300, 190, 400, 30);
        categoryBox.setBackground(Color.white);
        add(categoryBox);

        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,200, 30);
        add(income);

        String incomecategory[] = {"Null","< 1,00,000", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomeBox = new JComboBox<>(incomecategory);
        incomeBox.setBounds(300, 240, 400, 30);
        incomeBox.setBackground(Color.white);
        add(incomeBox);

        JLabel qualification = new JLabel("Qualification :");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,340,400, 30);
        add(qualification);

        String qualificationcategory[] = {"Non-Graduation","Graduate", "Post-Graduation", "Doctrate", "Others"};
        qualificationBox = new JComboBox<>(qualificationcategory);
        qualificationBox.setBounds(300, 340, 400, 30);
        qualificationBox.setBackground(Color.white);
        add(qualificationBox);

        JLabel occupation  = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,390,200, 30);
        add(occupation);

        String occupationcategory[] = {"Salaried","Self-Employed", "Business", "Student", "Retired", "Others"};
        occupationBox = new JComboBox<>(occupationcategory);
        occupationBox.setBounds(300, 390, 400, 30);
        occupationBox.setBackground(Color.white);
        add(occupationBox);

        JLabel pan = new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,440,200, 30);
        add(pan);

        panTextfield = new JTextField();
        panTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextfield.setBounds(300, 440, 400, 30);
        add(panTextfield);

        JLabel aadhar  = new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,490,200, 30);
        add(aadhar);

        aadharTextfield = new JTextField();
        aadharTextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextfield.setBounds(300, 490, 400, 30);
        add(aadharTextfield);

        JLabel seniorcitizen = new JLabel("Senior Citizen :");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(100,540,200, 30);
        add(seniorcitizen);

        senior = new JRadioButton("Yes");
        senior.setBounds(300,540,60,30);
        senior.setBackground(Color.white);
        add(senior);

        nosenior = new JRadioButton("No");
        nosenior.setBounds(400, 540, 80, 30 );
        nosenior.setBackground(Color.white);
        add(nosenior);

        ButtonGroup seniorbtn = new ButtonGroup();
        seniorbtn.add(senior);
        seniorbtn.add(nosenior);

        JLabel existing = new JLabel("Existing Account :");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100,590,200, 30);
        add(existing);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,60,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400, 590, 80, 30 );
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup ebtn = new ButtonGroup();
        ebtn.add(eyes);
        ebtn.add(eno);

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
        String srelegion = (String) religionBox.getSelectedItem();
        String scategory = (String) categoryBox.getSelectedItem();
        String sincome = (String) incomeBox.getSelectedItem();
        String squalification = (String) qualificationBox.getSelectedItem();
        String soccupation = (String)  occupationBox.getSelectedItem();
        String seniorcitizon = null;
        if(senior.isSelected()){
            seniorcitizon = "Yes";
        } else if (nosenior.isSelected()) {
            seniorcitizon = "No";
        }

        String existingAcc = null;
        if (eyes.isSelected()){
            existingAcc = "Yes";
        } else if (eno.isSelected()) {
            existingAcc = "No";
        }

        String span = panTextfield.getText();
        String saadhar = aadharTextfield.getText();

        try {
                Conn c = new Conn();
                String query = "Insert into signuptwo values('"+formno+"', '"+srelegion+"', '"+scategory+"', '"+sincome+"', '"+squalification+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizon+"', '"+existingAcc+"')";
                c.statement.executeUpdate(query);

                // signup 3 object
            setVisible(false);
            new SignUpThree(formno).setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}

