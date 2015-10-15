package expenseApp.java.tests

import expenseApp.java.domain.Expense
import expenseApp.java.domain.Expense.Type
import expenseApp.java.factory.ExpenseFactory

class ExpenseTest extends GroovyTestCase {
    Expense e1;
    static final int DAY = 7;
    static final double PRICE = 22.5;
    static final Type TYPE = Type.Clothes;

    @Override
    void setUp() {
        ExpenseFactory factory = new ExpenseFactory();
        e1 = factory.createExpense();
    }
    @Override
    void tearDown() {

    }

    void testGetDay() {
        assertEquals(ExpenseFactory.DAY, e1.getDay());
    }

    void testSetDay() {
        e1.setDay(DAY);
        assertEquals(e1.getDay(), DAY);
    }

    void testGetPrice() {
        assertTrue(ExpenseFactory.PRICE == e1.getPrice());
    }

    void testSetPrice() {
        e1.setPrice(PRICE);
        assertEquals(PRICE, e1.getPrice());
    }

    void testGetType() {
        assertEquals(ExpenseFactory.TYPE, e1.getType());
    }

    void testSetType() {
        e1.setType(TYPE);
        assertEquals(TYPE, e1.getType());
    }
}
