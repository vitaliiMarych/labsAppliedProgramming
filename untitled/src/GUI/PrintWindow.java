package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.ArrayList;
import java.util.ListResourceBundle;

public class PrintWindow {

    public static void newWindow(ArrayList<String> arrList, String title){

        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle(title);

        Pane pane = new Pane();

        Scene scene = new Scene(pane, 400,500);

        Button button = new Button("Закрити");
        button.setOnAction(e -> stage.close());
        button.setLayoutX(21);
        button.setLayoutY(435);
        button.setPrefWidth(346);
        button.setPrefHeight(48);

        ListView<String> listWiew = new ListView<>();
        ObservableList<String> list = FXCollections.observableArrayList(arrList);
        listWiew.setItems(list);
        listWiew.setLayoutX(24);
        listWiew.setLayoutY(21);
        listWiew.setPrefWidth(346);
        listWiew.setPrefHeight(376);

        pane.getChildren().add(listWiew);
        pane.getChildren().add(button);

        stage.setScene(scene);
        stage.showAndWait();
    }




}
