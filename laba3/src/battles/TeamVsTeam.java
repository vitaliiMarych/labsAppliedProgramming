package battles;
import druids.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** Бій команда на команду */
public class TeamVsTeam {

    BasicDruid[] whiteTeam;
    BasicDruid[] blackTeam;

    public TeamVsTeam(BasicDruid[] white, BasicDruid[] black) {
        whiteTeam = white;
        blackTeam = black;

    }

    public void battle(){
        move(whiteTeam, blackTeam);
        if (anybodyWon()) return;
        Arrays.stream(blackTeam).forEach(x -> System.out.println(x.toString()));
        System.out.println("\n\n");

        move(blackTeam, whiteTeam);
        if (anybodyWon()) return;
        Arrays.stream(whiteTeam).forEach(x -> System.out.println(x.toString()));
        System.out.println("\n\n");

        battle();
    }

    private void move(BasicDruid[] druids, BasicDruid[] enemy) {
        for (BasicDruid dr : druids) {
            Stream<BasicDruid> stream = Arrays.stream(enemy).filter(x -> !x.isDied());
            if (dr.getClass() == WizardDruid.class) {
                Comparator<BasicDruid> cp = Comparator.comparing(x -> x.getHealth());
                stream.sorted(cp).limit(2).forEach(x -> dr.makeMove(x));
            } else {
                if (dr.getClass() == HillerDruid.class)
                    Arrays.stream(druids).filter(x -> !x.isDied()).forEach(x -> x.wasHilled(((HillerDruid) dr).getHillKoef()));
                stream.limit(1).forEach(x -> dr.makeMove(x));
            }
            System.out.println();
        }
    }

    private boolean anybodyWon(){
        boolean whiteWin = Arrays.stream(whiteTeam).anyMatch(x->!x.isDied());
        boolean blackWin = Arrays.stream(blackTeam).anyMatch(x->!x.isDied());

        if (!whiteWin || !blackWin){
            if (whiteWin) {
                System.out.println("Біла команда перемогла");
                Arrays.stream(whiteTeam).forEach(x -> System.out.println(x.toString()));
            }
            else {
                System.out.println("Чорна команда перемогла");
                Arrays.stream(blackTeam).forEach(x -> System.out.println(x.toString()));
            }
            return true;
        }
        return false;
    }

}
