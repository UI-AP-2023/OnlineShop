package model.product;

import java.util.ArrayList;

public class Pencil extends Stationery {
    private PencilType pencilType;
    public Pencil(String goodName, double price, int inventory, String country,String pencilType) {
        super(goodName, price, inventory, country);
        this.pencilType=PencilType.valueOf(pencilType);
    }

    public void setPencilType(PencilType pencilType) {
        this.pencilType = pencilType;
    }

    @Override
    public void setCountry(String country) {
        super.setCountry(country);
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

    public PencilType getPencilType() {
        return pencilType;
    }
}
