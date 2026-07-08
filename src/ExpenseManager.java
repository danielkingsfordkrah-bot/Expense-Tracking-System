import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Expense> expenses;
    private int nextId;

    public ExpenseManager() {

        expenses = ExpenseFileManager.loadExpenses();

        nextId = 1;

        // Continue IDs after the highest existing one
        for (Expense expense : expenses) {
            if (expense.getId() >= nextId) {
                nextId = expense.getId() + 1;
            }
        }
    }

    // Generate automatic expense ID
    public int generateExpenseId() {
        return nextId++;
    }

    // Add a new expense
    public void addExpense(Expense expense) {

        expenses.add(expense);

        ExpenseFileManager.saveExpenses(expenses);

    }

    // Return all expenses
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    // Find expense by ID
    public Expense findExpenseById(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {
                return expense;
            }

        }

        return null;
    }

    // Delete expense
    public boolean deleteExpense(int id) {

        Expense expense = findExpenseById(id);

        if (expense != null) {

            expenses.remove(expense);

            ExpenseFileManager.saveExpenses(expenses);

            return true;

        }

        return false;
    }

}