/*
 * A simple password validator which validates passwords based on some simple rules
 * Your password should be atleast 8 characters long and contain
 * atleast one Uppercase letter, one Lowercase letter, one Number and one Special Character
 * This was my first tryst with GUIs in Java.
 * So it was a bit of a struggle but I enjoyed the experience.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class validator implements ActionListener
{
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    public static void main(String args[])
    {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(800, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Validator");
        frame.add(panel);

        panel.setLayout(null);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(300, 20, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(400, 20, 165, 25);
        panel.add(passwordText);

        button = new JButton("Check");
        button.setBounds(360, 60, 80, 25);
        button.addActionListener(new validator());
        panel.add(button);

        success = new JLabel("<html>Your password should be atleast 8 characters long<br/>and contain atleast one Uppercase letter, one Lowercase letter, one Number and one Special Character</html>");
        success.setBounds(50, 120, 800, 35);
        panel.add(success);

        frame.setVisible(true);
    }

    public boolean checkPassword(String password)
    {
        int u = 0, l = 0, d = 0, sp = 0;
        for(int i = 0; i < password.length(); i++)
        {
            char c = password.charAt(i);
            if(Character.isUpperCase(c))
            {
                u = 1;
            }
            else if(Character.isLowerCase(c))
            {
                l = 1;
            }
            else if(Character.isDigit(c))
            {
                d = 1;
            }
            if(!Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c))
            {
                sp = 1;
            }
        }
        if(u == 1 && l == 1 && d == 1 && sp == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        int flag = 0;
        String password = passwordText.getText();
        if(password.length() >= 8)
        {
            flag = 1;
        }
        if(checkPassword(password) && flag == 1)
        {
            success.setText("The password " + password + " is strong");
        }
        else
        {
            success.setText("The password " + password + " is not strong enough");
        }
    }
}