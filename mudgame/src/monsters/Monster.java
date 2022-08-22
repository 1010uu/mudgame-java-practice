package monsters;

public class Monster {

    private String monsterName; //이름
    private int hp; //피
    private int mp; //마나
    private String aa; //평타
    private String skill; //스킬
    private int armor; //방어력
    private int attack; //공격력

    public Monster(String name, int hp, int mp, int armor, int attack){
        this.monsterName = name;
        this.hp += hp;
        this.mp += mp;
        this.armor += armor;
        this.attack += attack;
    }

    public int attackPlayer(){
        return attack;
    };
    public void attackedByPlayer(int damage){
        this.hp = hp + armor - damage;
    };

    public void showInfo(){
        System.out.println("===================[몬스터 정보]===================");
        System.out.println("                1.이름 : " + monsterName);
        System.out.println("                2.체력 : " + hp );
        System.out.println("                3.마나 : " + mp );
        System.out.println("                4.공격력 : " + attack);
        System.out.println("                5.방어력 : " + armor);
        System.out.println("==================================================");
    };

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
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

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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
}
