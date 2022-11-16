package Controllers;

import CoffeeVan.CoffeeVan;
import Logs.LoggerCoffeeVan;
import Menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.logging.Level;

public class ControllerGetInfo {

    @FXML
    private Button button;

    @FXML
    private TextField edit;

    @FXML
    private Label label;

    @FXML
    private Label label2;

    public void initialize(){

        button.setOnAction(event -> {
            String id = edit.getText();

            StringBuilder text = new StringBuilder();


            try {
                if (CoffeeVan.getCoffees().stream().noneMatch(x -> x.getId() == Integer.parseInt(id)))
                    text.append("Такого id не існує");

                else
                    CoffeeVan.getCoffees().stream().filter(x -> x.getId() == Integer.parseInt(id)).forEach(
                            x -> text.append(x.toStringAllInfo()));
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Info about coffee was got");
            }
            catch (Exception e){
                text.append("Помилка при введенні");
                LoggerCoffeeVan.getLogger().log(Level.WARNING, "Input problem");
            }

            label.setText(text.toString());
        });


    }

}
