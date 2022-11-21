package Menu.Commands;


import CoffeeVan.CoffeeVan;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class FindByCostCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Найти каву за діапазоном ціни";
    }

    @Override
    public void execute() throws IOException {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/FindByCostW.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.showAndWait();
    }

    public static ArrayList<String> getFindByCostArr(int min, int max){
        ArrayList<String> arrayList = new ArrayList<>();
        CoffeeVan.getCoffees().stream().filter(x -> x.getCost() <= max && x.getCost() >= min).forEach(x -> arrayList.add(x.toString()));

        return arrayList;
    }
}
