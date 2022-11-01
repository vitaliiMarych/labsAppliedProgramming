package Menu.Commands;


import CoffeeVan.CoffeeVan;

import java.util.Collection;
import java.util.Collections;

public class SortCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Посортувати каву";
    }

    @Override
    public void execute() {
        Collections.sort(CoffeeVan.getCoffees());
        (new ShowAllCoffee()).execute();
    }
}
