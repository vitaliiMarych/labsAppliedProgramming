package Menu.Commands;

import CoffeeVan.CoffeeVan;
import SafeScans.SafeScans;

public class FindByNameCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Найти каву за частинкою назви або цілою назвою";
    }

    @Override
    public void execute() {

        String partOfName = SafeScans.scanLine();


        if (CoffeeVan.getCoffees().stream().noneMatch(x -> x.getName().toLowerCase().contains(partOfName.toLowerCase())))
            System.out.println("Нічого не найдено...");

        else
            CoffeeVan.getCoffees().stream().filter(
                    x -> x.getName().toLowerCase().contains(partOfName.toLowerCase())
            ).forEach(System.out::println);




    }



}
