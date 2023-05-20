package view;

import controller.AdminController;
import controller.CustomerController;
import model.user.Customer;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpPanel {
    AdminController adminController=AdminController.getInstance();
    CustomerController customerController = CustomerController.getInstance();
    private Scanner input;

    public SignUpPanel() {
        input = new Scanner(System.in);
        signUp();
    }

    private void signUp() {

        String username;
        while (true) {
            System.out.println("Enter username:");
            username = input.next();
            boolean find = customerController.checkUsername(username);
            if (find) {
                System.out.println("This username is available\nEnter another one");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.println("Enter password:");
            password = input.next();
            boolean check = customerController.checkPatternPassword(password);
            if (check)
                break;
            else
                System.out.println("This password is not acceptable\nEnter another one");
        }

        String email;
        while (true) {
            System.out.println("Enter email:");
            email = input.next();
            boolean check = customerController.checkPatternEmail(email);
            if (check) {
                boolean check2 = customerController.checkEmail(email);
                if (check2)
                    System.out.println("This email is available\nEnter another one");
                else
                    break;
            } else
                System.out.println("This email is not acceptable\nEnter another one");
        }
        String phoneNumber;
        while (true)
        {
            System.out.println("Enter phoneNumber:");
            phoneNumber =input.next();
            boolean check=customerController.checkPatternPhoneNumber(phoneNumber);
            if (check)
                break;
            else
                System.out.println("This phoneNumber is not acceptable\nEnter another one");
        }
        Customer customer=new Customer(username, password, email, phoneNumber);
        adminController.getAdmin().getRegistrationRequest().add(customer);
    }




}
