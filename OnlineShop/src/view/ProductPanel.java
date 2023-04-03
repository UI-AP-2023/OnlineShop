package view;

import controller.CustomerController;
import controller.ProductController;
import model.product.*;
import model.user.PurchaseInvoice;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ProductPanel {
    private static ProductPanel productPanel;
    private final ProductController productController = ProductController.getInstance();
    private final CustomerController customerController=CustomerController.getInstance();
    private Scanner input;

    private ProductPanel() {
        input = new Scanner(System.in);
    }

    public static ProductPanel getInstance() {
        if (productPanel == null)
            productPanel = new ProductPanel();
        return productPanel;
    }

    public static ProductPanel getProductPanel() {
        return productPanel;
    }

    public void printProductPanel(String username) {
        int size = productController.getProducts().size();
        int i = 0;
        while (i < size) {
            print(productController.showProducts(productController.getProducts(), i));
            if (size <= 10) {
                System.out.println("[1] Open Product          [2] Filter          [3] Search          [4] Exit");
                System.out.println("Select number:");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        filters(username);
                        return;
                    }
                    case 3: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 4: {
                        return;
                    }
                }
            } else if (i == 0) {
                System.out.println("[1] Open Product          [2] Next          [3] Filter          [4] Search          [5] Exit");
                System.out.println("Select number:");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        i += 10;
                        break;
                    }
                    case 3: {
                        filters(username);
                        return;
                    }
                    case 4: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 5: {
                        return;
                    }
                }
            } else if (i < size - 10) {
                System.out.println("[1] Open Product          [2] Next          [3] Previous          [4] Filter          [5] Search          [6] Exit");
                System.out.println("Select number:");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        i += 10;
                        break;
                    }
                    case 3: {
                        i -= 10;
                        break;
                    }
                    case 4:
                        filters(username);
                        return;
                    case 5: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 6: {
                        return;
                    }
                }

            } else {
                System.out.println("[1] Open Product          [2]  Previous          [3] Filter          [4] Search          [5] Exit");
                System.out.println("Select number:");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        i -= 10;
                        break;
                    }
                    case 3: {
                        filters(username);
                        return;
                    }
                    case 4: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 5: {
                        return;
                    }
                }
            }
        }
    }

    //---------print ----------------------------------------------------------------------------------------------------------------------------------
    private void print(ArrayList<Product> products) {
        for (Product p : products) {
            System.out.println("GoodID:" + p.getGoodID() + "\n" + "Price:" + p.getPrice() + "\n" + "Inventory:" + p.getInventory());
            System.out.println("--------------------------");
        }

    }

    //--------------filter------------------------------------------------------------------------------------------------------------------------------
    private void filters(String username) {
        System.out.println("[1] Available Goods            [2] Price Range            [3] Category           [4] Bikes          [5] Cars");
        System.out.println("[6] Personal Computers         [7] Flash Memories         [8] SSD                [9] Pen            [10] Pencil");
        System.out.println("[11] Note Books                [12] Food                  [13] Bike Type         [14] Car Automatic [15] NoteBook PageNumber");
        System.out.println("[16] Pen Color                 [17] Pencil Type           [18] Computers RAM     [19] SSD Capacity  [20] Flash Memory Capacity");
        System.out.println("Select number:");
        int select = input.nextInt();
        switch (select) {
            case 1:
                printFilterPanel(productController.filterInventoryAvailable(), username);
                break;
            case 2: {
                System.out.println("Enter price range :");
                printFilterPanel(productController.filterPrice(input.nextInt(), input.nextInt()), username);
                break;
            }
            case 3: {
                System.out.println("Enter category:");
                Category category = Category.valueOf(input.next());
                printFilterPanel(productController.filterCategory(category), username);
                break;
            }
            case 4:
                printFilterPanel(productController.filterBike(), username);
                break;
            case 5:
                printFilterPanel(productController.filterCar(), username);
                break;
            case 6:
                printFilterPanel(productController.filterPersonalComputer(), username);
                break;
            case 7:
                printFilterPanel(productController.filterFlashMemory(), username);
                break;
            case 8:
                printFilterPanel(productController.filterSSD(), username);
                break;
            case 9:
                printFilterPanel(productController.filterPen(), username);
                break;
            case 10:
                printFilterPanel(productController.filterPencil(), username);
                break;
            case 11:
                printFilterPanel(productController.filterNoteBook(), username);
                break;
            case 12:
                printFilterPanel(productController.filterFood(), username);
                break;
            case 13: {
                System.out.println("Enter type of Bike:");
                BikeType bikeType = BikeType.valueOf(input.next());
                printFilterPanel(productController.filterTypeBike(bikeType), username);
                break;
            }
            case 14: {
                System.out.println("Automatic or non-automatic cars?");
                if (Objects.equals(input.next(), "automatic")) {
                    printFilterPanel(productController.filterAutomaticCar(true), username);
                } else
                    printFilterPanel(productController.filterAutomaticCar(false), username);
                break;
            }
            case 15: {
                System.out.println("Enter number of page:");
                printFilterPanel(productController.filterNumberPage(input.nextInt()), username);
                break;
            }
            case 16: {
                System.out.println("Enter Color:");
                printFilterPanel(productController.filterColor(input.next()), username);
                break;
            }
            case 17: {
                System.out.println("Enter type of pencil:");
                PencilType pencilType = PencilType.valueOf(input.next());
                printFilterPanel(productController.filterTypePencil(pencilType), username);
                break;
            }
            case 18: {
                System.out.println("Enter amount of RAM:");
                printFilterPanel(productController.filterRAM(input.nextInt()), username);
                break;
            }
            case 19: {
                System.out.println("Enter capacity of SSD:");
                printFilterPanel(productController.filterCapacitySSD(input.nextInt()), username);
                break;
            }
            case 20: {
                System.out.println("Enter capacity of flash memory:");
                printFilterPanel(productController.filterCapacity(input.nextInt()), username);
                break;
            }
        }
    }

    private void printFilterPanel(ArrayList<Product> newProduct, String username) {

        int size = newProduct.size();
        int i = 0;
        while (i < size) {
            print(productController.showProducts(newProduct, i));
            if (size <= 10) {
                System.out.println("[1] Open Product          [2] Delete Filter          [3] Search          [4] Exit");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        printProductPanel(username);
                        return;
                    }
                    case 3: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 4: {
                        return;
                    }
                }
            } else if (i == 0) {
                System.out.println("[1] Open Product          [2] Next          [3] Delete Filter          [4] Search          [5] Exit");
                System.out.println("Select number:");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        i += 10;
                        break;
                    }
                    case 3: {
                        printProductPanel(username);
                        return;
                    }
                    case 4: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 5: {
                        return;
                    }
                }
            } else if (i < size - 10) {
                System.out.println("[1] Open Product          [2] Next          [3] Previous          [4]  Delete Filter          [5] Search          [6] Exit");
                System.out.println("Select number:");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        i += 10;
                        break;
                    }
                    case 3: {
                        i -= 10;
                        break;
                    }
                    case 4: {
                        printProductPanel(username);
                        return;
                    }
                    case 5: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 6: {
                        return;
                    }
                }

            } else {
                System.out.println("[1] Open Product          [2]  Previous          [3] Delete Filter          [4] Search          [5] Exit");
                System.out.println("Select number:");
                int select = input.nextInt();
                switch (select) {
                    case 1: {
                        System.out.println("Enter GoodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            openProduct(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 2: {
                        i -= 10;
                        break;
                    }
                    case 3: {
                        printProductPanel(username);
                        return;
                    }
                    case 4: {
                        System.out.println("Enter goodID:");
                        String goodID = input.next();
                        if (productController.findProduct(goodID) != null)
                            search(input.next(), username);
                        else
                            System.out.println("Not found!");
                        break;
                    }
                    case 5: {
                        return;
                    }
                }
            }
        }
    }

    //---------------search---------------------------------------------------------------------------------------------------------------------------
    private void openProduct(String goodID, String username) {
        System.out.println("GoodName:" + productController.findProduct(goodID).getGoodName());
        System.out.println("GoodID:" + productController.findProduct(goodID).getGoodID());
        System.out.println("Price:" + productController.findProduct(goodID).getPrice());
        System.out.println("Inventory:" + productController.findProduct(goodID).getInventory());
        System.out.println("Category:" + productController.findProduct(goodID).getCategory());
        System.out.println("AverageScore:" + productController.findProduct(goodID).getAverageScore());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<< Comments >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < productController.findProduct(goodID).getComments().size(); i++) {
            System.out.println("Comment Text:" + productController.findProduct(goodID).getComments().get(i).getCommentText());
            System.out.println("Username:" + productController.findProduct(goodID).getComments().get(i).getUser().getUsername());
        }
        System.out.println();
        System.out.println("[1] Add to cart          [2] Add Comment         [3] Giving Score          [4] Back to menu");
        int select = input.nextInt();
        switch (select) {
            case 1:
                addToCart(username, goodID);
                break;
            //???????????????????????????????
            case 4:
                return;
        }
    }

    private void search(String goodID, String username) {
        openProduct(goodID, username);
    }

    private void addToCart(String username, String goodID) {
        boolean add = customerController.addProduct(goodID, username);
        if (add)
            System.out.println("successfully");
        else
            System.out.println("Please login in your account!\n");
    }
}
