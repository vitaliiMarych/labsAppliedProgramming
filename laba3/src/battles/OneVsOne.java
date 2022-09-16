package battles;

import druids.BasicDroid;

public class OneVsOne {

    private BasicDroid robWhite, robBlack;

    public OneVsOne(BasicDroid r1, BasicDroid r2){
        robWhite = r1;
        robBlack = r2;
    }

    public void battle(){
        robWhite.makeMove(robBlack);
        if (anybodyWon()) return;

        robBlack.makeMove(robWhite);
        if (anybodyWon()) return;

        battle();
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