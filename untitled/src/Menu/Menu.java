package Menu;

import Menu.Commands.*;

import java.util.Hashtable;

public class Menu {
    private static Hashtable<String, ICommand> mn = new Hashtable<>();

    public static void createMenu(){
        mn.put("Help", new HelpCoffee(mn));
        mn.put("Add coffee", new AddNewCoffee());
        mn.put("Change info", new ChangeInfoCoffee());
        mn.put("Change status", new ChangeStatusCoffee());
        mn.put("Change status creator", new ChangeStatusCoffeeCreator());
        mn.put("Delete coffee", new DeleteCoffee());
        mn.put("Find by cost", new FindByCostCoffee());
        mn.put("Find by name", new FindByNameCoffee());
        mn.put("Find by type", new FindByTypeCoffee());
        mn.put("Get info", new GetInfoCoffee());
        mn.put("Show all coffee", new ShowAllCoffee());
        mn.put("Show all avaible coffee", new ShowCoffeeAvaible());
        mn.put("Show all creators", new ShowAllCoffeeCreators());
        mn.put("Sort Coffee", new SortCoffee());
        mn.put("Exit", new ExitCoffee());
        mn.put("Info about van", new GetInfoCoffeeVan());

    }

    public static void execute(String command){
        try {
            mn.get(command).execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неправильно введена команда... попробуйте ще раз!");
        }
    }
}
