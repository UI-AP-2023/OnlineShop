package controller;

import model.product.Product;
import model.product.PurchasedProduct;
import model.user.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerController {
    private static CustomerController customerController;
    private final ProductController productController = ProductController.getInstance();
    private final ArrayList<Customer> customerList;
    private PurchaseInvoice purchaseInvoice;
    private Admin admin = Admin.getInstance();

    private CustomerController() {
        customerList = new ArrayList<>();
    }

    public static CustomerController getInstance() {
        if (customerController == null) {
            customerController = new CustomerController();
        }
        return customerController;
    }

    public static CustomerController getCustomerController() {
        return customerController;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    private Customer showInfo(String username) {//?????????
        if (findCustomer(username) != null)
            return findCustomer(username);
        else
            return null;
    }

    public boolean checkUsername(String username) {
        for (Customer c : customerController.getCustomerList()) {
            if (Objects.equals(c.getUsername(), username)) {
                return true;//change username
            }
        }
        return false;// accept username
    }

    public boolean checkPatternPassword(String password) {
        Pattern pattern = Pattern.compile("^\\w{8}$");
        Matcher matcher = pattern.matcher(password);
        return (matcher.find());
    }

    public boolean checkPatternEmail(String email) {
        Pattern pattern = Pattern.compile("^\\w+(@)(\\D)+\\.com$");
        Matcher matcher = pattern.matcher(email);
        return (matcher.find());
    }

    public boolean checkEmail(String email) {
        for (Customer c : customerController.getCustomerList()) {
            if (Objects.equals(c.getEmail(), email)) {
                return true;//change email
            }
        }
        return false;//accept email
    }

    public boolean checkPatternPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^09\\d{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return (matcher.find());
    }

    //------------------------------------------------------------------------------------------------------------------
    public Customer findCustomer(String username) {
        for (Customer c : customerList) {
            if (Objects.equals(c.getUsername(), username)) {
                return c;//find
            }
        }
        return null;//not find
    }

    //-------------edit info--------------------------------------------------------------------------------------------
    public boolean editPassword(String username, String newPassword) {
        if (findCustomer(username) != null) {
            if (checkPatternPassword(newPassword)) {
                Objects.requireNonNull(findCustomer(username)).setPassword(newPassword);
                return true;//successfully
            }
        }
        return false;//error
    }

    public boolean editPhoneNumber(String username, String newPhoneNumber) {
        if (findCustomer(username) != null) {
            if (checkPatternPhoneNumber(newPhoneNumber)) {
                Objects.requireNonNull(findCustomer(username)).setPhoneNumber(newPhoneNumber);
                return true;//successfully
            }
        }
        return false;//error
    }

    public boolean editEmail(String username, String newEmail) {
        if (findCustomer(username) != null) {
            if (checkPatternEmail(newEmail)) {
                if (checkEmail(newEmail)) {
                    Objects.requireNonNull(findCustomer(username)).setEmail(newEmail);
                    return true;//successfully
                }
            }
        }
        return false;//error
    }

    //----------increase credit-----------------------------------------------------------------------------------------
    public void increaseCredit(String username, double increaseCredit) {
        RequestCredit requestCredit = new RequestCredit(username, increaseCredit);
        admin.getCreditIncreaseRequest().add(requestCredit);
    }

    public boolean checkCardNumber(String number) {
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(number);
        return (matcher.find());
    }

    public boolean checkPasswordCard(String password) {
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(password);
        return (matcher.find());
    }

    public boolean checkCVV2(String SVV2) {
        Pattern pattern = Pattern.compile("^\\d{3,4}$");
        Matcher matcher = pattern.matcher(SVV2);
        return (matcher.find());
    }

    //-----------show carts---------------------------------------------------------------------------------------------
    public ArrayList<Product> showCart(String username) {
        if (findCustomer(username) != null) {
            return Objects.requireNonNull(findCustomer(username)).getCart();
        } else return null;//not find user
    }

    //----------------add ----------------------------------------------------------------------------------------------
    public boolean addProduct(String goodID, String username) {
        if (username == null)
            return false;
        else {
            customerController.findCustomer(username).getCart().add(productController.findProduct(goodID));
            return true;
        }
    }

    public boolean deleteProduct(String goodID, String username) {
        for (Product p : customerController.showCart(username)) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                customerController.showCart(username).remove(p);
                return true;
            }
        }
        return false;
    }

    private double amountPaid(String username) {
        double amountPaid = 0;
        checkInventory(username);
        purchaseInvoice.getPurchasedGoods().add((PurchasedProduct) findCustomer(username).getCart().get(0));
        ((PurchasedProduct) findCustomer(username).getCart().get(0)).setProductNumber(((PurchasedProduct) findCustomer(username).getCart().get(0)).getProductNumber() + 1);
        findCustomer(username).getCart().get(0).setInventory(findCustomer(username).getCart().get(0).getInventory() - 1);
        amountPaid += findCustomer(username).getCart().get(0).getPrice();
        for (int i = 1; i < findCustomer(username).getCart().size(); i++) {
            checkInventory(username);
            for (int j = 0; j < i; j++) {
                checkInventory(username);
                if (Objects.equals(findCustomer(username).getCart().get(i).getGoodID(), findCustomer(username).getCart().get(j).getGoodID())) {
                    amountPaid += findCustomer(username).getCart().get(j).getPrice();
                    findCustomer(username).getCart().get(j).setInventory(findCustomer(username).getCart().get(j).getInventory() + 1);
                    findCustomer(username).getCart().get(j).setInventory(findCustomer(username).getCart().get(j).getInventory() - 1);
                } else {
                    amountPaid += findCustomer(username).getCart().get(j).getPrice();
                    purchaseInvoice.getPurchasedGoods().add((PurchasedProduct) findCustomer(username).getCart().get(j));
                    ((PurchasedProduct) findCustomer(username).getCart().get(j)).setProductNumber(((PurchasedProduct) findCustomer(username).getCart().get(j)).getProductNumber() + 1);
                    findCustomer(username).getCart().get(j).setInventory(findCustomer(username).getCart().get(j).getInventory() - 1);
                }
            }
        }
        return amountPaid;
    }

    public boolean finalizePurchase(String date, String username) {
        if (findCustomer(username).getAccountCredit() >= amountPaid(username)) {
            PurchaseInvoice purchaseInvoice = new PurchaseInvoice(date, amountPaid(username));
            findCustomer(username).getPurchaseInvoices().add(purchaseInvoice);
            findCustomer(username).setAccountCredit(findCustomer(username).getAccountCredit()-amountPaid(username));
            findCustomer(username).getCart().clear();
            return true;
        }
        else
            return false;//not enough accountCredit
    }


    private void checkInventory(String username) {
        findCustomer(username).getCart().removeIf(p -> p.getInventory() == 0);
    }

}
