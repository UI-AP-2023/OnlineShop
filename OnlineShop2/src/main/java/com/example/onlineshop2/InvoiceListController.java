package com.example.onlineshop2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InvoiceListController implements Initializable {
    @FXML
    private Label infoLabel;

    @FXML
    private ListView<String > invoiceViewList;

    @FXML
    private ImageView homeImage;

    private final String[] invoiceList = new String[LoginController.customer.getPurchaseInvoices().size()];
    private String currentChoice;

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
        for (int i = 0; i < LoginController.customer.getPurchaseInvoices().size(); i++) {
            invoiceList[i] = LoginController.customer.getPurchaseInvoices().get(i).getInvoiceID();
        }
        invoiceViewList.getItems().addAll(invoiceList);
        invoiceViewList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentChoice = invoiceViewList.getSelectionModel().getSelectedItem();
                int index = 0;
                for (int i = 0; i < LoginController.customer.getPurchaseInvoices().size(); i++) {
                    if (LoginController.customer.getPurchaseInvoices().get(i).getInvoiceID().equals(currentChoice)) {
                        index = i;
                        break;
                    }
                }
                infoLabel.setText(LoginController.customer.getPurchaseInvoices().get(index).toString());
            }
        });

    }
}
