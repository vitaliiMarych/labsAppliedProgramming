package MainPackage;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import Menu.Menu;
import SafeScans.SafeScans;

import java.sql.SQLException;


public class Program {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        DataBase.connection();
//        DataBase.createTable();
//        DataBase.closeBD();


        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee");

        System.out.println("Type 'Help' for all available commands");

        while (true) {
            Menu.execute(SafeScans.scanLine());
            System.out.println("\nВведіть команду");
        }

    }
}
