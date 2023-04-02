package view;

import controller.AdminController;
import model.product.BikeType;
import model.product.Category;
import model.product.Comment;
import model.user.RequestCredit;
import model.user.User;

import java.util.Objects;
import java.util.Scanner;

public class AdminPanel {
    private static AdminPanel adminPanel;
    private final AdminController adminController = AdminController.getInstance();
    private Scanner input;

    private AdminPanel() {
        input = new Scanner(System.in);
    }

    public static AdminPanel getInstance() {
        if (adminPanel == null) {
            adminPanel = new AdminPanel();
        }
        return adminPanel;
    }

    public static AdminPanel getAdminPanel() {
        return adminPanel;
    }

    private String command;
    private String[] command1;

    public void adminCommand() {
        String exitCommand = null;//??????????????
        do {
            System.out.println("Enter command:");
            command = input.nextLine();
            command1 = command.split(" ");
            switch (command1[0]) {//change to suggestion
                case "Add":
                    addProduct();
                    break;
                case "Remove":
                    removeProduct();
                    break;
                case "Edit":
                    editProduct();
                    break;
                case "Print":
                    printRequest();
                    break;
                case "Request":
                    request();
                    break;
                case "ShowUsers":
                    show();
                    break;
                case "Help":
                    printHelp();
                    break;
                case "Exit":
                    exitCommand = "Exit";
                    break;
                default:
                    System.out.println("UnCorrect command!");
            }
        } while (!Objects.equals(exitCommand, "Exit"));
    }

