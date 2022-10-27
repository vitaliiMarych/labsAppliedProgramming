package Menu.Commands;

import CoffeeVan.CoffeeVan;
import CoffeeVan.Coffees.Coffee;
import SafeScans.SafeScans;

public class GetInfoCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Дізнатися інформацію про каву";
    }

    @Override
    public void execute() {
        int id = SafeScans.scanInt(CoffeeVan.getCoffees().size());
        CoffeeVan.getCoffees().stream().filter(x -> x.getId() == id).forEach(Coffee::toStringAllInfo);
    }
}
