package model.product;

import java.util.ArrayList;

public class Equipment extends DigitalGoods {
    private int capacity;
    public Equipment(String goodName, double price, int inventory, double weight, double dimensions,int capacity) {
        super(goodName, price, inventory, weight, dimensions);
        this.capacity=capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
    public void setCategory(Category category) {
        super.setCategory(category);
    }

    @Override
    public void setAverageScore(double averageScore) {
        super.setAverageScore(averageScore);
    }

    @Override
    public void setDimensions(double dimensions) {
        super.setDimensions(dimensions);
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
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
    public Category getCategory() {
        return super.getCategory();
    }

    @Override
    public int getInventory() {
        return super.getInventory();
    }

    @Override
    public ArrayList<Comment> getComments() {
        return super.getComments();
    }

    @Override
    public double getAverageScore() {
        return super.getAverageScore();
    }

    @Override
    public double getDimensions() {
        return super.getDimensions();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Equipment{" +super.toString()+
                "capacity=" + capacity +
                '}';
    }
}
