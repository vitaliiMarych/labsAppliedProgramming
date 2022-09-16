import druids.*;
import battles.*;

public class Program {
    public static void main(String[] args) {
        BasicDruid rob1 = new StrongDruid("vitalik");
        BasicDruid rob2 = new StrongDruid("canya");

        OneVsOne batl1 = new OneVsOne(rob1, rob2);

        batl1.battle();

    }
}
