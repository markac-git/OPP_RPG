import java.util.Random;

public class Location {
    /*declaring int variable with private access, which means that it only
     * can be reach from inside this class*/
    private int lvl;
    private int description;

    //Creating a constructor: Every Location should be "born"/expects int parameter (lvl)
    public Location(int lvl) {
        //this.lvl (line: 06) is equal to the parameter
        this.lvl = lvl;
        this.description = lvl; //description is equal to lvl as well
    }

    //Getters and Setters to make the variables reachable from outside this class
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override //Overriding the original String method
    public String toString() {
        System.out.println(
                "-------------------------\n" +
                        "---------SETTING---------\n" +
                        "-------------------------");

        //instance variable "descriptions" pointing at a new array which contains five objects of type String
        String[] descriptions = new String[11]; //as the first index is null

        //declaring the Strings and placing them in the array
        descriptions[0] = null; //first index is "empty"/null

        //filling array with different scenes including ASCII Art
        descriptions[1] = "in a forest\n" +
                "       ^  ^  ^   ^      ___I_      ^  ^   ^  ^  ^   ^  ^\n" +
                "      /|\\/|\\/|\\ /|\\    /\\-_--\\    /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\n" +
                "      /|\\/|\\/|\\ /|\\   /  \\_-__\\   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\n" +
                "      /|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";

        descriptions[2] = "in a fallen house\n" +
                "               \n" +
                "                    _[]_          \n" +
                "     __[]___[]___[]/____\\_[]_     \n" +
                "    /______________|[][]|____\\   \n" +
                "    |[][]|[][]|[][]|[][]|[][]|__[]_\n" +
                "    |  /\\|/\\  |  /\\|  /\\|/\\  |_____\\\n" +
                "    |[]|||||[]|[]|||[]|||||[]|[_]|||\n" +
                "  ===================================\n" +
                "  -  -  -  -  -  -  -  -  -  -  -  -  -\n" +
                "=========================================";

        descriptions[3] = "at a castle\n" +
                "                  p                  p         p\n" +
                "                 /\\     p      p    /\\        /\\\n" +
                "                /__\\   /\\_____/\\   /__\\      /__\\\n" +
                "                |. |_=_|. . . .|_=_=_=_=_=_=_|. |\n" +
                "                |. |. .|  ___  |. . . . . . .|. |\n" +
                "                |. |   | |   | |             |. |\n" +
                "              __|__|___|_|___|_|_____________|__|__\n" +
                "             /          /   /                      \\";

        descriptions[4] = "next to a river\n" +
                "          _    .  ,   .           .\n" +
                "      *  / \\_ *  / \\_      _  *        *   /\\'__        *\n" +
                "        /    \\  /    \\,   ((        .    _/  /  \\  *'.\n" +
                "   .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.\n" +
                "      /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *\n" +
                "    /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\ \n" +
                "   /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-\n" +
                "  /        `.  / /       `.~-^=-=~=^=.-'      '-._ `._";

        descriptions[5] = "in the mountains\n" +
                "       ___..-.              \n" +
                "     ._/  __ \\_`-.__       \n" +
                "     / .'/##\\_ `-.  \\--.  \n" +
                "     .-_/#####\\  /-' `\\_      \n" +
                "      /###@@###\\_  \\._   `-  \n" +
                "    _|###########\\_`.  -' \\    \n" +
                "    \" \"'\"''\"'\"'''\" ''\"'\"''\"";

        descriptions[6] = "next to the sea\n" +
                "                                         |\n" +
                "                                       \\ _ /\n" +
                "                                     -= (_) =-\n" +
                "    .\\/.                               /   \\\n" +
                " .\\\\//o\\\\                      ,\\/.      |              ,~\n" +
                " //o\\\\|,\\/.   ,.,.,   ,\\/.  ,\\//o\\\\                     |\\\n" +
                "   |  |//o\\  /###/#\\  //o\\  /o\\\\|                      /| \\\n" +
                " ^^|^^|^~|^^^|' '|:|^^^|^^^^^|^^|^^^\"\"\"\"\"\"\"\"(\"~~~~~~~~/_|__\\~~~~~~~~~~\n" +
                "  .|'' . |  '''\"\"'\"''. |`===`|''  '\"\" \"\" \" (\" ~~~~ ~ ~======~~  ~~ ~\n" +
                "  jgs^^   ^^^ ^ ^^^ ^^^^ ^^^ ^^ ^^ \"\" \"\"\"( \" ~~~~~~ ~~~~~  ~~~ ~";

        descriptions[7] = "in a desert\n" +
                "        .-.    '\n" +
                "        |.|\n" +
                "      /)|`|(\\\n" +
                "     (.(|'|)`)\n" +
                "  ~~~~`\\`'./'~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "        |.|           ~~\n" +
                "        |`|                            ~~\n" +
                "       ,|'|.      (_)          ~~\n" +
                "        \"'\"        \\\"\\\n" +
                "             ~~     ^~^\n";

        descriptions[8] = "at an island\n" +
                "              |\n" +
                "            \\ _ /\n" +
                "          -= (_) =-                 \n" +
                "            /   \\                          _\\/_\n" +
                "              |                            //o\\  _\\/_\n" +
                "    _  ___  __  _ __ __ _  _ _  _ _ __  __ _ | __/o\\\\ _\n" +
                "  =-=-_=-=-_=-=_=-_=_=-_=-_-_=_=-= _=_=-=_,-'|\"'\"\"-|-,_ \n" +
                "   =- _=-=-_=- _=-= _--_ =-= -_=-=_-=_,-\"          |\n" +
                "     =- =- =-= =- = -  -===- -= -= .\"                    ";

        descriptions[9] = "in fallen temple\n" +
                "  `,  '.  `.  \".  `,  '.| n   ,-.   n |  \",  `.  `,  '.  `,  ',\n" +
                ",.:;..;;..;;.,:;,.;:,o__|__o !.|.! o__|__o;,.:;.,;;,,:;,.:;,;;:\n" +
                " ][  ][  ][  ][  ][  |_i_i_H_|_|_|_H_i_i_|  ][  ][  ][  ][  ][\n" +
                "                     |     //=====\\\\     |\n" +
                "                     |____//=======\\\\____|\n" +
                "                         //=========\\\\";

        descriptions[10] = "in a dark, dark place\n" +
                "\n" +
                "\n" +
                "\n";

        //s returns following + the above description depending on state variable
        String s = "You're finding yourself " + descriptions[this.description];
        return s;
    }

