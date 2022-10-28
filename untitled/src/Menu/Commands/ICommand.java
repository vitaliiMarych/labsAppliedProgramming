package Menu.Commands;

import java.sql.SQLException;

public interface ICommand {
    public String getInfoAboutCommand();
    public void execute() throws SQLException;
}
