package Menu.Commands;

import java.io.IOException;
import java.sql.SQLException;

public interface ICommand {
    public String getInfoAboutCommand();
    public void execute() throws SQLException, IOException;
}
