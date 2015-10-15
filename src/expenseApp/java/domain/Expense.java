package expenseApp.java.domain;

/**
 * Created by ZUZU on 05.10.2015.
 */


public class Expense {

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public enum Type {
        Food, Clothes, Housekeeping, Others
    }
    private int day;
    private double price;
    private Type type;
    private User user;
    private int expenseID;

    public Expense(int day, double price, Type type, User user) {
        this.day = day;
        this.price = price;
        this.type = type;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        return getExpenseID() == expense.getExpenseID();

    }

    @Override
    public String toString() {
        return "Expense{" +
                "day=" + day +
                ", price=" + price +
                ", type=" + type +
                ", user=" + user +
                ", expenseID=" + expenseID +
                '}';
    }

    @Override
    public int hashCode() {
        return getExpenseID();
    }

    public User getUser() {
        return user;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getExpenseID() {
        return expenseID;
    }
}

