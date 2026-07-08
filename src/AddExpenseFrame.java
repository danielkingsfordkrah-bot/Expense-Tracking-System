import javax.swing.*;
import java.awt.*;

public class AddExpenseFrame extends JFrame {

    private JTextField txtCategory;
    private JTextField txtAmount;
    private JTextField txtDate;
    private JTextField txtDescription;

    private JButton btnSave;

    private ExpenseManager manager;

    public AddExpenseFrame(ExpenseManager manager) {

        this.manager = manager;

        setTitle("Add Expense");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5,2,10,10));

        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        txtCategory = new JTextField();
        txtAmount = new JTextField();
        txtDate = new JTextField();
        txtDescription = new JTextField();

        btnSave = new JButton("Save Expense");

        panel.add(new JLabel("Category"));
        panel.add(txtCategory);

        panel.add(new JLabel("Amount"));
        panel.add(txtAmount);

        panel.add(new JLabel("Date"));
        panel.add(txtDate);

        panel.add(new JLabel("Description"));
        panel.add(txtDescription);

        panel.add(new JLabel());
        panel.add(btnSave);

        add(panel);

        btnSave.addActionListener(e -> saveExpense());

        setVisible(true);
    }

    private void saveExpense() {

        try {

            int id = manager.generateExpenseId();

            String category = txtCategory.getText();

            double amount = Double.parseDouble(txtAmount.getText());

            String date = txtDate.getText();

            String description = txtDescription.getText();

            Expense expense = new Expense(id, category, amount, date, description);

            manager.addExpense(expense);

            JOptionPane.showMessageDialog(this, "Expense Added Successfully!");

            dispose();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Amount must be a valid number.");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }

    }

}