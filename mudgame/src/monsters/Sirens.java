package monsters;

public class Sirens extends Monster {
    final String SYS = "[System]";
    public Sirens(String name, int hp, int mp, int armor, int attack) {
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

    @Override
    public void introMonster() {
        System.out.println(SYS + "요정 Sirens이(가) 나타났습니다!!!");
        System.out.println(SYS + "바다의 요정 세이렌은 상체는 사람이고 하체는 물고기.. 기괴하다!!");
    }
}
