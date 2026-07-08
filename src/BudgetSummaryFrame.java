import javax.swing.*;
import java.awt.*;

public class BudgetSummaryFrame extends JFrame {

    private Budget budget;
    private ExpenseManager manager;

    public BudgetSummaryFrame(Budget budget, ExpenseManager manager) {

        this.budget = budget;
        this.manager = manager;

        setTitle("Budget Summary");
        setSize(450,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        double monthlyBudget = budget.getMonthlyBudget();
        double totalExpenses = budget.getTotalExpenses(manager);
        double remaining = budget.getRemainingBudget(manager);

        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Monthly Budget:"));
        panel.add(new JLabel("GHS " + String.format("%.2f", monthlyBudget)));

        panel.add(new JLabel("Total Expenses:"));
        panel.add(new JLabel("GHS " + String.format("%.2f", totalExpenses)));

        panel.add(new JLabel("Remaining Budget:"));

        JLabel lblRemaining = new JLabel("GHS " + String.format("%.2f", remaining));

        if (remaining < 0) {
            lblRemaining.setForeground(Color.RED);
        }

        panel.add(lblRemaining);

        JLabel warning = new JLabel("");

        if (remaining < 0) {
            warning.setText("WARNING: Budget Exceeded!");
            warning.setForeground(Color.RED);
        } else {
            warning.setText("Budget is under control.");
            warning.setForeground(new Color(0,128,0));
        }

        panel.add(new JLabel(""));
        panel.add(warning);

        add(panel);

        setVisible(true);
    }
}