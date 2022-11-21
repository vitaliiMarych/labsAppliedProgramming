package Menu.Commands;

import CoffeeVan.CoffeeVan;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FindByTypeCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Найти каву за типом";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/FindByTypeW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();
    }

    public static ArrayList<String> getFindByTypeArr(String type){
        ArrayList<String> arrayList = new ArrayList<>();
        CoffeeVan.getCoffees().stream().filter(x -> x.getType().equals(type)).forEach(x -> arrayList.add(x.toString()));

        return arrayList;
    }
}
