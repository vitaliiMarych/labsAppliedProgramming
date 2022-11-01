package Menu.Commands;

import DataBase.DataBase;
import SafeScans.SafeScans;

import java.sql.SQLException;

public class DeleteCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Видалити каву";
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("Введіть id, яке потрібно видалити");
        int id = SafeScans.scanInt();

        String query = "DELETE FROM 'Coffees' WHERE id = " + id;
        DataBase.getMainStatm().executeUpdate(query);

    }
}
