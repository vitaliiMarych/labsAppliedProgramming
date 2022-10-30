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
        System.out.println("Введіть id кави про яку вам треба дізнатися більше");
        int id = SafeScans.scanInt();
        CoffeeVan.getCoffees().stream().filter(x -> x.getId() == id).forEach(x -> System.out.println(x.toStringAllInfo()));
    }
}
