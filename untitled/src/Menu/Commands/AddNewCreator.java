package Menu.Commands;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import SafeScans.SafeScans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddNewCreator implements  ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Add new сreator";
    }

    @Override
    public void execute() throws SQLException {
        System.out.println("Введіть тип пристроя(чайник, кавова машина, турка)");
        String type;
        do {
            type = SafeScans.scanLine();
        } while (!type.equals("чайник") && !type.equals("кавова машина") && !type.equals("турка"));

        System.out.println("Введіть чи працює пристрій(y or n): ");
        String buffer;
        do {
            buffer = SafeScans.scanLine().toLowerCase();

        } while (!buffer.equals("n") && !buffer.equals("y"));

        boolean isWorking = true;
        String state = "Все добре";

        if ("n".equals(buffer)) {
            isWorking = false;
            System.out.println("Введіть стан пристроя: ");
            state = SafeScans.scanLine();

        }

        insertCoffee(DataBase.getMainStatm(), type,isWorking, state);
    }

    //inserts
    public static void insertCoffee(Statement statm, String type, boolean isWorking, String state) throws SQLException {


        ResultSet idType = statm.executeQuery(String.format("SELECT id FROM 'typesOfCreator' WHERE type = '%s'", type));

        statm.executeUpdate("INSERT INTO 'Creators'(idType, isWorking, state) VALUES" +
                String.format("('%d','%d','%s')",
                        idType.getInt(1), isWorking ? 1 : 0, state));

        statm.close();
    }
}
