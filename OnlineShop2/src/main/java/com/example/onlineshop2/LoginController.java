package com.example.onlineshop2;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.user.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private final AdminPanel adminPanel=new AdminPanel();
    private final CustomerController customerController=CustomerController.getCustomerController();
    static Customer customer;
    @FXML
    private ImageView homeImage;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField usernameField;

    @FXML
    void loginButton(MouseEvent event) throws IOException {
        if (Objects.equals(usernameField.getText(), "admin") && Objects.equals(passwordField.getText(), "admin"))
        {
            adminPanel.adminCommand();
//            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-page.fxml")));
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(parent);
//            stage.setScene(scene);
//            stage.show();
        }
        else{
            if(customerController.checkInfo(usernameField.getText(),passwordField.getText()))
            {
                customer=customerController.findCustomer(usernameField.getText());
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer-page.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                Alert error = new Alert(Alert.AlertType.ERROR, "Your information is not correct!");
                error.setTitle("Error!");
                error.setHeaderText("Input error!");
                error.show();
            }
        }
    }

    @FXML
    void signupButton(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup.fxml")));
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void homeImage(MouseEvent event) throws IOException {
        Parent parent= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("first-page.fxml")));
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
