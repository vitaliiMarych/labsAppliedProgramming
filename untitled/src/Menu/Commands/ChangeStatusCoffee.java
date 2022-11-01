package Menu.Commands;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import SafeScans.SafeScans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeStatusCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Змінити статус кави";
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("Введіть id, яке потрібно змінити");
        int id = SafeScans.scanInt();
        if (CoffeeVan.getCoffees().stream().noneMatch(x -> x.getId() == id)) {
            System.out.println("Такого id не знайдено");
            return;
        }

        ResultSet rslt = DataBase.getMainStatm().executeQuery("SELECT * FROM 'Coffees' WHERE id = " + id + "");

        System.out.println("Введіть чи можна продавати цю каву(next - залишити все як є): ");
        String buffer;
        do {
            buffer = SafeScans.scanLine().toLowerCase();
        } while (!buffer.equals("n") && !buffer.equals("y") && !buffer.equals("next"));

        boolean canSell = true;
        String state = "Можна продавати";

        if ("n".equals(buffer) || "next".equals(buffer)) {
            System.out.println("Введіть новий стан кави(next - залишити все як є): ");
            if ("n".equals(buffer)) {
                canSell = false;
            } else {
                canSell = rslt.getBoolean(3);
            }
            state = SafeScans.scanLine();

            if ("next".equals(state))
                state = rslt.getString(5);
        }

        String query = String.format("UPDATE 'Coffees' " +
                "SET 'canSell' = '%d', " +
                "'state' = '%s' " +
                " WHERE id = %d", canSell ? 1 : 0, state, id);;

        DataBase.getMainStatm().executeUpdate(query);


    }
}
