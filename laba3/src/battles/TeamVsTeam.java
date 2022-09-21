package battles;
import colors.TextColors;
import druids.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** Бій команда на команду */
public class TeamVsTeam {

    BasicDruid[] whiteTeam;
    BasicDruid[] blackTeam;
    private int roundN = 1;

    public TeamVsTeam(BasicDruid[] white, BasicDruid[] black) {
        whiteTeam = white;
        blackTeam = black;

    }

    public void battle(){
        System.out.println("------------------------------------------------\nБіла команда атакує\n");
        if (move(whiteTeam, blackTeam)) return;
        System.out.println("Інформація про чорну команду:");
        Arrays.stream(blackTeam).forEach(x -> System.out.println(x.toString()));

        System.out.println("------------------------------------------------\nЧорна команда атакує\n");
        if (move(blackTeam, whiteTeam)) return;
        System.out.println("Інформація про білу команду:");
        Arrays.stream(whiteTeam).forEach(x -> System.out.println(x.toString()));
        System.out.println("------------------------------------------------\n" + TextColors.BLUE +
                (roundN++) + " раунд закінчився. Інформація про команди:" + TextColors.RESET);
        printInfoTeams();

        battle();
    }

    private boolean move(BasicDruid[] alldruids, BasicDruid[] enemy) {
        BasicDruid[] druidsAlive = Arrays.stream(alldruids).filter(x -> !x.isDied()).toArray(BasicDruid[] :: new);

        for (BasicDruid dr : druidsAlive) {
            if (dr.getClass() == WizardDruid.class) {
                if (Arrays.stream(enemy).filter(x -> !x.isDied()).count() == 1) {
                    BasicDruid e = Arrays.stream(enemy).filter(x -> !x.isDied()).findFirst().get();
                    IntStream.range(0, 2).forEach(x -> dr.makeMove(e));
                }
                else {
                    Comparator<BasicDruid> cp = Comparator.comparing(x -> x.getHealth());
                    Arrays.stream(enemy).filter(x -> !x.isDied()).sorted(cp).limit(2).forEach(x -> dr.makeMove(x));
                }

            } else {
                if (dr.getClass() == HillerDruid.class)
                    Arrays.stream(druidsAlive).filter(x -> !x.isDied()).forEach(x -> x.wasHilled(((HillerDruid) dr).getHillKoef()));

                Arrays.stream(enemy).filter(x -> !x.isDied()).limit(1).forEach(x -> dr.makeMove(x));
            }
            System.out.println();
            if (anybodyWon()) return true;
        }
        return false;
    }

    private boolean anybodyWon(){
        boolean whiteWin = Arrays.stream(whiteTeam).anyMatch(x->!x.isDied());
        boolean blackWin = Arrays.stream(blackTeam).anyMatch(x->!x.isDied());

        if (!whiteWin || !blackWin){
            if (whiteWin)
                System.out.println(TextColors.CYAN +"Біла команда перемогла");
            else
                System.out.println(TextColors.CYAN + "Чорна команда перемогла");

            printInfoTeams();
            return true;
        }
        return false;
    }

    private void printInfoTeams(){
        System.out.println("Біла команда:");
        for (BasicDruid dr : whiteTeam){
            if (dr.isDied())
                System.out.println("Друід " + dr.getType() + " " + dr.getName() + " мертвий");
            else
                System.out.println(dr.toString());
        }

        System.out.println("\nЧорна команда:");
        for (BasicDruid dr : blackTeam){
            if (dr.isDied())
                System.out.println("Друід " + dr.getType() + " " + dr.getName() + " мертвий");
            else
                System.out.println(dr.toString());
        }
    }

}
