package druids;

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

}
