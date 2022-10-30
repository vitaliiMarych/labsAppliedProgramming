package CoffeeVan;

import CoffeeVan.CoffeeCreators.CoffeeCreator;
import CoffeeVan.Coffees.Coffee;
import DataBase.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeVan {
    private static double maxVolume;
    private static double currentVolume = 0;
    private static String name;
    private static ArrayList<Coffee> coffees;
    private static ArrayList<CoffeeCreator> creators;

    public static void start(String n, Double volume) throws SQLException {
        name = n;
        maxVolume = volume;
        creators = new ArrayList<>();
    }

    public static double getMaxVolume() {
        return maxVolume;
    }

    public static double getCurrentVolume() {
        return currentVolume;
    }

    public static ArrayList<Coffee> getCoffees() {
        return coffees;
    }

    public static ArrayList<CoffeeCreator> getCreators() {
        return creators;
    }

    public static void readCoffeeListFromDB() throws SQLException {

        coffees = new ArrayList<>();
        ResultSet rslt = DataBase.getCoffeeData();

        while (rslt.next()){

            int id = rslt.getInt(1);
            String name = rslt.getString(2);
            boolean canSell = rslt.getBoolean(3);
            String state = rslt.getString(5);
            int countOfSell = rslt.getInt(6);
            int cost = rslt.getInt(7);


            //dabl ne tak raxye

            double f = rslt.getDouble(8);

            double volume = (Double) rslt.getDouble(8);
            String recomendAdditive = rslt.getString(9);

            int indexTypeCoffee = rslt.getInt(4);
            ResultSet typecolumh = DataBase.getTypeOfCoffee(indexTypeCoffee);
            String type = typecolumh.getString(2);
            int indexTypeCreator = typecolumh.getInt(3);

            String creatorType = DataBase.getTypeOfCreator(indexTypeCreator).getString(2);

            if (currentVolume + volume < maxVolume) {
                Coffee coffee = new Coffee(id, name, canSell, type, state, countOfSell, cost, volume, recomendAdditive, creatorType);
                coffees.add(coffee);
                currentVolume += volume;
            }
            else{
                System.out.println("У фургоні недостатньо місця");
            }
        }
    }

    public static String toStringe() {
        return String.format("Кавовий фургон '%s', максимальний об'єм кави на складі - %f, поточний зайнятий об'єм - %f",
                name, maxVolume, currentVolume);
    }
}
