package Menu.Commands;

import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;
import SafeScans.SafeScans;

import java.util.stream.Stream;

public class FindByTypeCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Найти каву за типом";
    }

    @Override
    public void execute() {
        System.out.println("Введіть тип: ");
        Stream<Coffee> stream = CoffeeVan.getCoffees().stream().filter(x -> x.getType().equals(SafeScans.scanLine()));

        if (!stream.findAny().isPresent())
            System.out.println("Нічого не найдено...");
        else
            CoffeeVan.getCoffees().stream().filter(x -> x.getType().equals(SafeScans.scanLine())).forEach(x -> System.out.println(x.toString()));
    }
}
