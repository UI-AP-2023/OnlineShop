package model.user;

import model.product.Comment;

import java.util.ArrayList;

public class RequestCredit {
    private String username;
    private double increaseCredit;

    public RequestCredit(String username,double increaseCredit)
    {
     this.username=username;
     this.increaseCredit=increaseCredit;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIncreaseCredit(double increaseCredit) {
        this.increaseCredit = increaseCredit;
    }

    public String getUsername() {
        return username;
    }

    public double getIncreaseCredit() {
        return increaseCredit;
    }

    @Override
    public String toString() {
        return "RequestCredit{" +
                "username='" + username + '\'' +
                ", increaseCredit=" + increaseCredit +
                '}';
    }
}
