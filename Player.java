import java.util.Scanner;

public abstract class Player {
    //name and role doesn't get to be changed at any point, therefore they can be static
    private static String name;
    private static String role;
    /*private variables so that the classes outside this class, needs to call the getters and setters
     * to interact with these variables*/
    private int lvl;
    private int maxHp;
    private int hP;
    private int maxAtt;

    //Constructor - every proper Player should be "born" as following
    public Player() {
        //not necessary to use getters and setters since it's from inside this class
        lvl = 1; //to avoid repetition
        if (role.equals("Mage")) {
            maxHp = 40;
            hP = maxHp;
            maxAtt = 15;
        } else if (role.equals("Warrior")) {
            maxHp = 50;
            hP = maxHp;
            maxAtt = 10;
        }
    }

    //Creating Getters and Setters to make variables accessible from outside this class
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        Player.role = role;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int gethP() {
        return hP;
    }

    public void sethP(int hP) {
        this.hP = hP;
    }

    public int getMaxAtt() {
        return maxAtt;
    }

    public void setMaxAtt(int maxAtt) {
        this.maxAtt = maxAtt;
    }

    public static Player createPlayer() {
        Scanner input = new Scanner(System.in); //repeat (class Main, line: 14)
        Player.name = null; //if the user returns to menu he'll get to enter another name (cf. next line)
        if (name == null) { //so that the user doesn't have to type in name again, if user input doesn't match the role (next in method)
            System.out.println("Enter name: ");
            String n = input.nextLine();
            /*s1 = input substring from zero to 1 which is the first letter. This letter is transformed to uppercase*/
            String s1 = n.substring(0, 1).toUpperCase();
            /*name = s1 (first capital letter) + input from second letter*/
            name = s1 + n.substring(1);
        }
        System.out.println("Choose role: ");
        System.out.println("1. Mage");
        System.out.println("2. Warrior");

        //checking if next input is an integer - if not: return null, which makes the createPlayer loop (class World, line: 15)
        if (!input.hasNextInt()) {
            System.out.println("wrong input");
            return null;
        }

        int choiceOfRole = input.nextInt();

        switch (choiceOfRole) { //cannot call choose method (as in: class Mage, line: 85) as player is not yet created
            case 1:
                setRole("Mage");
                return new Mage();
            case 2:
                setRole("Warrior");
                return new Warrior();
            default:
                return null; //if input is not an integer matching 1 or 2 = (this class, line: 91)
        }
    }

    //level up
    public void lvlUp() {
        System.out.println("-------------------------\n" +
                "-------LEVEL UP----------\n" +
                "-------------------------\n");
        lvl++; //level + 1
        //abilities follows lvl
        maxHp *= lvl;
        maxAtt *= lvl;
    }

    //choose
    public int choose() {
        Scanner sc = new Scanner(System.in);

        //error handling: if the input is not an integer
        if (!sc.hasNextInt()) {
            return 10;
            /*choosing a number that doesn't match any switch statements (class Location, line: 152 & 182)
             * so that it loops if no relevant input is given*/
        } else {
            return sc.nextInt(); //if input is right, return it.
        }
    }

    //Boolean method: Is dead? Checking player hp to return either true or false
    public boolean isDead() {
        if (gethP() <= 0) {
            return true;
        }
        return false;
    }

    /*Creating abstract methods, which contains no body. Hereby a promise that the
    subclasses will contain these methods and overwrite them by their own body*/
    //Attack
    public abstract int attack();

    //Status
    public abstract void status();

    //Flee
    public abstract boolean flee();

    //Move
    public abstract void move();

    //Take Potion
    public abstract void takePotion();


}


