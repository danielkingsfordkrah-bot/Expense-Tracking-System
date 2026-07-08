import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DashboardFrame extends JFrame {

    private ExpenseManager manager;
    private Budget budget;

    public DashboardFrame() {

        manager = new ExpenseManager();
        budget = new Budget(3000);

        setTitle("Expense Tracking System");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(20,20));
        mainPanel.setBackground(Theme.BACKGROUND);
        mainPanel.setBorder(new EmptyBorder(25,25,25,25));

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setBackground(Theme.BACKGROUND);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Expense Tracking System");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.PRIMARY);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcome = new JLabel("Welcome, Administrator");
        welcome.setFont(Theme.SUBTITLE_FONT);
        welcome.setForeground(Theme.SUBTEXT);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(welcome);

        // ================= BUTTONS =================

        JPanel center = new JPanel(new GridLayout(2,2,20,20));
        center.setBackground(Theme.BACKGROUND);

        JButton addExpense = createButton("Add Expense");
        JButton viewExpense = createButton("View Expenses");
        JButton budgetButton = createButton("Budget Summary");
        JButton reportsButton = createButton("Reports");

        center.add(addExpense);
        center.add(viewExpense);
        center.add(budgetButton);
        center.add(reportsButton);

        // ================= FOOTER =================

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(Theme.BACKGROUND);

        JButton logout = new JButton("Logout");
        logout.setPreferredSize(new Dimension(90,35));
        logout.setFont(new Font("Segoe UI", Font.PLAIN,13));
        logout.setFocusPainted(false);
        logout.setForeground(Color.RED);

        footer.add(logout);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);
        mainPanel.add(footer, BorderLayout.SOUTH);

        add(mainPanel);

        // ================= ORIGINAL LOGIC =================

        addExpense.addActionListener(e -> new AddExpenseFrame(manager));

        viewExpense.addActionListener(e -> new ViewExpenseFrame(manager));

        budgetButton.addActionListener(e -> new BudgetSummaryFrame(budget, manager));

        reportsButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Reports feature coming soon!")
        );

        logout.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }

    private JButton createButton(String text){

        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD,16));
        button.setBackground(Theme.PRIMARY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }
}