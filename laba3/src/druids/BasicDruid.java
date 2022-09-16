package druids;
import colors.TextColors;

public abstract class BasicDruid {
    //vars
    protected String name, type;
    protected int health, damage;
    protected double defense = 1;



    //functs
    public void makeMove(BasicDruid enemy){
        enemy.gotDamage(this.Damage());
    }

    public boolean isDied() {
        return health <= 0;
    }

    public void gotDamage(int damage) {
        System.out.println(TextColors.RED  + "Робот " + type + " " + name + " отрмав урон - " + damage);
        health -= damage;
        if (health > 0)
            System.out.println(TextColors.RED + this.toString() + TextColors.RESET);

        else
            System.out.println(TextColors.RESET + "Робот " + type + " " + name + " помер");

    }

    public int Damage() {
        System.out.println(TextColors.GREEN + "Робот " + type + " " + name + " завдає " + damage + " шкоди" + TextColors.RESET);

        return damage;
    }



    //overload
    @Override
    public String toString() {
        return "Робот " + type + " " + name + " має " + health + " hp ";
    }

}