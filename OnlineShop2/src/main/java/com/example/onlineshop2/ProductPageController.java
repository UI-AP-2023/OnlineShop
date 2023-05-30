package com.example.onlineshop2;

import controller.CustomerController;
import controller.ProductController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.product.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProductPageController implements Initializable {
    ProductController productController = ProductController.getInstance();
    CustomerController customerController = CustomerController.getInstance();
    public static ArrayList<Product> productList=new ArrayList<>();

    @FXML
    private Button addToCartButton;

    @FXML
    private Button commentButton;

    @FXML
    private TextField commentField;

    @FXML
    private ImageView homeImage;

    @FXML
    private Label infoLabel;

    @FXML
    private ListView<String> productViewList;

    @FXML
    private Button scoreButton;

    @FXML
    private TextField scoreField;

    @FXML
    void addToCartButton(MouseEvent event) {
        customerController.addProduct(currentChoice, LoginController.customer.getUsername());//?current
        Alert error = new Alert(Alert.AlertType.INFORMATION, "Added to your cart!");
        error.setTitle("Successfully!");
        error.setHeaderText("Successfully!");
        error.show();
    }

    @FXML
    void commentButton(MouseEvent event) {
        if (commentField == null) {
            Alert error = new Alert(Alert.AlertType.ERROR, "The field must be filled!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        } else {
            customerController.comment(LoginController.customer.getUsername(), currentChoice, commentField.getText());
            Alert error = new Alert(Alert.AlertType.INFORMATION, "saved!");
            error.setTitle("Successfully!");
            error.setHeaderText("Successfully!");
            error.show();
        }
        commentField.clear();
    }

    @FXML
    void homeImage(MouseEvent event) throws IOException {
        if (LoginController.customer == null) {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void scoreButton(MouseEvent event) {
        boolean check=customerController.checkBuy(LoginController.customer.getUsername(),currentChoice);
        if (check) {
            customerController.score(LoginController.customer.getUsername(), currentChoice, Double.parseDouble(scoreField.getText()));
                Alert error = new Alert(Alert.AlertType.INFORMATION, "saved!");
                error.setTitle("Successfully!");
                error.setHeaderText("Successfully!");
                error.show();
        }
        else {
            Alert error = new Alert(Alert.AlertType.ERROR, "You can not score when you do not buy this product!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
        scoreField.clear();
    }

    private final String[] productList1 = new String[productList.size()];
    private String currentChoice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productList.sort(Product::compareTo);
        for (int i = 0; i < productList.size(); i++) {
            productList1[i] = productList.get(i).getGoodID();
        }
        productViewList.getItems().addAll(productList1);
        productViewList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentChoice = productViewList.getSelectionModel().getSelectedItem();
                int index = 0;
                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getGoodID().equals(currentChoice)) {
                        index = i;
                        break;
                    }
                }
                infoLabel.setText(productList.get(index).toString());
            }
        });

    }

}
