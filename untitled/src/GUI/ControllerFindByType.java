package GUI;

import CoffeeVan.CoffeeVan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;

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
            ArrayList<String> arrayList = new ArrayList<>();
            CoffeeVan.getCoffees().stream().filter(x -> x.getType().equals(comboBox.getValue())).forEach(x -> arrayList.add(x.toString()));
            PrintWindow.newWindow(arrayList, "Finded coffees");
        });

    }
}