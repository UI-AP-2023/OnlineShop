package com.example.onlineshop2;

import controller.CustomerController;
import exception.ExpiryDate;
import exception.InvalidCapacity;
import exception.unavailableCode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.user.PurchaseInvoice;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class CartController implements Initializable {
    CustomerController customerController = CustomerController.getInstance();
    static PurchaseInvoice purchaseInvoice;
    static ArrayList<String> discountCodes=new ArrayList<>();

    @FXML
    private Button saveButton;

    @FXML
    private Button buyButton;

    @FXML
    private ListView<String> cartViewList;

    @FXML
    private Button deleteProductButton;

    @FXML
    private ImageView homeImage;

    @FXML
    private TextField productIDField;

    @FXML
    private TextField discountCodeField;

    private final String[] products = new String[LoginController.customer.getCart().size()];

    @FXML
    void saveButton(MouseEvent event) {
        discountCodes=listDiscountCodes();
        Alert error = new Alert(Alert.AlertType.INFORMATION, "Saved!");
        error.setTitle("Successfully!");
        error.setHeaderText("Successfully!");
        error.show();
    }


    @FXML
    void buyButton(MouseEvent event) throws IOException {
        int returnNumber = buy(LoginController.customer.getUsername(), LocalDate.now().toString(),discountCodes);
        if (returnNumber == 1) {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("invoice-page.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
            discountCodes.clear();
        } else if (returnNumber == 0) {
            Alert error = new Alert(Alert.AlertType.ERROR, "Your Account Credit is not enough!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR, "Your cart is empty!");
            error.setTitle("Error!");
            error.setHeaderText("Error!");
            error.show();
        }
    }

    @FXML
    void deleteProductButton(MouseEvent event) {
        customerController.deleteProduct(productIDField.getText(), LoginController.customer.getUsername());

    }

    @FXML
    void homeImage(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer-page.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < LoginController.customer.getCart().size(); i++) {
            products[i] = LoginController.customer.getCart().get(i).getGoodID();
        }
        cartViewList.getItems().addAll(products);
    }
//-------------------------------------------------------------------------------------------------------------------------
    private int buy(String username, String date, ArrayList<String> discountCodes) {
        purchaseInvoice = customerController.purchaseInvoice(username, date);
        if (purchaseInvoice != null) {
            try {
                boolean find = customerController.finalizePurchase(username, purchaseInvoice.getAmountPaid(), purchaseInvoice, discountCodes);
                if (find)
                    return 1;

                else
                    return 0;//Your Account Credit is not enough

            } catch (ExpiryDate ed) {
                Alert error = new Alert(Alert.AlertType.ERROR, "The discount code has expired!");
                error.setTitle("Error!");
                error.setHeaderText("ExpiryDate error!");
                error.show();
            } catch (InvalidCapacity ic) {
                Alert error = new Alert(Alert.AlertType.ERROR, "The number of discount codes is over!");
                error.setTitle("Error!");
                error.setHeaderText("InvalidCapacity error!");
                error.show();
            } catch (unavailableCode uc) {
                Alert error = new Alert(Alert.AlertType.ERROR, "No such discount code found!");
                error.setTitle("Error!");
                error.setHeaderText("unavailableCode error!");
                error.show();
            }
        }
        return -1; //Your cart is empty
    }

    private ArrayList<String> listDiscountCodes()
    {
        String code=discountCodeField.getText();
        String[] discountCode=code.split(" ");
        return new ArrayList<>(Arrays.asList(discountCode));
    }
}
