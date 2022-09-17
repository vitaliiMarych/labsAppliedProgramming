package druids;
import colors.TextColors;

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
        System.out.println(TextColors.RED  + "Друід " + type + " " + name + " отримав урон - " + realDamage);
        health -= realDamage;
        if (health > 0)
            System.out.println(TextColors.RED + this.toString() + TextColors.RESET);

        else
            System.out.println(TextColors.RESET + "Друід " + type + " " + name + " помер");

    }

    public int Damage(double baff) {
        int damage = (int) (baff * this.damage);
        System.out.println(TextColors.GREEN + "Друід " + type + " " + name + " завдав " + damage + " шкоди" + TextColors.RESET);

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

}