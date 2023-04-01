package model.product;

import model.user.Customer;
import model.user.User;

public class Comment {
    private Customer customer;
    private String goodID;
    private String commentText;
    private CommentStatus status;
    private boolean buy;

    public Comment(Customer customer, String goodID, String commentText) {
        this.customer = customer;
        this.goodID = goodID;
        this.commentText = commentText;
        this.status = CommentStatus.AWAITING_CONFIRMATION;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }

    public void setGoodID(String goodID) {
        this.goodID = goodID;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void setStatus(CommentStatus status) {//get string then change by value of then send to this
        this.status = status;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public Customer getUser() {
        return customer;
    }

    public String getGoodID() {
        return goodID;
    }

    public String getCommentText() {
        return commentText;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public boolean isBuyBuy() {
        return buy;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "customer=" + customer.getUsername() +
                ", goodID=" + goodID + '\'' +
                ", commentText='" + commentText + '\'' +
                ", status=" + status +
                ", buy=" + buy +
                '}';
    }
}
