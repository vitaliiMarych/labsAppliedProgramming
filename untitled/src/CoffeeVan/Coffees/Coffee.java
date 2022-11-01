package CoffeeVan.Coffees;

import CoffeeVan.CoffeeCreators.CoffeeCreator;

import java.util.ArrayList;

public class Coffee implements Comparable<Coffee>{
    protected int id;
    protected String name = "назву не придумали, можливо каву назвуть у вашу честь";
    protected boolean canSell;
    protected String type;
    protected String state; //стан кави
    protected int countOfSell = 0;
    protected int cost;
    protected double volume;
    protected String recomendAdditive;
    protected String creatortype;

    public Coffee(int id, String name, boolean canSell, String type, String state, int countOfSell, int cost, double volume, String recomendAdditive, String creatortype) {
        this.id = id;
        this.name = name;
        this.canSell = canSell;
        this.type = type;
        this.state = state;
        this.countOfSell = countOfSell;
        this.cost = cost;
        this.volume = volume;
        this.recomendAdditive = recomendAdditive;
        this.creatortype = creatortype;
    }

    @Override
    public String toString() {
        return id + ") " + "Кава " + type + " - " + name + ", ціна - " + cost;
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

    //other funct
    public String toStringAllInfo() {
        return  "Кава " + type + " - " + name + "\n" +
                "Стан кави - " + state + "\n" +
                "Ціна - " + cost + "\n" +
                "Кількість продаж - " + countOfSell + "\n" +
                "Об'єм - " + volume + "\n" +
                "Рекомендована добавка - " + recomendAdditive + "\n" +
                "Засіб для приготування - " + creatortype + "\n";
    }

    //geters and seters

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