    //int method called by (class World line: 71) to pick a random integer between 0 and 1
    public static int pickRandomSituation() {
        /*initializing variable "random" and sets it as type Random, pointing
        at a new object (Class imported in the top - from java.util library)*/
        Random random = new Random();
        int situationPick = random.nextInt(2); //picks either 0 or 1
        return situationPick; //returns the int variable "situationPick" is pointing towards
    }

    /*First situation that can exist in the World. Boolean method that expects following parameters and that return either true or
    false so that the while-loop (class World, line: 72 & 76) knows when to break out
    and read the next line to create a new scene/state*/
    public static boolean situationOne(Player player, Enemy[] enemies, int state, boolean nextDoor) {
        System.out.print("there's a ");
        //checking whether enemy is wounded by calling method (class Enemy, line: 106)
        if (enemies[state].isWounded()) {
            System.out.print("wounded ");
        }
        /*calling getter-method (class Enemy, line: 40), since the String variables are private*/
        System.out.println(enemies[state].getRole() + " ahead");
        System.out.println(enemies[state].toArt());

        System.out.println(
                "0. RETURN TO MENU \n" +
                        "1. ATTACK\n" +
                        "2. TAKE POTION\n" +
                        "3. FLEE");

        //switch statement controlled by choose method (class Player, line: 110)
        switch (player.choose()) {
            case 0:
                Main.menu(); //back to menu
                break; //breaks out of switch statement if this is the case
            case 1:
                /*calling boolean method (this class, line: 208) which returns either true or false depending on
                 * whether the enemy is dead or not. If the enemy dies, nextDoor is true and the while-loop
                 * (class World, line: 72 & 76) breaks out and read the next line to create a new scene/state */
                nextDoor = battle(player, enemies, state);
                break;
            case 2:
                /*calling abstract method (class Player, line: 144) that gets overwritten by the subclass,
                player variable is pointing towards. If player points at "new Mage", (Class Mage, line: 76) is read*/
                player.takePotion();
                break;
            case 3:
                nextDoor = player.flee(); //repeat
                break;
            default:
                /*this line is read if user input doesn't match the options in this case: 0,1,2,3.
                this is an error handling in addition to (class Player, line: 113)*/
                System.out.println("Your choice doesn't match the options given");
        }
        return nextDoor; //repeat (this class, line: 174)
    }

