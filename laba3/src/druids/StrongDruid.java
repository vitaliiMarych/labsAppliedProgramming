package druids;

import colors.TextColors;

/** Сильний друїд, хоча моє досить малий запас здоров'я, зато махає мечем покраще Дартаньяна або Гатса
 * Вдобавок у сильного друїда є берсекрмод який збільшує урон
 * */
public class StrongDruid extends BasicDruid{

    private double bersercMode = 1.3;

    public StrongDruid(String name) {
        this.type = "berserc";
        this.health = 200;
        this.damage = 65;
        this.name = name;
    }

    public void makeMove(BasicDruid enemy){
        if (health <= 70)
            enemy.gotDamage((this.Damage(bersercMode)));
        else
            enemy.gotDamage(this.Damage());
    }

    @Override
    public void wasHilled(double koef) {
        System.out.println(TextColors.BLUE + "Друід " + type + " " + name + " вилікувався на " + (int) (koef * 200) + " hp");
        health += (int) (koef * 200);
    }

}