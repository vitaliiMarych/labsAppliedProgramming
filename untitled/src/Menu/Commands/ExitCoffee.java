package Menu.Commands;

public class ExitCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Вийти з програми";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
