package monsters;

public class Dryad extends Monster {
    final String SYS = "[System]";
    public Dryad(String name, int hp, int mp, int armor, int attack) {
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
        System.out.println(SYS + "요정 Dryad이(가) 나타났습니다!!!");
        System.out.println(SYS + "나무의 요정 드라이어드는 꿀벌을 시켜 눈을 찌릅니다!!!");
    }
}