package model.product;

import java.util.ArrayList;

public class Pen extends Stationery implements Discount {
    private String color;
    private int discountPercent;
    private double priceWithDiscount;

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public Pen(String goodName, double price, int inventory, String country, String color) {
        super(goodName, price, inventory, country);
        this.color = color;
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
    public String getCountry() {
        return super.getCountry();
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Color:" + color +"\n"+"\n"
                +"Discount Percent:" + discountPercent +"\n"+"\n"
                +"Price Without Discount:" + getPrice() +"\n"+"\n";
    }

    @Override
    public void add(int percent) {
        discountPercent = percent;
        setPrice((getPrice()*(100-percent))/100);
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public void delete() {
        setPrice((100*(getPrice()))/(100-getDiscountPercent()));
        discountPercent = 0;
    }
}
