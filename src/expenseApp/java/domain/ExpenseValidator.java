package expenseApp.java.domain;

/**
 * Created by ZUZU on 07.10.2015.
 */
public class ExpenseValidator {
    public boolean validate(Expense e) {
        int day = e.getDay();
        return e.getPrice()>0 && day>0 && day<32;
    }
}
