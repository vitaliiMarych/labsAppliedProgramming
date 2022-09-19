package battles;

import druids.BasicDruid;
import druids.HillerDruid;
import druids.WizardDruid;

import java.util.stream.IntStream;

/** Дуель між двома друїдами */
public class OneVsOne {

    private BasicDruid drWhite, drBlack;

    public OneVsOne(BasicDruid r1, BasicDruid r2){
        drWhite = r1;
        drBlack = r2;
    }

    public void battle(){
        move(drWhite, drBlack);
        if (anybodyWon()) return;
        System.out.println();

        move(drBlack, drWhite);
        if (anybodyWon()) return;
        System.out.println();

        battle();
    }

    private void move(BasicDruid dr, BasicDruid enemy){
        if (dr.getClass() == WizardDruid.class)
            IntStream.range(0,2).forEach(i -> dr.makeMove(enemy));

        else {
            if (dr.getClass() == HillerDruid.class)
                dr.wasHilled(((HillerDruid) dr).getHillKoef());
            dr.makeMove(enemy);
        }
    }



    private boolean anybodyWon(){
        if (drWhite.isDied() || drBlack.isDied()){
            boolean whiteWinner = drBlack.isDied();
            System.out.println((whiteWinner ? (drWhite.toString()+ " (Біла ") : (drBlack.toString() + " (Чорна ")) +
                    "команда) - перемога");
            return true;
        }
        return false;
    }

}