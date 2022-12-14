import monsters.*;
import players.*;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Server {
    String jobName;
    Job job;
    Monster monster;
    Scanner scanner = new Scanner(System.in);
    final String SYS = "[System]";
    final String IN = "[Input]";
    final String ERR = "[Error]";
    final String MESSAGE = "을(를) 선택했습니다.";
    final String GO_MENU = "메뉴로 돌아갑니다.";
    final String MONSTER_KILLED_MESSAGE = "을(를) 처치했습니다.";
    final String GO_BUILD_MONSTER = "던전 입구로 돌아갑니다.";
    final String GET_EXP = "만큼의 경험치를 얻었습니다.";
    final String NOW_LEV = "의 현재 레벨 : ";

    public void gameInfo(){
        System.out.println(SYS + "이 게임은 텍스트를 이용해 진행됩니다.");
        System.out.println(SYS + "안내 메세지를 보고 알맞은 값을 입력해주세요.");
    }
    public void endGame(){
        System.out.println(SYS + "게임을 종료합니다.");
        System.exit(0);
    }
    public void showMenu(){
        System.out.println(SYS+"게임 메뉴를 선택하세요.");
        System.out.println("==================================================");
        System.out.println("[Q]내 캐릭터 정보 [W]던전으로 이동 [C]직업 전환 [X]게임 종료");
        System.out.println("==================================================");
        System.out.print(IN+"메뉴 입력 : ");
        try {
        }catch (InputMismatchException e){
            System.out.println(SYS);
        }
        String selectMenu = scanner.next();

        if("Q".equals(selectMenu.toUpperCase())){
            job.showInfo();
            subMenu();
        }
        if("W".equals(selectMenu.toUpperCase())){
            moveMap();
            buildMonster();
        }
        if("C".equals(selectMenu.toUpperCase())){
            changeJob();
        }
        if("X".equals(selectMenu.toUpperCase())){
            endGame();
        }
    }
    public void subMenu(){
        System.out.println("[Z]메뉴로 돌아가기");
        System.out.println("[X]게임 종료");
        String selectMenu = scanner.next();

        if("Z".equals(selectMenu) || "z".equals(selectMenu)){
            System.out.println(SYS + GO_MENU);
            showMenu();
        }
        if("X".equals(selectMenu) || "x".equals(selectMenu)){
           endGame();
        }
    }
    public void startGame() {
        System.out.println("====================GameStart===================");
        gameInfo();
        System.out.println(SYS + "캐릭터 이름을 설정하세요");
        System.out.print(IN + "이름 입력 : ");
        String userName = scanner.next();
        boolean chkName = checkName(userName);
        if(!chkName){
            scanner.nextLine();
            startGame();
        }
        else {
            System.out.println(SYS + "캐릭터 이름을 설정했습니다. ");
            selectJob(userName);
        }
    }
    public void selectJob(String name){
        //기본 레벨과 경험치
        int init_lev = 1;
        int init_exp = 20;
        System.out.println(SYS + "캐릭터 직업을 결정하세요");
        System.out.println("==================================================");
        System.out.println("[1]나이트 [2]몽크 [3]흑마도사 [4]백마도사");
        System.out.println("=================================================");
        System.out.print(IN + "번호 입력 : ");

        try{
            int selectNum = scanner.nextInt();

            //직업 선택 기본값 초기화
            if (selectNum == 1) {
                jobName = "나이트";
                job = new Knight(name, 250, 150, init_lev, init_exp, 50, 30);
                job.setUserJob(jobName);
                System.out.println(SYS + jobName + MESSAGE);
                job.showInfo();
            }
            if (selectNum == 2) {
                jobName = "몽크";
                job = new Monk(name, 220, 80, init_lev, init_exp, 30, 40);
                job.setUserJob(jobName);
                System.out.println(SYS + jobName + MESSAGE);
                job.showInfo();
            }
            if (selectNum == 3) {
                jobName = "흑마도사";
                job = new BlackMage(name, 180, 300, init_lev, init_exp, 20, 60);
                job.setUserJob(jobName);
                System.out.println(SYS + jobName + MESSAGE);
                job.showInfo();
            }
            if (selectNum == 4) {
                jobName = "백마도사";
                job = new WhiteMage(name, 140, 200, init_lev, init_exp, 10, 15);
                job.setUserJob(jobName);
                System.out.println(SYS + jobName + MESSAGE);
                job.showInfo();
            }
            System.out.println(SYS + "캐릭터를 생성했습니다.");
            System.out.println(SYS + init_exp + GET_EXP);
            System.out.println(SYS + name + NOW_LEV + init_lev);
        } catch (InputMismatchException e){
            System.out.println(ERR + "메뉴를 보고 알맞은 숫자를 입력해주세요.");
            scanner.nextLine();
            selectJob(name);
        }


    }
    public void moveMap(){
        String selectedMap = null;
        String[] map = {"창천", "홍련", "칠흑", "효월"};
        System.out.print(SYS + "랜덤으로 맵 선택 중 .. ");
        for(int i=0; i <= map.length ; i++){
            Random random = new Random();
            int num = random.nextInt(3);
            selectedMap = map[num];
        }
        System.out.println("    >>>> [" + selectedMap + "] 으로 이동합니다.");
    }
    public void buildMonster(){
        System.out.println(SYS + "던전에 입장했습니다. 전투 상대를 선택하세요.");
        System.out.println("==================================================");
        System.out.println("[1]도비 [2]드리야드 [3]세이렌 [4]티타니아 [0]떠나기");
        System.out.println("=================================================");
        System.out.print(IN + "번호 입력 : ");
        int selectNum = scanner.nextInt();

        if( selectNum == 1){
            monster = new Dobby("Dobby", 100, 100, 10, 10);
        }
        if( selectNum == 2){
            monster = new Dryad("Dryad", 300, 300, 30, 30);
        }
        if( selectNum == 3){
            monster = new Sirens("Sirens", 500, 500, 50, 50);
        }
        if( selectNum == 4){
            monster = new Titania("Titania", 1000, 1000, 100, 100);
        }
        if( selectNum == 0){
            System.out.println(SYS + GO_MENU);
            showMenu();
        }
        monster.introMonster();
        monster.showInfo();

        playerAtkMonster(); //플레이어가 몬스터를 공격하는 메서드 호출
    }
    public void playerAtkMonster(){
        int monsterLife = monster.getHp();
        int userDamage = job.attackMonster();
        if( monsterLife <= 0 ){ //몬스터의 생명력이 0보다 작거나 같을 때
            System.out.println(SYS + "몬스터 " + monster.getMonsterName() + MONSTER_KILLED_MESSAGE);
            monster = null;
            System.out.println(SYS+"다음 던전으로 이동합니다.");
            moveMap();
            buildMonster();
        }else {
            monsterLife -= userDamage ;
            if( monsterLife > 0 ){ //몬스터의 생명력이 0보다 클 때
                monster.attackedByPlayer(userDamage);
                monster.setHp(monsterLife);
                System.out.println(SYS + "몬스터 "+ monster.getMonsterName()+"의 남은 생명력 : " + monsterLife);
                monsterAtkPlayer();
            }else {
                System.out.println(SYS + "몬스터 " + monster.getMonsterName() + MONSTER_KILLED_MESSAGE);
                monster = null;
                System.out.println(SYS+"다음 던전으로 이동합니다.");
                moveMap();
                buildMonster();
            }
        }
    }
    public void monsterAtkPlayer(){
        int userLife = job.getHp();
        System.out.println(SYS + "몬스터가 " + job.getName() + "을 공격합니다.");
        int monsterDamage = monster.attackPlayer();
        userLife -= monsterDamage;
        if (userLife >0){
            job.attackedByMonster(monsterDamage);
            job.setHp(userLife);
            System.out.println(SYS + job.getName() + "의 남은 생명력 : " + userLife);
            playerAtkMonster(); //플레이어가 몬스터를 공격하는 메서드 호출
        }else {
            System.out.println( job.getName() + "이(가) " + monster.getMonsterName() + "에게 당했습니다.");
            System.out.println(SYS+GO_BUILD_MONSTER);
            buildMonster();
        }
    }

    public boolean checkName(String name) {
        boolean chk= true;
        //닉네임에 문장부호가 있는지 확인
        for (int i = 0; i < name.length(); i++) {
            if (String.valueOf(name.charAt(i)).matches("[^a-zA-Z0-9-가-힣\\s]")) { //특수문자 인 경우
                System.out.println(ERR + "<" + name.charAt(i) + "> : " + "특수문자는 이름으로 사용할 수 없습니다.");
                chk = false;
            }
        }
        return chk;
    }

    public void changeJob(){
        //직업전환 체인지 메서드

    }
}
