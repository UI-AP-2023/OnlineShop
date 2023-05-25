package com.example.onlineshop2;

import controller.ProductController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstPageController implements Initializable {
    private static final ProductController productController=ProductController.getInstance();

    @FXML
    private Label CategoriesLabel;

    @FXML
    private Label OnlineShopLabel;

    @FXML
    private Button SSDButton;

    @FXML
    private Button SSDCapacityButton;

    @FXML
    private TextField SearchField;

    @FXML
    private Button availableGoodsButton;

    @FXML
    private Button bikeTypeButton;

    @FXML
    private Button bikesButton;

    @FXML
    private Button carAutomaticButton;

    @FXML
    private Button carsButton;

    @FXML
    private Button cartButton;

    @FXML
    private ImageView cartImage;

    @FXML
    private AnchorPane categoriesPane;

    @FXML
    private Button computerRAM;

    @FXML
    private Button digitalGoodsButton;

    @FXML
    private ImageView digitalGoodsImage;

    @FXML
    private Label filterLabel;

    @FXML
    private AnchorPane filterPane;

    @FXML
    private Button flashMemoryButton;

    @FXML
    private Button flashMemoryCapacityButton;

    @FXML
    private Button foodButton;

    @FXML
    private ImageView foodImage;

    @FXML
    private Button noteBookButton;

    @FXML
    private Button noteBookPageNumberButton;

    @FXML
    private Button penButton;

    @FXML
    private Button penColorButton;

    @FXML
    private Button pencilButton;

    @FXML
    private Button pencilType;

    @FXML
    private Button personalComputersButton;

    @FXML
    private Button priceRangeButton;

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
    void SSDButton(MouseEvent event) {

    }

    @FXML
    void SSDCapacityButton(MouseEvent event) {

    }

    @FXML
    void availableGoodsButton(MouseEvent event) {

    }

    @FXML
    void bikeTypeButton(MouseEvent event) {

    }

    @FXML
    void bikesButton(MouseEvent event) {

    }

    @FXML
    void carAutomaticButton(MouseEvent event) {

    }

    @FXML
    void carsButton(MouseEvent event) {

    }

    @FXML
    void cartImage(MouseEvent event) {

    }

    @FXML
    void computerRAM(MouseEvent event) {

    }

    @FXML
    void digitalGoodsButton(MouseEvent event) {

    }

    @FXML
    void flashMemoryButton(MouseEvent event) {

    }

    @FXML
    void flashMemoryCapacityButton(MouseEvent event) {

    }

    @FXML
    void foodButton(MouseEvent event) {

    }

    @FXML
    void noteBookButton(MouseEvent event) {

    }

    @FXML
    void noteBookPageNumberButton(MouseEvent event) {

    }

    @FXML
    void penButton(MouseEvent event) {

    }

    @FXML
    void penColorButton(MouseEvent event) {

    }

    @FXML
    void pencilButton(MouseEvent event) {

    }

    @FXML
    void pencilType(MouseEvent event) {

    }

    @FXML
    void personalComputersButton(MouseEvent event) {

    }

    @FXML
    void priceRangeButton(MouseEvent event) {

    }

    @FXML
    void searchImage(MouseEvent event) {

    }

    @FXML
    void signupAndLoginButton(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void stationeryButton(MouseEvent event) {

    }

    @FXML
    void vehicleButton(MouseEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
