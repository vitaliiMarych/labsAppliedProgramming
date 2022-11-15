package Menu.Commands;

import CoffeeVan.CoffeeVan;
import GUI.PrintWindow;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Показати весь асортимент кави";
    }

    @Override
    public void execute() throws IOException {

        ArrayList<String> arrList = new ArrayList<>();
        CoffeeVan.getCoffees().forEach(x -> arrList.add(x.toString()));

        PrintWindow.newWindow(arrList, "Show coffee");

    }
}
