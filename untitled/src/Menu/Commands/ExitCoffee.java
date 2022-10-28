package Menu.Commands;

import DataBase.DataBase;

import java.sql.SQLException;

public class ExitCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Вийти з програми";
    }

    @Override
    public void execute() throws SQLException {
        DataBase.closeBD();
        System.exit(0);
    }
}
