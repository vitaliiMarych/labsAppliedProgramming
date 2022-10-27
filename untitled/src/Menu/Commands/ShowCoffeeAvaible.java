package Menu.Commands;

import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;

public class ShowCoffeeAvaible implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Показати весь доступний асортимент кави";
    }

    @Override
    public void execute() {
        if (CoffeeVan.getCoffees().stream().noneMatch(Coffee::isCanSell))
            System.out.println("Доступної кави нема...");

        else
            CoffeeVan.getCoffees().stream().filter(Coffee::isCanSell).forEach(x -> System.out.println(x.toString()));
    }
}
