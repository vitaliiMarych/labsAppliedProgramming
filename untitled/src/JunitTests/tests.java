package JunitTests;

import CoffeeVan.CoffeeCreators.CoffeeCreator;
import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;
import DataBase.DataBase;
import Logs.LoggerCoffeeVan;
import Menu.Commands.*;
import Menu.Menu;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class tests {

    @Test
    void insertCoffee() throws SQLException, ClassNotFoundException {
        LoggerCoffeeVan.createLogger();
        LoggerCoffeeVan.getLogger().log(Level.INFO, "Insert coffee test is started");
        DataBase.connection();
        DataBase.createTable();
        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        Coffee cof = new Coffee(0, "name", true, "мелена", "vdv", 0, 100, 4.2, "grdgdr", "турка");
        AddNewCoffee.insertCoffee(DataBase.getMainStatm(), cof.getName(), cof.getType(), cof.getCost(),cof.getVolume(),cof.getRecomendAdditive());

        CoffeeVan.readLists();
        int ind = CoffeeVan.getCoffees().size() - 1;
        Coffee cof2 = CoffeeVan.getCoffees().get(ind);

        if (cof.equals(cof2))
            LoggerCoffeeVan.getLogger().log(Level.INFO, "Insert coffee test is good");
        else
            LoggerCoffeeVan.getLogger().log(Level.WARNING, "Insert coffee test is failed");

        DeleteCoffee.deleteCoffee(cof2.getId());
        assertEquals(cof, cof2);
    }


    @Test
    void insertCreator() throws SQLException, ClassNotFoundException {
        LoggerCoffeeVan.createLogger();
        LoggerCoffeeVan.getLogger().log(Level.INFO, "Insert creator test is started");
        DataBase.connection();
        DataBase.createTable();
        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        CoffeeCreator cr = new CoffeeCreator(0,true, "fsrf", "турка");
        AddNewCreator.insertCreator(DataBase.getMainStatm(), cr.getType(), cr.isWorking(), cr.getState());
        CoffeeVan.readLists();

        int ind = CoffeeVan.getCreators().size() - 1;
        CoffeeCreator cr2 = CoffeeVan.getCreators().get(ind);

        if (cr.equals(cr2))
            LoggerCoffeeVan.getLogger().log(Level.INFO, "Insert creator test is good");
        else
            LoggerCoffeeVan.getLogger().log(Level.WARNING, "Insert creator test is failed");

        DeleteCreator.deleteCreator(cr2.getId());
        assertEquals(cr, cr2);
    }

    @Test
    void changeInfo() throws SQLException, ClassNotFoundException {
        LoggerCoffeeVan.createLogger();
        DataBase.connection();
        DataBase.createTable();
        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        CoffeeVan.readLists();

        AddNewCoffee.insertCoffee(DataBase.getMainStatm(), "fee", "мелена",100, 2.2, "fff");
        CoffeeVan.readLists();

        int size = CoffeeVan.getCoffees().size() - 1;
        int id = CoffeeVan.getCoffees().get(size).getId();

        String change = "changed";
        ChangeInfoCoffee.changeInfo(id, change, 1, 0,0,0.2,"fee");

        CoffeeVan.readLists();
        Coffee coffee = CoffeeVan.getCoffees().get(size);
        DeleteCoffee.deleteCoffee(id);

        assertEquals(coffee.getName(), change);
    }

    @Test
    void changeStatus() throws SQLException, ClassNotFoundException {
        LoggerCoffeeVan.createLogger();
        DataBase.connection();
        DataBase.createTable();
        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        CoffeeVan.readLists();

        AddNewCoffee.insertCoffee(DataBase.getMainStatm(), "fee", "мелена",100, 2.2, "fff");
        CoffeeVan.readLists();

        int size = CoffeeVan.getCoffees().size() - 1;
        int id = CoffeeVan.getCoffees().get(size).getId();

        String state = "changed";
        ChangeStatusCoffee.changeStatus(id, false, state);

        CoffeeVan.readLists();
        Coffee coffee = CoffeeVan.getCoffees().get(size);
        DeleteCoffee.deleteCoffee(id);

        assertEquals(coffee.getState(), state);
    }

    @Test
    void deleteCoffee() throws SQLException, ClassNotFoundException {
        LoggerCoffeeVan.createLogger();
        DataBase.connection();
        DataBase.createTable();
        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        CoffeeVan.readLists();
        int count1 = CoffeeVan.getCoffees().size();

        AddNewCoffee.insertCoffee(DataBase.getMainStatm(), "fee", "мелена",100, 2.2, "fff");
        CoffeeVan.readLists();
        DeleteCoffee.deleteCoffee(CoffeeVan.getCoffees().get(CoffeeVan.getCoffees().size() - 1).getId());
        CoffeeVan.readLists();
        int count2 = CoffeeVan.getCoffees().size();

        assertEquals(count1, count2);
    }

    @Test
    void deleteCreator() throws SQLException, ClassNotFoundException {
        LoggerCoffeeVan.createLogger();
        DataBase.connection();
        DataBase.createTable();
        Menu.createMenu();
        CoffeeVan.start("Vitalik coffee", 50000.0);

        CoffeeVan.readLists();
        int count1 = CoffeeVan.getCreators().size();

        AddNewCreator.insertCreator(DataBase.getMainStatm(), "турка", true, "fff");
        CoffeeVan.readLists();
        DeleteCreator.deleteCreator(CoffeeVan.getCreators().get(CoffeeVan.getCreators().size() - 1).getId());
        CoffeeVan.readLists();
        int count2 = CoffeeVan.getCreators().size();

        assertEquals(count1, count2);
    }
}