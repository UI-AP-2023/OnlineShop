package model.product;

import java.util.ArrayList;

public class FlashMemory extends Equipment {
    private String USB;
    public FlashMemory(String goodName, double price, int inventory, double weight, double dimensions, int capacity,String USB) {
        super(goodName, price, inventory, weight, dimensions, capacity);
        this.USB=USB;
    }

    public void setUSB(String USB) {
        this.USB = USB;
    }

    @Override
    public void setCapacity(int capacity) {
        super.setCapacity(capacity);
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
    public void setComments(ArrayList<Comment> comments) {
        super.setComments(comments);
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

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    public String getUSB() {
        return USB;
    }
}
