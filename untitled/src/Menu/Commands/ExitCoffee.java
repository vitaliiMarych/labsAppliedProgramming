package Menu.Commands;

import DataBase.DataBase;
import Logs.LoggerCoffeeVan;

import java.sql.SQLException;
import java.util.logging.Level;

public class ExitCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Вийти з програми";
    }

    @Override
    public void execute() throws SQLException {
        DataBase.closeBD();
        LoggerCoffeeVan.getLogger().log(Level.INFO, "Good exit");
        System.exit(0);
    }
}
