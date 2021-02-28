/*
 * A simple password validator which validates passwords based on some simple rules.
 * Your password should be atleast 8 characters long and should contain atleast
 * one Uppercase letter, one Lowercase letter, one Number and one Special Character.
 * This was my first tryst with GUIs in Java.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class validator implements ActionListener
{
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel info;
    public static void main(String args[])
    {
        JPanel panel = new JPanel();

        JFrame frame = new JFrame();
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Validator");
        frame.add(panel);

        panel.setLayout(null);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(160, 20, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(260, 20, 165, 25);
        panel.add(passwordText);

        button = new JButton("Check");
        button.setBounds(250, 60, 80, 25);
        button.addActionListener(new validator());
        panel.add(button);

        info = new JLabel("<html>Your password should be atleast 8 characters long<br/>and contain atleast one Uppercase letter,<br/>one Lowercase letter, one Number and one Special Character</html>");
        info.setBounds(150, 120, 500, 55);
        panel.add(info);

        frame.setVisible(true);
    }

    public boolean checkValidPassword(String password)
    {
        int u = 0, l = 0, d = 0, sp = 0;
        //This function returns different values based on what is missing in the parameter 'password'
        if(password.length() < 8)
        {
            return false;
        }
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
        return false;
    }

    public void actionPerformed(ActionEvent e)
    {
        String message = "";
        String password = passwordText.getText();
        if(checkValidPassword(password))
        {
            message = "The password " + password + " is strong enough and valid.";
        }
        else
        {
            message = "The password " + password + " is not strong enough.";
        }
        info.setText(message);
    }
}