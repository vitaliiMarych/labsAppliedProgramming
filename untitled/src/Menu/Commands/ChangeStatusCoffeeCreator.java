package Menu.Commands;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import SafeScans.SafeScans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeStatusCoffeeCreator implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Змінити статус пристрія для кави";
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("Введіть id, яке потрібно змінити");
        int id = SafeScans.scanInt();
        if (CoffeeVan.getCoffees().stream().noneMatch(x -> x.getId() == id)) {
            System.out.println("Такого id не знайдено");
            return;
        }

        ResultSet rslt = DataBase.getMainStatm().executeQuery("SELECT * FROM 'Creators' WHERE id = " + id + "");

        System.out.println("Введіть чи працює цей пристрій(y or n)(next - залишити все як є): ");
        String buffer;
        do {
            buffer = SafeScans.scanLine().toLowerCase();
        } while (!buffer.equals("n") && !buffer.equals("y") && !buffer.equals("next"));

        boolean isWorking = true;
        String state = "Все добре";

        if ("n".equals(buffer) || "next".equals(buffer)) {
            System.out.println("Введіть новий стан пристроя(next - залишити все як є): ");
            if ("n".equals(buffer)) {
                isWorking = false;
            } else {
                isWorking = rslt.getBoolean(3);
            }
            state = SafeScans.scanLine();

            if ("next".equals(state))
                state = rslt.getString(5);
        }

        String query = String.format("UPDATE 'Creators' " +
                "SET 'canSell' = '%d', " +
                "'state' = '%s' " +
                " WHERE id = %d", isWorking ? 1 : 0, state, id);;

        DataBase.getMainStatm().executeUpdate(query);
    }
}
