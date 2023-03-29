package model.user;

import model.product.Product;

import java.util.ArrayList;

public class Customer extends User {

    private ArrayList<Product> products;
    private ArrayList<PurchaseInvoice> purchaseInvoices;
    private double accountCredit;
    public Customer(String username, String password, String email, String phoneNumber, String userType,double accountCredit) {
        super(username, password, email, phoneNumber, userType);
        this.accountCredit=accountCredit;
        products=new ArrayList<>();
        purchaseInvoices=new ArrayList<>();
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

    public void setProducts(ArrayList<Product> products) {this.products = products;}

    public void setPurchaseInvoices(ArrayList<PurchaseInvoice> purchaseInvoices) {this.purchaseInvoices = purchaseInvoices;}

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

    public ArrayList<Product> getProducts() {return products;}

    public ArrayList<PurchaseInvoice> getPurchaseInvoices() {return purchaseInvoices;}
}
