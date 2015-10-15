package expenseApp.java.main;

import expenseApp.java.manager.UserManager;

import java.util.Scanner;

/**
 * Created by ZUZU on 15.10.2015.
 */
public class ExpenseApp {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Dati un username: ");
                String username = in.nextLine();
                System.out.println("Dati parola: ");
                String password = in.nextLine();
                userManager.addNewUser(username,password);
            }
        }
        catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
