package GUI;

import CoffeeVan.CoffeeVan;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

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

                CoffeeVan.getCoffees().stream().filter(x -> x.getCost() <= max && x.getCost() >= min).forEach(x -> arrayList.add(x.toString()));
                PrintWindow.newWindow(arrayList, "Finded coffees");
            }
            catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Exception");
                alert.setContentText("Проблема з введенням");
                alert.showAndWait();
            }
        });

    }

}