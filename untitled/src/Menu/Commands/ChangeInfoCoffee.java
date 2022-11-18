package Menu.Commands;

import DataBase.DataBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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

    public static void changeInfo(int id, String name, int typeId, int count, int cost, double volume, String recommned) throws SQLException {
        String query = String.format("UPDATE 'Coffees' " +
                "SET 'name' = '%s', " +
                "'idType' = %d, " +
                "'countOfSell' = %d, " +
                "'cost' = %d, " +
                "'volume' = " + volume +
                ", 'recommendAdd' = '%s'" +
                " WHERE id = %d", name, typeId, count, cost, recommned, id);

        DataBase.getMainStatm().executeUpdate(query);
    }


}
