package players;

public class Job
{
    private String name; //이름
    private int hp; //체력
    private int maxHp; //최대체력
    private int mp; //마나
    private int maxMp; //최대마나
    private int lev; //레벨
    private int exp; //경험치
    private int maxExp = 100; //최대경험치
    private int armor; //방어력
    private int attack; //공격력 //마력
    private String userJob;

    public Job(String name, int hp, int mp, int lev, int exp, int armor, int attack ){
        this.name = name;
        this.hp += hp;
        this.maxHp = hp;
        this.mp += mp;
        this.maxMp = mp;
        this.lev += lev;
        this.exp += exp;
        this.armor += armor;
        this.attack += attack;
    };

    public int attackMonster(){
        return attack;
    };
    public void attackedByMonster(int damage){
        // 생명력 = 체력 + 방어력
        this.hp = hp + armor - damage;

    };

    public void ExpUp(int tempExp){ //경험치 획득 메서드
        if(exp + tempExp < maxExp){ //최대 경험치보다 적을 때
           exp += tempExp;
        }
        if(exp + tempExp >= maxExp){ //최대 경험치와 같거나 이상
            exp = exp + tempExp;
            exp -= maxExp;
            levUp();
        }
    };

    public void levUp(){
        lev ++;
        maxHp += 50;
        maxMp += 50;
        maxExp += 100;
        armor += 50;
        attack += 50;
        hp = maxHp;
        mp = maxMp;
    };

    public void showInfo(){
        System.out.println("==================[내 캐릭터 정보]==================");
        System.out.println("         1.이름 : " + name + "  |  2.직업 : " + userJob);
        System.out.println("         3.체력 : " + hp + "  |  4.마나 : " + mp);
        if("백마도사".equals(userJob) || "흑마도사".equals(userJob)){
            System.out.println("         5.마력 : " + attack + "  |  6.방어력 : " + armor);
        }
        System.out.println("         5.공격력 : " + attack + "  |  6.방어력 : " + armor);
        System.out.println("         7.레벨 : " + lev + "  |  8.경험치 : " + exp);
        System.out.println("==================================================");
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getLev() {
        return lev;
    }

    public void setLev(int lev) {
        this.lev = lev;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }
}
