package ca.ubc.cs304.UI;
import ca.ubc.cs304.delegates.LoginDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeUI extends InterfaceUI {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public WelcomeUI(LoginDelegate controller) {
        setTitle("Welcome");

        setSize(340, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(mainPanel);

        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField(20);

        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        usernamePanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Add empty border insets
        usernamePanel.add(lblUsername);
        usernamePanel.add(txtUsername);

        mainPanel.add(usernamePanel);

        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField(20);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Add empty border insets
        passwordPanel.add(lblPassword);
        passwordPanel.add(txtPassword);

        mainPanel.add(passwordPanel);

        JButton btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                char[] passwordChars = txtPassword.getPassword();
                String password = new String(passwordChars);
                System.out.println("username: " + username);
                System.out.println("password: " + password);
                controller.login(username, password);
            }
        });

        mainPanel.add(btnLogin);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void retryLogin() {
        JOptionPane.showMessageDialog(this, "Invalid username or password.");
    }
}
