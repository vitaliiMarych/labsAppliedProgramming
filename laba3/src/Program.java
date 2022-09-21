import druids.*;
import battles.*;
import fileWork.FileScan;

/** основний клас програми */
public class Program {
    public static void main(String[] args) {
        String path = "file.txt";

        BasicDruid Wrob1 = new TankDruid("arsen1");
        BasicDruid Wrob2 = new TankDruid("arsen2");
        BasicDruid Wrob3 = new TankDruid("arsen3");
        BasicDruid[] teamWhite = new BasicDruid[] {Wrob1, Wrob2, Wrob3};

        BasicDruid Brob1 = new TankDruid("sanya1");
        BasicDruid Brob2 = new HillerDruid("sanya2");
        BasicDruid Brob3 = new WizardDruid("sanya3");
        BasicDruid[] teamBlack = new BasicDruid[] {Brob1, Brob2, Brob3};

        TeamVsTeam batl1 = new TeamVsTeam(teamWhite, teamBlack, path);

//        BasicDruid Wrob = new StrongDruid("fesf");
//        BasicDruid Brob = new WizardDruid("fgdfg");
//
//        OneVsOne batl1 = new OneVsOne(Wrob, Brob);


        batl1.battle();
        FileScan.create(path);
        FileScan.printAll();
        FileScan.close();
    }
}
