package Menu.Commands;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddNewCreator implements  ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Добавити новий пристрій";
    }

    @Override
    public void execute() throws SQLException, IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AddNewCreatorW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();
    }

    //inserts
    public static void insertCreator(Statement statm, String type, boolean isWorking, String state) throws SQLException {


        ResultSet idType = statm.executeQuery(String.format("SELECT id FROM 'typesOfCreator' WHERE type = '%s'", type));

        statm.executeUpdate("INSERT INTO 'Creators'(idType, isWorking, state) VALUES" +
                String.format("('%d','%d','%s')",
                        idType.getInt(1), isWorking ? 1 : 0, state));

        statm.close();
    }
}