    private void addProduct() {

        switch (command1[1]) {
            case "FOOD":
                //System.out.println("Help: GoodName , Price , inventory , productionDate , expirationDate");
                adminController.addFood(command1[2], Double.parseDouble(command1[3]), Integer.parseInt(command1[4]), command1[5], command1[6]);
                break;
            case "VEHICLE":
                if (Objects.equals(command1[2], "Bike")) {
                    //System.out.println("Help: GoodName , Price , inventory , manufacturer, bikeType");
                    adminController.addBike(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), command1[6], command1[7]);
                } else if (Objects.equals(command1[2], "Car")) {
                    //System.out.println("Help: GoodName , Price , inventory ,  manufacturer , engineVolume, automatic");
                    adminController.addCar(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), command1[6], Integer.parseInt(command1[7]), Boolean.parseBoolean(command1[8]));
                }
                break;
            case "STATIONERY":
                if (Objects.equals(command1[2], "NoteBook")) {
                    //System.out.println("Help: String goodName, double price, int inventory, String country, int numberOfPages, String pageType");
                    adminController.addNoteBook(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), command1[6], Integer.parseInt(command1[7]), command1[8]);
                } else if (Objects.equals(command1[2], "Pen")) {
                    //System.out.println("Help: String goodName, double price, int inventory, String country, String color ");
                    adminController.addPen(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), command1[6], command1[7]);
                } else if (Objects.equals(command1[2], "Pencil")) {
                    //System.out.println("Help: String goodName, double price, int inventory, String country, String pencilType");
                    adminController.addPencil(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), command1[6], command1[7]);
                }
                break;
            case "DIGITAL_GOODS":
                if (Objects.equals(command1[2], "PersonalComputer")) {
                    //System.out.println("Help: String goodName, double price, int inventory,  double weight, double dimensions, String processorModel, int RAM");
                    adminController.addPersonalComputer(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), Double.parseDouble(command1[6]), Double.parseDouble(command1[7]), command1[8], Integer.parseInt(command1[9]));
                } else if (Objects.equals(command1[2], "FlashMemory")) {
                    //System.out.println("Help: String goodName, double price, int inventory,  double weight, double dimensions, int capacity, String USB");
                    adminController.addFlashMemory(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), Double.parseDouble(command1[6]), Double.parseDouble(command1[7]), Integer.parseInt(command1[8]), command1[9]);
                } else if (Objects.equals(command1[2], "SSD")) {
                    //System.out.println("Help: String goodName, double price, int inventory,  double weight, double dimensions, int capacity, int readingSpeed, int writingSpeed");
                    adminController.addSSD(command1[3], Double.parseDouble(command1[4]), Integer.parseInt(command1[5]), Double.parseDouble(command1[6]), Double.parseDouble(command1[7]), Integer.parseInt(command1[8]), Integer.parseInt(command1[9]), Integer.parseInt(command1[10]));
                }
                break;
        }
    }

    private void removeProduct() {
        //System.out.println("Help: goodID");
        boolean find = adminController.removeProducts(command1[1]);
        if (find)
            System.out.println("successfully removed!");
        else
            System.out.println("not found!");
    }

    private void editProduct() {
        switch (command1[1]) {
            case "Name":
                //System.out.println("Help: String goodID, String newName");
                boolean find = adminController.editGoodName(command1[2], command1[3]);
                if (find)
                    System.out.println("successfully!");
                else
                    System.out.println("not found!");
                break;
            case "Price":
                //System.out.println("Help: String goodID, double newNPrice");
                boolean find1 = adminController.editPrice(command1[2], Double.parseDouble(command1[3]));
                if (find1)
                    System.out.println("successfully!");
                else
                    System.out.println("not found!");
                break;
            case "Inventory":
                //System.out.println("Help: String goodID, int newInventory");
                boolean find2 = adminController.editInventory(command1[2], Integer.parseInt(command1[3]));
                if (find2)
                    System.out.println("successfully!");
                else
                    System.out.println("not found!");
                break;
        }
    }

    private void show() {
        for (User u : adminController.showUsers()) {
            System.out.println(u.toString());
        }
    }

    private void printRequest() {
//        if (Objects.equals(command1[1], "Request")) {
            switch (command1[2]) {
                case "Signup":
                    showSignUp();
                    break;
                case "Comment":
                    showComment();
                    break;
                case "IncreaseCredit":
                    showCredit();
                    break;
            }
       // }
    }

    private void request() {
        switch (command1[1]) {
            case "Signup": {
                if (Objects.equals(command1[2], "Accept")) {
                    boolean check=adminController.acceptCustomer(command1[3]);
                    if (check)
                        System.out.println("Accepted successfully");
                    else
                        System.out.println("Unsuccessfully");
                } else if (Objects.equals(command1[2], "Reject")) {
                    adminController.rejectCustomer(command1[3]);
                }
                break;
            }
            case "Comment": {
                if (Objects.equals(command1[2], "Accept")) {
                    boolean check=adminController.acceptComment(command1[3], command1[4]);
                    if (check)
                        System.out.println("Accepted successfully");
                    else
                        System.out.println("Unsuccessfully");
                } else if (Objects.equals(command1[2], "Reject")) {
                    adminController.rejectComment(command1[3], command1[4]);
                }
                break;
            }
            case "IncreaseCredit": {
                if (Objects.equals(command1[2], "Accept")) {
                    boolean check=adminController.acceptCredit(command1[3]);
                    if (check)
                        System.out.println("Accepted successfully");
                    else
                        System.out.println("Unsuccessfully");
                } else if (Objects.equals(command1[2], "Reject")) {
                    adminController.rejectCredit(command1[3]);
                }
                break;
            }
        }
    }

    private void showSignUp() {
        for (User u : adminController.showRequestsSignUp()) {
            System.out.println(u.toString());
        }
    }

    private void showComment() {
        for (Comment c : adminController.showRequestComments()) {
            System.out.println(c.toString());
        }
    }

    private void showCredit() {
        for (RequestCredit r : adminController.showRequestCredit()) {
            System.out.println(r.toString());
        }
    }

    private void printHelp() {
        System.out.println("         <<<<<<<<<<<<<<<<<<<<<<<<<< Help >>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Food:             Add GoodName  Price  inventory  productionDate  expirationDate");
        System.out.println("Bike:             Add GoodName  Price  inventory  manufacturer  bikeType");
        System.out.println("Car:              Add GoodName  Price  inventory  manufacturer  engineVolume  automatic");
        System.out.println("NoteBook:         Add GoodName  price  inventory  country  numberOfPages  pageType");
        System.out.println("Pen:              Add GoodName  price  inventory  country  color");
        System.out.println("Pencil:           Add GoodName  price  inventory  country  pencilType");
        System.out.println("PersonalComputer: Add GoodName  price  inventory  weight  dimensions  processorModel  RAM");
        System.out.println("FlashMemory:      Add GoodName  price  inventory  weight  dimensions  capacity  USB");
        System.out.println("SSD:              Add GoodName  price  inventory  weight  dimensions  capacity  readingSpeed  writingSpeed");
        System.out.println("Remove    GoodId");
        System.out.println("Edit      GoodName        newName");
        System.out.println("Edit      GoodPrice       newPrice");
        System.out.println("Edit      GoodInventory   newInventory");
        System.out.println("Print     Request         Signup");
        System.out.println("Print     Request         Comment");
        System.out.println("Print     Request         IncreaseCredit");
        System.out.println("Request   Signup          Accept/Reject         username");
        System.out.println("Request   Comment         Accept/Reject         username");
        System.out.println("Request   IncreaseCredit  Accept/Reject         username");
        System.out.println("ShowUsers");
        System.out.println("Exit");
    }
}