package Menu.Commands;

import CoffeeVan.CoffeeVan;

import java.sql.SQLException;

public class GetInfoCoffeeVan implements ICommand{

    @Override
    public String getInfoAboutCommand() {
        return "Дізнатися інформацію про фургон";
    }

    @Override
    public void execute() throws SQLException {
        System.out.println(CoffeeVan.toStringe());
    }
}
