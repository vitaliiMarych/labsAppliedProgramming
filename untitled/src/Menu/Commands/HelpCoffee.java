package Menu.Commands;

import java.util.Hashtable;

public class HelpCoffee implements ICommand{
    private Hashtable<String, ICommand> mn;

    public HelpCoffee(Hashtable<String, ICommand> mn){
        this.mn = mn;
    }

    @Override
    public String getInfoAboutCommand() {
        return "Показати всі можливі команди";
    }

    @Override
    public void execute() {
        for (String command : mn.keySet())
            System.out.printf("%25s - %s\n", command, mn.get(command).getInfoAboutCommand());
    }
}
