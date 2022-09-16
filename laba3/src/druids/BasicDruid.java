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
        System.out.println(TextColors.RED  + "����� " + type + " " + name + " ������ ���� - " + damage);
        health -= damage;
        if (health > 0)
            System.out.println(TextColors.RED + this.toString() + TextColors.RESET);

        else
            System.out.println(TextColors.RESET + "����� " + type + " " + name + " �����");

    }

    public int Damage() {
        System.out.println(TextColors.GREEN + "����� " + type + " " + name + " ����� " + damage + " �����" + TextColors.RESET);

        return damage;
    }



    //overload
    @Override
    public String toString() {
        return "����� " + type + " " + name + " �� " + health + " hp ";
    }

}