package CoffeeVan;

import CoffeeVan.CoffeeCreators.CoffeeCreator;
import CoffeeVan.Coffees.Coffee;

import java.util.ArrayList;

public class CoffeeVan {
    private static double maxVolume;
    private static String name;
    private static ArrayList<Coffee> coffees;
    private static ArrayList<CoffeeCreator> creators;

    public static void start(String n){
        coffees = new ArrayList<>();
        creators = new ArrayList<>();
        name = n;
    }

    public static ArrayList<Coffee> getCoffees() {
        return coffees;
    }

    public static ArrayList<CoffeeCreator> getCreators() {
        return creators;
    }
}
