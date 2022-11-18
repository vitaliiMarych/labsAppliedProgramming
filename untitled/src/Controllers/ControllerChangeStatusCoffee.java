package Controllers;


import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import Menu.Commands.ChangeStatusCoffee;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.util.logging.Level;

public class ControllerChangeStatusCoffee {

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

                boolean canSell = edit2.getText().toLowerCase().equals("y") ;
                String state;
                if (canSell)
                    state = "Можна продавати";
                else
                    state = edit3.getText();

                ChangeStatusCoffee.changeStatus(id, canSell, state);
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Changed status coffee");
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
