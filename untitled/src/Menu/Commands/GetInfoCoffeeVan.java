package Menu.Commands;

import CoffeeVan.CoffeeVan;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class GetInfoCoffeeVan implements ICommand{

    @Override
    public String getInfoAboutCommand() {
        return "Дізнатися інформацію про фургон";
    }

    @Override
    public void execute() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info van");
        alert.setHeaderText("Інформація про вагончик");
        alert.setContentText(CoffeeVan.toStringe());
        alert.showAndWait();
    }
}
