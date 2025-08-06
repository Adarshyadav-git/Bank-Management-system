package Bank.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton Login, SignUp, Clear;
    JTextField cardTextField;
    JPasswordField PinTextField;

    public Login() throws HeadlessException {

        setTitle("ATM");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm-card.png"));
        Image i2 = i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(20,10,100,100);
        add(lable);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 40, 400, 40);
        add(text);

        JLabel Card_No = new JLabel("Card No: ");
        Card_No.setFont(new Font("Osward", Font.BOLD, 28));
        Card_No.setBounds(120, 150, 200, 30);
        add(Card_No);
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel Pin = new JLabel("ATM Pin: ");
        Pin.setFont(new Font("Osward", Font.BOLD, 28));
        Pin.setBounds(120, 220, 250, 30);
        add(Pin);
        PinTextField = new JPasswordField();
        PinTextField.setBounds(300, 220, 250, 30);
        PinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(PinTextField);

        Login = new JButton("SIGN IN");
        Login.setBounds(300, 300, 100, 30);
        add(Login);
        Login.setBackground(Color.black);
        Login.setForeground(Color.white);
        Login.addActionListener(this);

        Clear = new JButton("CLEAR");
        Clear.setBounds(450, 300, 100, 30);
        add(Clear);
        Clear.setBackground(Color.black);
        Clear.setForeground(Color.white);
        Clear.addActionListener(this);


        SignUp = new JButton("SIGN UP");
        SignUp.setBounds(300, 350, 250, 30);
        add(SignUp);
        SignUp.setBackground(Color.black);
        SignUp.setForeground(Color.white);
        SignUp.addActionListener(this);

        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login){
            Conn conn = new Conn();
            String CardNumber = cardTextField.getText();
            String pinNumber = PinTextField.getText();
            String query = "Select * from Login where CardNumber = '"+CardNumber+"' and Pin = '"+pinNumber+"'";

            try{
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
                }
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == Clear) {
            cardTextField.setText("");
            PinTextField.setText("");
        } else if (e.getSource() == SignUp) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
}
