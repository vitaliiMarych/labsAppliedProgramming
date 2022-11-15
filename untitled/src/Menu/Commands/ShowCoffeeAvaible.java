package Menu.Commands;

import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;
import GUI.PrintWindow;

import java.util.ArrayList;

public class ShowCoffeeAvaible implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Показати весь доступний асортимент кави";
    }

    @Override
    public void execute() {
        ArrayList<String> arrList = new ArrayList<>();
        CoffeeVan.getCoffees().stream().filter(Coffee::isCanSell).forEach(x -> arrList.add(x.toString()));

        PrintWindow.newWindow(arrList, "Show avaible coffee");


    }
}
