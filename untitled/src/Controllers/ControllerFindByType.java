package Controllers;

import CoffeeVan.CoffeeVan;
import GUI.PrintWindow;
import Logs.LoggerCoffeeVan;
import Menu.Commands.FindByTypeCoffee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.logging.Level;

public class ControllerFindByType {

    @FXML
    private Button button;

    @FXML
    private ChoiceBox<String> comboBox;

    public void initialize() {
        String[] TYPES = new String[] {"мелена","розчинна","зернова"};
        ObservableList<String> types = FXCollections.observableArrayList(TYPES);
        comboBox.setItems(types);


        button.setOnAction(event -> {
            ArrayList<String> arrayList = FindByTypeCoffee.getFindByTypeArr(comboBox.getValue());
            PrintWindow.newWindow(arrayList, "Finded coffees");
            LoggerCoffeeVan.getLogger().log(Level.INFO, "Find coffee");
        });

    }
}