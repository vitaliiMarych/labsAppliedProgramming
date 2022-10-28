package CoffeeVan.CoffeeCreators;

public class CoffeeCreator {
    private boolean isWorking;  //чи працює
    private String state; //стан роботи
    private String type;

    public boolean isWorking() {
        return isWorking;
    }

    public CoffeeCreator(boolean isWorking, String state, String type) {
        this.isWorking = isWorking;
        this.state = state;
        this.type = type;
    }

    public void setWorking(boolean working) {
        if (working)
            setWorking(working, "Все добре");
        else
            setWorking(working, "Причину не відомо");
    }


    public void setWorking(boolean working, String state) {
        isWorking = working;
        this.state = state;
    }

    public String getType() {
        return type;
    }


    //coffeeMug, coffeeMachine, Kettle
}
