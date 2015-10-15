package expenseApp.java.repository;

import expenseApp.java.domain.Expense;
import expenseApp.java.domain.ExpenseValidator;

import java.util.ArrayList;

public class ExpenseRepository {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private ExpenseValidator validator = new ExpenseValidator();
    int nextID = 1;

    public void saveExpense(Expense e) {
        if (validator.validate(e)) {
            e.setExpenseID(nextID++);
            expenses.add(e);
        }
    }

    public ArrayList<Expense> findAllExpensesByUser(int ID) {
        if (ID < 1)
            return null;
        ArrayList<Expense> allExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getUser().getUserID() == ID) {
                allExpenses.add(expense);
            }
        }
        if (allExpenses.size() == 0) {
            return null;
        }
        return allExpenses;
    }

    public Expense findExpenseById(int ID) {
        for (Expense expense: expenses) {
            if (expense.getExpenseID()==ID) {
                return expense;
            }
        }
        return null;
    }
//TODO: delete
    public void deleteExpenseById(int ID) {
        if (findExpenseById(ID)==null) {
            return;
        }

    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public int getSize() {
        return expenses.size();
    }
}
