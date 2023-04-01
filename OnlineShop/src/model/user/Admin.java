package model.user;
import model.product.Car;
import model.product.Comment;
import model.product.Product;

import java.util.ArrayList;

public class Admin extends User {
    public static Admin admin ;
    private final ArrayList<Product> products;
    private final ArrayList<Customer> registrationRequest;
    private final ArrayList<Comment> reviewComments;
    private final ArrayList<RequestCredit> creditIncreaseRequest;
    private Admin(String username, String password, String email, String phoneNumber, String userType) {
        super(username, password, email, phoneNumber, userType);
        products=new ArrayList<>();
        registrationRequest=new ArrayList<>();
        reviewComments=new ArrayList<>();
        creditIncreaseRequest=new ArrayList<>();

    }
    public static Admin getInstance(String username, String password, String email, String phoneNumber, String userType) {
        if (admin==null)
        {
            admin=new Admin(username,password,email,phoneNumber,userType);
        }
        return admin;
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

    public ArrayList<Customer> getRegistrationRequest() {
        return registrationRequest;
    }

    public ArrayList<Comment> getReviewComments() {
        return reviewComments;
    }

    public ArrayList<RequestCredit> getCreditIncreaseRequest() {
        return creditIncreaseRequest;
    }

    @Override
    public String toString() {
        return "Admin{" +super.toString()+
                '}';
    }
}
