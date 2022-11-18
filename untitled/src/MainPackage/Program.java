package MainPackage;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import Menu.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Program extends Application {
    private static DecimalFormat df = new DecimalFormat();
    private static Scene mainScene;


    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(dfs);

        LoggerCoffeeVan.createLogger();
        DataBase.connection();
        DataBase.createTable();
        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        System.out.println("Type 'Help' for all available commands");

        launch(args);
    }

    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/MainW.fxml"));
        stage.setTitle("Menu");

        mainScene = new Scene(root);

        stage.setScene(mainScene);
        stage.show();

    }

    public static DecimalFormat getDf() {
        return df;
    }
}
