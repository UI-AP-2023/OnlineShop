package model.product;

import java.util.ArrayList;

public class Product {
    private static int numberProduct=0;
    private final String goodID;
    private String goodName;
    private double price;
    private int inventory;
    private Category category;
    private double averageScore;
    private ArrayList<Comment> comments;

    public Product(String goodName, double price, int inventory,Category category) {
        this.goodName = goodName;
        this.price = price;
        this.inventory = inventory;
        this.category = category;
        this.goodID=this.creatID();
        comments = new ArrayList<>();
    }
    private String creatID()
    {
        StringBuilder creat=new StringBuilder();
        for (int i=0;i<4;i++)
        {
            creat.append(category.name().charAt(i));
        }
        creat.append("-");
        for (int i=0;i<3;i++)
        {
            creat.append(goodName.charAt(i));
        }
        creat.append("-");
        creat.append(++numberProduct);
        return creat.toString();
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setCategory(Category category) {this.category = category;}

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void setComments(ArrayList<Comment> comments) {this.comments = comments;}

    public static int getNumberProduct() {return numberProduct;}

    public String getGoodID() {
        return goodID;
    }

    public String getGoodName() {
        return goodName;
    }

    public double getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public Category getCategory() {return category;}

    public double getAverageScore() {
        return averageScore;
    }

    public ArrayList<Comment> getComments() {return comments;}
}


