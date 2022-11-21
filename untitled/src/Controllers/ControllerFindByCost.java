package Controllers;

import CoffeeVan.CoffeeVan;
import GUI.PrintWindow;
import Logs.LoggerCoffeeVan;
import Menu.Commands.FindByCostCoffee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.logging.Level;

public class ControllerFindByCost {

    @FXML
    private Button button;

    @FXML
    private TextField edit1;

    @FXML
    private TextField edit2;

    public void initialize() {
        button.setOnAction(event -> {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                int min = Integer.parseInt(edit1.getText());
                int max = Integer.parseInt(edit2.getText());

                arrayList = FindByCostCoffee.getFindByCostArr(min,max);
                PrintWindow.newWindow(arrayList, "Finded coffees");
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Find coffee");

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