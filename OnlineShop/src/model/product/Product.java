package model.product;

import java.util.ArrayList;

abstract public class Product {
    private static int numberProduct=0;
    private String goodID;
    private String goodName;
    private double price;
    private int inventory;
    private Category category;
    private double averageScore;
    private final ArrayList<Comment> comments;
    private final ArrayList<Score> scores;
    private int numberGoods=0;
    public Product(String goodName, double price, int inventory,Category category) {
        this.goodName = goodName;
        this.price = price;
        this.inventory = inventory;
        this.category = category;
        this.goodID=this.creatID();
        comments = new ArrayList<>();
        scores=new ArrayList<>();
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
    private String creatNewID()
    {
        String[] ID=getGoodID().split("-");
        StringBuilder newID=new StringBuilder();
        newID.append(ID[0]).append("-");
        for (int i=0;i<3;i++)
        {
            newID.append(goodName.charAt(i));
        }
        newID.append("-");
        newID.append(ID[2]).append("-");
        return newID.toString();
    }
    public void setGoodName(String goodName) {
        this.goodName = goodName;
        this.goodID=this.creatNewID();
    }

    public void setNumberGoods(int numberGoods) {
        this.numberGoods = numberGoods;
    }

    public int getNumberGoods() {
        return numberGoods;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

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

    public ArrayList<Score> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "Product{" +
                "goodID='" + goodID + '\'' +
                ", goodName='" + goodName + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", category=" + category +
                ", averageScore=" + averageScore +
                ", comments=" + comments +
                '}';
    }
}


