package players;

import java.util.Scanner;

public class Monk extends Job {
    final String SYS = "[System]";
    final String JOB = "몽크";
    final String UNABLE_TO_USE_SKILL = "스킬 시전이 불가능합니다.";
    public Monk(String name, int hp, int mp, int lev, int exp, int armor, int attack) {
        super(name, hp, mp, lev, exp, armor, attack);
    }
    @Override
    public int attackMonster() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(SYS + "몬스터를 공격하세요.");
        System.out.println("=================================================");
        System.out.println("[A]평타 [S]스킬 [R]궁극기");
        System.out.println("=================================================");
        System.out.print("[Input]메뉴 입력 : ");
        String selectMenu = scanner.next();

        int sum = 0; //공격 데미지
        int randNum = (int)(Math.random() * 10); //랜덤 확률
        if("A".equals(selectMenu.toUpperCase())){
            //평타 사용시 추가 공격력 획득 추가
            System.out.println("[AutoAttack]평타를 사용합니다.");
            sum = getLev() + randNum + (int)( getAttack() * 0.2 ); //평타 데미지
            System.out.println(SYS + getName() + "이(가) 평타로 " + sum + "의 데미지를 주었습니다. ");
            return sum;
        }
        if ("S".equals(selectMenu.toUpperCase())) {
            int num = useMp("skill");
            if (num != 0){
                System.out.println("[Skill]로켓펀치를 사용합니다.");
                sum = (int)( getAttack() * 0.3 ) + randNum; //스킬 데미지
                System.out.println(SYS + getName() + "의 마나를 " + num + "만큼 소비합니다.");
                System.out.println(SYS + getName() + "의 남은 마나 : " + getMp());
                System.out.println(SYS + getName() + "이(가) 스킬로 " + sum + "의 데미지를 주었습니다. ");
                return sum;
            }
            if(num == 0){
                System.out.println(SYS + UNABLE_TO_USE_SKILL);
                System.out.println(SYS + getName() + "의 마나가 부족합니다.");
            }
            return sum;

        }
        if("R".equals(selectMenu.toUpperCase())){
            int num = useMp("ulti");
            if ( num != 0){
                System.out.println(("[Ultimate]파멸의 일격을 사용합니다."));
                sum = (int)( getAttack() * 0.6 ) + ( randNum * getLev()); //궁극기 사용 데미지
                System.out.println(SYS + getName() + "의 마나를 " + num + "만큼 소비합니다.");
                System.out.println(SYS + getName() + "의 남은 마나 : " + getMp());
                System.out.println(SYS + getName() + "이(가) 궁극기로 " + sum + "의 데미지를 주었습니다. ");
                return sum;
            }
            if(num == 0){
                System.out.println(SYS + UNABLE_TO_USE_SKILL);
                System.out.println(SYS + getName() + "의 마나가 부족합니다.");
            }
            return sum;
        }
        return sum;
    }

    @Override
    public void attackedByMonster(int damage) {
        super.attackedByMonster(damage);
    }
}
