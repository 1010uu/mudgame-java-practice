package players;

import java.util.Scanner;

public class WhiteMage extends Job {
    final String sys = "[System]";
    final String job = "백마도사";
    public WhiteMage(String name, int hp, int mp, int lev, int exp, int armor, int attack) {
        super(name, hp, mp, lev, exp, armor, attack);
    }
    @Override
    public int attackMonster() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sys+"몬스터를 공격하세요.");
        System.out.println("=================================================");
        System.out.println("[A]평타 [S]스킬 [R]궁극기");
        System.out.println("=================================================");
        System.out.print("[Input]메뉴 입력 : ");
        String selectMenu = scanner.next();

        int sum = 0; //공격 데미지
        int randNum = (int)(Math.random() * 10); //랜덤 확률
        if("A".equals(selectMenu.toUpperCase())){
            System.out.println("[AutoAttack]평타를 사용합니다.");
            sum = getLev() + randNum; //평타 데미지
            System.out.println(sys + getName() + "이(가) 평타로 " + sum + "의 데미지를 주었습니다. ");
            return sum;

        }
        if ("S".equals(selectMenu.toUpperCase())) {
            System.out.println("[Skill]힐리를 사용합니다.");
            int heal = (int)(getHp() * 0.3) + randNum; //기본 체력의 30% 회복
            System.out.println(sys + getName() + "이(가) 스킬로 " + heal + "의 체력을 회복했습니다. ");
            healPlayer(heal);
            return sum;
        }
        if("R".equals(selectMenu.toUpperCase())){
            System.out.println(("[Ultimate]최후의 섬광을 사용합니다."));
            sum = (int)( getAttack() * 0.5 ) + ( randNum * getLev()); //궁극기 사용 데미지
            System.out.println(sys + getName() + "이(가) 궁극기로 " + sum + "의 데미지를 주었습니다. ");
            return sum;
        }
        return sum;
    }

    @Override
    public void attackedByMonster(int damage) {
        super.attackedByMonster(damage);
    }

    public void healPlayer(int heal){
        //최대체력조건
        int life = getHp() + heal;
        setHp(life);
        //마나가 없을 때
        int useMp = getMp() - heal;
        setMp(useMp);
    }

}
