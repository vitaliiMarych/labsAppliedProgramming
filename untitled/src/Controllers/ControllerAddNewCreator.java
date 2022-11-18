package Controllers;



import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.logging.Level;

import static Menu.Commands.AddNewCreator.insertCreator;

public class ControllerAddNewCreator {

    @FXML
    private Button button;

    @FXML
    private ChoiceBox<String> choiceBox1;

    @FXML
    private ChoiceBox<String> choiceBox2;

    @FXML
    private TextField edit;

    @FXML
    private Label label;

    @FXML
    private Label label2;

    public void initialize() {
        String[] TYPES = new String[]{"чайник", "кавова машина", "турка"};
        ObservableList<String> types = FXCollections.observableArrayList(TYPES);
        choiceBox1.setItems(types);

        String[] BOOL = new String[] {"y", "n"};
        ObservableList<String> bool = FXCollections.observableArrayList(BOOL);
        choiceBox2.setItems(bool);

        choiceBox2.setOnAction(event -> {
            if (choiceBox2.getValue().equals("y")){
                edit.setVisible(false);
                label.setVisible(false);
            }
            else{
                edit.setVisible(true);
                label.setVisible(true);
            }
        });

        button.setOnAction(event -> {
            try {

                String type = choiceBox1.getValue();

                boolean isWorking = choiceBox2.getValue().equals("y");

                String state;
                if (isWorking)
                    state = "Все добре";
                else
                    state = edit.getText();

                if (type == null || state == null || choiceBox2.getValue() == null)
                    throw new Exception();

                insertCreator(DataBase.getMainStatm(), type,isWorking, state);
                label2.setText("Успішно додано");
                LoggerCoffeeVan.getLogger().log(Level.INFO, "Added new creator");
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