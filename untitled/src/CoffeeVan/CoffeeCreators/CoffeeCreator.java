package CoffeeVan.CoffeeCreators;

import CoffeeVan.Coffees.Coffee;

public class CoffeeCreator {
    private int id;
    private boolean Working;  //чи працює
    private String state; //стан роботи
    private String type;

    public boolean isWorking() {
        return Working;
    }

    public CoffeeCreator(int id, boolean isWorking, String state, String type) {
        this.id = id;
        this.Working = isWorking;
        this.state = state;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("%d) %s, працює - %b, стан - %s", id, type, Working, state);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CoffeeCreator))
            return false;

        CoffeeCreator cr = (CoffeeCreator) obj;
        return this.type.equals(cr.type) && this.Working == cr.Working;
    }
    //coffeeMug, coffeeMachine, Kettle
}
