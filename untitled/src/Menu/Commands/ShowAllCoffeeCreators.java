package Menu.Commands;

import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;
import GUI.PrintWindow;

import java.util.ArrayList;

public class ShowAllCoffeeCreators implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Показати всі пристрої для кави";
    }

    @Override
    public void execute() {
        ArrayList<String> arrList = new ArrayList<>();
        CoffeeVan.getCreators().forEach(x -> arrList.add(x.toString()));

        PrintWindow.newWindow(arrList, "Show creators");
    }
}
