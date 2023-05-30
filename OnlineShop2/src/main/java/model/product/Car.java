package model.product;

import java.util.ArrayList;

public class Car extends Vehicle {
    private int engineVolume;
    private boolean automatic;
    public Car(String goodName, double price, int inventory, String manufacturer,int engineVolume,boolean automatic) {
        super(goodName, price, inventory, manufacturer);
        this.engineVolume=engineVolume;
        this.automatic=automatic;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
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
    public String getManufacturer() {
        return super.getManufacturer();
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    @Override
    public String toString() {
        return super.toString()+
                "EngineVolume:" + engineVolume +"\n"+"\n"+
                "Automatic:" + automatic +"\n"+"\n";
    }
}
