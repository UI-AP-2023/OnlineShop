package model.product;

import model.user.Customer;
import model.user.User;

public class Score {
    private Customer customer;
    private double score;
    private Product product;
    public Score(Customer customer,double score,Product product)
    {
        this.customer=customer;
        this.score=score;
        this.product=product;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getUser() {
        return customer;
    }

    public double getScore() {
        return score;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Score{" +
                "customer=" + customer.getUsername() +
                ", score=" + score +
                ", product=" + product +
                '}';
    }
}
