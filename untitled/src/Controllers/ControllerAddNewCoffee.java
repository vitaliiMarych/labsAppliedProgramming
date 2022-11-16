package Controllers;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import MainPackage.Program;
import SafeScans.SafeScans;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.util.logging.Level;

import static Menu.Commands.AddNewCoffee.insertCoffee;

public class ControllerAddNewCoffee {

    @FXML
    private Button button;

    @FXML
    private ChoiceBox<String> choiceBox;


    @FXML
    private TextField edit1;

    @FXML
    private TextField edit2;

    @FXML
    private TextField edit3;

    @FXML
    private TextField edit4;

    @FXML
    private Label label;

    public void initialize() {
        String[] TYPES = new String[]{"мелена", "розчинна", "зернова"};
        ObservableList<String> types = FXCollections.observableArrayList(TYPES);
        choiceBox.setItems(types);

        button.setOnAction(event -> {
            try {
                if (edit1.getText() == null)
                    throw new Exception();
                String name = edit1.getText();

                if (choiceBox.getValue() == null)
                    throw new Exception();
                String type = choiceBox.getValue();

                if (edit2.getText() == null)
                    throw new Exception();
                int cost = Integer.parseInt(edit2.getText());

                if (edit3.getText() == null)
                    throw new Exception();
                double volume = (Double) Program.getDf().parse(edit3.getText());;

                if (CoffeeVan.getMaxVolume() - CoffeeVan.getCurrentVolume() < 0)
                    throw new Exception();

                if (edit4.getText() == null)
                    throw new Exception();
                String recommned = edit4.getText();

                if (volume <= 0 || cost <= 0)
                    throw new Exception();

                insertCoffee(DataBase.getMainStatm(), name, type, cost, volume, recommned);
                label.setText("Успішно додано!");
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Added new coffee");
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