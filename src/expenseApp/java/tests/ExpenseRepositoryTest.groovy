package expenseApp.java.tests

import expenseApp.java.domain.Expense
import expenseApp.java.factory.ExpenseFactory
import expenseApp.java.repository.ExpenseRepository

class ExpenseRepositoryTest extends GroovyTestCase {
    Expense expense;
    Expense invalidExpense;
    ArrayList<Expense> expenses;
    ExpenseRepository expenseRepository;

    void setUp() {
        ExpenseFactory factory = new ExpenseFactory();
        expenses = factory.createExpenseArrayList();
        expense = factory.createExpense();
        invalidExpense = factory.createInvalidExpense();
        expenseRepository = new ExpenseRepository();
    }

    void testSaveExpense() {
        expenseRepository.saveExpense(expense);
        assertEquals(expenseRepository.getSize(), 1);
        Expense expense = expenseRepository.getExpenses()[0];
        assertEquals(expense, this.expense);
    }

    void testSaveInvalidExpense() {
        expenseRepository.saveExpense(invalidExpense);
        assertEquals(expenseRepository.getSize(),0);
    }

    void testFindByUserId() {
//        userRepositoryTest.saveUsers();
        saveExpenses();
        assertEquals(expenseRepository.getSize(),expenses.size());
        ArrayList<Expense> expensesByUser = expenseRepository.findAllExpensesByUser(2);
        assertEquals(expensesByUser.size(),2);
        expensesByUser = expenseRepository.findAllExpensesByUser(17);
        assertNull(expensesByUser);
        expensesByUser = expenseRepository.findAllExpensesByUser(0);
        assertNull(expensesByUser);
    }

    void testFindExpenseById() {
        saveExpenses();
        assertNull(expenseRepository.findExpenseById(7));
        assertEquals(expenseRepository.findExpenseById(1).getDay(),ExpenseFactory.DAY);
    }

    void saveExpenses() {
        int ID = 1;
        for (Expense expense: expenses) {
            expense.setExpenseID(ID++);
            expenseRepository.saveExpense(expense);
        }
    }
}
