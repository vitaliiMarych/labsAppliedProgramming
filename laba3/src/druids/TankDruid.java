package druids;

/** ���� ���� ���� ������ ������'� � �� � ������� �� ����� ��� ���� ����� ���� ������, ��� ����� ���� ���������
 * ���� �� ��������� ��, �� ���� ������ ���� ����������
 * */
public class TankDruid extends BasicDruid{

    public TankDruid(String name){
        this.type = "���������";
        this.health = 350;
        this.damage = 30;
        this.name = name;
        this.defense = 1.25;
    }

}
