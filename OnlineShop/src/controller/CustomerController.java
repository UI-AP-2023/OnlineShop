package controller;

import model.product.Comment;
import model.product.DiscountCode;
import model.product.Product;
import model.product.Score;
import model.user.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerController {
    private static CustomerController customerController;
    private final ProductController productController = ProductController.getInstance();
    private final ArrayList<Customer> customerList;
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


    public boolean checkUsername(String username) {
        for (Customer c : customerController.getCustomerList()) {
            if (Objects.equals(c.getUsername(), username)) {
                return true;//change username
            }
        }
        return false;// accept username
    }

    public boolean checkPatternPassword(String password) {
        Pattern pattern = Pattern.compile("\\w{8}$");
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
    public boolean check(String username) {
        if (username == null)
            return false;
        else
            return true;

    }

    public void addProduct(String goodID, String username) {
        customerController.findCustomer(username).getCart().add(productController.findProduct(goodID));

    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean deleteProduct(String goodID, String username) {
        for (Product p : customerController.showCart(username)) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                customerController.showCart(username).remove(p);
                return true;
            }
        }
        return false;
    }
    //----------------------purchaseInvoice-----------------------------------------------------------------------------

    public PurchaseInvoice purchaseInvoice(String username, String date) {
        double amountPaid = 0;
        checkInventory(username);
        if (findCustomer(username).getCart().size() > 0) {
            PurchaseInvoice purchaseInvoice = new PurchaseInvoice(date, amountPaid);
            purchaseInvoice.getPurchasedGoods().add(findCustomer(username).getCart().get(0));
            (findCustomer(username).getCart().get(0)).setNumberGoods((findCustomer(username).getCart().get(0).getNumberGoods() + 1));
            amountPaid += findCustomer(username).getCart().get(0).getPrice();
            for (int i = 1; i < findCustomer(username).getCart().size(); i++) {
                checkInventory(username);
                for (int j = 0; j < i; j++) {
                    checkInventory(username);
                    if (Objects.equals(findCustomer(username).getCart().get(i).getGoodID(), findCustomer(username).getCart().get(j).getGoodID())) {
                        amountPaid += findCustomer(username).getCart().get(j).getPrice();
                        findCustomer(username).getCart().get(j).setNumberGoods(findCustomer(username).getCart().get(j).getNumberGoods() + 1);
                    } else {
                        amountPaid += findCustomer(username).getCart().get(j).getPrice();
                        purchaseInvoice.getPurchasedGoods().add(findCustomer(username).getCart().get(j));
                        (findCustomer(username).getCart().get(j)).setNumberGoods((findCustomer(username).getCart().get(j)).getNumberGoods() + 1);
                    }
                }
            }

            purchaseInvoice.setAmountPaid(amountPaid);
            return purchaseInvoice;
        } else
            return null;
    }

    public boolean finalizePurchase(String username, double amountPaid, PurchaseInvoice purchaseInvoice, String discountCode) {
        double newAmountPaid=calculateNewAmount(amountPaid, username, discountCode);//new
        if (findCustomer(username).getAccountCredit() >= newAmountPaid) {
            findCustomer(username).getPurchaseInvoices().add(purchaseInvoice);
            inventoryReduction(username);
            findCustomer(username).setAccountCredit(findCustomer(username).getAccountCredit() - newAmountPaid);
            findCustomer(username).getCart().clear();
            return true;
        } else
            return false;//not enough accountCredit
    }

    private void inventoryReduction(String username) {
        for (Product p : findCustomer(username).getCart()) {
            p.setInventory(p.getInventory() - 1);
        }
    }

    private void checkInventory(String username) {
        findCustomer(username).getCart().removeIf(p -> p.getInventory() == 0);
    }

    public ArrayList<PurchaseInvoice> printPurchaseInvoices(String username) {
        return findCustomer(username).getPurchaseInvoices();
    }

    //---------------discount-------------------------------------------------------------------------------------------
    private Boolean checkNameDiscountCode(String username, String code) {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code))
                return true;
        }
        return false;//exception!
    }

    private Boolean checkCapacity(String username, String code) {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code)) {
                if (d.getCapacity() > 0)
                    return true;
            }
        }
        return false;//exception!
    }

    private Boolean checkDate(String username, String code) {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code)) {
                if (d.getDate().isAfter(LocalDate.now()))
                    return true;
            }
        }
        return false;//exception!
    }

    private DiscountCode findDiscountCode(String username, String code) {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code))
                return d;
        }
        return null;//not found!//exception
    }

    private double calculateNewAmount(double amount, String username, String code) {
        if (checkNameDiscountCode(username, code) && checkCapacity(username, code) && checkDate(username, code)) {
            double newAmount;
            DiscountCode temp = findDiscountCode(username, code);
            if (temp != null) {
                newAmount = (amount * (100 - temp.getDiscountPercent())) / 100;
                return newAmount;
            }
        }
        return -1;//error
    }


    //---------------score----------------------------------------------------------------------------------------------
    public boolean checkBuy(String username, String goodID) {
        for (PurchaseInvoice p : findCustomer(username).getPurchaseInvoices()) {
            for (Product s : p.getPurchasedGoods()) {
                if (Objects.equals(s.getGoodID(), goodID))
                    return true;//buy good
            }
        }
        return false;//not buy good
    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean score(String username, String goodID, double score) {

        for (Product p : admin.getProducts()) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                Score score1 = new Score(findCustomer(username), score, p);
                p.getScores().add(score1);
                p.setAverageScore(averageScore(p.getScores()));
                return true;//successfully
            }
        }
        return false;
    }

    private double averageScore(ArrayList<Score> scores) {
        double sum = 0;
        for (Score s : scores) {
            sum += s.getScore();
        }
        return sum / scores.size();
    }

    //-----------comment------------------------------------------------------------------------------------------------
    public boolean comment(String username, String goodID, String text) {
        Comment comment = new Comment(findCustomer(username), goodID, text, checkBuy(username, goodID));
        for (Product p : admin.getProducts()) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                admin.getReviewComments().add(comment);
                return true;//request successfully
            }
        }
        return false;
    }


}
