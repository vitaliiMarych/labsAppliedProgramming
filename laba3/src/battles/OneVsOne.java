package battles;

import druids.BasicDruid;
import druids.WizardDruid;

import java.util.stream.IntStream;

/** Дуель між двома друїдами */
public class OneVsOne {

    private BasicDruid robWhite, robBlack;

    public OneVsOne(BasicDruid r1, BasicDruid r2){
        robWhite = r1;
        robBlack = r2;
    }

    public void battle(){
        move(robWhite, robBlack);
        if (anybodyWon()) return;
        System.out.println();

        move(robBlack, robWhite);
        if (anybodyWon()) return;
        System.out.println();

        battle();
    }

    private void move(BasicDruid rob, BasicDruid enemy){
        if (rob.getClass() == WizardDruid.class)
            IntStream.range(0,2).forEach(i -> rob.makeMove(enemy));
        else
            rob.makeMove(enemy);
    }



    private boolean anybodyWon(){
        if (robWhite.isDied() || robBlack.isDied()){
            boolean whiteWinner = robBlack.isDied();
            System.out.println((whiteWinner ? (robWhite.toString()+ " (Біла ") : (robBlack.toString() + " (Чорна ")) +
                    "команда) - перемога");
            return true;
        }
        return false;
    }

}