public class RecurringExpense extends Expense {

    private String frequency;

    public RecurringExpense(int id,
                            String category,
                            double amount,
                            String date,
                            String description,
                            String frequency) {

        super(id, category, amount, date, description);

        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {

        return super.toString() + " | " + frequency;

    }

}