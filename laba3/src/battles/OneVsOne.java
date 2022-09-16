package battles;

import druids.BasicDruid;

/** ����� �� ����� ������� */
public class OneVsOne {

    private BasicDruid robWhite, robBlack;

    public OneVsOne(BasicDruid r1, BasicDruid r2){
        robWhite = r1;
        robBlack = r2;
    }

    public void battle(){
        robWhite.makeMove(robBlack);
        if (anybodyWon()) return;
        System.out.println();

        robBlack.makeMove(robWhite);
        if (anybodyWon()) return;
        System.out.println();

        battle();
    }

    private boolean anybodyWon(){
        if (robWhite.isDied() || robBlack.isDied()){
            boolean whiteWinner = robBlack.isDied();
            System.out.println((whiteWinner ? (robWhite.toString()+ " (���� ") : (robBlack.toString() + " (����� ")) +
                    "�������) - ��������");
            return true;
        }
        return false;
    }

}