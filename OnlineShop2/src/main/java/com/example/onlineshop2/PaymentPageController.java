package com.example.onlineshop2;

import controller.CustomerController;
import exception.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PaymentPageController implements Initializable {
    CustomerController customerController = CustomerController.getInstance();

    @FXML
    private TextField CVV2Field;

    @FXML
    private TextField cardNumberField;

    @FXML
    private ImageView homeImage;

    @FXML
    private TextField moneyField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    void homeImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void submitButton(MouseEvent event) throws IOException {
        try {
            String cardNumber = cardNumberField.getText();
            customerController.checkCardNumber(cardNumber);
            String password = passwordField.getText();
            customerController.checkPasswordCard(password);
            String CVV2 = CVV2Field.getText();
            customerController.checkCVV2(CVV2);
            double amountMoney = Double.parseDouble(moneyField.getText());
            customerController.increaseCredit(LoginController.customer.getUsername(), amountMoney);
            Alert successfully = new Alert(Alert.AlertType.INFORMATION);
            successfully.setTitle("Successfully!");
            successfully.setHeaderText("Successfully!");
            successfully.show();
        } catch (InvalidCardNumber ic) {
            Alert error = new Alert(Alert.AlertType.ERROR, "InvalidCardNumber!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();
        } catch (InvalidPasswordCard ip) {
            Alert error = new Alert(Alert.AlertType.ERROR, "InvalidPasswordCard!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();

        } catch (InvalidCVV2 ic) {
            Alert error = new Alert(Alert.AlertType.ERROR, "InvalidCVV2!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();
        }
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
