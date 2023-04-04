package view;

import controller.CustomerController;
import model.product.Product;
import model.user.PurchaseInvoice;

import java.util.Objects;
import java.util.Scanner;

public class CustomerPanel {
    private static CustomerPanel customerPanel;
    private final CustomerController customerController = CustomerController.getInstance();
    private final ProductPanel productPanel = ProductPanel.getInstance();
    private Scanner input;

    private CustomerPanel() {
        input = new Scanner(System.in);
    }

    public static CustomerPanel getInstance() {
        if (customerPanel == null)
            customerPanel = new CustomerPanel();
        return customerPanel;
    }

    public static CustomerPanel getCustomerPanel() {
        return customerPanel;
    }

    public void printMenu(String username) {
        while (true) {
            System.out.println("[1] Show Information        [2] Edit Information             [3] Product Panel");
            System.out.println("[4] Show Carts              [5] Increase AccountCredit       [6] Show Invoices");
            System.out.println("[7] Exit");
            System.out.println("Select number:");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    System.out.println(customerController.findCustomer(username).toString());
                    break;
                case 2:
                    editInfoMenu(username);
                    break;
                case 3:
                    productPanel.printProductPanel(username);
                    break;
                case 4: {
                    showCart(username);
                    break;
                }
                case 5: {
                    checkCardInfo();
                    System.out.println("Enter amount of credit increase:");
                    customerController.increaseCredit(username, input.nextDouble());
                    break;
                }
                case 6:
                    printInvoices(username);
                    break;
                case 7:
                    return;
            }
        }
    }

    private void editInfoMenu(String username) {
        boolean exit = false;
        do {
            System.out.println("[1] Edit Password         [2] Edit Email         [3] Edit PhoneNumber         [4] Back to Menu");
            System.out.println("Select number:");
            int select = input.nextInt();
            switch (select) {
                case 1: {
                    System.out.println("Enter new password:");
                    boolean check = customerController.editPassword(username, input.next());
                    if (check)
                        System.out.println("Successfully");
                    else
                        System.out.println("Unsuccessfully");
                    break;
                }
                case 2: {
                    System.out.println("Enter new email:");
                    boolean check = customerController.editEmail(username, input.next());
                    if (check)
                        System.out.println("Successfully");
                    else
                        System.out.println("Unsuccessfully");
                    break;
                }
                case 3: {
                    System.out.println("Enter new phoneNumber:");
                    boolean check = customerController.editPhoneNumber(username, input.next());
                    if (check)
                        System.out.println("Successfully");
                    else
                        System.out.println("Unsuccessfully");
                    break;
                }
                case 4: {
                    exit = true;
                    break;
                }
            }
        } while (!exit);
    }

    private void checkCardInfo() {
        while (true) {
            System.out.println("Enter your card number:");
            if (customerController.checkCardNumber(input.next())) {
                break;
            } else
                System.out.println("Not correct!");
        }
        while (true) {
            System.out.println("Enter your password:");
            if (customerController.checkPasswordCard(input.next())) {
                break;
            } else
                System.out.println("Not correct!");
        }
        while (true) {
            System.out.println("Enter SVV2:");
            if (customerController.checkCVV2(input.next()))
                break;
            else
                System.out.println("Not correct!");
        }
    }

    private void showCart(String username) {
        if (customerController.showCart(username).size() != 0) {
            for (Product p : customerController.showCart(username)) {
                System.out.println("GoodID:" + p.getGoodID() + "\n" + "GoodName:" + p.getGoodName() + "\n" + "GoodPrice:" + p.getPrice());
                System.out.println("----------------------");
            }
            System.out.println("[1] Delete product                    [2] Buy                  [3] Back to menu");
            System.out.println("Select number:");
            switch (input.nextInt()) {
                case 1: {
                    System.out.println("Enter GoodID:");
                    boolean find = customerController.deleteProduct(input.next(), username);
                    if (find)
                        System.out.println("Delete successfully");
                    else
                        System.out.println("Not found!");
                    break;
                }
                case 2: {
                    System.out.println("Enter date:");
                    String date = input.next();
                    buy(username, date);
                    break;
                }

                case 3:
                    break;
            }
        }
    }

    private void buy(String username, String date) {
        PurchaseInvoice purchaseInvoice = customerController.purchaseInvoice(username, date);
        if (purchaseInvoice != null) {
            boolean find = customerController.finalizePurchase(username, purchaseInvoice.getAmountPaid(), purchaseInvoice);
            if (find)
                printPurchaseInvoice(purchaseInvoice);
            else
                System.out.println("Your Account Credit is not enough!");
        } else
            System.out.println("Your cart is empty!");
    }


    private void printPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        System.out.println("InvoiceID:" + purchaseInvoice.getInvoiceID());
        System.out.println("Date:" + purchaseInvoice.getDate());
        System.out.println("Total AmountPay:" + purchaseInvoice.getAmountPaid());
        for (Product p : purchaseInvoice.getPurchasedGoods()) {
            System.out.println("GoodID:" + p.getGoodID() + "\n" + "Number:" + p.getNumberGoods());
            System.out.println("----------------------");
        }
    }

    private void printInvoices(String username) {
        for (PurchaseInvoice p : customerController.printPurchaseInvoices(username)) {
            System.out.println("InvoiceID:" + p.getInvoiceID());
            System.out.println("Date:" + p.getDate());
            System.out.println("Total AmountPay:" + p.getAmountPaid());
            System.out.println("-------------------------");
        }
    }

}
