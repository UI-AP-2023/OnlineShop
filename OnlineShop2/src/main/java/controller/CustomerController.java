package controller;

import exception.*;
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


    public boolean checkUsername(String username) throws DuplicateUsername {
        for (Customer c : customerController.getCustomerList()) {
            if (Objects.equals(c.getUsername(), username)) {
                throw new DuplicateUsername();//change username
            }
        }
        return false;// accept username
    }

    public boolean checkPatternPassword(String password) throws InvalidPassword {
        Pattern pattern = Pattern.compile("\\w{8}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find())
            return true;
        throw new InvalidPassword();
    }

    public boolean checkPatternEmail(String email) throws InvalidEmail {
        Pattern pattern = Pattern.compile("^\\w+(@)(\\D)+\\.com$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find())
            return true;
        throw new InvalidEmail();
    }

    public boolean checkEmail(String email) throws DuplicateEmail {
        for (Customer c : customerController.getCustomerList()) {
            if (Objects.equals(c.getEmail(), email)) {
                throw new DuplicateEmail();//change email
            }
        }
        return true;//accept email
    }

    public boolean checkPatternPhoneNumber(String phoneNumber) throws InvalidPhoneNumber {
        Pattern pattern = Pattern.compile("^09\\d{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find())
            return true;
        throw new InvalidPhoneNumber();
    }

    public boolean checkInfo(String username, String password) {
        for (Customer c : getCustomerList()) {
            if (Objects.equals(c.getUsername(), username)) {
                if (Objects.equals(c.getPassword(), password))
                    return true;
            }
        }
        return false;
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
    public boolean editPassword(String username, String newPassword) throws InvalidPassword {
        if (findCustomer(username) != null) {
            if (checkPatternPassword(newPassword)) {
                Objects.requireNonNull(findCustomer(username)).setPassword(newPassword);
                return true;//successfully
            }
        }
        throw new InvalidPassword();
    }

    public boolean editPhoneNumber(String username, String newPhoneNumber) throws InvalidPhoneNumber {
        if (findCustomer(username) != null) {
            if (checkPatternPhoneNumber(newPhoneNumber)) {
                Objects.requireNonNull(findCustomer(username)).setPhoneNumber(newPhoneNumber);
                return true;//successfully
            }
        }
        throw new InvalidPhoneNumber();
    }

    public boolean editEmail(String username, String newEmail) throws InvalidEmail, DuplicateEmail {
        if (findCustomer(username) != null) {
            if (checkPatternEmail(newEmail)) {
                if (checkEmail(newEmail)) {
                    Objects.requireNonNull(findCustomer(username)).setEmail(newEmail);
                    return true;//successfully
                }
                else
                    throw new DuplicateEmail();

            } else
                throw new InvalidEmail();
        }
        return false;
    }

    //----------increase credit-----------------------------------------------------------------------------------------
    public void increaseCredit(String username, double increaseCredit) {
        RequestCredit requestCredit = new RequestCredit(username, increaseCredit);
        admin.getCreditIncreaseRequest().add(requestCredit);
    }

    public boolean checkCardNumber(String number) throws InvalidCardNumber {
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(number);
        if (matcher.find())
            return true;
        throw new InvalidCardNumber();
    }

    public boolean checkPasswordCard(String password) throws InvalidPasswordCard {
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find())
            return true;
        throw new InvalidPasswordCard();
    }

    public boolean checkCVV2(String SVV2) throws InvalidCVV2 {
        Pattern pattern = Pattern.compile("^\\d{3,4}$");
        Matcher matcher = pattern.matcher(SVV2);
        if (matcher.find())
            return true;
        throw new InvalidCVV2();
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

    public boolean finalizePurchase(String username, double amountPaid, PurchaseInvoice purchaseInvoice, ArrayList<String> discountCodes) throws ExpiryDate, InvalidCapacity, unavailableCode {
        double newAmountPaid;
        for (String s : discountCodes) {
            newAmountPaid = calculateNewAmount(amountPaid, username, s);
            if (newAmountPaid != 0) {
                amountPaid = newAmountPaid;
                findDiscountCode(username,s).setCapacity(findDiscountCode(username,s).getCapacity()-1);
            }
            //else amountPaid not changed!
        }
        purchaseInvoice.setDiscountPrice(amountPaid);
        if (findCustomer(username).getAccountCredit() >= amountPaid) {
            findCustomer(username).getPurchaseInvoices().add(purchaseInvoice);
            inventoryReduction(username);
            findCustomer(username).setAccountCredit(findCustomer(username).getAccountCredit() - amountPaid);
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
    private Boolean checkNameDiscountCode(String username, String code) throws unavailableCode {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code))
                return true;
        }
        throw new unavailableCode();
    }

    private Boolean checkCapacity(String username, String code) throws InvalidCapacity {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code)) {
                if (d.getCapacity() > 0)
                    return true;
            }
        }
        throw new InvalidCapacity();
    }

    private Boolean checkDate(String username, String code) throws ExpiryDate {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code)) {
                if (d.getDate().isAfter(LocalDate.now()))
                    return true;
            }
        }
        throw new ExpiryDate();
    }

    private DiscountCode findDiscountCode(String username, String code) throws unavailableCode {
        for (DiscountCode d : findCustomer(username).getDiscountCodes()) {
            if (Objects.equals(d.getDiscountCode(), code))
                return d;
        }
        throw new unavailableCode();
    }

    private double calculateNewAmount(double amount, String username, String code) throws unavailableCode, InvalidCapacity, ExpiryDate {
        if (checkNameDiscountCode(username, code) && checkCapacity(username, code) && checkDate(username, code)) {
            double newAmount;
            DiscountCode temp = findDiscountCode(username, code);
            if (temp != null) {
                newAmount = (amount * (100 - temp.getDiscountPercent())) / 100;
                return newAmount;
            }
        }
        return 0;//error
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

    //---------show discountCodes---------------------------------------------------------------------------------------
    public ArrayList<DiscountCode> showCodes(String username) {
        if (findCustomer(username) != null) {
            return Objects.requireNonNull(findCustomer(username)).getDiscountCodes();
        }
        return null;//not find user
    }


}
