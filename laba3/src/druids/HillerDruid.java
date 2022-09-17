package druids;

import colors.TextColors;

/** Хіллер лікує себе і своїх союзників
 * Хіллер це єдиний друїд який робить два ходи, лікує свою команду а потім п'є палкою по голові суперника
 * */
public class HillerDruid extends BasicDruid{

    double hillKoef = 0.08;
    public HillerDruid(String name){
        this.type = "hiller";
        this.health = 200;
        this.damage = 35;
        this.name = name;
        this.defense = 1.05;
    }

    @Override
    public void wasHilled(double koef) {
        System.out.println(TextColors.BLUE + "Друід " + type + " " + name + " вилікувався на " + (int) (koef * 200) + " hp");
        health += (int) (koef * 200);
    }

    public double getHillKoef() {
        return hillKoef;
    }
}
