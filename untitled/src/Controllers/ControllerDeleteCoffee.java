package Controllers;

import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import Menu.Commands.DeleteCoffee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.logging.Level;

public class ControllerDeleteCoffee {

    @FXML
    private Button button;

    @FXML
    private TextField edit;

    public void initialize() {
        button.setOnAction(event -> {
            try {
                int id = Integer.parseInt(edit.getText());

                DeleteCoffee.deleteCoffee(id);
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Coffee was deleted");
            }
            catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Exception");
                alert.setContentText("Проблема з введенням");
                alert.showAndWait();
                LoggerCoffeeVan.getLogger().severe("Input problem");
            }
        });
    }

}
