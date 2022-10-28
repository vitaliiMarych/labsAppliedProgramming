package Menu.Commands;

import CoffeeVan.CoffeeVan;

public class AddNewCoffee implements ICommand{

    @Override
    public String getInfoAboutCommand() {
        return "Добавити нову каву";
    }

    @Override
    public void execute() {
        //CoffeeVan.getCoffees().add(new GrainCoffee());
    }
}
