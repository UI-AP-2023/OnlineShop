package view;

import controller.AdminController;
import controller.CustomerController;
import model.user.Customer;

import java.util.Objects;
import java.util.Scanner;

public class LoginPanel {
    AdminPanel adminPanel=AdminPanel.getInstance();
    CustomerPanel customerPanel=CustomerPanel.getInstance();
    AdminController adminController = AdminController.getInstance();
    CustomerController customerController = CustomerController.getInstance();
    private Scanner input;

    public LoginPanel() {
        input = new Scanner(System.in);
        login();
    }

    private void login() {
        String username;
        String password ;
        while (true) {
            System.out.println("Enter username:");
            username = input.next();
            System.out.println("Enter password:");
            password=input.next();
            if (Objects.equals(username, "admin")) {
                if (Objects.equals(password, "admin"))
                {
                    adminPanel.adminCommand();
                    break;
                }
            }
            else
            {
                boolean check=checkInfo(username,password);
                if (check)
                {
                    customerPanel.printMenu(username);
                    break;
                }
                else
                    System.out.println("Not found!");
            }
        }
    }

    private boolean checkInfo(String username, String password) {
        for (Customer c : customerController.getCustomerList()) {
            if (Objects.equals(c.getUsername(), username)) {
                if (Objects.equals(c.getPassword(), password))
                    return true;
            }
        }
        return false;
    }
}
