package Menu.Commands;

import CoffeeVan.CoffeeVan;

public class ShowAllCoffeeCreators implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Показати всі пристрої для кави";
    }

    @Override
    public void execute() {
        if (CoffeeVan.getCreators().isEmpty())
            System.out.println("Пристроїв для кави нема...");

        else
            CoffeeVan.getCreators().forEach(System.out::println);
    }
}
