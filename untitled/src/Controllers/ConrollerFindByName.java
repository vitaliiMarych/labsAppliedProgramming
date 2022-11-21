package Controllers;

import CoffeeVan.CoffeeVan;
import GUI.PrintWindow;
import Logs.LoggerCoffeeVan;
import Menu.Commands.FindByNameCoffee;
import Menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.logging.Level;

public class ConrollerFindByName {

    @FXML
    private Button button;

    @FXML
    private TextField edit;

    public void initialize(){

        button.setOnAction(event -> {
            String partOfName = edit.getText();
            ArrayList<String> arrayList = FindByNameCoffee.getFindByNameArr(partOfName);

            PrintWindow.newWindow(arrayList, "Finded coffees");
            LoggerCoffeeVan.getLogger().log(Level.INFO, "Find coffee");
        });

    }

}