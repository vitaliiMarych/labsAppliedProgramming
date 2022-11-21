package Menu.Commands;

import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;
import GUI.PrintWindow;

import java.util.ArrayList;
import java.util.Collections;

public class ShowCoffeeAvaible implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Показати весь доступний асортимент кави";
    }

    @Override
    public void execute() {
        ArrayList<String> arrList = getAvaibleArr();

        PrintWindow.newWindow(arrList, "Show avaible coffee");
    }

    public static ArrayList<String> getAvaibleArr(){
        ArrayList<String> arrList = new ArrayList<>();
        CoffeeVan.getCoffees().stream().filter(Coffee::isCanSell).forEach(x -> arrList.add(x.toString()));

        return arrList;
    }
}
