import java.util.Random;

public class Enemy {
    private String role;
    private int hp;
    private int maxHp;
    private int lvl;
    private int maxAtt;

    //Constructor that expects following parameter: lvl
    public Enemy(int lvl) {
        this.lvl = lvl; //lvl (line: 7) is equal to parameter
        Random random = new Random(); //repeat (class Location, line: 141)
        int i = (random.nextInt(2)) + 1; //picking either 1 or 2
        switch (i) { //parameter choose which case that should run
            case 1:
                //stats for skeleton enemy
                role = "skeleton";
                maxHp = lvl * 7;
                hp = maxHp;
                maxAtt = lvl * 13;
                break;
            case 2:
                //stats for ghost enemy
                role = "ghost";
                maxHp = lvl * 13;
                hp = maxHp;
                maxAtt = lvl * 7;
                break;
            default:
        }
    }

    //Creating getters and setters to access the variable from outside this class - Some of them are unnecessary
    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLvl() {
        return lvl;
    }

    public int getMaxAtt() {
        return maxAtt;
    }

    public void setMaxAtt(int maxAtt) {
        this.maxAtt = maxAtt;
    }

    public int attack() {
        System.out.println(
                "------------------ \n" +
                        "---ENEMY ATTACK--- \n" +
                        "------------------");
        if (role.equals("skeleton")) { //if role is skeleton
            System.out.println("*** Bidding ***");
        } else if (role.equals("ghost")) { //could also just have been else
            System.out.println("*** Screaming ***");
        }

        Random random = new Random(); //repeat (class Location, line: 141)
        int damageDealt = maxAtt - random.nextInt(9); //minus random 0-8
        System.out.println("Damage dealt: " + damageDealt);
        return damageDealt;
    }


    public void status() {
        System.out.println("-------------- \n" +
                "-ENEMY STATUS- \n" +
                "--------------");
        System.out.println("Lvl        : " + lvl);
        System.out.println("HP         : " + hp);
        System.out.println("Max attack : " + maxAtt + "\n");
    }

    //Boolean method that returns either true or false regarding the hp of enemy
    public boolean isDead() {
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    //repeats line 97 but checking if enemy have lesser health that maxHealth
    public boolean isWounded() {
        if (hp < maxHp) {
            return true;
        }
        return false;
    }

    //String method that returns ASCII art depending on role
    public String toArt() {
        String a;

        if (role == "ghost") {
            a =
                    "       .-.\n" +
                            "      ( \" )\n" +
                            "   /\\_.' '._/\\\n" +
                            "   |         |\n" +
                            "    \\       /\n" +
                            "     \\    /`\n" +
                            "   (__)  /\n" +
                            "   `.__.'\n";
        } else {
            a =
                    "    ,--.\n" +
                            "   ([ oo]\n" +
                            "    `- ^\\\n" +
                            "  _  I`-'\n" +
                            ",o(`-V'\n" +
                            "|( `-H-'\n" +
                            "|(`--A-'\n" +
                            "|(`-/_\\'\\\n";
        }
        return a;
    }
}

