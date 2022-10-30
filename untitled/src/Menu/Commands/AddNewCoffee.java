package Menu.Commands;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import SafeScans.SafeScans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddNewCoffee implements ICommand{

    @Override
    public String getInfoAboutCommand() {
        return "Добавити нову каву";
    }

    @Override
    public void execute() throws SQLException {

        System.out.println("Введіть назву кави: ");
        String name = SafeScans.scanLine();

        System.out.println("Введіть тип кави(мелена, розчинна, зернова)");
        String type;
        do {
            type = SafeScans.scanLine();
        } while (!type.equals("мелена") && !type.equals("розчинна") && !type.equals("зернова"));

        System.out.println("Введіть ціну кави");
        int cost = SafeScans.scanInt();

        System.out.println("Введіть весь об'єм кави, що маєте");
        double volume = SafeScans.scanDouble(CoffeeVan.getMaxVolume() - CoffeeVan.getCurrentVolume());

        System.out.println("Введіть смачну добавку у цю каву");
        String recommned = SafeScans.scanLine();

        insertCoffee(DataBase.getMainStatm(), name, type, cost, volume, recommned);
    }

    //inserts
    public static void insertCoffee(Statement statm, String NAME, String TYPE,
                                    int COST, double VOLUME, String RECOMMEND) throws SQLException {

        boolean canSell = false;
        String state = "Нема на складі";

        if (VOLUME > 0) {
            canSell = true;
            state = "Можна продавати";
        }

        ResultSet idType = statm.executeQuery(String.format("SELECT id FROM 'typesOfCoffee' WHERE type = '%s'", TYPE));

        statm.execute("INSERT INTO 'Coffees'(name, canSell, idType, state, cost, volume, recommendAdd) VALUES" +
                String.format("('%s','%b','%d','%s','%d','%f','%s')",
                        NAME, canSell, idType.getInt(1), state, COST, VOLUME, RECOMMEND));

    }
}
