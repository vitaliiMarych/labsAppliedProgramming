package druids;

import colors.TextColors;

/** Чародій може кидати вогняні кулі у 2 суперників з найменшим здоров'ям
 * Це єдиний друід який може атакувати зразу дві цілі якщо у нього достатньо мани
 * Якщо мани недостатньо, то він пропускає один з ходів, щоб її накопити
 * */
public class WizardDruid extends BasicDruid{

    int mana = 200;
    public WizardDruid(String name){
        this.type = "wizard";
        this.health = 225;
        this.damage = 32;
        this.name = name;
        this.defense = 1.05;
    }

    @Override
    public void makeMove(BasicDruid enemy) {
        if (mana > 35) {
            System.out.println(TextColors.YELLOW + "Друід " + type + " " + name + " говорить заклинання вогняної кулі" + TextColors.RESET);
            enemy.gotDamage(this.Damage());
            mana -= 35;
        }
        else
            restoringMana();
    }

    private void restoringMana(){
        mana += 90;
        System.out.println(TextColors.PURPLE + "Друід " + type + " " + name + " відновив 90 мани, тепер його мана = " + mana + TextColors.RESET);
    }



}
