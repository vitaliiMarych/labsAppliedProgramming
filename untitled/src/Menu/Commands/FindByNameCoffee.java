package Menu.Commands;

import CoffeeVan.CoffeeVan;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FindByNameCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Найти каву за частинкою назви або цілою";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/FindByNameW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();

    }

    public static ArrayList<String> getFindByNameArr(String name){
        ArrayList<String> arrayList = new ArrayList<>();

        CoffeeVan.getCoffees().stream().filter(
                x -> x.getName().toLowerCase().contains(name.toLowerCase())
        ).forEach(x -> arrayList.add(x.toString()));

        return arrayList;
    }

}
