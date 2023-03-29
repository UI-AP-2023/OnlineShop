package model.product;

import model.user.User;

public class Comment {
    private User user;
    private String goodID;
    private String commentText;
    private CommentStatus status;
    private boolean buy;//???
    public Comment(User user,String goodID,String commentText)
    {
        this.user=user;
        this.goodID=goodID;
        this.commentText=commentText;
        this.status=CommentStatus.AWAITING_CONFIRMATION;
    }

    public void setUser(User user) {
        this.user = user;
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

    public User getUser() {
        return user;
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
    public boolean isBuyBuy()
    {
        return buy;
    }
}