    //Second situation that can exist in the World. Mainly repeats situationOne
    public static boolean situationTwo(Player player, Enemy[] enemies, int state, boolean nextDoor) {
        System.out.println("There are two doors ahead of you. Which one do you choose \n" +
                "  .--.      .--.  \n" +
                "||    ||  ||    ||\n" +
                "|| -  ||  || -  ||\n" +
                "|'----'|  |'----'|\n" +
                "/      `. /´    `|\n" +
                "0. Return to menu\n" +
                "1. Left door \n" +
                "2. Right door \n");
        /*the clever secret here is that, whether you choose the left or right door, it doesn't really matter
         * both choices makes the while-loop (class World, line: 72 & 76) break out and go to the next state*/
        switch (player.choose()) {
            case 0:
                Main.menu();
                break;
            case 1:
                System.out.print("You chose the left door");
                nextDoor = true;
                break;
            case 2:
                System.out.print("You chose the right door");
                nextDoor = true;
                break;
            default:
                /*this line is read if user input doesn't match the options in this case: 0,1,2,3.
                this is an error handling in addition to (class Player, line: 113)*/
                System.out.println("Your choice doesn't match the options given");
        }
        System.out.println("which leads you to a new place");
        return nextDoor;
    }


    /*Boolean method that expects following parameters - called by (this class, line: 176)*/
    public static boolean battle(Player player, Enemy[] enemies, int state) {
        /*as long as the boolean returns false, the switch statement (this class, line 168-) is active,
         * as the while-loop (class World, line: 72 & 76) doesn't breaks out. Hereby meant, that the user
         * is given the opportunity to take a potion or flee after an attack */
        boolean battleOver = false;

        //if both player and enemy are alive
        if (!player.isDead() && !enemies[state].isDead()) {
            //Players turn
            /*calling getters and setters to change the hp of the given enemy. The abstract
            attack method (class Player, line: 134) depends on which subclass chosen (repeat: this class, line: 179)
            if subclass equals Mage, (class Mage, line: 99) is read. This is a method that returns an integer*/
            enemies[state].setHp(enemies[state].getHp() - player.attack());
            enemies[state].status(); //prints enemy status
        }
        //if both player and enemy are alive
        if (!player.isDead() && !enemies[state].isDead()) {
            //Enemy turn
            //repeat - except the Enemy class isn't abstract
            player.sethP(player.gethP() - enemies[state].attack());
            player.status();
        }

        //if player is dead, return to menu
        if (player.isDead()) {
            System.out.println("You lost the battle");
            Main.menu();
        }

        /*if enemy is dead the method returns true which makes the program breaks out of switch statement (this Class, line: 163)
        and then while loop (class World, line: 64)*/
        if (enemies[state].

                isDead()) {
            System.out.println("You won the battle");
            player.lvlUp(); //player gains a level by calling method (class Player, line: 113)
            battleOver = true;
        }

        return battleOver;
    }
}
