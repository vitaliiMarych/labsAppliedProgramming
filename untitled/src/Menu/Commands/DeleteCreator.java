package Menu.Commands;

import DataBase.DataBase;
import SafeScans.SafeScans;

import java.sql.SQLException;

public class DeleteCreator implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Delete creator";
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("Введіть id, яке потрібно видалити");
        int id = SafeScans.scanInt();

        String query = "DELETE FROM 'Creators' WHERE id = " + id;
        DataBase.getMainStatm().executeUpdate(query);
    }
}
