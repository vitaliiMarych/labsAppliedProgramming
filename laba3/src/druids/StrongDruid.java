package druids;

public class StrongDruid extends BasicDruid{

    private double bersercMode = 1.25;

    public StrongDruid(String name) {
        this.type = "атакуючий";
        this.health = 200;
        this.damage = 70;
        this.name = name;
    }

    public void makeMove(BasicDruid enemy){
        if (health < 70)
            enemy.gotDamage((int) (this.Damage() * bersercMode));
        else
            enemy.gotDamage(this.Damage());
    }

}