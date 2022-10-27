package CoffeeVan.Coffees;

import CoffeeVan.CoffeeCreators.CoffeeCreator;

import java.util.ArrayList;

abstract public class Coffee implements Comparable<Coffee>{
    private static  int autoId = 1;
    protected int id;
    protected String name = "назву не придумали, можливо каву назвуть у вашу честь";
    protected boolean canSell;
    protected String type;
    protected String state; //стан кави
    protected int countOfSell = 0;
    protected int cost;
    protected double volume;
    protected String recomendAdditive;
    protected CoffeeCreator creator;

    @Override
    public String toString() {
        return "Кава " + type + " - " + name;
    }

    @Override
    public int compareTo(Coffee o) {
        if (this.getCost() == o.getCost()) {
            if (this.getVolume() - o.getVolume() < 0.00001)
                return 0;
            else if (this.getVolume() > o.getVolume())
                return 1;
            else
                return -1;
        }
        return this.getCost() - o.getCost();
    }

    public String toStringAllInfo() {
        return  "Кава " + type + " - " + name + "\n" +
                "Стан кави - " + state + "\n" +
                "Ціна - " + cost + "\n" +
                "Кількість продаж - " + countOfSell + "\n" +
                "Об'єм - " + volume + "\n" +
                "Рекомендована добавка - " + recomendAdditive + "\n" +
                "Засіб для приготування - " + creator.getType() + "\n";
    }

    public static int getNextId(){
        return autoId++;
    }

    public int getId() {
        return id;
    }

    public boolean isCanSell() {
        return canSell;
    }

    public int getCost() {
        return cost;
    }

    public double getVolume() {
        return volume;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}


// кава буде відрізнятися за розрахунком ваги, хтось з банкою, хтось нє
//•	Назва
//        •	Фізичний стан
//        •	Кількість покупок
//        •	Ціна
//        •	Назва
//        •	Об’єм кави з упаковкою
//        •	Добавки у каву
//        •	Чи потрібний кавовий апарат
