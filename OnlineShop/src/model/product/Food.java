package model.product;

import java.util.ArrayList;

public class Food extends Product {
    private String productionDate;
    private String expirationDate;

    public Food(String goodName, double price, int inventory, String productionDate, String expirationDate) {
        super(goodName, price, inventory, Category.FOOD);
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public void setGoodName(String goodName) {
        super.setGoodName(goodName);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public void setInventory(int inventory) {
        super.setInventory(inventory);
    }

    @Override
    public void setAverageScore(double averageScore) {
        super.setAverageScore(averageScore);
    }

    @Override
    public String getGoodName() {
        return super.getGoodName();
    }

    @Override
    public String getGoodID() {
        return super.getGoodID();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getInventory() {
        return super.getInventory();
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
    }

    @Override
    public double getAverageScore() {
        return super.getAverageScore();
    }

    @Override
    public ArrayList<Comment> getComments() {
        return super.getComments();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Food{" +super.toString()+
                "productionDate='" + productionDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
