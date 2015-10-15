package expenseApp.java.factory;

import expenseApp.java.domain.Expense;
import expenseApp.java.domain.User;

import java.util.ArrayList;

/**
 * Created by ZUZU on 05.10.2015.
 */
public class ExpenseFactory {
    public static final int DAY = 10;
    public static final double PRICE = 17.4;
    public static final Expense.Type TYPE = Expense.Type.Food;
   // public static final int ID = 1;
    public static UserFactory factory = new UserFactory();

    public Expense createExpense() {

        User u = factory.createUser();
        u.setUserID(1);
        Expense e = new Expense(DAY, PRICE, TYPE, u);
        return e;
    }

    public Expense createInvalidExpense() {
        Expense e = new Expense(0, -15, TYPE, null);
        return e;
    }

    public ArrayList<Expense> createExpenseArrayList() {
        ArrayList<Expense> expenses = new ArrayList<>();
        expenses.add(createExpense());
        User u = factory.createUser();
        u.setUserID(2);
        expenses.add(new Expense(12, 12.3, TYPE, u));
        expenses.add(new Expense(15, 19.3, TYPE, factory.createUser()));
        expenses.add(new Expense(17, 11.3, TYPE, u));
        expenses.add(new Expense(19, 1.3, TYPE, factory.createUser()));
        return expenses;
    }
}
