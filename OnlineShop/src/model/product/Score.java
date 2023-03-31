package model.product;

import model.user.User;

public class Score {
    private User user;
    private int score;
    private Product product;
    public Score(User user,int score,Product product)
    {
        this.user=user;
        this.score=score;
        this.product=product;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Score{" +
                "user=" + user +
                ", score=" + score +
                ", product=" + product +
                '}';
    }
}
