import druids.*;
import battles.*;

/** основний клас програми */
public class Program {
    public static void main(String[] args) {
        BasicDruid Wrob1 = new TankDruid("vitalik1");
        BasicDruid Wrob2 = new StrongDruid("vitalik2");
        BasicDruid Wrob3 = new StrongDruid("vitalik3");
        BasicDruid[] teamWhite = new BasicDruid[] {Wrob1, Wrob2, Wrob3};

        BasicDruid Brob1 = new TankDruid("canya1");
        BasicDruid Brob2 = new HillerDruid("canya2");
        BasicDruid Brob3 = new HillerDruid("canya3");
        BasicDruid[] teamBlack = new BasicDruid[] {Brob1, Brob2, Brob3};

        TeamVsTeam batl1 = new TeamVsTeam(teamWhite, teamBlack);

        batl1.battle();

    }
}
