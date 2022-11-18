package Menu.Commands;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GetInfoCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Дізнатися інформацію про каву";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/GetInfo.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();


    }
}
