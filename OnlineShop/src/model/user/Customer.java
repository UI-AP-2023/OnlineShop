package model.user;

import model.product.Product;

import java.util.ArrayList;

public class Customer extends User {

    private final ArrayList<Product> products;
    private final ArrayList<PurchaseInvoice> purchaseInvoices;
    private double accountCredit;

    public Customer(String username, String password, String email, String phoneNumber, String userType) {
        super(username, password, email, phoneNumber, userType);
        products = new ArrayList<>();
        purchaseInvoices = new ArrayList<>();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public void setUserType(String userType) {
        super.setUserType(userType);
    }

    public void setAccountCredit(double accountCredit) {
        this.accountCredit = accountCredit;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public String getUserType() {
        return super.getUserType();
    }

    public double getAccountCredit() {
        return accountCredit;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<PurchaseInvoice> getPurchaseInvoices() {
        return purchaseInvoices;
    }

    @Override
    public String toString() {
        return "Customer{" +super.toString()+
                "products=" + products +
                ", purchaseInvoices=" + purchaseInvoices +
                ", accountCredit=" + accountCredit +
                '}';
    }
}
