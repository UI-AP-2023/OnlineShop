package controller;

import model.product.*;
import model.user.Admin;
import model.user.Customer;

import java.util.ArrayList;
import java.util.Objects;

public class ProductController {
    private static ProductController productController;
    private Admin admin;
    private final ArrayList<Product> products;

    private ProductController() {
        admin = Admin.getInstance();
        products =admin.getProducts() ;
    }

    public static ProductController getInstance() {
        if (productController == null)
            productController = new ProductController();
        return productController;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public static ProductController getProductController() {
        return productController;
    }

    //--------------------filter----------------------------------------------------------------------------------------
    public ArrayList<Product> filterInventoryAvailable() {
        ArrayList<Product> available = new ArrayList<>();
        for (Product p : products) {
            if (p.getInventory() > 0) {
                available.add(p);
            }
        }
        return available;
    }

    public ArrayList<Product> filterInventoryUnavailable() {
        ArrayList<Product> unavailable = new ArrayList<>();
        for (Product p : products) {
            if (p.getInventory() == 0) {
                unavailable.add(p);
            }
        }
        return unavailable;
    }

    public ArrayList<Product> filterPrice(double firstPrice, double secondPrice) {
        ArrayList<Product> rangePrice = new ArrayList<>();
        for (Product p : products) {
            if (firstPrice <= p.getPrice() && p.getPrice() <= secondPrice) {
                rangePrice.add(p);
            }
        }
        return rangePrice;
    }

    public ArrayList<Product> filterCategory(Category category) {
        ArrayList<Product> categoryProduct = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory() == category) {
                categoryProduct.add(p);
            }
        }
        return categoryProduct;
    }

    //---------filter categories----------------------------------------------------------------------------------------
    public ArrayList<Product> filterBike() {
        ArrayList<Product> bikes = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Bike temp) {
                bikes.add(temp);
            }
        }
        return bikes;
    }

    public ArrayList<Product> filterCar() {
        ArrayList<Product> cars = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Car temp) {
                cars.add(temp);
            }
        }
        return cars;
    }

    public ArrayList<Product> filterNoteBook() {
        ArrayList<Product> noteBooks = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof NoteBook temp) {
                noteBooks.add(temp);
            }
        }
        return noteBooks;
    }

    public ArrayList<Product> filterPen() {
        ArrayList<Product> pens = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Pen temp) {
                pens.add(temp);
            }
        }
        return pens;
    }

    public ArrayList<Product> filterPencil() {
        ArrayList<Product> pencils = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Pencil temp) {
                pencils.add(temp);
            }
        }
        return pencils;
    }

    public ArrayList<Product> filterPersonalComputer() {
        ArrayList<Product> personalComputers = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof PersonalComputer temp) {
                personalComputers.add(temp);
            }
        }
        return personalComputers;
    }

    public ArrayList<Product> filterFlashMemory() {
        ArrayList<Product> flashMemories = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof FlashMemory temp) {
                flashMemories.add(temp);
            }
        }
        return flashMemories;
    }

    public ArrayList<Product> filterSSD() {
        ArrayList<Product> ssds = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof SSD temp) {
                ssds.add(temp);
            }
        }
        return ssds;
    }

    public ArrayList<Product> filterFood() {
        ArrayList<Product> foods = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Food temp) {
                foods.add(temp);
            }
        }
        return foods;
    }

    //-----------minor filter-------------------------------------------------------------------------------------------
    public ArrayList<Product> filterTypeBike(BikeType bikeType) {
        ArrayList<Product> bikes = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Bike temp) {
                if (temp.getBikeType() == bikeType) {
                    bikes.add(temp);
                }
            }
        }
        return bikes;
    }

    public ArrayList<Product> filterAutomaticCar(Boolean automatic) {
        ArrayList<Product> cars = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Car temp) {
                if (temp.isAutomatic() == automatic) {
                    cars.add(temp);
                }
            }
        }
        return cars;
    }

    public ArrayList<Product> filterNumberPage(int numberPage) {
        ArrayList<Product> noteBooks = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof NoteBook temp) {
                if (temp.getNumberOfPages() == numberPage) {
                    noteBooks.add(temp);
                }
            }
        }
        return noteBooks;
    }

    public ArrayList<Product> filterColor(String color) {
        ArrayList<Product> pens = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Pen temp) {
                if (Objects.equals(temp.getColor(), color)) {
                    pens.add(temp);
                }
            }
        }
        return pens;
    }

    public ArrayList<Product> filterTypePencil(PencilType pencilType) {
        ArrayList<Product> pencils = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Pencil temp) {
                if (temp.getPencilType() == pencilType) {
                    pencils.add(temp);
                }
            }
        }
        return pencils;
    }

    public ArrayList<Product> filterRAM(int RAM) {
        ArrayList<Product> personalComputers = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof PersonalComputer temp) {
                if (temp.getRAM() == RAM) {
                    personalComputers.add(temp);
                }
            }
        }
        return personalComputers;
    }

    public ArrayList<Product> filterCapacity(int capacity) {
        ArrayList<Product> flashMemories = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof FlashMemory temp) {
                if (temp.getCapacity() == capacity) {
                    flashMemories.add(temp);
                }
            }
        }
        return flashMemories;
    }

    public ArrayList<Product> filterCapacitySSD(int capacity) {
        ArrayList<Product> ssds = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof SSD temp) {
                if (temp.getCapacity() == capacity) {
                    ssds.add(temp);
                }
            }
        }
        return ssds;
    }

    public ArrayList<Product> filterExpirationDate(String expirationDate) {
        ArrayList<Product> foods = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof Food temp) {
                if (Objects.equals(temp.getExpirationDate(), expirationDate)) {
                    foods.add(temp);
                }
            }
        }
        return foods;
    }

    //------------------------------------------------------------------------------------------------------------------
    public ArrayList<Product> showProducts(ArrayList<Product> products, int startIndex) {
        ArrayList<Product> show = new ArrayList<>();
        for (int i = startIndex; i < startIndex + 10 && i < products.size(); i++) {
            show.add(products.get(i));
        }
        return show;
    }

    //------------------------------------------------------------------------------------------------------------------
    public Product findProduct(String goodID) {
        for (Product p : products) {
            if (Objects.equals(p.getGoodID(), goodID)) {
                return p;
            }
        }
        return null;
    }


}


