package Menu.Commands;

import DataBase.DataBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Видалити каву";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/DeleteCoffeeW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();

    }

    public static void deleteCoffee(int id) throws SQLException {
        String query = "DELETE FROM 'Coffees' WHERE id = " + id;
        DataBase.getMainStatm().executeUpdate(query);
    }
}
