package Menu.Commands;

import DataBase.DataBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ChangeStatusCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Змінити статус кави";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/ChangeStatusCoffeeW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void changeStatus(int id, boolean canSell, String state) throws SQLException {
        String query = String.format("UPDATE 'Coffees' " +
                "SET 'canSell' = '%d', " +
                "'state' = '%s' " +
                " WHERE id = %d", canSell ? 1 : 0, state, id);;

        DataBase.getMainStatm().executeUpdate(query);
    }
}
