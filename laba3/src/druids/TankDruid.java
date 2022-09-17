package druids;

import colors.TextColors;

/** Танк буде мати багато здоров'я і ще в добавок до цього щит який дасть йому захист, але урону мало завдавати
 * Якщо це командний бій, то танк агрить своїх противників
 * */
public class TankDruid extends BasicDruid{

    public TankDruid(String name){
        this.type = "tank";
        this.health = 350;
        this.damage = 30;
        this.name = name;
        this.defense = 1.25;
    }

    @Override
    public void wasHilled(double koef) {
        System.out.println(TextColors.BLUE + "Друід " + type + " " + name + " вилікувався на " + (int) (koef * 200) + " hp");
        health += (int) (koef * 350);
    }


}
