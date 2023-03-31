package model.product;

import java.util.ArrayList;

public class Bike extends Vehicle {
    private BikeType bikeType;

    public Bike(String goodName, double price, int inventory, String manufacturer, String bikeType) {
        super(goodName, price, inventory, manufacturer);
        this.bikeType = BikeType.valueOf(bikeType);
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
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
    public String getManufacturer() {
        return super.getManufacturer();
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    @Override
    public String toString() {
        return "Bike{" +super.toString()+
                "bikeType=" + bikeType +
                '}';
    }
}
