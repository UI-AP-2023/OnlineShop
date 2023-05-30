package com.example.onlineshop2;

import controller.AdminController;
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

public class SignupController implements Initializable {
    private CustomerController customerController = CustomerController.getCustomerController();
    private final AdminController adminController = AdminController.getInstance();
    @FXML
    private TextField emailField;

    @FXML
    private ImageView homeImage;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameField;

    @FXML
    void homeImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void signupButton(MouseEvent event) {
        try {
            String username = usernameField.getText();
            customerController.checkUsername(username);
            String password = passwordField.getText();
            customerController.checkPatternPassword(password);
            String email = emailField.getText();
            customerController.checkPatternEmail(email);
            customerController.checkEmail(email);
            String phone = phoneNumberField.getText();
            customerController.checkPatternPhoneNumber(phone);
            Customer newCustomer = new Customer(username, password, email, phone);
            adminController.getAdmin().getRegistrationRequest().add(newCustomer);
            Alert successfully = new Alert(Alert.AlertType.INFORMATION, "The information was registered!");
            successfully.setTitle("Successfully!");
            successfully.setHeaderText("Successfully!");
            successfully.show();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (DuplicateUsername du) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Your username is available!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();
        } catch (InvalidPassword ip) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Your password pattern is not correct!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();

        } catch (InvalidEmail ie) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Your email pattern is not correct!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();
        } catch (DuplicateEmail de) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Your email is available!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();
        } catch (InvalidPhoneNumber ip) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Your phone number pattern is not correct!");
            error.setTitle("Error!");
            error.setHeaderText("Input error!");
            error.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        usernameField.clear();
        passwordField.clear();
        phoneNumberField.clear();
        emailField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
