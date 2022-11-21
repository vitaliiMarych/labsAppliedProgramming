package Menu.Commands;


import CoffeeVan.CoffeeVan;
import GUI.PrintWindow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortCoffee implements ICommand{
    @Override
    public String getInfoAboutCommand() {
        return "Посортувати каву";
    }

    @Override
    public void execute() throws IOException {
        ArrayList<String> arrList = getSortArr();
        PrintWindow.newWindow(arrList, "Sort coffee");
    }

    public static ArrayList<String> getSortArr(){
        Collections.sort(CoffeeVan.getCoffees());
        ArrayList<String> arrList = new ArrayList<>();
        CoffeeVan.getCoffees().forEach(x -> arrList.add(x.toString()));
        return arrList;
    }
}
