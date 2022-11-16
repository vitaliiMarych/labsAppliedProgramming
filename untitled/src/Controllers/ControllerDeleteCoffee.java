package Controllers;

import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
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

                String query = "DELETE FROM 'Coffees' WHERE id = " + id;
                DataBase.getMainStatm().executeUpdate(query);
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Coffee was deleted");
            }
            catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Exception");
                alert.setContentText("Проблема з введенням");
                alert.showAndWait();
                LoggerCoffeeVan.getLogger().log(Level.WARNING, "Input problem");
            }
        });
    }

}
