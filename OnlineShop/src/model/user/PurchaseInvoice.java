package model.user;

import model.product.Product;

import java.util.ArrayList;

public class PurchaseInvoice {
    private static int numberInvoice=0;
    private final String InvoiceID;
    private final String date;
    private double amountPaid;
    private ArrayList<Product> purchasedGoods;
    public PurchaseInvoice(String date,double amountPaid)
    {
        this.InvoiceID=creatID();
        this.date=date;
        this.amountPaid=amountPaid;
        purchasedGoods=new ArrayList<>();
    }
    private String creatID()
    {
        return "PI-" + ++numberInvoice;
    }
    public void setAmountPaid(double amountPaid) {this.amountPaid = amountPaid;}

    public void setPurchasedGoods(ArrayList<Product> purchasedGoods) {this.purchasedGoods = purchasedGoods;}

    public static int getNumberInvoice() {return numberInvoice;}

    public String getInvoiceID() {return InvoiceID;}

    public String getDate() {return date;}

    public double getAmountPaid() {return amountPaid;}

    public ArrayList<Product> getPurchasedGoods() {return purchasedGoods;}
}