import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {

        setTitle("Expense Tracking System");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Theme.BACKGROUND);
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 1;

        // Title
        JLabel title = new JLabel("Expense Tracker", SwingConstants.CENTER);
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.PRIMARY);

        gbc.gridy = 0;
        mainPanel.add(title, gbc);

        // Subtitle
        JLabel subtitle = new JLabel("Track your expenses with ease", SwingConstants.CENTER);
        subtitle.setFont(Theme.SUBTITLE_FONT);
        subtitle.setForeground(Theme.SUBTEXT);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 25, 0);
        mainPanel.add(subtitle, gbc);

        gbc.insets = new Insets(8, 0, 5, 0);

        // Username Label
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(Theme.LABEL_FONT);

        gbc.gridy = 2;
        mainPanel.add(userLabel, gbc);

        // Username Field
        usernameField = new JTextField();
        usernameField.setFont(Theme.INPUT_FONT);
        usernameField.setPreferredSize(new Dimension(0, 40));

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 15, 0);
        mainPanel.add(usernameField, gbc);

        // Password Label
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(Theme.LABEL_FONT);

        gbc.gridy = 4;
        gbc.insets = new Insets(8, 0, 5, 0);
        mainPanel.add(passLabel, gbc);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(Theme.INPUT_FONT);
        passwordField.setPreferredSize(new Dimension(0, 40));

        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 25, 0);
        mainPanel.add(passwordField, gbc);

        // Login Button
        loginButton = new JButton("LOGIN");
        loginButton.setFont(Theme.BUTTON_FONT);
        loginButton.setBackground(Theme.PRIMARY);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setPreferredSize(new Dimension(180, 45));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Theme.BACKGROUND);
        buttonPanel.add(loginButton);

        gbc.gridy = 6;
        gbc.insets = new Insets(5, 0, 20, 0);
        mainPanel.add(buttonPanel, gbc);

        // Footer
        JLabel footer = new JLabel("© 2026 Expense Tracking System", SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(Theme.SUBTEXT);

        gbc.gridy = 7;
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(footer, gbc);

        add(mainPanel);

        loginButton.addActionListener(e -> login());
        getRootPane().setDefaultButton(loginButton);

        setVisible(true);
    }

    private void login() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            dispose();
            new DashboardFrame();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}