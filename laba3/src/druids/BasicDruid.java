package druids;
import colors.TextColors;
import fileWork.FilePrint;

/** Абстрактний клас друідів з якого всі походять */
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
        int realDamage = (int) (damage / defense);
        FilePrint.print(TextColors.RED  + "Друід " + type + " " + name + " отримав урон - " + realDamage);
        health -= realDamage;
        if (health > 0)
            FilePrint.print(TextColors.RED + this.toString() + TextColors.RESET);

        else
            FilePrint.print(TextColors.RESET + "Друід " + type + " " + name + " помер");

    }

    public int Damage(double baff) {
        int damage = (int) (baff * this.damage);
        FilePrint.print(TextColors.GREEN + "Друід " + type + " " + name + " завдав " + damage + " шкоди" + TextColors.RESET);

        return damage;
    }

    public int Damage() {
        return Damage(1);
    }

    public abstract void wasHilled(double koef);

    //overload
    @Override
    public String toString() {
        return "Друід " + type + " " + name + " має " + health + " hp ";
    }

    //geters
    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}