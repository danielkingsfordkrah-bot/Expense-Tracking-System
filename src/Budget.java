public class Budget {

    private double monthlyBudget;

    public Budget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public double getRemainingBudget(ExpenseManager manager) {

        double totalExpenses = 0;

        for (Expense expense : manager.getExpenses()) {
            totalExpenses += expense.getAmount();
        }

        return monthlyBudget - totalExpenses;
    }

    public double getTotalExpenses(ExpenseManager manager) {

        double total = 0;

        for (Expense expense : manager.getExpenses()) {
            total += expense.getAmount();
        }

        return total;
    }

}