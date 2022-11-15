package Menu;

import CoffeeVan.CoffeeVan;
import Menu.Commands.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class Menu {
    private static Hashtable<String, ICommand> mn = new Hashtable<>();

    public static void createMenu(){
        mn.put("Add coffee", new AddNewCoffee());
        mn.put("Change info", new ChangeInfoCoffee());
        mn.put("Change status", new ChangeStatusCoffee());
        mn.put("Change status creator", new ChangeStatusCoffeeCreator());
        mn.put("Delete coffee", new DeleteCoffee());
        mn.put("Find by cost", new FindByCostCoffee());
        mn.put("Find by name", new FindByNameCoffee());
        mn.put("Find by type", new FindByTypeCoffee());
        mn.put("Get info", new GetInfoCoffee());
        mn.put("Show coffee", new ShowAllCoffee());
        mn.put("Show avaible coffee", new ShowCoffeeAvaible());
        mn.put("Show creators", new ShowAllCoffeeCreators());
        mn.put("Sort coffee", new SortCoffee());
        mn.put("Exit", new ExitCoffee());
        mn.put("Info van", new GetInfoCoffeeVan());
        mn.put("Delete creator", new DeleteCreator());
        mn.put("Add creator", new AddNewCreator());

    }

    public static ArrayList<String> getAllCommands(){
        return new ArrayList<String>(mn.keySet());
    }

    public static Hashtable<String, ICommand> getMn() {
        return mn;
    }

    public static void execute(String command){
        try {
            CoffeeVan.readLists();
            mn.get(command).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неправильно введена команда... попробуйте ще раз!");
        }
    }
}
