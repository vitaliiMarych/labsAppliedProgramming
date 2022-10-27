package Menu.Commands;

import CoffeeVan.CoffeeVan;

public class ShowAllCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Показати весь асортимент кави";
    }

    @Override
    public void execute() {
        if (CoffeeVan.getCoffees().isEmpty())
            System.out.println("Кавовий фургончик пустий...");

        else
            CoffeeVan.getCoffees().forEach(System.out::println);
    }
}
