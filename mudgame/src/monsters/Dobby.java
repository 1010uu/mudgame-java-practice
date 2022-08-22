package monsters;

public class Dobby extends Monster {
    final String SYS = "[System]";
    public Dobby(String name, int hp, int mp, int armor, int attack) {
        super(name, hp, mp, armor, attack);
    }

    @Override
    public int attackPlayer() {
        int sum;
        int randNum = (int)(Math.random() * 10);
        sum = (int)( getAttack() * 0.3 )+ randNum; //공격 데미지
        System.out.println(SYS + getMonsterName() + "에게 " + sum + "의 데미지를 받았습니다. ");
        return sum;
    }

    @Override
    public void attackedByPlayer(int damage) {
        super.attackedByPlayer(damage);
    }
}
