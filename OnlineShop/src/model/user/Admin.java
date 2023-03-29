package model.user;
import model.product.Product;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Product> products;
    //private ArrayList<Request> requests;
    public Admin(String username, String password, String email, String phoneNumber, String userType) {
        super(username, password, email, phoneNumber, userType);
        products=new ArrayList<>();
        //new arraylist
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

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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

    public ArrayList<Product> getProducts() {
        return products;
    }
    //get arraylist
}
