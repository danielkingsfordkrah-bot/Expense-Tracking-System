import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewExpenseFrame extends JFrame {

    private ExpenseManager manager;
    private JTable table;
    private DefaultTableModel model;

    private JTextField txtSearch;
    private JButton btnSearch;
    private JButton btnRefresh;
    private JButton btnDelete;

    public ViewExpenseFrame(ExpenseManager manager) {

        this.manager = manager;

        setTitle("View Expenses");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Category");
        model.addColumn("Amount");
        model.addColumn("Date");
        model.addColumn("Description");

        table = new JTable(model);

        txtSearch = new JTextField(15);
        btnSearch = new JButton("Search");
        btnRefresh = new JButton("Refresh");
        btnDelete = new JButton("Delete Selected");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Category:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnRefresh);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnDelete);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadExpenses();

        btnRefresh.addActionListener(e -> loadExpenses());

        btnSearch.addActionListener(e -> searchExpenses());

        btnDelete.addActionListener(e -> deleteExpense());

        setVisible(true);
    }

    private void loadExpenses() {

        model.setRowCount(0);

        for (Expense expense : manager.getExpenses()) {

            model.addRow(new Object[]{
                    expense.getId(),
                    expense.getCategory(),
                    expense.getAmount(),
                    expense.getDate(),
                    expense.getDescription()
            });

        }

    }

    private void searchExpenses() {

        String keyword = txtSearch.getText().trim().toLowerCase();

        model.setRowCount(0);

        for (Expense expense : manager.getExpenses()) {

            if (expense.getCategory().toLowerCase().contains(keyword)) {

                model.addRow(new Object[]{
                        expense.getId(),
                        expense.getCategory(),
                        expense.getAmount(),
                        expense.getDate(),
                        expense.getDescription()
                });

            }

        }

    }

    private void deleteExpense() {

        int row = table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(this,
                    "Please select an expense.");

            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete selected expense?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int id = (Integer) model.getValueAt(row, 0);

        if (manager.deleteExpense(id)) {

            JOptionPane.showMessageDialog(this,
                    "Expense deleted successfully.");

            loadExpenses();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Unable to delete expense.");

        }

    }

}