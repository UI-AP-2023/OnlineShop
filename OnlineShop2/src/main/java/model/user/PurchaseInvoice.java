package model.user;

import model.product.Product;

import java.util.ArrayList;

public class PurchaseInvoice {
    private static int numberInvoice = 0;
    private final String InvoiceID;
    private final String date;
    private double amountPaid;
    private double discountPrice;
    private final ArrayList<Product> purchasedGoods;

    public PurchaseInvoice(String date, double amountPaid) {
        this.InvoiceID = creatID();
        this.date = date;
        this.amountPaid = amountPaid;
        purchasedGoods = new ArrayList<>();
    }

    private String creatID() {
        return "PI-" + ++numberInvoice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public static int getNumberInvoice() {
        return numberInvoice;
    }

    public String getInvoiceID() {
        return InvoiceID;
    }

    public String getDate() {
        return date;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public ArrayList<Product> getPurchasedGoods() {
        return purchasedGoods;
    }

    @Override
    public String toString() {
        return "InvoiceID:" + InvoiceID + "\n" +"\n" +
                "Date:" + date +  "\n" +"\n" +
                "Total AmountPay:" + amountPaid + "\n" +"\n" +
                "Total AmountPay with Discount:" + discountPrice;
    }
}
