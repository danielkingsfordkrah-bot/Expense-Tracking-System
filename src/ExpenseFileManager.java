import java.io.*;
import java.util.ArrayList;

public class ExpenseFileManager {

    private static final String FILE_NAME = "expenses.txt";

    public static void saveExpenses(ArrayList<Expense> expenses) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Expense expense : expenses) {

                writer.println(
                        expense.getId() + "," +
                        expense.getCategory() + "," +
                        expense.getAmount() + "," +
                        expense.getDate() + "," +
                        expense.getDescription()
                );

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", 5);

                if (data.length == 5) {

                    expenses.add(new Expense(
                            Integer.parseInt(data[0]),
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3],
                            data[4]
                    ));

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return expenses;
    }

}