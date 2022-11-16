package Menu.Commands;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import MainPackage.Program;
import SafeScans.SafeScans;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeInfoCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Змінити інформацію про каву";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/ChangeInfoCoffeeW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();

    }


}
