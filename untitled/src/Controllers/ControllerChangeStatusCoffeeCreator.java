package Controllers;


import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.util.logging.Level;

public class ControllerChangeStatusCoffeeCreator {

    @FXML
    private Button button;

    @FXML
    private TextField edit1;

    @FXML
    private TextField edit2;

    @FXML
    private TextField edit3;

    public void initialize() {

        button.setOnAction(event -> {
            try {

                int id = Integer.parseInt(edit1.getText());

                if (!edit2.getText().equals("y") && !edit2.getText().equals("n"))
                    throw new Exception();

                boolean isWorking = edit2.getText().toLowerCase().equals("y") ;
                String state;
                if (isWorking)
                    state = "Все добре";
                else
                    state = edit3.getText();

                String query = String.format("UPDATE 'Creators' " +
                        "SET 'isWorking' = '%d', " +
                        "'state' = '%s' " +
                        " WHERE id = %d", isWorking ? 1 : 0, state, id);;

                DataBase.getMainStatm().executeUpdate(query);
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Changed status coffee creator");
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