package model.product;

import java.util.ArrayList;

abstract public class DigitalGoods extends Product {
    private double weight;
    private double dimensions;

    public DigitalGoods(String goodName, double price, int inventory, double weight, double dimensions) {
        super(goodName, price, inventory, Category.DIGITAL_GOODS);
        this.weight = weight;
        this.dimensions = dimensions;
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


    @Override
    public String toString() {
        return "DigitalGoods{" +super.toString()+
                "weight=" + weight +
                ", dimensions=" + dimensions +
                '}';
    }
}
