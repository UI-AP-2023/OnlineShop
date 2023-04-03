package view;

import controller.CustomerController;
import controller.ProductController;

import java.util.Scanner;

public class MainPanel {
    private Scanner input;

    public MainPanel()
    {
        input=new Scanner(System.in);
        printMenu();
    }

    public void printMenu() {
        while (true) {
            boolean exit=false;
            System.out.println("[1] Sign Up       [2] Login       [3] Product Panel       [4] Exit");
            System.out.println("Select number: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    SignUpPanel signUpPanel = new SignUpPanel();
                    break;
                case 2:
                    LoginPanel loginPanel = new LoginPanel();
                    break;
                case 3:
                    ProductPanel productPanel=ProductPanel.getInstance();
                    productPanel.printProductPanel(null);
                    break;
                case 4:
                    exit=true;
                    break;
            }
            if (exit)
                break;
        }
    }
}
