package model.user;

import model.product.Product;
import model.product.PurchasedProduct;

import java.util.ArrayList;

public class PurchaseInvoice {
    private static int numberInvoice=0;
    private final String InvoiceID;
    private final String date;
    private double amountPaid;
    private final ArrayList<PurchasedProduct> purchasedGoods;
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

    public static int getNumberInvoice() {return numberInvoice;}

    public String getInvoiceID() {return InvoiceID;}

    public String getDate() {return date;}

    public double getAmountPaid() {return amountPaid;}

    public ArrayList<PurchasedProduct> getPurchasedGoods() {return purchasedGoods;}

    @Override
    public String toString() {
        return "PurchaseInvoice{" +
                "InvoiceID='" + InvoiceID + '\'' +
                ", date='" + date + '\'' +
                ", amountPaid=" + amountPaid +
                ", purchasedGoods=" + purchasedGoods +
                '}';
    }
}
