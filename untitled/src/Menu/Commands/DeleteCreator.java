package Menu.Commands;

import DataBase.DataBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteCreator implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Видалити пристрій для кави";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/DeleteCreatorW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void deleteCreator(int id) throws SQLException {
        String query = "DELETE FROM 'Creators' WHERE id = " + id;
        DataBase.getMainStatm().executeUpdate(query);
    }
}
