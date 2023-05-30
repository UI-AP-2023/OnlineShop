package controller;

import model.product.*;
import model.user.Admin;
import model.user.Customer;
import model.user.RequestCredit;
import model.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AdminController {
    private static AdminController adminController;
    private final Admin admin;
    private final CustomerController customerController = CustomerController.getInstance();
    private final ProductController productController=ProductController.getInstance();

    private AdminController() {
        admin = Admin.getInstance();
    }

    public static AdminController getInstance() {
        if (adminController == null) {
            adminController = new AdminController();
        }
        return adminController;
    }

    public static AdminController getAdminController() {
        return adminController;
    }

    public Admin getAdmin() {
        return admin;
    }

    //------------request sing up---------------------------------------------------------------------------------------
    public ArrayList<Customer> showRequestsSignUp() {
        return admin.getRegistrationRequest();
    }

    public boolean acceptCustomer(String username) {
        for (Customer c : admin.getRegistrationRequest()) {
            if (Objects.equals(c.getUsername(), username)) {
                customerController.getCustomerList().add(c);
                admin.getRegistrationRequest().remove(c);
                return true;//"Accept successfully!"
            }
        }
        return false;//"Not found!"
    }

    public boolean rejectCustomer(String username) {
        for (Customer c : admin.getRegistrationRequest()) {
            if (Objects.equals(c.getUsername(), username)) {
                admin.getRegistrationRequest().remove(c);
                return true;//"Reject successfully!"
            }
        }
        return false;//"Not found!"
    }

    //------------request comments--------------------------------------------------------------------------------------
    public ArrayList<Comment> showRequestComments() {
        return admin.getReviewComments();
    }

    public boolean acceptComment(String username, String goodID) {
        for (Comment c : admin.getReviewComments()) {
            if (Objects.equals(c.getUser().getUsername(), username) && Objects.equals(c.getGoodID(), goodID)) {
                c.setStatus(CommentStatus.CONFIRMED);
                for (Product p : admin.getProducts()) {
                    if (Objects.equals(p.getGoodID(), goodID)) {
                        p.getComments().add(c);
                        admin.getReviewComments().remove(c);
                        return true;//"Successfully!"}
                    }
                }
            }
        }
        return false;//"Not found!"
    }

    public boolean rejectComment(String username, String goodID) {
        for (Comment c : admin.getReviewComments()) {
            if (Objects.equals(c.getUser().getUsername(), username) && Objects.equals(c.getGoodID(), goodID)) {
                c.setStatus(CommentStatus.NOT_CONFIRMED);
                return true;//"Successfully!"
            }
        }
        return false;//"Not found!"
    }

    //-----------request increase credit--------------------------------------------------------------------------------
    public ArrayList<RequestCredit> showRequestCredit() {

        return admin.getCreditIncreaseRequest();
    }

    public boolean acceptCredit(String username) {
        for (Customer c : customerController.getCustomerList()) {
            if (Objects.equals(c.getUsername(), username)) {
                {
                    for (RequestCredit r : admin.getCreditIncreaseRequest()) {
                        if (Objects.equals(r.getUsername(), username)) {
                            c.setAccountCredit(r.getIncreaseCredit() + c.getAccountCredit());
                            admin.getCreditIncreaseRequest().remove(r);
                            return true;//"Accept successfully!"
                        }
                    }
                }
            }
        }
        return false;//"Not found!"
    }

    public boolean rejectCredit(String username) {
        for (RequestCredit r : admin.getCreditIncreaseRequest()) {
            if (Objects.equals(r.getUsername(), username)) {
                admin.getCreditIncreaseRequest().remove(r);
                return true;//"Reject successfully!"
            }
        }
        return false;//"Not found!"
    }

    //--------add product-----------------------------------------------------------------------------------------------
    public void addFood(String goodName, double price, int inventory, String productionDate, String expirationDate) {
        Food newFood = new Food(goodName, price, inventory, productionDate, expirationDate);
        admin.getProducts().add(newFood);

    }

    public void addBike(String goodName, double price, int inventory, String manufacturer, String bikeType) {
        Bike newBike = new Bike(goodName, price, inventory, manufacturer, bikeType);
        admin.getProducts().add(newBike);
    }

    public void addCar(String goodName, double price, int inventory, String manufacturer, int engineVolume, boolean automatic) {
        Car newCar = new Car(goodName, price, inventory, manufacturer, engineVolume, automatic);
        admin.getProducts().add(newCar);
    }

    public void addNoteBook(String goodName, double price, int inventory, String country, int numberOfPages, String pageType) {
        NoteBook newNoteBook = new NoteBook(goodName, price, inventory, country, numberOfPages, pageType);
        admin.getProducts().add(newNoteBook);
    }

    public void addPen(String goodName, double price, int inventory, String country, String color) {
        Pen newPen = new Pen(goodName, price, inventory, country, color);
        admin.getProducts().add(newPen);
    }

    public void addPencil(String goodName, double price, int inventory, String country, String pencilType) {
        Pencil newPencil = new Pencil(goodName, price, inventory, country, pencilType);
        admin.getProducts().add(newPencil);
    }

    public void addPersonalComputer(String goodName, double price, int inventory, double weight,
                                    double dimensions, String processorModel, int RAM) {
        PersonalComputer newPersonalComputer = new PersonalComputer(goodName, price, inventory, weight, dimensions, processorModel, RAM);
        admin.getProducts().add(newPersonalComputer);
    }

    public void addFlashMemory(String goodName, double price, int inventory, double weight, double dimensions,
                               int capacity, String USB) {
        FlashMemory newFlashMemory = new FlashMemory(goodName, price, inventory, weight, dimensions, capacity, USB);
        admin.getProducts().add(newFlashMemory);
    }

    public void addSSD(String goodName, double price, int inventory, double weight, double dimensions, int capacity,
                       int readingSpeed, int writingSpeed) {
        SSD newSSD = new SSD(goodName, price, inventory, weight, dimensions, capacity, readingSpeed, writingSpeed);
        admin.getProducts().add(newSSD);
    }

    //----------------remove product------------------------------------------------------------------------------------
    public boolean removeProducts(String goodID) {
        for (Product p : admin.getProducts()) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                admin.getProducts().remove(p);
                return true;//"Remove successfully!"
            }
        }
        return false;//"Not found!"
    }

    //---------------edit information of product------------------------------------------------------------------------
    public boolean editGoodName(String goodID, String newName) {
        for (Product p : admin.getProducts()) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                p.setGoodName(newName);
                return true;//"successfully!"
            }
        }
        return false;//"Not found!"
    }

    public boolean editPrice(String goodID, double newPrice) {
        for (Product p : admin.getProducts()) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                p.setPrice(newPrice);
                return true;//"successfully!"
            }
        }
        return false;//"Not found!"
    }

    public boolean editInventory(String goodID, int newInventory) {
        for (Product p : admin.getProducts()) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                p.setInventory(newInventory);
                return true;//"successfully!"
            }
        }
        return false;//"Not found!"
    }

    //-------------show users-------------------------------------------------------------------------------------------
    public ArrayList<User> showUsers() {
        ArrayList<User> allUser = new ArrayList<>();
        allUser.add(admin);
        allUser.addAll(customerController.getCustomerList());
        return allUser;
    }

    //-------------discount code for customer---------------------------------------------------------------------------
    //welcome
    public Boolean welcomeDiscount(double discountPercent, int capacity, String date) {
        for (Customer c : customerController.getCustomerList()) {
            if (c.getPurchaseInvoices().size() == 0) {
                DiscountCode welcomeDiscount = new DiscountCode(discountPercent, capacity, date, "Welcome");
                c.getDiscountCodes().add(welcomeDiscount);
                return true;//successfully
            }
        }
        return false;//unsuccessfully
    }

    //Encouragement

    // More than 200
    public Boolean encouragementDiscount1( double discountPercent, int capacity, String date) {
        for (Customer c : customerController.getCustomerList()) {
            if (calculateTotalAmount(c)>=200)
            {
                DiscountCode encouragementDiscount=new DiscountCode(discountPercent,capacity,date,"Encouragement");
                c.getDiscountCodes().add(encouragementDiscount);
                return true;//successfully
            }
        }
        return false;
    }

    //Max
    public Boolean encouragementDiscount2(double discountPercent, int capacity, String date) {
        int max = calculateTotalAmount(customerController.getCustomerList().get(0));
        Customer maxCustomer=customerController.getCustomerList().get(0);
        for (int i=1;i<customerController.getCustomerList().size();i++) {
            if (calculateTotalAmount(customerController.getCustomerList().get(i))>max) {
                max = calculateTotalAmount(customerController.getCustomerList().get(i));
                maxCustomer=customerController.getCustomerList().get(i);
            }
        }
        DiscountCode encouragementDiscount=new DiscountCode(discountPercent,capacity,date,"Encouragement");
        maxCustomer.getDiscountCodes().add(encouragementDiscount);
        return true;//successfully
    }

    private int calculateTotalAmount(Customer customer) {
        int sum = 0;
        for (int i = 0; i < customer.getPurchaseInvoices().size(); i++) {
            sum += customer.getPurchaseInvoices().get(i).getAmountPaid();
        }
        return sum;
    }
    //-------------Discount codes for products--------------------------------------------------------------------------
    public int discountProducts(String productID,int percent)
    {
        Product product=productController.findProduct(productID);
        if (product!=null)
        {
            if (product instanceof Pen temp)
            {
                temp.add(percent);
            }
            else if (product instanceof Pencil temp)
            {
                temp.add(percent);
            }
            else if (product instanceof DigitalGoods temp)
            {
                temp.add(percent);
            }
            else
                return -1;//discount is for special products
            return 0;//successfully
        }
        return 1;//not found product
    }

    public int removeDiscount(String productID)
    {
        Product product=productController.findProduct(productID);
        if (product!=null)
        {
            if (product instanceof Pen temp)
            {
                temp.delete();
            }
            else if (product instanceof Pencil temp)
            {
                temp.delete();
            }
            else if (product instanceof DigitalGoods temp)
            {
                temp.delete();
            }
            return 0;//successfully
        }
        return 1;//not found product
    }

}
