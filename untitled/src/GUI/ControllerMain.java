package GUI;

import Menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerMain {

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    public void initialize(){
        ObservableList<String> commands = FXCollections.observableArrayList(Menu.getAllCommands());
        choiceBox.setItems(commands);

        choiceBox.setOnAction(event -> {
            label.setText(Menu.getMn().get(choiceBox.getValue()).getInfoAboutCommand());
        });

        button.setOnAction(e -> Menu.execute(choiceBox.getValue()));

    }




}
