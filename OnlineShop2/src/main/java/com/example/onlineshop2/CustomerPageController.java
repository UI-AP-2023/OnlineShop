package com.example.onlineshop2;

import controller.CustomerController;
import controller.ProductController;
import exception.DuplicateEmail;
import exception.InvalidEmail;
import exception.InvalidPassword;
import exception.InvalidPhoneNumber;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.product.Pen;
import model.product.Product;
import model.user.Customer;
import model.user.PurchaseInvoice;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class CustomerPageController  implements Initializable {
    CustomerController customerController=CustomerController.getInstance();


    @FXML
    private ImageView editEmailImage;

    @FXML
    private ImageView editPasswordImage;

    @FXML
    private ImageView editPhoneImage;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView cartImage;

    @FXML
    private Button cartButton;

    @FXML
    private Button discountCodesButton;

    @FXML
    private Button increaseCreditButton;

    @FXML
    private AnchorPane informationPane;

    @FXML
    private Button invoicesButton;

    @FXML
    private ImageView logoutButton;

    @FXML
    private Button productPageButton;


    @FXML
    private Label accountCreditBox;

    @FXML
    private Label emailBox;

    @FXML
    private Label passwordBox;

    @FXML
    private Label phoneNumberBox;

    @FXML
    private Label userTypeBox;

    @FXML
    private Label usernameBox;

    @FXML
    private TextField editEmailField;
    @FXML
    private TextField editPasswordField;
    @FXML
    private TextField editPhoneField;

    @FXML
    private Button saveEmailButton;

    @FXML
    private Button savePasswordButton;

    @FXML
    private Button savePhoneButton;

    @FXML
    void cartButton(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cartImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void discountCodesButton(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("discountCode-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void increaseCreditButton(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("payment-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void invoicesButton(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("invoiceList-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logoutButton(MouseEvent event) throws IOException {
        LoginController.customer=null;
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void productPageButton(MouseEvent event) throws IOException {
        ProductPageController.productList= ProductController.getProductController().getProducts();
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void homeImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void editEmailImage(MouseEvent event) {
        editEmailField.setVisible(true);
        saveEmailButton.setVisible(true);
    }

    @FXML
    void editPasswordImage(MouseEvent event) {
        editPasswordField.setVisible(true);
        savePasswordButton.setVisible(true);
    }

    @FXML
    void editPhoneImage(MouseEvent event) {
        editPhoneField.setVisible(true);
        savePhoneButton.setVisible(true);
    }
    @FXML
    void saveEmailButton(MouseEvent event) {
        try{
        customerController.editEmail(LoginController.customer.getUsername(),editEmailField.getText());
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Edited!");
            error.setTitle("Successfully!");
            error.setHeaderText("Successfully!");
            error.show();
            emailBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getEmail());
            editEmailField.setVisible(false);
            saveEmailButton.setVisible(false);
            editEmailField.clear();

        }
        catch (DuplicateEmail de)
        {
            Alert error = new Alert(Alert.AlertType.ERROR, "The email is duplicated!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
        catch (InvalidEmail ie)
        {
            Alert error = new Alert(Alert.AlertType.ERROR, "The email is invalid!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
    }

    @FXML
    void savePasswordButton(MouseEvent event)  {
        try{
            customerController.editPassword(LoginController.customer.getUsername(),editPasswordField.getText());
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Edited!");
            error.setTitle("Successfully!");
            error.setHeaderText("Successfully!");
            error.show();
            passwordBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getPassword());
            editPasswordField.setVisible(false);
            savePasswordButton.setVisible(false);
            editPasswordField.clear();
        }
        catch (InvalidPassword  ip)
        {
            Alert error = new Alert(Alert.AlertType.ERROR, "The password is invalid!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
    }

    @FXML
    void savePhoneButton(MouseEvent event) {
        try{
            customerController.editPhoneNumber(LoginController.customer.getUsername(),editPhoneField.getText());
            Alert error = new Alert(Alert.AlertType.INFORMATION, "Edited!");
            error.setTitle("Successfully!");
            error.setHeaderText("Successfully!");
            error.show();
            phoneNumberBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getPhoneNumber());
            editPhoneField.setVisible(false);
            savePhoneButton.setVisible(false);
            editPhoneField.clear();
        }
        catch (InvalidPhoneNumber  ip)
        {
            Alert error = new Alert(Alert.AlertType.ERROR, "The phone number is invalid!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getUsername());
        passwordBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getPassword());
        emailBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getEmail());
        phoneNumberBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getPhoneNumber());
        userTypeBox.setText(customerController.findCustomer(LoginController.customer.getUsername()).getUserType());
        accountCreditBox.setText(String.valueOf(customerController.findCustomer(LoginController.customer.getUsername()).getAccountCredit()));

    }

}

