package MainPackage;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import Menu.Commands.AddNewCoffee;
import Menu.Menu;
import SafeScans.SafeScans;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;


public class Program {
    public static DecimalFormat df = new DecimalFormat();
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(dfs);


        DataBase.connection();
        DataBase.createTable();


        for (int i = 0; i < 100; i++){
            AddNewCoffee.insertCoffee(DataBase.getMainStatm(), "kava"+ i, "розчинна", 50, 5.1, "молоко");
        }
        DataBase.closeBD();

        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        System.out.println("Type 'Help' for all available commands");

        while (true) {
            String command = SafeScans.scanLine();

            CoffeeVan.readCoffeeListFromDB();
            Menu.execute(command);
            System.out.println("\nВведіть команду");
        }
    }
}
