package druids;

import colors.TextColors;
import fileWork.FilePrint;

/** Хіллер лікує себе і своїх союзників
 * Хіллер це єдиний друїд який робить два ходи, лікує свою команду а потім п'є палкою по голові суперника
 * */
public class HillerDruid extends BasicDruid{

    double hillKoef = 0.055;
    public HillerDruid(String name){
        this.type = "hiller";
        this.health = 200;
        this.damage = 30;
        this.name = name;
        this.defense = 1.05;
    }

    @Override
    public void wasHilled(double koef) {
        FilePrint.print(TextColors.BLUE + "Друід " + type + " " + name + " вилікувався на " + (int) (koef * 200) + " hp" + TextColors.RESET);
        health += (int) (koef * 200);
    }

    public double getHillKoef() {
        return hillKoef;
    }
}
