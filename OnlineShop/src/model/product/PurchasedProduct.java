package model.product;

public class PurchasedProduct extends Product{
    private int ProductNumber=0;
    public PurchasedProduct(String goodName, double price, int inventory, Category category) {
        super(goodName, price, inventory, category);
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

    public void setProductNumber(int productNumber) {
        ProductNumber = productNumber;
    }

    @Override
    public String getGoodID() {
        return super.getGoodID();
    }

    @Override
    public String getGoodName() {
        return super.getGoodName();
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

    public int getProductNumber() {
        return ProductNumber;
    }
}
