package com.example.onlineshop2;

import controller.ProductController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.product.BikeType;
import model.product.Category;
import model.product.PencilType;
import model.product.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstPageController implements Initializable {
    private final ProductController productController = ProductController.getInstance();

    @FXML
    private Label CategoriesLabel;

    @FXML
    private AnchorPane HomePane;

    @FXML
    private Label OnlineShopLabel;

    @FXML
    private RadioButton SSDCapacityRadio;

    @FXML
    private RadioButton SSDRadio;

    @FXML
    private TextField searchField;

    @FXML
    private Button applyFilterButton;

    @FXML
    private RadioButton availableGoodsRadio;

    @FXML
    private RadioButton bikeRadio;

    @FXML
    private RadioButton bikeTypeRadio;

    @FXML
    private RadioButton carAutomaticRadio;

    @FXML
    private RadioButton carsRadio;

    @FXML
    private Button cartButton;

    @FXML
    private ImageView cartImage;

    @FXML
    private AnchorPane categoriesPane;

    @FXML
    private RadioButton computerRAMRadio;

    @FXML
    private Button digitalGoodsButton;

    @FXML
    private ImageView digitalGoodsImage;

    @FXML
    private Label filterLabel;

    @FXML
    private AnchorPane filterPane;

    @FXML
    private RadioButton flashMemoryCapacityRadio;

    @FXML
    private RadioButton flashMemoryRadio;

    @FXML
    private Button foodButton;

    @FXML
    private ImageView foodImage;

    @FXML
    private RadioButton noteBookPageNumberRadio;

    @FXML
    private RadioButton noteBookRadio;

    @FXML
    private RadioButton penColorRadio;

    @FXML
    private RadioButton penRadio;

    @FXML
    private RadioButton pencilRadio;

    @FXML
    private RadioButton pencilTypeRadio;

    @FXML
    private RadioButton personalComputersRadio;

    @FXML
    private RadioButton priceRangeRadio;

    @FXML
    private ImageView searchImage;

    @FXML
    private Button signupAndLoginButton;

    @FXML
    private ImageView signupAndLoginImage;

    @FXML
    private Button stationeryButton;

    @FXML
    private ImageView stationeryImage;

    @FXML
    private Button vehicleButton;

    @FXML
    private ImageView vehicleImage;

    @FXML
    private Label price1Label;

    @FXML
    private Label price2Label;

    @FXML
    private Label priceLabel;

    @FXML
    private TextField range1Field;

    @FXML
    private TextField range2Field;

    @FXML
    private Button applyPriceButton;

    @FXML
    private AnchorPane infoPane;

    @FXML
    private AnchorPane bikeTypePane;

    @FXML
    private TextField typeField;

    @FXML
    private Label typeLabel;

    @FXML
    private Button saveTypeButton;

    @FXML
    private TextField automaticField;

    @FXML
    private AnchorPane automaticPane;

    @FXML
    private Button saveAutomaticButton;

    @FXML
    private TextField numberPagesField;

    @FXML
    private AnchorPane numberPagesPane;

    @FXML
    private Button savePagesButton;

    @FXML
    private TextField colorField;

    @FXML
    private AnchorPane colorPane;

    @FXML
    private Button saveColorButton;

    @FXML
    private TextField pencilTypeField;

    @FXML
    private AnchorPane pencilTypePane;

    @FXML
    private Button savePencilTypeButton;

    @FXML
    private TextField RAMField;

    @FXML
    private AnchorPane RAMPane;

    @FXML
    private Button saveRAMButton;

    @FXML
    private TextField SSDField;

    @FXML
    private AnchorPane SSDPane;

    @FXML
    private Button saveSSDButton;

    @FXML
    private TextField flashField;

    @FXML
    private AnchorPane flashPane;

    @FXML
    private Button saveFlashButton;

    ToggleGroup radioGroup = new ToggleGroup();


    @FXML
    void cartImage(MouseEvent event) throws IOException {
        if (LoginController.customer == null) {
            Alert successfully = new Alert(Alert.AlertType.ERROR, "You should login in your account!");
            successfully.setTitle("Error!");
            successfully.setHeaderText("Error!");
            successfully.show();
        } else {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }
    }


    @FXML
    void searchImage(MouseEvent event) throws IOException {
        String search = searchField.getText();
        ArrayList<Product> searchTemp = new ArrayList<>();
        searchTemp.add(productController.findProduct(search));
        ProductPageController.productList = searchTemp;
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        //ProductPageController.productList.clear();
    }

    @FXML
    void signupAndLoginButton(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void digitalGoodsButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterCategory(Category.DIGITAL_GOODS);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void foodButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterCategory(Category.FOOD);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void stationeryButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterCategory(Category.STATIONERY);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void vehicleButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterCategory(Category.VEHICLE);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void applyFilterButton(MouseEvent event) throws IOException, InterruptedException {
        if (availableGoodsRadio.isSelected()) {
            ProductPageController.productList = productController.filterInventoryAvailable();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (priceRangeRadio.isSelected()) {
            infoPane.setVisible(true);
            priceLabel.setVisible(true);
            price1Label.setVisible(true);
            price2Label.setVisible(true);
            range1Field.setVisible(true);
            range2Field.setVisible(true);
            applyPriceButton.setVisible(true);

        } else if (bikeRadio.isSelected()) {
            ProductPageController.productList = productController.filterBike();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (carsRadio.isSelected()) {
            ProductPageController.productList = productController.filterCar();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (personalComputersRadio.isSelected()) {
            ProductPageController.productList = productController.filterPersonalComputer();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (flashMemoryRadio.isSelected()) {
            ProductPageController.productList = productController.filterFlashMemory();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (SSDRadio.isSelected()) {
            ProductPageController.productList = productController.filterSSD();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (penRadio.isSelected()) {
            ProductPageController.productList = productController.filterPen();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (pencilRadio.isSelected()) {
            ProductPageController.productList = productController.filterPencil();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (noteBookRadio.isSelected()) {
            ProductPageController.productList = productController.filterNoteBook();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (bikeTypeRadio.isSelected()) {
            bikeTypePane.setVisible(true);
        } else if (carAutomaticRadio.isSelected()) {
            automaticPane.setVisible(true);
        } else if (noteBookPageNumberRadio.isSelected()) {
            numberPagesPane.setVisible(true);
        } else if (penColorRadio.isSelected()) {
            colorPane.setVisible(true);
        } else if (pencilTypeRadio.isSelected()) {
            pencilTypePane.setVisible(true);
        } else if (computerRAMRadio.isSelected()) {
            RAMPane.setVisible(true);
        } else if (SSDCapacityRadio.isSelected()) {
            SSDPane.setVisible(true);
        } else if (flashMemoryCapacityRadio.isSelected()) {
            flashPane.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        availableGoodsRadio.setToggleGroup(radioGroup);
        priceRangeRadio.setToggleGroup(radioGroup);
        bikeRadio.setToggleGroup(radioGroup);
        carsRadio.setToggleGroup(radioGroup);
        personalComputersRadio.setToggleGroup(radioGroup);
        flashMemoryRadio.setToggleGroup(radioGroup);
        SSDRadio.setToggleGroup(radioGroup);
        penRadio.setToggleGroup(radioGroup);
        pencilRadio.setToggleGroup(radioGroup);
        noteBookRadio.setToggleGroup(radioGroup);
        bikeTypeRadio.setToggleGroup(radioGroup);
        carAutomaticRadio.setToggleGroup(radioGroup);
        noteBookPageNumberRadio.setToggleGroup(radioGroup);
        penColorRadio.setToggleGroup(radioGroup);
        pencilTypeRadio.setToggleGroup(radioGroup);
        computerRAMRadio.setToggleGroup(radioGroup);
        SSDCapacityRadio.setToggleGroup(radioGroup);
        flashMemoryCapacityRadio.setToggleGroup(radioGroup);
    }

    @FXML
    void applyPriceButton(MouseEvent event) throws IOException {
        double range1 = Double.parseDouble(range1Field.getText());
        double range2 = Double.parseDouble(range2Field.getText());
        ProductPageController.productList = productController.filterPrice(range1, range2);
        infoPane.setVisible(false);
        priceLabel.setVisible(false);
        price1Label.setVisible(false);
        price2Label.setVisible(false);
        range1Field.setVisible(false);
        range2Field.setVisible(false);
        applyPriceButton.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveTypeButton(MouseEvent event) throws IOException {
        String type = typeField.getText();
        ProductPageController.productList = productController.filterTypeBike(BikeType.valueOf(type));
        bikeTypePane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveAutomaticButton(MouseEvent event) throws IOException {
        boolean auto = Boolean.parseBoolean(automaticField.getText());
        ProductPageController.productList = productController.filterAutomaticCar(auto);
        automaticPane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void savePagesButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterNumberPage(Integer.parseInt(numberPagesField.getText()));
        numberPagesPane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveColorButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterColor(colorField.getText());
        colorPane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void savePencilTypeButton(MouseEvent event) throws IOException {
        String type = pencilTypeField.getText();
        ProductPageController.productList = productController.filterTypePencil(PencilType.valueOf(type));
        pencilTypePane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveRAMButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterRAM(Integer.parseInt(RAMField.getText()));
        RAMPane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveSSDButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterCapacitySSD(Integer.parseInt(SSDField.getText()));
        SSDPane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveFlashButton(MouseEvent event) throws IOException {
        ProductPageController.productList = productController.filterCapacity(Integer.parseInt(flashField.getText()));
        flashPane.setVisible(false);
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}