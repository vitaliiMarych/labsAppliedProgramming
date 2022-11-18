package Menu.Commands;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddNewCoffee implements ICommand{

    @Override
    public String getInfoAboutCommand() {
        return "Добавити нову каву";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AddNewCoffeeW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();
    }

    //inserts
    public static void insertCoffee(Statement statm, String NAME, String TYPE,
                                    int COST, double VOLUME, String RECOMMEND) throws SQLException {

        boolean canSell = false;
        String state = "Нема на складі";

        if (VOLUME > 0) {
            canSell = true;
            state = "Можна продавати";
        }

        ResultSet idType = statm.executeQuery(String.format("SELECT id FROM 'typesOfCoffee' WHERE type = '%s'", TYPE));

        statm.executeUpdate("INSERT INTO 'Coffees'(name, canSell, idType, state, cost, volume, recommendAdd) VALUES" +
                String.format("('%s','%d','%d','%s','%d','"+ VOLUME + "','%s')",
                        NAME, canSell ? 1 : 0, idType.getInt(1), state, COST, RECOMMEND));
        statm.close();

    }
}
