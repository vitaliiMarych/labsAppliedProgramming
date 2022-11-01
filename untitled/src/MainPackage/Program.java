package MainPackage;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import Menu.Commands.AddNewCoffee;
import Menu.Menu;
import SafeScans.SafeScans;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;


public class Program {
    private static DecimalFormat df = new DecimalFormat();
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(dfs);


        DataBase.connection();
        DataBase.createTable();

        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        System.out.println("Type 'Help' for all available commands");


        while (true) {
            String command = SafeScans.scanLine();

            CoffeeVan.readLists();

            Menu.execute(command);

            System.out.println("\nВведіть команду");
        }
    }

    public static DecimalFormat getDf() {
        return df;
    }
}
