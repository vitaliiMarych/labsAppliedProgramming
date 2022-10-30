package Menu.Commands;

import CoffeeVan.CoffeeVan;
import DataBase.DataBase;
import MainPackage.Program;
import SafeScans.SafeScans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeInfoCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Змінити інформацію про каву";
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

        System.out.println("Введіть нову назву кави(next - залишити все як є): ");
        String name = SafeScans.scanLine();
        if (name.equals("next"))
            name = rslt.getString(2);

        System.out.println("Введіть новий тип кави(мелена, розчинна, зернова)(next - залишити все як є)");
        String type;
        do {
            type = SafeScans.scanLine();
        } while (!type.equals("мелена") && !type.equals("розчинна") && !type.equals("зернова") && !type.equals("next"));

        int typeId;
        if (type.equals("зернова"))
            typeId = 1;
        else if (type.equals("мелена"))
            typeId = 2;
        else if (type.equals("розчинна"))
            typeId = 3;
        else
            typeId = rslt.getInt(4);


        String buffer;
        System.out.println("Введіть кількість продаж кави(0 - залишити все як є)");
        int count;
        while (true) {
            try {
                buffer = SafeScans.scanLine();
                if (buffer.equals("next"))
                    count = rslt.getInt(7);
                else {
                    count = Integer.parseInt(buffer);
                }
                break;
            }
            catch (Exception e) {}

            System.out.println("Некоректно введено! Попробуйте ще раз: ");
        }

        System.out.println("Введіть нову ціну кави(0 - залишити все як є)");

        int cost;
        while (true) {
            try {
                buffer = SafeScans.scanLine();
                if (buffer.equals("next"))
                    cost = rslt.getInt(7);
                else {
                    cost = Integer.parseInt(buffer);
                }
                break;
            }
            catch (Exception e) {}

            System.out.println("Некоректно введено! Попробуйте ще раз: ");
        }

        System.out.println("Введіть новий об'єм кави, що маєте(next - залишити все як є)");
        double volume;
        while (true) {
            try {
                buffer = SafeScans.scanLine();
                if (buffer.equals("next"))
                    volume = (Double) rslt.getDouble(8);
                else {
                    volume = (Double) Program.df.parse(buffer);
                }
                break;
            }
            catch (Exception e) {}

            System.out.println("Некоректно введено! Попробуйте ще раз: ");
        }

        System.out.println("Введіть нову смачну добавку у цю каву");
        String recommned = SafeScans.scanLine();
        //rslt.close();

        String query = String.format("UPDATE 'Coffees' " +
                "SET 'name' = '%s', " +
                "'idType' = %d, " +
                "'countOfSell' = %d, " +
                "'cost' = %d, " +
                "'volume' = " + volume +
                ", 'recommendAdd' = '%s'" +
                " WHERE id = %d", name, typeId, count, cost, recommned, id);

        DataBase.getSecondStatm().executeQuery(query);
    }


}
