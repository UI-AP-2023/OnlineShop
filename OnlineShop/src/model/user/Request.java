package model.user;

import model.product.Comment;

import java.util.ArrayList;

public class Request {
    private ArrayList<User> registrationRequest;
    private ArrayList<Comment> reviewComments;
    private ArrayList<Customer> creditIncreaseRequest;
    public Request()
    {
        registrationRequest=new ArrayList<>();
        reviewComments=new ArrayList<>();
        creditIncreaseRequest=new ArrayList<>();
    }

    public void setRegistrationRequest(ArrayList<User> registrationRequest) {
        this.registrationRequest = registrationRequest;
    }

    public void setReviewComments(ArrayList<Comment> reviewComments) {
        this.reviewComments = reviewComments;
    }

    public void setCreditIncreaseRequest(ArrayList<Customer> creditIncreaseRequest) {
        this.creditIncreaseRequest = creditIncreaseRequest;
    }

    public ArrayList<User> getRegistrationRequest() {
        return registrationRequest;
    }

    public ArrayList<Comment> getReviewComments() {
        return reviewComments;
    }

    public ArrayList<Customer> getCreditIncreaseRequest() {
        return creditIncreaseRequest;
    }
}
