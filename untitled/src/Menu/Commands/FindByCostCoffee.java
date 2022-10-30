package Menu.Commands;

import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;
import SafeScans.SafeScans;

import java.util.stream.Stream;

public class FindByCostCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Найти каву за діапазоном ціни";
    }

    @Override
    public void execute() {
        System.out.println("Введіть максимальну суму: ");
        int max = SafeScans.scanInt();
        System.out.println("Введіть мінімальну суму: ");
        int min = SafeScans.scanInt(max);


        Stream<Coffee> stream = CoffeeVan.getCoffees().stream().filter(x -> x.getCost() < max && x.getCost() > min);

        if (!stream.findAny().isPresent())
            System.out.println("Нічого не найдено...");
        else
            CoffeeVan.getCoffees().stream().filter(x -> x.getCost() < max && x.getCost() > min).forEach(x -> System.out.println(x.toString()));

    }
}
