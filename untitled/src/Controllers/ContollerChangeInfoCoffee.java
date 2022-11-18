package Controllers;

import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import MainPackage.Program;
import Menu.Commands.ChangeInfoCoffee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.util.logging.Level;

public class ContollerChangeInfoCoffee {

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
    private TextField edit5;

    @FXML
    private TextField edit6;

    public void initialize() {
        String[] TYPES = new String[]{"мелена", "розчинна", "зернова", "next"};
        ObservableList<String> types = FXCollections.observableArrayList(TYPES);
        choiceBox.setItems(types);

        button.setOnAction(event -> {
            try {

                int id = Integer.parseInt(edit1.getText());


                ResultSet rslt = DataBase.getMainStatm().executeQuery("SELECT * FROM 'Coffees' WHERE id = " + id + "");


                String name;
                if (edit2.getText().equals("next"))
                    name = rslt.getString(2);
                else
                    name = edit2.getText();


                String type = choiceBox.getValue();
                int typeId;
                switch (type) {
                    case "зернова":
                        typeId = 1;
                        break;
                    case "мелена":
                        typeId = 2;
                        break;
                    case "розчинна":
                        typeId = 3;
                        break;
                    case "next":
                        typeId = rslt.getInt(4);
                        break;
                    default:
                        throw new Exception();
                }


                int count;
                if (edit3.getText().equals("next"))
                    count = Integer.parseInt(rslt.getString(6));
                else
                    count = Integer.parseInt(edit3.getText());


                int cost;
                if (edit4.getText().equals("next"))
                    cost = Integer.parseInt(rslt.getString(7));
                else
                    cost = Integer.parseInt(edit4.getText());


                double volume;
                if (edit5.getText().equals("next"))
                    volume = (Double) rslt.getDouble(8);
                else
                    volume = (Double) Program.getDf().parse(edit5.getText());

                if (volume <= 0 || cost <= 0 || count <= 0)
                    throw new Exception();

                String recommned = edit6.getText();

                ChangeInfoCoffee.changeInfo(id, name, typeId, count,cost,volume,recommned);

                LoggerCoffeeVan.getLogger().log(Level.INFO, "Changed info about coffee");
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