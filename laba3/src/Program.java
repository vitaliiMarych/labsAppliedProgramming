import druids.*;
import battles.*;

/** основний клас програми */
public class Program {
    public static void main(String[] args) {
        BasicDruid rob1 = new HillerDruid("vitalik");
        BasicDruid rob2 = new WizardDruid("canya");

        OneVsOne batl1 = new OneVsOne(rob1, rob2);

        batl1.battle();

    }
}
